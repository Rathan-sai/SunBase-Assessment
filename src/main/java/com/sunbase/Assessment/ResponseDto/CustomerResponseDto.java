package com.sunbase.Assessment.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponseDto {

    int id;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    String phone;
    String message;
    String street;
}
