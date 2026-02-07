package library.modules.users.registration;

import lombok.Data;

@Data
public class CreateAccountDto {

    protected String firstName;
    protected String lastName;
    protected String emailAddress;
    protected String password;
    protected String clubPhoneNumber;
    protected String clubDayOfBirth;
}
