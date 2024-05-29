package starter.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String getCurrentDatePlusDays(int days) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_YEAR, days); // Add the specified number of days to the current date
        Date currentDatePlusDays = c.getTime();
        return dateFormat.format(currentDatePlusDays);
    }

    public static int extractDaysFromString(String input) {
        // Define a regular expression pattern to extract the number
        Pattern pattern = Pattern.compile("(\\d+) days later");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Extract the integer from the matched group
            return Integer.parseInt(matcher.group(1));
        }

        // Return 0 or throw an exception if no valid number is found
        throw new IllegalArgumentException("Invalid input string: " + input);
    }

    public static String convertDate(String dateStr) {
        // Define the input date format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        // Define the output date format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);

        // Parse the input date string to a LocalDate
        LocalDate date = LocalDate.parse(dateStr, inputFormatter);
        // Format the LocalDate to the desired output format
        return date.format(outputFormatter);
    }
}
