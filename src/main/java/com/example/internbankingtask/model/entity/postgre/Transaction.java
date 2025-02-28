package com.example.internbankingtask.model.entity.postgre;

import com.example.internbankingtask.enums.Type;
import com.example.internbankingtask.enums.Utility;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    @Enumerated(EnumType.STRING)
    Utility utility;
    Double amount;
    LocalDateTime time;
    @Enumerated(EnumType.STRING)
    Type type;
}
