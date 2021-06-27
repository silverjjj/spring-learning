package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    // psvm + enter
    public static void main(String[] args) {
        // 1. 멤버 생성을 위해 MemberServiceImpl 인스턴스 생성
        MemberService memberAdd = new MemberServiceImpl();
        // 2. 멤버 생성
        Member member = new Member(1L, "memberA", Grade.VIP);
        // 3. 멤버 저장
        memberAdd.join(member);
        // 4. 멤버 찾기
        Member findMember = memberAdd.findMember(1L);
        // soutv
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
