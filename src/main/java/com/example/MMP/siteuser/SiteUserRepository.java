package com.example.MMP.siteuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteUserRepository extends JpaRepository<SiteUser,Long> ,SiteUserCustom{

    Optional<SiteUser> findByUserId(String userId);
    Optional<SiteUser> findByName(String name);
    Optional<SiteUser> findByUserIdAndEmail(String userId, String email);
    SiteUser findByNumber(String number);
<<<<<<< HEAD
}
=======
}
>>>>>>> 1b62e6e0842e675028138d9a2166ac6d62d47755
