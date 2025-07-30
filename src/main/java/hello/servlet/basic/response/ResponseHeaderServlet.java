package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //setStatus: 응답 메시지의 상태코드를 지정할 수 있는 메서드
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        //[response-header]
       /* 메서드 없이 헤더 주입
        * resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        * resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        * resp.setHeader("Pragma", "no-cache");
        * resp.setHeader("my-header", "hello"); //내가 원하는 임의의 헤더를 만들 수 있다.
        */
        content(resp);

        //[cookie]
        /* 메서드 없이 쿠키 주입
        * resp.setHeader("Set-Cookie", "myCookie=hello; Max-Age=600");
        */
        cookie(resp);

        //[Redirect]
        /*
        * 메서드 없이 Redirect 주입
        *        resp.setStatus(HttpServletResponse.SC_FOUND);
        *        resp.setHeader("Location", "/basic/hello-form.html");
        */
        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }
    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){

        Cookie cookie = new Cookie("myCookie", "hello");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status-code: 302, Location: /basic/hello-form.html
        response.sendRedirect("/basic/hello-form.html");
    }
}
