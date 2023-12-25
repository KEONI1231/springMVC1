package MVC1.servlet.web.frontcontroller.v3;

import MVC1.servlet.web.frontcontroller.ModelView;
import MVC1.servlet.web.frontcontroller.MyView;
import MVC1.servlet.web.frontcontroller.v2.ControllerV2;
import MVC1.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import MVC1.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import MVC1.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import MVC1.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import MVC1.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import MVC1.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV1Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV1Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV3());
        controllerV1Map.put("/front-controller/v2/members/save", new MemberSaveControllerV3());
        controllerV1Map.put("/front-controller/v2/members", new MemberListControllerV3());
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerV1Map.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap


        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName(); //논리 이름 new-form

        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");

        view.render(mv.getModel(),request, response);

    }

    private Map<String, String> createParamMap (HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
