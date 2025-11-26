package com.elifcetinkaya.backendtraining.member;

import java.util.List;

public class FeatureGroup {
    private FeatureType featureType;
    private List<FeatureBO> features;

    public FeatureGroup(FeatureType featureType, List<FeatureBO> features) {
        this.featureType = featureType;
        this.features = features;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }
    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }
    public List<FeatureBO> getFeatures() {
        return features;
    }
    public void setFeatures(List<FeatureBO> features) {
        this.features = features;
    }
}
