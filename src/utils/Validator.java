package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alejandro Ojea
 */
public class Validator {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{6,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\+?\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isValidDni(String dni) {
        String dniRegex = "^\\d{8}[A-Za-z]$";
        Pattern pattern = Pattern.compile(dniRegex);
        Matcher matcher = pattern.matcher(dni);
        return matcher.matches();
    }
    
    public static boolean isValidSalary(String salary) {
    String salaryRegex = "^\\d+(\\.\\d+)?$";
    Pattern pattern = Pattern.compile(salaryRegex);
    Matcher matcher = pattern.matcher(salary);
    return matcher.matches();
}
}
