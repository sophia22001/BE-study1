package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 레포지토리를 구현한 클래스
// 실제 회원 데이터를 메모리 상의 HashMap에 저장하고 관리한다.
// save와 findById 메서드를 구현하여 HashMap에 데이터를 넣고 찾는 로직을 제공한다.

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberid) {
        return store.get(memberid);
    }
}
