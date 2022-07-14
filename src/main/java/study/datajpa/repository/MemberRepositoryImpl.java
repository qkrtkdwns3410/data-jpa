package study.datajpa.repository;
/*
 *packageName    : study.datajpa.repository
 * fileName       : MemberRepositoryImpl
 * author         : ipeac
 * date           : 2022-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-15        ipeac       최초 생성
 */

import lombok.RequiredArgsConstructor;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    
    private final EntityManager em;
    
    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member  m", Member.class)
                 .getResultList();
    }
    
}
