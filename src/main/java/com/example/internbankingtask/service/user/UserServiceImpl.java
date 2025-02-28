package com.example.internbankingtask.service.user;

import com.example.internbankingtask.globalExceptionHandler.exceptions.NotFoundException;
import com.example.internbankingtask.mapper.UserMapper;
import com.example.internbankingtask.model.entity.postgre.Cards;
import com.example.internbankingtask.model.entity.postgre.User;
import com.example.internbankingtask.model.repo.postgre.CardRepo;
import com.example.internbankingtask.model.repo.postgre.UserRepo;
import com.example.internbankingtask.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final CardRepo cardRepo;

    @Override
    public boolean checkEmail(String email) {
        log.info("ActionLog started checkEmail " + email);
        return userRepo.existsByEmail(email);
    }

    @Override
    public User findUserByUserName(String userName) {
        log.info("ActionLog started findUserByUserName " + userName);
        return userRepo.findUserByUserName(userName).orElseThrow(() -> new NotFoundException("user not founded"));
    }

    @Override
    public User findUserByEmail(String email) {
        log.info("ActionLog started findUserByEmail " + email);
        return userRepo.findUserByEmail(email).orElseThrow(() -> new NotFoundException("user not founded"));
    }

    @Override
    public User userSave(User user) {
        log.info("ActionLog started userSave " + user.getId());
        return userRepo.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        log.info("ActionLog started getAllUsers ");
        List<User> userList = userRepo.findAll();
        return userList.stream().map(userMapper::mapToResponse).toList();
    }

    @Override
    public UserResponse getById(Long id) {
        log.info("ActionLog started getById " + id);
        User user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("user not founded"));
        return userMapper.mapToResponse(user);
    }

    @Override
    public void removeUser(Long id) {
        log.info("ActionLog removeUser started " + id);
        userRepo.deleteById(id);
        log.info("ActionLog removeUser end " + id);
    }

    @Override
    public void addCardToUser(Long cardId, Long userId) {
        log.info("ActionLog addCardToUser started " + userId + "-" + cardId);
        User user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("userId not founded"));
        Cards card = cardRepo.findById(cardId).orElseThrow(() -> new NotFoundException("cardId not founded"));
        user.getCards().add(card);
        card.setUser(user);
        userRepo.save(user);
        log.info("ActionLog addCardToUser end " + userId + "-" + cardId);
    }

    @Override
    public void removeCardFromUser(Long userId, Long cardId) {
        log.info("ActionLog addCardToUser started " + userId + "-" + cardId);
        User user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("userId not founded"));
        List<Cards> cards = user.getCards();
        cards.removeIf(it -> it.getId().equals(cardId));
        user.setCards(cards);
        userRepo.save(user);
        log.info("ActionLog addCardToUser end " + userId);
    }
}
