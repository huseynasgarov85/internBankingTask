package com.example.internbankingtask.model.response;

import com.example.internbankingtask.model.entity.postgre.Cards;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String name;
    String surname;
    String userName;
    String phoneNumber;
    String email;
    String password;
    boolean isActive;
    List<Cards> cards;

}
