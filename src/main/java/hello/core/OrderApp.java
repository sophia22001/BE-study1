package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        // DIP 만족. AppConfig에서 의존성 주입시켜서 준다.
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // MemberService memberService = new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member); // 회원을 메모리에 넣기

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order); // toString 실행됨
        System.out.println("order = " + order.calculatePrice());
    }
}
