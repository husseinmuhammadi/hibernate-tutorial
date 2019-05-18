package com.javastudio.tutorial.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APPLET_INFO")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "APPLET_INFO_SEQ")
public class AppletInfo extends EntityBase {

    @NotNull
    @Column(name = "APPLICATION_LABEL", nullable = false, length = 16)
    String applicationLabel;

    @Column(name = "APPLICATION_PRIORITY_INDICATOR")
    Integer applicationPriorityIndicator;

    // Issuer Code Table Index


    // region Getter & Setter
    public String getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }

    public Integer getApplicationPriorityIndicator() {
        return applicationPriorityIndicator;
    }

    public void setApplicationPriorityIndicator(Integer applicationPriorityIndicator) {
        this.applicationPriorityIndicator = applicationPriorityIndicator;
    }
    // endregion Getter & Setter
}

