package MVC1.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("테스트!!!!!!!!!!!!!!");
        System.out.println("OldController.handleRequest");
        System.out.println("테스트!!!!!!!!!!!!!!");
        return new ModelAndView("new-form");
    }
}
