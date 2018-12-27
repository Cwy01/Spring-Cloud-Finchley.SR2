package com.boot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.boot.service.UserServiceDetail;

@SpringBootApplication
@EnableResourceServer  //开启Resource Server
@EnableEurekaClient
public class ServiceAuthApplication{
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceAuthApplication.class, args);
	}
	
	@Configuration
	@EnableAuthorizationServer  //开启授权服务的功能
	protected class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter{
		//private TokenStore tokenStore = new InMemoryTokenStore();
		JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
		
		@Autowired
		@Qualifier("authenticationManegerBean")
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private UserServiceDetail userServiceDetail;
		
		//配置了客户端的一些基本信息
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
			//clients.inMemory() 配置了将客户端的信息存储在内存中
			//.withClient("browser") 创建了一个clientId 为browser的客户端
			//.authorizedGrantTypes("refresh_token","password") 配置了验证类型为refresh_token和password
			//.scopes("ui") 配置了客户端域为“ui”
			
			clients.inMemory().withClient("browser").authorizedGrantTypes("refresh_token","password")
			.scopes("ui").and().withClient("service-hi").secret("123456")
			.authorizedGrantTypes("client_credentials","refresh_token","password").scopes("server");
		}
		
		//
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
			//tokenStore(token的存储方式)采用将Token存储在内存中，即InMemoryTokenStore
			//另一种方式是JdbcTokenStore，即数据库存储
			//userDetailsService用来读取验证用户的信息
			
			endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
			.userDetailsService(userServiceDetail);
		}
		
		//配置了获取Token的策略（此处对获取Token请求不进行拦截，只验证获取Token的验证信息）
		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception{
			oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
		}
		
	}
	
}
