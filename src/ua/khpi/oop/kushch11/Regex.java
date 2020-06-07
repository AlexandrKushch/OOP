package ua.khpi.oop.kushch11;

public class Regex {
    private final String REGEX_NAME = "\\b[A-Z][a-z]+\\b";
    private final String REGEX_BIRTHDAY = "\\b(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-([0-9]{4})\\b";
    private final String REGEX_AGE = "\\b(1[1-9][0-9])\\b|\\b([1-9][0-9])\\b|\\b([1-9])\\b"; // 1-199
    private final String REGEX_GENDER = "\\bmale|female\\b";

    public boolean matchName(String name) {
        return name.matches(REGEX_NAME);
    }

    public boolean matchBirthday(String birthday) {
        return birthday.matches(REGEX_BIRTHDAY);
    }

    public boolean matchAge(String age) {
        return age.matches(REGEX_AGE);
    }

    public boolean matchGender(String gender) {
        return gender.matches(REGEX_GENDER);
    }
}
