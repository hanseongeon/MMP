package com.example.MMP.challengeGroup;

import com.example.MMP.challenge.attendance.Attendance;
import com.example.MMP.challengeGroup.GroupTag.GroupTag;
import com.example.MMP.chat.ChatRoom;
import com.example.MMP.siteuser.SiteUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class ChallengeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String goal;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    @JsonBackReference
    private SiteUser leader;

    // db에 저장이 안 되면서 챌린지 그룹에 담기는 애너테이션
    @Transient
    private int rank;

    @ManyToMany
    @JoinTable(
            name = "site_user_challenge_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonBackReference
    private Set<SiteUser> members = new HashSet<>();

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<GroupTag> groupTagList = new ArrayList<> ();


    @OneToMany(mappedBy = "challengeGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Attendance> attendances = new ArrayList<>();

    @OneToOne
    @JsonManagedReference
    private ChatRoom chatRoom;


}

