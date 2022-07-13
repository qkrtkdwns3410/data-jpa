package study.datajpa.repository;
/*
 *packageName    : study.datajpa.repository
 * fileName       : TeamRepository
 * author         : ipeac
 * date           : 2022-07-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-13        ipeac       최초 생성
 */

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.domain.Team;


public interface TeamRepository extends JpaRepository<Team, Long> {

}
