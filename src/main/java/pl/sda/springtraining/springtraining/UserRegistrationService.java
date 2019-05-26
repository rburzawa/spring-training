package pl.sda.springtraining.springtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private PasswordEncoder encoder;

    private void registerUser(UserRegistrationDTO dto) {

        User user = dtoToEntity(dto);

    }

    private User dtoToEntity(UserRegistrationDTO dto) {
        UserAddress address = UserAddress.builder()

                .city(dto.getCity())
                .country(dto.getCountry())
                .street(dto.getStreet())
                .zipCode(dto.getZipCode())
                .build();


        User user = User.builder()
                .birthDate(dto.getBirthDate())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .pesel(dto.getPesel())
                .phone(dto.getPhone())
                .preferEmails(dto.isPreferEmails())
                .userAddress(address)
                .passwordHash(encoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .build();

        return user;
    }
}
