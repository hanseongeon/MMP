package com.example.MMP.coupon;

import com.example.MMP.siteuser.SiteUser;
import com.example.MMP.siteuser.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {
    private final CouponService couponService;
    private final SiteUserService siteUserService;
    private final CouponRepository couponRepository;

    @GetMapping("/create")
    public String create(CouponForm couponForm) {
        return "coupon/coupon_create";
    }

    @PostMapping("/create")
    public String create(@Valid CouponForm couponForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "coupon/coupon_create";
        }
        couponService.create(couponForm.getName(), Integer.parseInt(couponForm.getPoint()), Integer.parseInt(couponForm.getDiscount()));

        return "redirect:/coupon/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(Coupon useCoupon) {
        couponService.delete(useCoupon);
        return "redirect:/trainer/form";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id,
                         CouponForm couponForm,
                         Model model) {
        Coupon coupon = couponService.findById(id);
        model.addAttribute("coupon", coupon);
        coupon.setName(coupon.getName());
        coupon.setPoint(coupon.getPoint());
        coupon.setDiscount(coupon.getDiscount());
        couponRepository.save(coupon);
        return "redirect:/coupon/coupon_create";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/update/{id}")
    public String update(@Valid CouponForm couponForm,
                         BindingResult bindingResult,
                         @PathVariable("id") Long id,
                         Principal principal) {

        if (bindingResult.hasErrors()) {
            return "coupon/coupon_create";
        }
        Coupon coupon = couponService.getCoupon(id);
        principal.getName();
        return "redirect:/coupon/coupon_list";
    }

    @GetMapping("/list")
    public String list(Model model, Principal principal) {
        List<Coupon> couponList = couponService.getAll();
        SiteUser siteUser = siteUserService.findByUserName(principal.getName());
        String points = String.valueOf(siteUser.getPoint().getPoints());
        List<Coupon> userCouponList = siteUser.getCouponList();

        model.addAttribute("couponList", couponList);
        model.addAttribute("userCouponList", userCouponList);
        model.addAttribute("points", points);
        System.out.println(userCouponList.size());
        return "coupon/coupon_list";
    }

    @GetMapping("/purchase/{id}")
    public String purchase(@PathVariable("id") Long id, Model model, Principal principal) {
        Coupon coupon = couponService.getCoupon(id);
        List<Coupon> couponList = couponService.getAll();
        SiteUser siteUser = siteUserService.findByUserName(principal.getName());
        int a = siteUser.getPoint().getPoints() - coupon.getPoint();

        siteUser.getPoint().setPoints(a);
        String points = String.valueOf(siteUser.getPoint().getPoints());

        siteUser.getCouponList().add(coupon);
        siteUserService.save(siteUser);

        model.addAttribute("couponList", couponList);
        model.addAttribute("points", points);
        return "redirect:/coupon/list";
    }
}
