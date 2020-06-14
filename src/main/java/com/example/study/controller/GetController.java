package com.example.study.controller;

import com.example.study.model.SerchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api") // localhost:8080/api

public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";

    }

    @GetMapping("/getParameter")  //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam String password){

        System.out.println("id : "+id);
        System.out.println("password : "+password);

        return id+password;
    }


    //localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SerchParam getMultiParameter(SerchParam serchParam){
        System.out.println(serchParam.getAccount());
        System.out.println(serchParam.getEmail());
        System.out.println(serchParam.getPage());


        // { "account" : "", "email" : "", "page" : ""} 어떻게 받는지 ? => return SerchPara;
        return serchParam;
    }


    @GetMapping("/header")
    public Header getHeader(){


        return Header.builder().resultCode("OK").description("OK").build();
    }


}
