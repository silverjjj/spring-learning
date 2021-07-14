package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 인스턴스를 정의
    /**
     * 1.
     * OrderServiceImpl은 DiscountPolicy(추상클래스) 뿐만 아니라
     * FixDiscountPolicy(구현클래스)도 의존하고 있다
     * ==> DIP 위반!! (DIP란 인터페이스에만 의존해라!! 라는 의미, 인터페이스와 구현체에 다 의존하면 원칙 위반임)
     * 그 결과, 인터페이스에만 의존하도록 재설계한다.
     *
     * 2.
     * FixDiscountPolicy와 RateDiscountPolicy를 동시에 정의하면 OCP 위반!!
     */

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;      // 1. 재설계 수행 ==> 인터페이스에만 의존함

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 1. memberId를 넣어 member를 리턴받음
        Member member = memberRepository.findById(memberId);
        // 2. member, itemPrice를 넣어 할인 금액을 리턴받음
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
