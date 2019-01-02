$(function() {
	var url = "/index/v1/user";
	$.getJSON(url,function(result,status){
		var vm = new Vue({
			el:'#div_show',
			data : {
				sites : result
			}
		})
	})
});