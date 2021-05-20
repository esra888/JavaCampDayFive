package Business.Abstracts;

public interface AuthenticationService {
    boolean emailCheck(String email);
    boolean firstNameCheck(String firstName);
    boolean lastNameCheck(String lastName);
    boolean passwordCheck(String password);
}
