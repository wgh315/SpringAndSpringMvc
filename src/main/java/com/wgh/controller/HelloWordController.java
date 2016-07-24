package com.wgh.controller;/**
 * Created by wangguohui on 16/7/24.
 */

import com.wordnik.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 第一个controller
 *
 * @author wangguohui
 * @create 2016-07-24-下午1:07
 */

@Api("test example")
@Controller
@RequestMapping(value = "/wgh")
public class HelloWordController {

    @ApiOperation(value = "say hello method", httpMethod = "get", notes="this is a say hello methods", response = String.class)
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "hello";
    }

//	@ApiOperation(value="say world", httpMethod="post", position = 1, notes="this is a say world methods", response = String.class)
//	@RequestMapping(value = "/sayWorld", method = RequestMethod.POST)
//	@ResponseBody
//	public String sayWorld(@RequestParam("name") String name) {
//		return name;
//	}

    @ApiOperation(value="say world",
            httpMethod="post",
            position = 1,
            notes="###this is a say world methods" ,
            response = String.class)
    @ApiParam(name = "name", defaultValue = "world", required = true)
    @ApiResponses(value = {
            @ApiResponse(code=404, message="不存在的资源"), @ApiResponse(code=400, message = "Invalid ID")
    })
    @RequestMapping(value = "/sayWorld", method = RequestMethod.POST)
    @ResponseBody
    public String sayWorld(@RequestParam("name") String name,@RequestParam("age") String age) {
        return name+":" +age;
    }
}