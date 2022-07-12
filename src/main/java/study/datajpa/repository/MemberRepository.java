package study.datajpa.repository;
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

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.domain.Member;


public interface MemberRepository extends JpaRepository<Member, Long> {

}
