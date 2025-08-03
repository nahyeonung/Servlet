package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
* 1. 파라미터 전송 기능 http://localhost:8080/request-param?username=hello&age=20
* */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /*
        * req.getParameter 메서드는 GET 파라미터, POST 파라미터 모두 확인할 수 있다.
        * 왜냐하면 GET, POST 둘 다 쿼리 파라미터 형식으로 데이터를 전달하기 때문이다. 차이점은 GET은 header로, POST는 body로 파라미터 전달.
        * */
        System.out.println("전체 파라미터 조회 [START]");
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("전체 파라미터 조회 [END]");
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String age = req.getParameter("age");
        System.out.println("age = " + age);

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        res.getWriter().write("ok");

    }

}
