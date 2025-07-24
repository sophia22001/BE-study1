package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// OrderService는 할인에 관한 건 모르고, DiscountPolicy가 알아서 하게 한다.
// -> 단일책임 원칙 !

public class OrderServiceImpl implements OrderService{

    // DIP를 지킨다. 이 인터페이스로 어떤 구현체가 들어올지 나는 모른다.
    private final MemberRepository memberRepository; // 리포지토리에서 회원을 찾고,
    private final DiscountPolicy discountPolicy; // 할인 서비스에 회원을 넘긴다.

    // 생성자가 필요해졌다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원을 찾고,
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인에 회원을 넘긴다.
        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문은 할인된 결과를 받기만 한다.
    }
}
