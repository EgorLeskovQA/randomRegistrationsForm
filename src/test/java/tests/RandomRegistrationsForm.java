package tests;

import org.junit.jupiter.api.Test;
import pages.RandomFormPage;
import utils.RandomUtils;

public class RandomRegistrationsForm  extends TestBase{

    private final RandomFormPage randomFormPage = new RandomFormPage();
    private final RandomUtils randomData = new RandomUtils();

    String firstName = randomData.firstName(),
            lastName = randomData.lastName(),
            userEmail = randomData.userEmail(),
            gender = randomData.gender(),
            userNumber = randomData.userNumber(),
            dayOfBirth = randomData.dayOfBirth(),
            monthOfBirth = randomData.monthOfBirth(),
            yearOfBirth = randomData.yearOfBirth(),
            subjects = randomData.subjects(),
            hobbies = randomData.hobbies(),
            pictureName = randomData.pictureRandom(),
            address = randomData.address(),
            state = randomData.state(),
            city = randomData.city(state);




    @Test
    void registrationFormTest() {
        randomFormPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjects)
                .setHobby(hobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .clickSubmit();


        randomFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                .checkSuccessResult ("Student Email", userEmail)
                .checkSuccessResult ("Gender", gender)
                .checkSuccessResult ("Mobile", userNumber)
                .checkSuccessResult ("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkSuccessResult ("Subjects", subjects)
                .checkSuccessResult ("Hobbies", hobbies)
                .checkSuccessResult ("Picture", pictureName)
                .checkSuccessResult ("Address", address)
                .checkSuccessResult ("State and City", state + " " + city);
    }
}
