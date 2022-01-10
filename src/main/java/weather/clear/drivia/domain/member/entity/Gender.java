package weather.clear.drivia.domain.member.entity;

public enum Gender {

    MALE(1)/*, FEMALE, FOREIGN_MALE, FOREIGN_FEMALE;*/;

    private int i;

    Gender(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
