package com.example.MMP.order;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class Order {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String paymentRequest(HttpServletRequest request, Model model) throws Exception {
        return "/success";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) throws Exception {
        return "/checkout";
    }

    /**
     * 인증실패처리
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String failPayment(HttpServletRequest request, Model model) throws Exception {
        String failCode = request.getParameter("code");
        String failMessage = request.getParameter("message");

        model.addAttribute("code", failCode);
        model.addAttribute("message", failMessage);

        return "/fail";
    }
}
