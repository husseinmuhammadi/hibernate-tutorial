package com.javastudio.tutorial.model;

import com.javastudio.tutorial.type.CharacterEncoding;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "appletInfo")
@Table(name = "APPLET_INFO")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "APPLET_INFO_SEQ")
public class AppletInfo extends EntityBase {

    @NotNull
    @Column(name = "APPLICATION_LABEL", nullable = false, length = 16)
    String applicationLabel;

    @Column(name = "APPLICATION_PRIORITY_INDICATOR")
    Integer applicationPriorityIndicator;

    @Type(type = "com.javastudio.tutorial.converter.CharacterEncodingConverter")
    @Column(name = "ISSUER_CODE_TABLE_INDEX")
    CharacterEncoding issuerCodeTableIndex;

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

    public CharacterEncoding getIssuerCodeTableIndex() {
        return issuerCodeTableIndex;
    }

    public void setIssuerCodeTableIndex(CharacterEncoding issuerCodeTableIndex) {
        this.issuerCodeTableIndex = issuerCodeTableIndex;
    }
    // endregion Getter & Setter
}

