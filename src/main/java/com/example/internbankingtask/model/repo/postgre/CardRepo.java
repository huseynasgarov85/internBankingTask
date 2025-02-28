package com.example.internbankingtask.model.repo.postgre;

import com.example.internbankingtask.model.entity.postgre.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Cards, Long> {
}
