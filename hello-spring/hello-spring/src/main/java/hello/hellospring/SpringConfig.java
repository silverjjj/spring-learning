package hello.hellospring;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 스프링 빈이 등륵할때 어노테이션이 아닌 직접 자바로 등록하는 방법
 */

/*
 * memberService와 memberRepository를 스프링빈에 등록하자
 * helloController ==> memberService ==> memberRepository 이렇게 스프링 빈이 등록된다.
 */

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);  // Jdbc
        return new JdbcTemplateMemberRepository(dataSource);
    }
}