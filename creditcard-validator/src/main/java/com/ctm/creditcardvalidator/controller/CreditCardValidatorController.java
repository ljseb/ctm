package com.ctm.creditcardvalidator.controller;

import com.ctm.creditcardvalidator.model.ValidationResponse;
import com.ctm.creditcardvalidator.service.CreditCardValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@RestController
public class CreditCardValidatorController {

    @Autowired
    public CreditCardValidatorService validatorService;

    @RequestMapping(value = "/validate", produces = "application/json", method = RequestMethod.GET)
    public ValidationResponse validateCreditCard(@RequestParam String fullName,
                                                 @RequestParam @Size(min = 13, max = 16) Long cardNumber,
                                                 @RequestParam Integer csvNumber) {

        return validatorService.validateCreditCard(fullName, cardNumber, csvNumber);

    }

}
