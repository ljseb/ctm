package com.ctm.creditcardvalidator.model;

import lombok.Data;

@Data
public class ValidationResponse {
    private String fullName;
    private Long cardNumber;
    private String cardType;
    private String status = "Invalid";
}
