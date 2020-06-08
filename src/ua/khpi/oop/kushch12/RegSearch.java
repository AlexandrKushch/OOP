package ua.khpi.oop.kushch12;

public class RegSearch {
    private static String NAME_SEARCH = "\\b[A-Z][a-z]*asha\\b"; // Names which ended in 'asha'
    private static String AGE_SEARCH = "\\b(30)\\b|\\b([1-2][0-9])\\b|\\b([1-9])\\b"; // Age <= 30

    public static boolean nameSearch(String name) {
        return name.matches(NAME_SEARCH);
    }

    public static boolean ageSearch(String age) {
        return age.matches(AGE_SEARCH);
    }
}
