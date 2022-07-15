package study.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import study.datajpa.entity.Member;


/**
 *packageName    : study.datajpa.dto
 * fileName       : MemberDto
 * author         : jihye94
 * date           : 2022-07-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-13        jihye94       최초 생성
 */
@Data
public class MemberDto {
    
    private Long id;
    private String username;
    private String teamName;
    
    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }
    
    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        
    }
    
}
