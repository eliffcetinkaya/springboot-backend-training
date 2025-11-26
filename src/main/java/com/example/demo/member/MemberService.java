package com.example.demo.member;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberBO> getMembers() {
        return memberRepository.findAll()
                .stream().map(this::MemberBO)
                .collect(Collectors.toList());
    }

    public List<MemberBO> getStudents() {
        return memberRepository.findByMemberType(MemberType.STUDENT)
                .stream().map(this::MemberBO)
                .collect(Collectors.toList());
    }

    public List<MemberBO> getTeachers() {
        return memberRepository.findByMemberType(MemberType.TEACHER)
                .stream().map(this::MemberBO)
                .collect(Collectors.toList());
    }

    public List<MemberBO> getStaff() {
        return memberRepository.findByMemberType(MemberType.STAFF)
                .stream().map(this::MemberBO)
                .collect(Collectors.toList());
    }

    public MemberBO MemberBO(Member member) {
        return new MemberBO(member, groupedFeatures(member.getFeatures()));
    }

    public List<FeatureGroup> groupedFeatures(List<Feature> features){
        return features.stream()
                .collect(Collectors.groupingBy(Feature::getFeatureType))
                .entrySet().stream()
                .map(entry -> new FeatureGroup(
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(f->new FeatureBO(f.getAttributeName(),f.getAttributeValue()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public void add(Member member) {
        Optional<Member> memberOptional = memberRepository.findByUsername(member.getUsername());
        if (memberOptional.isEmpty()) {
            Member newMember = new Member(member.getUsername(), member.getName(), member.getEmail(), member.getDob(),
                    member.getMemberType(), member.getFeatures());
            memberRepository.save(newMember);
            System.out.println("Member with username " + member.getUsername() + " added");
        } else  {
            System.out.println("Member with username " + member.getUsername() + " already exists");
        }
    }

    public void delete(String process, String memberType, String username) {
        Optional<Member> member = memberRepository.findByUsername(username);
        if (member.isEmpty()) {
            throw new IllegalStateException("Member with username " + username + " does not exist");
        }
        memberRepository.delete(member.get());
        System.out.println("Member with username " + username + " deleted");
    }

    @Transactional
    public Member update(String process, String memberType, String username, String name, String email) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow( () -> new IllegalStateException("Member with username " + username + " does not exist"));
        if (name != null &&
                !name.isEmpty() &&
                !Objects.equals(member.getName(), name)) {
            member.setName(name);
            System.out.println("Name is updated to " + name + ".");
        }
        if (email != null &&
                !email.isEmpty() &&
                !Objects.equals(email, member.getEmail())) {
            Optional<Member> memberOptional1 = memberRepository.
                    findByEmail(email);
            if (memberOptional1.isPresent()) {
                throw new IllegalStateException("email is taken");
            }
            member.setEmail(email);
            System.out.println("Email is updated to "  + email + ".");
        }return member;
    }
}
