package com.spring.mvc.basic.v2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-check")
public class LoginCheck extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //아이디 패스워드 읽기
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        //검증
        if (id.equals("banana")) {
            if (pw.equals("1234")) {
                //로그인 성공
                req.setAttribute("result", "success");
            } else {
                //비번 틀림
                req.setAttribute("result", "pwFail");
            }
        } else {
            //id가 없음
            req.setAttribute("result", "idFail");
        }

        //jsp파일 열기
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/temp/")
    }
}
