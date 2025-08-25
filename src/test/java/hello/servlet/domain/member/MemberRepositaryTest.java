package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositaryTest {

    MemberRepositary memberRepositary = MemberRepositary.getInstance();

    @AfterEach
    void afterEach(){
        memberRepositary.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepositary.save(member);

        //then
        Member findMember = memberRepositary.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("ungs", 28);
        Member member2 = new Member("angry", 90);

        memberRepositary.save(member1);
        memberRepositary.save(member2);

        //when
        List<Member> result = memberRepositary.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);
    }

}