package hello.core.member;

// 회원과 관련된 비지니스 로직을 정의하는 인터페이스

public interface MemberService {

    // 회원을 가입시키는 기능
    void join(Member member);

    // 특정 회원을 찾는 기능
    Member findMember(Long memberId);
}
