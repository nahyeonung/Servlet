package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Message body의 내용을 바이트 코드로 얻을 수 있는 코드
        //HTML form 데이터나 쿼리스트링도 InputStream으로 읽을 수 있으나 그것들은 getParameter로 바로 읽을 수 있기에 굳이 이렇게 받을 필요X
        ServletInputStream inputStream = req.getInputStream();
        //바이트 코드를 인코딩하는 코드(UTF-8로 인코딩)
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("ok");

    }
}
