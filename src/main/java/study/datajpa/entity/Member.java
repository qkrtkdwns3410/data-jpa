package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;


/*
 *packageName    : study.datajpa.domain
 * fileName       : Member
 * author         : ipeac
 * date           : 2022-07-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-12        ipeac       최초 생성
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member extends BaseTimeEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    
    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
            
        }
    }
    
    public Member(String username) {
        this.username = username;
    }
    
    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
    
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers()
            .add(this);
    }
    
}
