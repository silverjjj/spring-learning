package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 1. GetMapping : url과 mapping 시켜주는것
    // 웹브라우저에서 http://localhost:8080/hello로 들어오면 매핑됨
    @GetMapping("hello")
    public String hello(Model model) {
        // 2. model(data : spring!!)를 생성
        model.addAttribute("data","spring!!");

        /**
         * 컨트롤러에서의 리턴값으로 문자로 반환하면 viewResolver가 해당 화면을 찾아서 처리함
         * 3. resouces에 있는 hello 파일에 넘긴다.
         */
        return "hello";
    }

    // MVC 실습 - MVC 구조로 쪼개서 뷰를 컨트롤러에서 랜더링하여 전달해준다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
           model.addAttribute("name",name);
           return "hello-template";
    }

    // API 실습 - 값을 바로 뷰에 리턴함
    @GetMapping("hello-string")
    @ResponseBody   // html-body에 값을 그대로 직접 넣어주겠다라는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // API 실습 2 - json 구조를 만들어주는 실습(객체(json)를 반환하는것)
    @GetMapping("hello-api")
    @ResponseBody   // 없으면 viewResolve를 통해 template에 던져서 해당 html을 출력하지만
                    // 있으면 html-body값을 만들어서 값을 보냄(여기선 json 객체를 만들어서 보냄)
                    // 내생각엔 이 객체를 활용해서 http 통신을 수행할듯
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}