package pl.sda.springtraining.springtraining;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegistrationDTO {

    @Size(min = 3, max = 15, message = "Imie od 3 do 15 znakow")
    private String firstName;
    private String lastName;
    private String birthDate;
    private String pesel;
    private String username;
    private String password;
    private String phone;
    private boolean preferEmails;
    private String zipCode;
    private String city;
    private Countries country;
    private String street;
}
