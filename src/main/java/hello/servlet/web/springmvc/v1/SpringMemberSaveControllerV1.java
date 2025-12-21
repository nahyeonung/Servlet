package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepositary;
import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 {

    private MemberRepositary memberRepositary = MemberRepositary.getInstance();
    @RequestMapping("springmvc/v1/member/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepositary.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;

    }
}
