package com.example.internbankingtask.service.card;

import com.example.internbankingtask.globalExceptionHandler.exceptions.IllegalArgumentException;
import com.example.internbankingtask.globalExceptionHandler.exceptions.InsufficientFunds;
import com.example.internbankingtask.globalExceptionHandler.exceptions.NotFoundException;
import com.example.internbankingtask.mapper.CardMapper;
import com.example.internbankingtask.model.entity.postgre.Cards;
import com.example.internbankingtask.model.entity.postgre.User;
import com.example.internbankingtask.model.payload.CardPayload;
import com.example.internbankingtask.model.repo.postgre.CardRepo;
import com.example.internbankingtask.model.repo.postgre.UserRepo;
import com.example.internbankingtask.model.response.CardResponse;
import com.example.internbankingtask.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {
    private final CardRepo cardRepo;
    private final CardMapper cardMapper;
    private final UserRepo userRepo;

    @Override
    public List<CardResponse> gatAll() {
        log.info("ActionLog started getAll ");
        List<Cards> cardsList = cardRepo.findAll();
        return cardsList.stream().map(cardMapper::mapToResponse).toList();
    }

    @Override
    public CardResponse getById(Long id) {
        log.info("ActionLog started getById " + id);
        Cards card = cardRepo.findById(id).orElseThrow(() -> new NotFoundException("cardId not founded"));
        return cardMapper.mapToResponse(card);
    }

    @Override
    public void add(CardPayload cardPayload) {
        log.info("ActionLog started add " + cardPayload.getPan());
        Cards cards = cardMapper.mapFromPayloadToEntity(cardPayload);
        cardRepo.save(cards);
        log.info("ActionLog end add " + cardPayload.getPan());
    }

    @Override
    public void remove(Long id) {
        log.info("ActionLog started remove ");
        cardRepo.deleteById(id);
        log.info("ActionLog end remove ");
    }

    @Override
    public void addCardToUser(CardPayload cardPayload, Long userId) {
        log.info("ActionLog started addCardToUser " + userId);
        User user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("userId not founded"));
        Cards cards = cardMapper.mapFromPayloadToEntity(cardPayload);
        cards.setUser(user);
        cardRepo.save(cards);
        log.info("ActionLog end addCardToUser " + userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void sendMoneyToAnotherBalance(Long fromCardId, Long toCardId, Double amount) {
        log.info("ActionLog started sendMoneyToAnotherBalance " + fromCardId + "-" + toCardId);
        Cards fromCard = cardRepo.findById(fromCardId).orElseThrow(() -> new NotFoundException("fromCardId not founded"));
        Cards toCard = cardRepo.findById(toCardId).orElseThrow(() -> new NotFoundException("toCardId not founded"));
        if (amount < 1) {
            throw new IllegalArgumentException("pls Enter more than 1 manat");
        }
        if (fromCard.getBalance() < amount) {
            throw new InsufficientFunds("pls boost your card balance");
        }
        fromCard.setBalance(fromCard.getBalance() - amount);
        cardRepo.save(fromCard);
        toCard.setBalance(toCard.getBalance() + amount);
        cardRepo.save(toCard);
        log.info("ActionLog end sendMoneyToAnotherBalance " + fromCardId + "-" + toCardId);
    }
}
