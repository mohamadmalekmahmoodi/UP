package com.example.service.repositories;

import com.example.common.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CardRepository extends JpaRepository<Card,Long> {

}
