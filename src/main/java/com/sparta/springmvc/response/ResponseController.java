package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    //Content-Type:text/html
    //Response Body
    //{"name":"Hyunji","age":26}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";//java는 json을 읽을 수없으므로 일단 json모양으로 문자열을 만들어두고
    }

    //Content-type:application/json
    //Response Body
    //{"name":"Robbie",age:95}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson(){
        return new Star("Hyunji",26);
    }
    //
}
