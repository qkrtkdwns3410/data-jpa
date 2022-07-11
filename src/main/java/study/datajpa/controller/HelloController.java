package study.datajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 *packageName    : study.datajpa.controller
 * fileName       : HelloController
 * author         : ipeac
 * date           : 2022-07-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-11        ipeac       최초 생성
 */
@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
}
