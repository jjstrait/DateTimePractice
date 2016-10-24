package student.lab;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import java.util.Date;
/**
 * Singleton uility class to simplify managing and using dates and times, 
 * using the new Java Date/Time API (Past JDK 8). Fields are
 *
 * 
 * @author jstra
 * @version 1.00
 */
public class DateUtilities {

    private static DateUtilities instance;

    private DateUtilities() {

    }
    /**
     * Gets the instance of DateUtilities so only one object is made at a time.
     * @return 
     */
    public static DateUtilities getInstance() {
        if (instance == null) {
            instance = new DateUtilities();
        }

        return instance;
    }
    /**
     * To convert a LocalDate to a string
     * @param date - validates to see if it is null
     * @return A string is returned of the date that was passed in, As the format of ISO_LOCAL_DATE
     * @throws IllegalArgumentException 
     */
    public String toString(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }

        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    /**
     * To convert a LocalDateTime to a string
     * @param date - validates to see if it is null
     * @return A string is returned of the date that was passed in, As the format of ISO_LOCAL_DATE_TIME
     * @throws IllegalArgumentException 
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: dateTime argument cannot be null");
        }

        return date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    /**
     * Converts LocalDate to String using a format
     * @param date- validates to see if it is null
     * @param format- validates to see if it is null
     * @return a String of the date in the format that was given
     * @throws IllegalArgumentException 
     */
    public String toString(LocalDate date, String format) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: date argument cannot be null");
        }

        return date.format(DateTimeFormatter.ofPattern(format));
    }
    /**
     * Converts LocalDateTime to String using a format Provided 
     * @param date- validates to see if it is null
     * @param format- validates to see if it is null
     * @return a String of the dateTime in the format that was given
     * @throws IllegalArgumentException 
     */
    public String toString(LocalDateTime date, String format) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Error: dateTime argument cannot be null");
        }

        return date.format(DateTimeFormatter.ofPattern(format));
    }
    /**
     * Covert a string into a LocalDate
     * @param dateString- validates to see if it is null
     * @return A LocalDate
     * @throws IllegalArgumentException 
     */
    public LocalDate toDate(String dateString) throws IllegalArgumentException {
        if(dateString == null){throw new IllegalArgumentException("Input can't be null");}
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
        } catch (Exception e) {
            try {
                date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
            } catch (Exception e2) {
                try {
                    date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (Exception e3) {
                    try {
                        date = LocalDate.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE);
                    } catch (Exception e4) {
                        try {
                            date = LocalDate.parse(dateString, DateTimeFormatter.ISO_ORDINAL_DATE);
                        } catch (Exception e5) {
                            throw new IllegalArgumentException("Not in the proper LocalDate Format");
                        }
                    }

                }
            }
        }
        return date;
    }
    /**
     * Covert a string into a LocalDateTime
     * @param dateString- validates to see if it is null
     * @return A LocalDateTime
     * @throws IllegalArgumentException 
     */
    public LocalDateTime toDateTime(String dateString) throws IllegalArgumentException {
        if(dateString == null){throw new IllegalArgumentException("Input can't be null");}
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
        } catch (Exception e) {
            try {
                date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_INSTANT);
            } catch (Exception e2) {
                try {
                    date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                } catch (Exception e3) {
                    try {
                        date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_LOCAL_TIME);
                    } catch (Exception e4) {
                        try {
                            date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                        } catch (Exception e5) {
                            try {
                                date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_TIME);
                            } catch (Exception e6) {
                                try {
                                    date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_TIME);
                                } catch (Exception e7) {
                                    try {
                                        date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_ZONED_DATE_TIME);
                                    } catch (Exception e8) {
                                        try {
                                            date = LocalDateTime.parse(dateString, DateTimeFormatter.RFC_1123_DATE_TIME);
                                        } catch (Exception e9) {
                                            throw new IllegalArgumentException("Not in the proper LocalDateTime Format");
                                        }

                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

        return date;

    }
    /**
     * Convert String to Date based on a format
     * @param dateString- validates to see if it is null
     * @param format- validates to see if it is null
     * @return
     * @throws IllegalArgumentException 
     */
    public LocalDate toDate(String dateString, String format) throws IllegalArgumentException {
        if(dateString == null||format == null){throw new IllegalArgumentException("Input can't be null");}
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
        return date;
    }
    /**
     * Convert String to a date based on a format
     * @param dateString- validates to see if it is null
     * @param format - validates to see if it is null
     * @return
     * @throws IllegalArgumentException 
     */
    public LocalDateTime toDateTime(String dateString, String format) throws IllegalArgumentException {
        if(dateString == null||format == null){throw new IllegalArgumentException("Input can't be null");}
        LocalDateTime date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(format));
        return date;
    }
    
    
    
    
    
    
    /**
     * Finds the Duration difference between two DateTime 
     * @param startDate- validates to see if it is null
     * @param endDate- validates to see if it is null
     * @return 
     */
    public Duration diff(LocalDateTime startDate,LocalDateTime endDate){
        if(startDate == null||endDate == null){throw new IllegalArgumentException("Inputs can't be null");}
        Duration diff = Duration.between(startDate, endDate);
        return diff;
    }
    
    /**
     * Gets the amount of weeks difference between two dates
     * @param startDate- validates to see if it is null
     * @param endDate- validates to see if it is null
     * @return a Long 
     */
    public double diffInWeek(LocalDateTime startDate,LocalDateTime endDate){
        if(startDate == null||endDate == null){throw new IllegalArgumentException("Inputs can't be null");}
        Duration diff = Duration.between(startDate, endDate);
        return diff.toDays()/7;
    }
    /**
     * Gets the amount of days difference between two dates
     * @param startDate- validates to see if it is null
     * @param endDate- validates to see if it is null
     * @return a Long 
     */
    public long diffInDay(LocalDateTime startDate,LocalDateTime endDate){
        if(startDate == null||endDate == null){throw new IllegalArgumentException("Inputs can't be null");}
        Duration diff = Duration.between(startDate, endDate);
        return diff.toDays();
    }
    /**
     * Gets the amount of hours difference between two dates
     * @param startDate- validates to see if it is null
     * @param endDate- validates to see if it is null
     * @return a Long 
     */
    public long diffInHours(LocalDateTime startDate,LocalDateTime endDate){
        if(startDate == null||endDate == null){throw new IllegalArgumentException("Inputs can't be null");}
        Duration diff = Duration.between(startDate, endDate);
        return diff.toHours();
    }
    /**
     * Gets the amount of min difference between two dates
     * @param startDate- validates to see if it is null
     * @param endDate- validates to see if it is null
     * @return a Long 
     */
    public long diffInMin(LocalDateTime startDate,LocalDateTime endDate){
        if(startDate == null||endDate == null){throw new IllegalArgumentException("Inputs can't be null");}
        Duration diff = Duration.between(startDate, endDate);
        return diff.toMinutes();
    }
    
    
//    
    
}
