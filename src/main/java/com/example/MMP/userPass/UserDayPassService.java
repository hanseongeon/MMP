package com.example.MMP.userPass;

import com.example.MMP.siteuser.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDayPassService {
    private final UserDayPassRepository userDayPassRepository;

    public UserDayPass UserDayadd(String name, String title, int price, int passDays, SiteUser siteUser){
        UserDayPass userDayPass = new UserDayPass();
        userDayPass.setPassName(name);
        userDayPass.setPassTitle(title);
        userDayPass.setPassPrice(price);
        userDayPass.setPassStart(LocalDate.now());
        LocalDate finish = LocalDate.now().plusDays(passDays);
        userDayPass.setPassFinish(finish);
        userDayPass.setSiteUser(siteUser);
        return userDayPassRepository.save(userDayPass);
    }

    public List<UserDayPass> findBySiteUser(SiteUser siteUser){

        return userDayPassRepository.findBySiteUser(siteUser);
    }

    public UserDayPass findByPassName(String passName) {

        return userDayPassRepository.findByPassName(passName);
    }

    public void save(UserDayPass userDayPass) {
        userDayPassRepository.save(userDayPass);
    }

    public List<UserDayPass> findAll() {
        return userDayPassRepository.findAll();
    }

    public void delete(UserDayPass userDayPass) {
        userDayPassRepository.delete(userDayPass);
    }

    public UserDayPass findById(Long passId) {
        return userDayPassRepository.findById(passId).orElseThrow();
    }
}
