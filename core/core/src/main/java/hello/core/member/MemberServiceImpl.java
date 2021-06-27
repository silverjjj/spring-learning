package hello.core.member;
// 회원 서비스 구현체
public class MemberServiceImpl implements MemberService {
    // 1. MemoryMemberRepository 인스턴스를 생성
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 2. MemoryMemberRepository의 객체인 save
    public void join(Member member) {
        memberRepository.save(member);
    }
    // 3. MemoryMemberRepository의 객체인 findById
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
