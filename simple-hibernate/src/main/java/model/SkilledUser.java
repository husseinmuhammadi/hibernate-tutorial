package model;

import type.Skill;

import java.io.Serializable;

public class SkilledUser implements Serializable {

    public SkilledUser() {
        mandatory = "YES";
    }

    private Long id;

    private String name;

    private Skill skill;

    private String mandatory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }
}
