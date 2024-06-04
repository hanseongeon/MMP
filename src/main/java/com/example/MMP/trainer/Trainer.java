package com.example.MMP.trainer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String phone_number;
    private String birthDate;
    private String trainerId;
    private String password;
    @Email
    @Column(unique = true)
    private String email;
}
