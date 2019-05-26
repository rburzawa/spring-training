package pl.sda.springtraining.springtraining;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;

    @Embedded
    private UserAddress userAddress;
    private String birthDate;
    private String pesel;
    private String username;
    private String passwordHash;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Countries countries;
    private boolean preferEmails;
}
