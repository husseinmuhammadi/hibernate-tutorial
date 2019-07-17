package com.javastudio.tutorial.model;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);

    String getStatus();
}
