package MVC1.servlet.basic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // "/hello"로 요청이 오면 아래가 실행되는데
public class HelloServlet extends HttpServlet { //서블릿은 HttpServlet이라는 클래스를 상속받아야 함.

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //쿼리 파라미터
        String userName = request.getParameter("username"); // 서블릿 기능임
        System.out.println("username = " + userName);

        response.setContentType("text/plain"); // 컨텐트 타입, 헤더 정보에 들어감
        response.setCharacterEncoding("utf-8"); // 헤더정보에 들어감
        response.getWriter().write("hello "+userName );

    }
}
