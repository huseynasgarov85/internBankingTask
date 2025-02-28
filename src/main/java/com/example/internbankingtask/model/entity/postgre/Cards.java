package com.example.internbankingtask.model.entity.postgre;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String pan;
    String cvv;
    String expireDate;
    Double balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
