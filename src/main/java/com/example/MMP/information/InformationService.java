package com.example.MMP.information;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformationService {
    private final InformationRepository informationRepository;

    public void create(String imagePath, String healthName, String companyNumber, String address, String callNumber, String email, String text) {
        Information information = new Information();
        information.setImagePath(imagePath);
        information.setHealthName(healthName);
        information.setCompanyNumber(companyNumber);
        information.setAddress(address);
        information.setCallNumber(callNumber);
        information.setEmail(email);
        information.setText(text);

        informationRepository.save(information);
    }
}
