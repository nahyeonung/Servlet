package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepositary;
import hello.servlet.web.frontcontroller.ModelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepositary memberRepositary = MemberRepositary.getInstance();

    @RequestMapping("springmvc/v1/members")
    public ModelAndView process(){

        List<Member> members = memberRepositary.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;

    }
}
