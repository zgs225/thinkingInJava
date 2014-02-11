package annotations;

import java.util.List;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-7
 */
public class PasswordUtils {
    @UseCase(id = 1, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\.*\\d\\.*");
    }

    @UseCase(id = 2)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 3, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> passwords, String password) {
        return !passwords.contains(password);
    }
}
