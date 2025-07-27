package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //request.getParameter로 편리하게 쿼리 파라미터를 조회할 수 있다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plan"); //응답 데이터 타입 지정
        response.setCharacterEncoding("utf-8"); //응답 데이터 인코딩 지정
        response.getWriter().write("hello " + username); //응답 HTTP body에 데이터가 들어감
    }
}
