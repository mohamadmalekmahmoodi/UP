package com.example.service.service;

import com.example.common.entities.Card;
import com.example.service.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService extends AbstractService<Card, CardRepository> {
    @Override
    public Card save(Card card) {
        return super.save(card);
    }
}
