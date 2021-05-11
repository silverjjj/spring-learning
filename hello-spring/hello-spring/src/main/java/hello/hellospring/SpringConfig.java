package hello.hellospring;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 빈이 등륵할때 어노테이션이 아닌 직접 자바로 등록하는 방법
 */

/*
 * memberService와 memberRepository를 스프링빈에 등록하자
 * helloController ==> memberService ==> memberRepository 이렇게 스프링 빈이 등록된다.
 */

//@Configuration
//public class SpringConfig {
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//}