package com.example.MMP.wod;

import com.example.MMP.siteuser.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WodService {
    private final WodRepository wodRepository;

    public void create(String imagePath, String content, SiteUser writer) {
        Wod wod = new Wod();
        wod.setImagePath(imagePath);
        wod.setContent(content);
        wod.setCreateDate(LocalDateTime.now());
        wod.setWriter(writer);

        this.wodRepository.save(wod);
    }

    public List<Wod> getList() {
        List<Wod> wodList = wodRepository.findAll();
        return wodList;
    }

    public Wod getWod(Long id) {
        Wod wod = wodRepository.findById(id).get();
        return wod;
    }

    public void delete(Long id) {
        Wod wod = wodRepository.findById(id).get();
        wodRepository.delete(wod);
    }

    public void update(Long id, String content) {
        Wod wod = wodRepository.findById(id).get();
        wod.setContent(content);
        wodRepository.save(wod);
    }
}
