package com.sunbase.Assessment.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    String phone;
    String street;
}
