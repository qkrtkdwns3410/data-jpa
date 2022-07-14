package study.datajpa.repository;

import study.datajpa.entity.Member;

import java.util.List;


/*
 *packageName    : study.datajpa.repository
 * fileName       : MemberRepositoryCustom
 * author         : ipeac
 * date           : 2022-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-15        ipeac       최초 생성
 */
public interface MemberRepositoryCustom {
    
    List<Member> findMemberCustom();
    
}
