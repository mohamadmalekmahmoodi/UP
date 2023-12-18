package com.example.service.controllers;

import com.example.common.dtos.CardDto;
import com.example.common.entities.Card;
import com.example.service.service.CardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController extends AbstractController<Card, CardDto, CardService> {
}
