package module.three.lld.principles;

/**
 * DRY (Don't Repeat Yourself):
 * - The DRY (Don't Repeat Yourself) principle is a fundamental concept in software development that emphasizes the importance of reducing
 * code duplication.
 * - By abstracting common functionalities into reusable components, DRY promotes code reusability and maintainability, and reduces the
 * likelihood of inconsistencies and bugs caused by redundant code.
 * <p>
 * Example for DRY (Don't Repeat Yourself):
 * - Imagine you are developing a web application where multiple forms require similar data validation.
 * - Instead of writing separate validation logic for each form, you can create a reusable validation function or class.
 * - Let's say you have two forms: a registration form and a login form. Both forms need to validate the email and password fields.
 */
public class _6DRY {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    // This is a bad example as validation logic is repeated, it is violating the DRY principle.
    private static void badExample() {
        Registration registration = new Registration();
        System.out.println("Validate registration: " + registration.validate("email@gmail.com", "123456"));
        Login login = new Login();
        System.out.println("Validate login: " + login.validate("email@gmail.com", "123456"));
    }

    // This is a good example as validation logic is not repeated, following the DRP principle.
    private static void goodExample() {
        RegistrationForm registration = new RegistrationForm();
        System.out.println("Validate registration form: " + registration.validate("email@gmail.com", "123456"));
        LoginForm login = new LoginForm();
        System.out.println("Validate login form: " + login.validate("email@gmail.com", "123456"));
    }

}

/////////////////////////////////// BAD EXAMPLE ///////////////////////////////
class Registration {
    public boolean validate(String email, String password) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            return false;
        }
        if (password == null || password.length() < 6) {
            return false;
        }
        return true;
    }
}

class Login {
    public boolean validate(String email, String password) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            return false;
        }
        if (password == null || password.length() < 6) {
            return false;
        }
        return true;
    }
}

/////////////////////////////////// GOOD EXAMPLE /////////////////////////////////
class Validator {
    public boolean validateEmail(String email) {
        return email != null && !email.isEmpty() && email.contains("@");
    }

    public boolean validatePassword(String password) {
        return password != null && password.length() >= 6;
    }
}

class RegistrationForm {
    private final Validator validator = new Validator();

    public boolean validate(String email, String password) {
        return validator.validateEmail(email) && validator.validatePassword(password);
    }
}

class LoginForm {
    private final Validator validator = new Validator();

    public boolean validate(String email, String password) {
        return validator.validateEmail(email) && validator.validatePassword(password);
    }
}
