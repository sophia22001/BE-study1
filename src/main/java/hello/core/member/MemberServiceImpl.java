package hello.core.member;


// 서비스 인터페이스를 구현한 클래스
// 회원가입 및 회원 찾기 로직을 실제로 구현한다.

public class MemberServiceImpl implements MemberService {
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 의존성 역접 원칙을 지킨다. (인터페이스에만 의존)
    // 이제 MemoryMemberRepository 라는 구현체에 의존하지 않게 되었다.
    // 이제부터 의존관계에 대한 고민은 외부에 맡기고, 서비스는 실행에만 집중하면 된다.
    private final MemberRepository memberRepository;

    // 샐성자가 필요해졌다: AppConfig에서 어떤 구현체를 넣을건지 결정해주기 때문.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        // 리포지토리를 통해 회원 저장
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        // 리포지토리를 통해 회원 찾기
        return memberRepository.findById(memberId);
    }
}
