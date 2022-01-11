package weather.clear.drivia.domain.member.entity;

public enum Gender {

    MALE, FEMALE, FOREIGN_MALE, FOREIGN_FEMALE;

    public static Gender genderFormat(int genderNumber) {
        if (genderNumber == 1 || genderNumber == 3) {
            return Gender.MALE;
        } else if (genderNumber == 2 || genderNumber == 4) {
            return Gender.FEMALE;
        } else if (genderNumber == 7) {
            return Gender.FOREIGN_MALE;
        } else {
            return Gender.FOREIGN_FEMALE;
        }
    }
}
