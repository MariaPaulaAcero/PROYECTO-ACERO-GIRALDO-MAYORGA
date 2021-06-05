package sample;

public class DateException extends Exception{

    public static String BAD_DEATHDATE_AFTER = "The death of date is after the current date";
    public static String BAD_DEATHDATE_BEFORE = "The death of date is before the first murder";
    public static String BAD_DEATHDATE = "this text is not a death date";

    public DateException(String badDeathdate) {

    }
}
