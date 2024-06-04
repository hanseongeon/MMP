package com.example.MMP.wod;

import com.example.MMP.siteuser.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Wod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private SiteUser writer;

    private String image;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    private List<SiteUser> likeList;

    private int like;

    private LocalDateTime createDate;
}
