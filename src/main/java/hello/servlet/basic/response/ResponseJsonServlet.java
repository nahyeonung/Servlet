package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.basic.model.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ResponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-Type: application/json
        resp.setContentType("application/json");
        /*
        * `application/json` 은 스펙상 utf-8 형식을 사용하도록 정의되어 있다. 그래서 스펙에서 charset=utf-8 과
        *    같은 추가 파라미터를 지원하지 않는다.
        */
        resp.setCharacterEncoding("utf-8"); //무의미한 세팅

        HelloData helloData = new HelloData();
        helloData.setAge(28);
        helloData.setUsername("La");

        //{"username":"La", "age":28}
        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);

    }
}
