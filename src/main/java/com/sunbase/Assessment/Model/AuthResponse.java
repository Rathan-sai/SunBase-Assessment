package com.sunbase.Assessment.Model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthResponse {
    String Token;
    String user_name;
}
