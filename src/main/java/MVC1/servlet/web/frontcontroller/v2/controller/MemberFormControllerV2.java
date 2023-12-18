package MVC1.servlet.web.frontcontroller.v2.controller;

import MVC1.servlet.web.frontcontroller.MyView;
import MVC1.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test!!!");
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
