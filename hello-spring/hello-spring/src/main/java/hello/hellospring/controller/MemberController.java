package hello.hellospring.controller;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
참고 : 해당 스프링은 helloController는 스프링이 제공하기 때문에 스프링빈으로 자동으로 동륵한다.
하지만 MemberController 아니기 때문에 @Controller를 넣어 등록한다.
@Controller 뿐만 아니라 @Component를 포함하는 @Service, @Repository더 스프링빈으로 자동등록한다.
*/
@Controller
public class MemberController {

    private final MemberService memberService;

    /**
    Autowired : MemberController와 MemberService를 이어줌
     스프링 빈에 등록이 되야 사용 가능함
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    };

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // soutv
//        System.out.println("member = " + member.getName());

        // 회원가입 인스턴스
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        // members 객체가 html에서 랜더링됨
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}