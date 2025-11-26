package com.elifcetinkaya.backendtraining.member;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class MemberBO {
    private String username;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;
    private List<FeatureGroup> featureGroups;

    public MemberBO(Member member, List<FeatureGroup> groupedFeatures) {
        this.username = member.getUsername();
        this.name = member.getName();
        this.email = member.getEmail();
        this.dob = member.getDob();
        this.memberType = member.getMemberType();
        this.featureGroups = groupedFeatures;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public List<FeatureGroup> getFeatureGroups() {
        return featureGroups;
    }

    public void setFeatureGroups(List<FeatureGroup> groupedFeatures) {
        this.featureGroups = groupedFeatures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
