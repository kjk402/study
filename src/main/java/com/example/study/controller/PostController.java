package com.example.study.controller;

import com.example.study.model.SerchParam;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/api")

public class PostController {


    //http post body -> data
    // json, xml, multipart-form

    //@RequestMapping(method = RequestMethod.POST , path = "/postMethod") => 아래 두줄과 같은 기능
    @PostMapping(value = "/postMethod")
    public SerchParam postMethod(@RequestBody SerchParam serchParam){
        return serchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }

}
