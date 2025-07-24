package hello.core.member;

// 회원 데이터를 어떻게 저장하고 찾아올지에 대한 인터페이스를 정의한다.
// 레포지토리: 데이터를 저장하는 방식을 정의

public interface MemberRepository {
    // 회원을 저장하는 기능
    void save(Member member);

    // ID를 통해 회원을 찾아오는 기능
    Member findById(Long id);
}
