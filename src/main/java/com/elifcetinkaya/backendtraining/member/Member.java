package com.elifcetinkaya.backendtraining.member;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "member_sequence", allocationSize = 1)
    private Integer id;
    private String username;
    private String name;
    private String email;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    @NonNull
    private MemberType memberType;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<Feature> features = new ArrayList<>();
    @Transient
    private Integer age;

    public Member() {
    }

    public Member(String username,
                  String name,
                  String email,
                  LocalDate dob,
                  MemberType memberType,
                  List<Feature> features) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.memberType = memberType;
        addFeature(features);
    }

    public Member(Integer id,
                  String username,
                  String name,
                  String email,
                  LocalDate dob,
                  MemberType memberType,
                  List<Feature> features) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.memberType = memberType;
        addFeature(features);
    }

    public void addFeature(List<Feature> features) {
        for (Feature feature : features) {
            feature.setMember(this);
            getFeatures().add(feature);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MemberType getMemberType() {
        return memberType;
    }
    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "Member{" +
                "username=" + getUsername() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", dob=" + getDob() +
                ", age=" + getAge() +
                '}';
    }
}
