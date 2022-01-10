package weather.clear.drivia.domain.member.entity;

public enum Gender {

    MALE, FEMALE, FOREIGN_MALE, FOREIGN_FEMALE;

    public static Gender genderFormat(int genderNumber) {
        Gender gender;
        if (genderNumber == 1 || genderNumber == 3) {
            gender = Gender.MALE;
        } else if (genderNumber == 2 || genderNumber == 4) {
            gender = Gender.FEMALE;
        } else if (genderNumber == 7) {
            gender = Gender.FOREIGN_MALE;
        } else {
            gender = Gender.FOREIGN_FEMALE;
        }
        return gender;
    }
}
