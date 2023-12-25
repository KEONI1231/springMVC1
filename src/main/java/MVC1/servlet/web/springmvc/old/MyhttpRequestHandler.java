package MVC1.servlet.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;


@Component("/springmvc/request-handler")
public class MyhttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("테스트!");
        System.out.println("MyhttpRequestHandler.handleRequest");
        System.out.println("테스트!!!!!!!!!!!!!!");
    }
}
