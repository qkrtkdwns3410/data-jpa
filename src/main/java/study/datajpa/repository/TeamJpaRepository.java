package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


/*
 *packageName    : study.datajpa.repository
 * fileName       : TeamRepository
 * author         : ipeac
 * date           : 2022-07-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-12        ipeac       최초 생성
 */
@Repository
public class TeamJpaRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Team save(Team team) {
        em.persist(team);
        return team;
    }
    
    public void delete(Team tem) {
        em.remove(tem);
    }
    
    public List<Team> findAll() {
        return em.createQuery("select t from Team  t", Team.class).getResultList();
    }
    
    public Team find(Long id) {
        return em.find(Team.class, id);
    }
    
    public Optional<Team> findById(Long id) {
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }
    
    public long count() {
        return em.createQuery("select  count(t) from Team t", Long.class).getSingleResult();
    }
    
}
