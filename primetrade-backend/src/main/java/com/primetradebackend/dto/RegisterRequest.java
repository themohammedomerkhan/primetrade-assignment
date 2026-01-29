package com.primetradebackend.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String contact;
    private String email;
    private String password;
}
