import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Validator {
    private static final DateTimeFormatter DATE_FORMATTER =  DateTimeFormatter.ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public static boolean validateLine(String line){
        if (line == null || line.isBlank()){
            return false;
        } else {
            return line.trim().matches("[a-zA-Z]+");
        }
    }

    public static String formatString(String line){
        line = line.trim();
        return line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase();
    }

    public static boolean validateDateOfBirth(String birth) {
        try {
            LocalDate.parse(birth, DATE_FORMATTER);
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDate formatDateOfBirth(String dateOfBirth){
        return LocalDate.parse(dateOfBirth, DATE_FORMATTER);
    }

    public static boolean validatePhone(String phone) {
        return phone.matches("^\\+380\\d{9}$");
    }

    public static int getAge(LocalDate dateOfBirth){
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
