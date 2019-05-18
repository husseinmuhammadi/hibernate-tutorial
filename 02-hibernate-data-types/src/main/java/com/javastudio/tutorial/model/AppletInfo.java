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

    Byte applicationPriorityIndicator;

    public String getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }
}

