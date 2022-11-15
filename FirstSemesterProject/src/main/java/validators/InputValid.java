package validators;

import java.util.regex.Pattern;

public class InputValid {

    private final String usernameRegex = "^[A-ZА-Я]([A-ZА-Яa-zа-я]{1,19})$";
    private final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-z0-9-]+\\.[a-z]{2,4}$";
    private final String passwordRegex = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])[a-zA-Z0-9]{8,}$";
    private final String ageRegex = "^([1-9]|[1-2][0-9]|[3][0-5])$";
    private final String textRegex = "^[A-Za-zА-Яа-я]([a-zа-я]{1,30})";

    public String validUsername(String username) {
        Pattern pattern = Pattern.compile(usernameRegex);
        if (pattern.matcher(username).find()) {
            return "";
        } else {
            return "[Username/Name] ";
        }
    }

    public String validEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).find()) {
            return "";
        } else {
            return "[Email] ";
        }
    }

    public String validPassword(String password) {
        Pattern pattern = Pattern.compile(passwordRegex);
        if (pattern.matcher(password).find()) {
            return "";
        } else {
            return "[Password] ";
        }
    }

    public String validAge(String age) {
        Pattern pattern = Pattern.compile(ageRegex);
        if (pattern.matcher(age).find()) {
            return "";
        } else {
            return "[Age] ";
        }
    }

    public String validInputText(String text) {
        Pattern pattern = Pattern.compile(textRegex);
        if (pattern.matcher(text).find()) {
            return "";
        } else {
            return "[Breed/Character] ";
        }
    }
}
