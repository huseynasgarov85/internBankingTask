package com.example.internbankingtask.service.card;

import com.example.internbankingtask.model.payload.CardPayload;
import com.example.internbankingtask.model.response.CardResponse;

import java.util.List;

public interface CardService {
    List<CardResponse> gatAll();

    CardResponse getById(Long id);

    void add(CardPayload cardPayload);

    void remove(Long id);

    void addCardToUser(CardPayload cardPayload, Long userid);

    void sendMoneyToAnotherBalance(Long fromCardId, Long toCardId, Double amount);
}
