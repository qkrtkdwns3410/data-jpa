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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;
import study.datajpa.dto.MemberDto;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
    
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
    
    @Query("select m.username from Member m")
    List<String> findUsernameList();
    
    @Query("select  new study.datajpa.dto.MemberDto(m.id,m.username, t.name)  " +
           "from Member m " +
           " join m.team t")
    List<MemberDto> findMemberDto();
    
    @Query("select m from Member  m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);
    
    List<Member> findListByUsername(String username);
    
    Member findMemberByUsername(String username);
    
    Optional<Member> findOptionalByUsername(String username);
    
    @Query(value = "select  m from Member  m left join m.team t",
        countQuery = "select count(m.username) from Member  m")
    Page<Member> findByAge(int age, Pageable pageable);
    
    @Modifying(clearAutomatically = true)
    @Query("update Member  m " +
           "set m.age = m.age +1 " +
           "where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);
    
    @EntityGraph(attributePaths = ("team"))
    List<Member> findEntityGraphByUsername(@Param("username") String username);
    
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByUsername(String username);
    
    //select for update
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);
    
    List<UsernameOnly> findProjectionsByUsername(@Param("username") String username);
    
}
