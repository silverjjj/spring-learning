package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// 여긴 테스트단
class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder() {
        long memberId = 1L;
        // 1. memberId = 1L, name = memberA, Grade = VIP인 멤버 추출
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // 2. 메모리에 저장시킴
        memberService.join(member);

        // 3. memberId = 1L인 유저가 상품 = itemA, 가격 = 10000에 주문
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // 4. order.getDiscountPrice()와 1000원이 일치한지를 확인
        //      - 해당 유저는 VIP라 1000원 할인받음
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        System.out.println(member.getName()+" 회원님의 할인 가격은 " + order.getDiscountPrice()+ "원 입니다.");
    }
}
