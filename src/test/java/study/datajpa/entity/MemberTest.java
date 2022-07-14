package study.datajpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {
    
    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void testEntity() throws Exception {
        //given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        
        em.persist(teamA);
        em.persist(teamB);
        
        //when
        Member member1 = new Member("member1", 20, teamA);
        Member member2 = new Member("member2", 22, teamB);
        Member member3 = new Member("member3", 32, teamA);
        Member member4 = new Member("member4", 42, teamB);
        
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        
        // db에 insert 쿼리 전달
        em.flush();
        em.clear();
        
        //확인
        List<Member> members = em.createQuery("select m from Member  m", Member.class)
                                 .getResultList();
        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam() = " + member.getTeam());
            
        }
        
    }
    
    @Test
    public void JpaEventBaseEntity() throws Exception {
        //given
        Member member = new Member("member1");
        memberRepository.save(member); //@PrePersist 발생
        
        Thread.sleep(100);
        
        member.setUsername("member2");
        em.flush(); // @PreUpdate
        em.clear();
        //when
        Member member1 = memberRepository.findById(member.getId())
                                         .get();
        
        LocalDateTime lastModifiedDate = member1.getLastModifiedDate();
        LocalDateTime createdDate = member1.getCreatedDate();
        System.out.println("createdDate = " + createdDate);
        System.out.println("lastModifiedDate = " + lastModifiedDate);
        
        //then
        
    }
    
}