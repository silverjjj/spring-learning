package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();


    // 각각 메서드들이 test가 끝나면 돌리는 메서드
    @AfterEach
    public void afterEach() {
        repository.clearStore();    // repository를 clear 해줌
    }

    // Sava 여부 test
    @Test
    public void save() {
        //given
        // 1. member 변수 생성후 이름 저장
        Member member = new Member();
        member.setName("spring"); //when
        repository.save(member);
        //then
        // 2. test 수행
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);   // member가 result랑 같은지아닌지 test 수행
    }

    // 이름으로 계정을 찾는 여부 test
    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();      // shift + f6으로 이름 변경
        member2.setName("spring2");
        repository.save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll(); //then
        assertThat(result.size()).isEqualTo(2);
    }
}