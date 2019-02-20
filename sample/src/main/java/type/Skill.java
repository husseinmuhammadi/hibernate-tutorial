package type;

public enum Skill {
    GOOD("G"),
    BETTER("B"),
    BEST("S");

    private String id;

    private Skill(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Skill getSkill(String id) {
        Skill targetSkill = null;
        for (Skill skill : Skill.values()) {
            if (skill.getId().equals(id)) {
                targetSkill = skill;
            }
        }
        return targetSkill;
    }
}
