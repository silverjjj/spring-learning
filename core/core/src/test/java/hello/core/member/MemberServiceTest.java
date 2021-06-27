package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

// Test code
// junit으로 test를 수행하기 위한 코드
public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    // join 검증
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
