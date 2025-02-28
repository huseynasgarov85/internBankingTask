package com.example.internbankingtask.mapper;

import com.example.internbankingtask.model.entity.postgre.Cards;
import com.example.internbankingtask.model.payload.CardPayload;
import com.example.internbankingtask.model.response.CardResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardMapper {

    public CardResponse mapToResponse(Cards cards) {
        return CardResponse
                .builder()
                .pan(cards.getPan())
                .cvv(cards.getCvv())
                .balance(cards.getBalance())
                .expireDate(cards.getExpireDate())
                .build();
    }

    public Cards mapFromPayloadToEntity(CardPayload cardPayload) {
        return Cards
                .builder()
                .balance(cardPayload.getBalance())
                .pan(cardPayload.getPan())
                .cvv(cardPayload.getCvv())
                .expireDate(cardPayload.getExpireDate())
                .build();
    }

    public Cards mapToCardsFromUser(Cards cards) {
        return Cards
                .builder()
                .id(cards.getId())
                .balance(cards.getBalance())
                .cvv(cards.getCvv())
                .expireDate(cards.getExpireDate())
                .pan(cards.getPan())
                .build();
    }
}
