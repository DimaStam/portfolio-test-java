package library.modules.users.registration;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class CreateAccountFactory {

    public static CreateAccountDto createRegisterUserData(){
        CreateAccountDto createAccountData = new CreateAccountDto();
        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        createAccountData.setFirstName(faker.name().firstName());
        createAccountData.setLastName(faker.name().lastName());
        createAccountData.setEmailAddress(faker.letterify("??") + System.currentTimeMillis() + "@example.test");
        createAccountData.setPassword("SamplePass123!");
        createAccountData.setClubPhoneNumber("5376" + (faker.number().digits(5)));
        createAccountData.setClubDayOfBirth(dateFormat.format(faker.date().birthday(18, 100)));
        return createAccountData;
    }
}
