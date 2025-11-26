package com.elifcetinkaya.backendtraining.member;

import jakarta.persistence.*;

@Entity
@Table(name = "features")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String attributeName;
    private String attributeValue;
    @ManyToOne
    @JoinColumn(name = "memberID", nullable = false)
    private Member member;
    private FeatureType featureType;

    public Feature() {
    }

    public Feature(String attributeName, String attributeValue, FeatureType featureType) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.featureType = featureType;
    }

    public Feature(String attributeName, String attributeValue, Member member, FeatureType featureType) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.member = member;
        this.featureType = featureType;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }
}
