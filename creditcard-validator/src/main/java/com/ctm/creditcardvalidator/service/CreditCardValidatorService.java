package com.ctm.creditcardvalidator.service;

import com.ctm.creditcardvalidator.model.ValidationResponse;


public interface CreditCardValidatorService {

    ValidationResponse validateCreditCard(String fullName, Long cardNumber, Integer csv);
}
