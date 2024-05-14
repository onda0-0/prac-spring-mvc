package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    private static long visitCount=0;
    //1. url 경로직접접근
    //2. thymeleaf 안쓰고 한번 컨트롤러 통해 반환
    //3. thymeleaf쓰고 컨트롤러 통해 반환
        //3-1. redirect 사용
        //3-2.
    @GetMapping("/static-hello")
    public String hello(){
        return "hello.html";
    }
    //controller를 통해서 정적웹페이지를 반환하는 것은 의미가 없을 수는 있지만 가능은 하다.

    //static폴더에 있는 html을 접근하기 윈한 방법
    //1.url 경로직접접근- 이미 완성된 정적인 html파일을 반환 http://localhost:8080/hello.html
    //1-1.thymeleaf dependencies 주석처리하면  controller 를 거쳐 static폴더의 해당  html파일을 찾아 반환한다.
    //thymeleaf는 동적페이지 처리를 위한 템플릿엔진이기때문에 추가되어 있으면 자동으로 Controller에서 html찾는 경로를 /resources/templates로 설정한다.


    //2.Redirect http://localhost:8080/html/redirect
    //템플릿 엔진을 적용한 상태에서 static 폴더의 html 파일을 Controller를 통해서 처리하고 싶다면
    //이렇게 "redirect:/hello.html" redirect 요청을 문자열로 반환하면
    // http://localhost:8080/hello.html 요청이 재 수행되면서 static 폴더의 파일을 반환할 수 있다.
    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";//직접접근 경로를 리다이렉트 경로에 써놓은것
    }


    //http://localhost:8080/html/templates
    @GetMapping("/html/templates")
    public String htmlTemplates(){
        return "hello";
        //정적인 파일도 templates에 넣어도 된다.
        //tempaltes폴더에있는 html파일이 반환된다. 타임리프 엔진을 적용해서 html을 반환할때에는 이름뒤에html을 떼고 이름만 적어도 된다.
        //tempaltes폴더에있는 html파일을 찾을때는 파일의 이름만 반환한다. 컨트롤러 어노테이션이 있는 클래스에서! -14분28초
        //controller라는 annotation이 달린 클래스에서 templates에 들어 있는 파일의 이름을 문자열로 받아와서 반환할수 있게 된다.
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model){
        visitCount++;
        model.addAttribute("visits",visitCount);
        //식별되는 이름을 넣어주고, 데이터를 넣어준다.
        //동적페이지를 만들때 필요한건 두가지: 1. 모델 2. 뷰이름 정보
        return "hello-visit";

    }//반환할 데이터는 모델에 담고, 그 모델에 적용이 될 뷰네임의 정보를 전달하면 viewreasable?을 통해서 그모델의 데이터가 뷰에 적용이되고 완성된 화면이 클라이언트에게 전달된다.
}
