package com.example.internbankingtask.controller;

import com.example.internbankingtask.model.response.UserResponse;
import com.example.internbankingtask.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "This end point will get  all users list", description = "This api shows front all users")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "This api getById shows user")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "this end point removed user from db")
    public void removeUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @PostMapping("/card/{cardId}/{userId}")
    @Operation(summary = "this end point will be insert card to user account")
    public void addCardToUser(@PathVariable Long cardId, @PathVariable Long userId) {
        userService.addCardToUser(cardId, userId);
    }

    @DeleteMapping("/{userId}/card/{cardId}")
    @Operation(summary = "this end point removed card which user want")
    public void removeCardFromUser(@PathVariable Long userId, @PathVariable Long cardId) {
        userService.removeCardFromUser(userId, cardId);
    }
}
