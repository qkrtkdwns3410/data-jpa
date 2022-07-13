package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class MemberRepositoryTest {
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Test
    public void testMember() throws Exception {
        //given
        Member member = new Member("memberA");
        Member save = memberRepository.save(member);
        //when
        Member findMember = memberRepository.findById(save.getId()).get();
        //then
        
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
        
    }
    
    @Test
    public void basicCRUD() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        
        memberRepository.save(member1);
        memberRepository.save(member2);
        
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);
        
        //리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
        
        //카운트 검증
        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);
        
        //삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);
        
        long removeCount = memberRepository.count();
        assertThat(removeCount).isEqualTo(0);
    }
    
}