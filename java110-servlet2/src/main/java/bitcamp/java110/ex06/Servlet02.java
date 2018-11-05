/* 서블릿 배치 정보 - loadOnStratup 속성
 * => loadOnStratup 속성의 값을 설정하지 않으면,
 *    클라이언트가 최초로 해당 서블릿의 실행으르 욫어했을 때 비로서 객체를 생성한다.
 * => loadOnStartup 속성의 값을 설정하면,
 *    웹애플리케이션이 시작될 때 해당 서블리쇼 객체를 자동으로 생성한다.
 *    물로 init()도 자동으로 호출된다.
 * => 사용법
 *    loadOnStartup=실행순서
 * => 활용
 *    - 서블릿을 실행하기 전에 준비해야할 작업이 있다면,
 *      그리고 그 작업을 수행하는 데 시간이 걸린다면,
 *      서블릿을 실행하기 전에 미리 서블릿 객체를 만들어 놓고,
 *      init()에서 필요한 자원을 미리 준비시키는 것이 좋다.
 *    - 모든 서블릿들이 공유하는 자원을 준비시킬 때도 응요할 수 있다.
 * 
 */

package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( // 배치 정보를 설정하는 애노테이션
    value="/ex06/servlet02",
    initParams= {
        @WebInitParam(name="aaa",value="hello"),
        @WebInitParam(name="bbb",value="hello2"),
        @WebInitParam(name="ccc",value="hello3")
    })
public class Servlet02 extends HttpServlet {
private static final long serialVersionUID = 1L;

@Override
public void service(
        HttpServletRequest req, 
        HttpServletResponse res) 
        throws ServletException, IOException {

    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    // 배치 정보에서 초기화 파라미터 값을 꺼내기
    out.printf("aaa=%s\n", this.getInitParameter("aaa"));
    out.printf("bbb=%s\n", this.getInitParameter("bbb"));
    out.printf("ccc=%s\n", this.getInitParameter("ccc"));
}
}









