package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//이렇게 controller라고 annotation을 달면 클래스에서 반환을 문자열로 하게 되면,
//resources쪽에 templates에서 hello world라는 html파일을 찾아서 반환한다.
//즉, view네임의 정보를 전달하는게 되기 때문에 @ResponseBody라고 달아줘야 실제로 우리가 리턴에 담은 문자열이 출력된다.
@Controller
@RequestMapping("/api")
///api 로시작되는 요청은  하단의 모든 메서드에 적용이 된다.
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "Get요청";
    }
    @PostMapping("/api/post")
    @ResponseBody
    public String post(){
        return "POST요청";
    }
    @PutMapping("/put")
    @ResponseBody
    public String put(){
        return "PUT 요청";
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){
        return "DELETE 요청";
    }
    //경로 중복은 가능하지만 메서드 중복은 불가능하다
}
