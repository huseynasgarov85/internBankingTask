package com.example.internbankingtask.service.user;

import com.example.internbankingtask.model.entity.postgre.User;
import com.example.internbankingtask.model.response.UserResponse;

import java.util.List;

public interface UserService {
    boolean checkEmail(String email);

    User findUserByUserName(String userName);

    User findUserByEmail(String email);

    User userSave(User user);

    List<UserResponse> getAllUsers();

    UserResponse getById(Long id);

    void removeUser(Long id);

    void addCardToUser(Long cardId, Long userId);

    void removeCardFromUser(Long userId, Long cardId);
}
