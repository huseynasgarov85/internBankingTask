package com.example.internbankingtask.controller;

import com.example.internbankingtask.model.payload.CardPayload;
import com.example.internbankingtask.model.payload.TransferRequest;
import com.example.internbankingtask.model.response.CardResponse;
import com.example.internbankingtask.service.card.CardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<CardResponse> getAll() {
        return cardService.gatAll();
    }

    @GetMapping("{id}")
    public CardResponse getById(@PathVariable Long id) {
        return cardService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CardPayload cardPayload) {
        cardService.add(cardPayload);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        cardService.remove(id);
    }

    @PostMapping("/linkToUser")
    public void addCardToUser(@RequestBody CardPayload cardPayload, @RequestParam(value = "userId") Long id) {
        cardService.addCardToUser(cardPayload, id);
    }

    @PatchMapping("/sendMoneyToAnotherAccount")
    @Operation(summary = "this api used that in your card to transfered another account")
    public void sendMoneyToAnotherBalance(@RequestBody TransferRequest transferRequest, @RequestParam(value = "amount") Double amount) {
        cardService.sendMoneyToAnotherBalance(transferRequest.getFromCardId(), transferRequest.getToCardId(), amount);
    }

}
