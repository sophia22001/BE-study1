package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // 테스트 대상 객체 인스턴스화
    MemberService memberService;
    @BeforeEach // 각 테스트 실행 전에 무조건 실행된다.
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    //MemberService memberService = new MemberServiceImpl(); // 삭제

    // 테스트 메서드 정의
    @Test // 이 메서드가 테스트임을 JUnit에게 알린다.
    void join(){
        // given (준비) : 상황 설정
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when (실행) : 테스트하려는 행위 실행
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then (검증) : 실행 결과가 기대한 결과와 일치하는지 검증
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
