package study.datajpa.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.datajpa.domain.Member;

import javax.persistence.EntityManager;


/*
 *packageName    : study.datajpa.repository
 * fileName       : MemberRepository
 * author         : ipeac
 * date           : 2022-07-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-12        ipeac       최초 생성
 */
@Repository
@RequiredArgsConstructor
public class MemberJpaRepository {
    
    private final EntityManager em;
    
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
    
}
