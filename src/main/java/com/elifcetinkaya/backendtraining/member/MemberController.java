package com.elifcetinkaya.backendtraining.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()
    public List<MemberBO> get() {
        return memberService.getMembers();
    }

    @GetMapping(path = "/students")
    public List<MemberBO> getStudents() {
        return memberService.getStudents();
    }

    @GetMapping(path = "/teachers")
    public List<MemberBO> getTeachers() {
        return memberService.getTeachers();
    }

    @GetMapping(path = "/staff")
    public List<MemberBO> getStaff() {
        return memberService.getStaff();
    }

    @PostMapping()
    public void registerNew(@RequestBody Member member) {
        memberService.add(member);
    }

    @DeleteMapping(path = "{process}/{memberType}/{username}")
    public void delete(@PathVariable("process") String process,
            @PathVariable("memberType") String memberType,
            @PathVariable("username") String username) {
        memberService.delete(process, memberType, username);
    }

    @PutMapping(path = "{process}/{memberType}/{username}")
    public void update(@PathVariable("process") String process,
                        @PathVariable("memberType") String memberType,
                        @PathVariable("username") String username,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email) {
        memberService.update(process, memberType, username, name, email);
    }
}
