package com.example.internbankingtask.model.payload;

import com.example.internbankingtask.enums.Type;
import com.example.internbankingtask.enums.Utility;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionPayload {
    Long id;
    Long userId;
    Utility utility;
    Double amount;
    LocalDateTime time;
    Type type;
}

