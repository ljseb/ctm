package com.ctm.creditcardvalidator.service;

import com.ctm.creditcardvalidator.model.ValidationResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidatorServiceImpl implements CreditCardValidatorService {

    @Override
    public ValidationResponse validateCreditCard(String fullName, Long cardNumber, Integer csv) {

        ValidationResponse validationResponse = new ValidationResponse();
        validationResponse.setFullName(fullName);
        validationResponse.setCardNumber(cardNumber);

        String cardNumberStr = "";
        if (cardNumber != null) {
            cardNumberStr = Long.toString(cardNumber);
        }

        if (calculateSum(cardNumberStr) % 10 == 0) {
            validationResponse.setStatus("Valid");
            validationResponse.setCardType(checkCardType(cardNumberStr));
        }
        return validationResponse;
    }

    private Integer calculateSum(String cardNumberStr) {
        int sum = 0;
        int count = cardNumberStr.length() - 1;

        for (int i = count; i >= 0; i--) {
            int currentValue = Integer.parseInt(cardNumberStr.substring(i, i + 1));
            if (count % 2 != 0) { //card number length is odd
                if (i % 2 != 0) {
                    sum = sum + currentValue;
                } else if (currentValue >= 5) {
                    sum = sum + (2 * currentValue) - 9;
                } else {
                    sum = sum + (2 * currentValue);
                }
            } else { //card number length is even
                if (i % 2 == 0) {
                    sum = sum + currentValue;
                } else if (currentValue >= 5) {
                    sum = sum + (2 * currentValue) - 9;
                } else {
                    sum = sum + (2 * currentValue);
                }
            }
        }
        System.out.println("Sum = " + sum);
        return sum;
    }

    private String checkCardType(String cardNumberStr) {
        String prefix = cardNumberStr.substring(0, 2);
        String cardType = "";

        switch (prefix) {
            case "34": {
                cardType = "AMEX";
                break;
            }
            case "37": {
                cardType = "AMEX";
                break;
            }
            case "4": {
                cardType = "Visa";
                break;
            }
            case "51": {
                cardType = "MasterCard";
                break;
            }
            case "52": {
                cardType = "MasterCard";
                break;
            }
            case "53": {
                cardType = "MasterCard";
                break;
            }
            case "54": {
                cardType = "MasterCard";
                break;
            }
            case "55": {
                cardType = "MasterCard";
                break;
            }
        }
        if (cardNumberStr.substring(0, 4).equals("6011")) {
            cardType = "Discovery";
        }
        return cardType;
    }

}
