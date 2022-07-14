package study.datajpa.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


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
    
    public void delete(Member member) {
        em.remove(member);
    }
    
    public List<Member> findAll() {
        //JPQL
        return em.createQuery("select m from Member  m", Member.class)
                 .getResultList();
    }
    
    //단건 카운트
    
    public long count() {
        return em.createQuery("select count(m) from Member  m", Long.class)
                 .getSingleResult();
    }
    
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
    
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    
    public List<Member> findByUsernameAndAgeGreaterThen(String username, int age) {
        
        return em.createQuery("select m from Member  m " + "where  m.username = :username " + "and m.age > :age",
                              Member.class)
                 .setParameter("username", username)
                 .setParameter("age", age)
                 .getResultList();
    }
    
    public List<Member> findByPage(int age, int offset, int limit) {
        return em.createQuery("select m from Member  m "
                              + "where m.age  = :age"
                              + " order by  m.username desc ")
                 .setParameter("age", age)
                 .setFirstResult(offset)
                 .setMaxResults(limit)
                 .getResultList();
        
    }
    
    public long totalCount(int age) {
        return em.createQuery("select count(m) from Member  m "
                              + "where m.age  = :age", Long.class)
                 .setParameter("age", age)
                 .getSingleResult();
    }
    
    public int bulkAgePlus(int age) {
        
        return em.createQuery("update Member  m " +
                              "set m.age = m.age +1 " +
                              "where m.age >= :age")
                 .setParameter("age", age)
                 .executeUpdate();
    }
    
}
