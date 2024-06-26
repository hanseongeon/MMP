package com.example.MMP.homeTraining;

import com.example.MMP.homeTraining.category.Category;
import com.example.MMP.siteuser.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeTrainingRepository extends JpaRepository<HomeTraining, Long> {
    List<HomeTraining> findByCategory(Category category);
}
