package com.example.internbankingtask.mapper;

import com.example.internbankingtask.model.entity.postgre.User;
import com.example.internbankingtask.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final CardMapper cardMapper;

    public UserResponse mapToResponse(User user) {
        return UserResponse
                .builder()
                .name(user.getName())
                .surname(user.getSurname())
                .userName(user.getUserName())
                .phoneNumber(user.getPhoneNumber())
                .isActive(user.isActive())
                .password(user.getPassword())
                .email(user.getEmail())
                .cards(user.getCards().stream().map(cardMapper::mapToCardsFromUser).toList())
                .build();
    }
}
