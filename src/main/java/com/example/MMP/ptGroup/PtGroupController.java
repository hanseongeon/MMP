package com.example.MMP.ptGroup;

import com.example.MMP.security.UserDetail;
import com.example.MMP.siteuser.SiteUser;
import com.example.MMP.siteuser.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ptGroup")
public class PtGroupController {
    private final SiteUserService siteUserService;
    private final PtGroupService ptGroupService;

    @GetMapping("/join")
    public String joinUser(@AuthenticationPrincipal UserDetail userDetail){
        boolean isTrainer = userDetail.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_TRAINER"));
        if(!isTrainer)
            return "redirect:/";

        return "ptGroup/ptgroupjoin";
    }

    @PostMapping("/join")
    public String joinUser(@AuthenticationPrincipal UserDetail userDetail, @RequestParam("number")String number){
        boolean isTrainer = userDetail.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_TRAINER"));
        if(!isTrainer)
            return "redirect:/";

        SiteUser siteUser = siteUserService.getUser(userDetail.getUsername());
        PtGroup ptGroup = ptGroupService.findByTrainer(siteUser);
        SiteUser member = siteUserService.getUser(number);
        ptGroup.getMembers().add(member);
        ptGroupService.save(ptGroup);
        member.setPtGroupUser(ptGroup);

        siteUserService.save(member);
        return "redirect:/";
    }
}