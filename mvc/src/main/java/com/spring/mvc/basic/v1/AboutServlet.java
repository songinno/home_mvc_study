package com.spring.mvc.basic.v1;

import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//#서블릿: 웹 브라우저의 요청을 처리하여 서버에서 동적HTML을 생성해서 응답해주는 클래스.
@WebServlet("/about")
public class AboutServlet extends HttpServlet {
    public AboutServlet() {
        System.out.println("어바웃서블릿 객체 생성됨!!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/about요청 들어옴");

        //HttpServletRequest req -> 요청 정보들(IP주소, URL, URI, 보낸 날짜 등) 이곳에 모임.
        //URI정보 얻기
        String requestURI = req.getRequestURI();
        System.out.println("requestURI: " + requestURI);

        //URL정보 얻기
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL: " + requestURL);

        //요청 파라미터 얻기
        String queryString = req.getQueryString();
        System.out.println("queryString: " + queryString);

        //요청 파라미터 각각 얻기
        String msg = req.getParameter("msg");
        System.out.println("msg = " + msg);

        String hobby = req.getParameter("hobby");
        System.out.println("hobby = " + hobby);

        //웹브라우저에 html을 응답 ( HttpServletResponse resp을 이용)
        resp.setContentType(MediaType.TEXT_HTML_VALUE);
        resp.setCharacterEncoding("utf-8");
        PrintWriter w = resp.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write("</head>");
        w.write("<body>");
        w.write("<h1> 당신이 보낸 메세지: " + msg + "</h1>");
        if (hobby.equals("soccer")) {
            w.write("<h2> 축구를 좋아하시는군요</h2>");
        } else {
            w.write("<h2> 축구 말고 " + hobby + "를 좋아하시네요~~</h2>");
        }
        w.write("</body>");
        w.write("</html>");

    }
}
