package com.sunbase.Assessment.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequestDto {
    private String login_id;
    private String password;
}
