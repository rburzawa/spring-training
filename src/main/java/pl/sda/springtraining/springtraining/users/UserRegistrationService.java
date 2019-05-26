package pl.sda.springtraining.springtraining.users;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.springtraining.roles.RoleRepository;

@Service
public class UserRegistrationService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    public void registerUser(UserRegistrationDTO dto) {

        User user = dtoToEntity(dto);
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User with email: " + user.getUsername() + " exsists");
        } else {
            userRepository.save(user);
        }

    }

    private User dtoToEntity(UserRegistrationDTO dto) {
        UserAddress address = UserAddress.builder()

                .city(dto.getCity())
                .country(dto.getCountry())
                .street(dto.getStreet())
                .zipCode(dto.getZipCode())
                .build();


        return User.builder()
                .birthDate(dto.getBirthDate())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .pesel(dto.getPesel())
                .phone(dto.getPhone())
                .preferEmails(dto.isPreferEmails())
                .userAddress(address)
                .passwordHash(encoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .roles(Sets.newHashSet(roleRepository.findByRoleName("ROLE_USER")))
                .build();

    }

    /*@PostConstruct
    public void initializeRoles(){
        if (roleRepository.count() == 0){
            roleRepository.save(new Role("ROLE_USER"));
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

    }*/

}

