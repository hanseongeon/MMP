package com.example.MMP.siteuser;

import com.example.MMP.attendance.Attendance;
import com.example.MMP.challenge.challenge.Challenge;
import com.example.MMP.homeTraining.HomeTraining;
import com.example.MMP.userPass.UserDayPass;
import com.example.MMP.userPass.UserPtPass;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userId;

    private String password;

    private String name;

    private String gender;

    private String number;

    private String birthDate;

    private String email;

    private String userRole;

    @OneToMany(mappedBy = "siteUser",cascade = CascadeType.REMOVE)
    List<UserPtPass> userPtPassList = new ArrayList<>();

    @OneToMany(mappedBy = "siteUser",cascade = CascadeType.REMOVE)
    List<UserDayPass> userDayPassList = new ArrayList<>();
//
//    @OneToMany
//    private List<Wod> wodList;

    @OneToMany(mappedBy = "siteUser")
    private List<Attendance> attendanceList = new ArrayList<>();

    @OneToMany
    private List<Challenge> challenges = new ArrayList<> ();

    @ManyToMany
    private Set<HomeTraining> saveTraining = new HashSet<>();

}
