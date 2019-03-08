package com.boot.druid.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.druid.util.Response;

@RestController
@RequestMapping(value = "/admin/")
public class AdminController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Response test() {

        return new Response.Builder().setMessage("test").setStatus(200).build();
    }

}