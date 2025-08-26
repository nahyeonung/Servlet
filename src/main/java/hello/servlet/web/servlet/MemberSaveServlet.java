package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepositary;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepositary memberRepositary = MemberRepositary.getInstance();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("MemberSaveServlet.service");
        String username = request.getParameter("username");
        //request.getParameter로 데이터를 추출할 때 데이터 타입은 항상 String이다.
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepositary.save(member);


        //멤버를 저장했으니 저장이 잘 되었는지 보여주는 페이지 response
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>id="+member.getId()+"</li>\n" +
                " <li>username="+member.getUsername()+"</li>\n" +
                " <li>age="+member.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");


    }
}
