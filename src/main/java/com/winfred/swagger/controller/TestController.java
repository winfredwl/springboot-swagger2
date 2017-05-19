package com.winfred.swagger.controller;

import com.winfred.swagger.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Winfred.Wang
 * @since 05.19.2017
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value="@ApiOperation测试", notes="获取@ApiOperation测试测试",produces = "application/json")
    @RequestMapping(value="/getTest1", method= RequestMethod.GET)
    public Map<String, Object> getTest1() {
        System.out.println("1");
        return null;
    }

    @ApiOperation(value="@ApiResponses测试", notes="@ApiResponses测试测试",produces = "application/json")
    // ApiResponses 增加返回结果的描述
    @ApiResponses(value = {@ApiResponse(code = 405,message = "Invalid input",response = Integer.class)})
    @ApiImplicitParam(name = "id",value = "用户ID",dataType = "int",paramType = "path")
    @RequestMapping(value="/getTest2", method= RequestMethod.GET)
    public Map<String, Object> getTest2(@PathVariable Integer id) { // PathVariable是Spring 的注解，对于这种简单的参数，就可以不用写ApiParam来描述接口参数
        System.out.println("2");
        return null;
    }

    @ApiOperation(value="使用ApiImplicitParams描述多个参数", notes="使用ApiImplicitParam时，需要指定paramType,这样也便于swagger ui 生成参数的输入格式。"
            + "paramType 有五个可选值: path, query, body, header, form")
    @RequestMapping(value="getTest3", method= RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "userName", value = "用户名称", paramType = "form", dataType = "string")
    })
    public void getTest3(@PathVariable Integer id, @RequestParam String userName){
        System.out.println("3");
    }

    @ApiOperation(value="使用ApiParam描述接口参数", notes="对Servlets或者非 JAX-RS的环境，只能使用 ApiImplicitParam。" +
            "在使用上，ApiImplicitParam比ApiParam具有更少的代码侵入性，只要写在方法上就可以了，但是需要提供具体的属性才能配合swagger ui解析使用。" +
            "ApiParam只需要较少的属性，与swagger ui配合更好。", produces = "application/json")
    @RequestMapping(value="/getTest4", method= RequestMethod.POST)
    //可以不加ApiParam注解，需要给参数添加描述时可以使用这个注解，或者使用ApiImplicitParams注解
    public Map<String, Object> getTest4(@RequestParam  String userName, @ApiParam("地址") @RequestParam(required = false) String address) {
        System.out.println("4");
        return null;
    }

    @ApiOperation(value="创建用户-传递复杂对象", notes="传递复杂对象DTO，json格式传递数据",produces = "application/json")
    @RequestMapping(value="/getTest5", method= RequestMethod.POST)
    //json格式传递对象使用RequestBody注解
    public User getTest5(@RequestBody User user) {
        return user;
    }




}
