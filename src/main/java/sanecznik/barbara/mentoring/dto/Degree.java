package sanecznik.barbara.mentoring.dto;

public enum Degree {
    INZ("inżynier", "inż."),
    MGR("magister","mgr"),
    DR ("doktor", "dr"),
    PROF("profesor", "prof.");

    private String fullName;
    private String shortName;

    Degree(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }
}
