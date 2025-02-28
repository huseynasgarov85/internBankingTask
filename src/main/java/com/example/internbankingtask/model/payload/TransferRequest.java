package com.example.internbankingtask.model.payload;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferRequest {
    Long FromCardId;
    Long ToCardId;
}
