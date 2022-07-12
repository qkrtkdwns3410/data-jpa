package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;

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
    
}