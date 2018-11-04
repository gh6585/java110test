// request handler에서 콘텐트 출력하기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01 {

    @RequestMapping("/ex02/test01/m1")
    @ResponseBody
    public String m1() {
        // 리턴 값을 콘텐트로 보낼 때 메서드 선언부에 @ResponseBody를 붙인다.
        // 기본 콘텐트 타입이 "text/plain;charset=ISO=8859-1 이다
        // 그래서 한글을 출력할 때 ISO-8859-1 문자표에 한글이 정의되지 않아서
        // ?로 바뀌어 출력된다.
        return "Hello! 안녕하세요";
    
    }
}