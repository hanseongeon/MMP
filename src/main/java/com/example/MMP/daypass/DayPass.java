package com.example.MMP.daypass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DayPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passId;

    private String passName;

    private String passTitle;

    private int passPrice;

    private int passDays;

}
