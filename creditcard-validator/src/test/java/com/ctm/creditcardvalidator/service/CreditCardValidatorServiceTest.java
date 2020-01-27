package com.ctm.creditcardvalidator.service;

import com.ctm.creditcardvalidator.model.ValidationResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditCardValidatorServiceTest {

    @InjectMocks
    CreditCardValidatorServiceImpl validatorService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldValidateCreditCardSuccessfully() throws Exception {
        ValidationResponse result = validatorService.validateCreditCard("John Doe",340000000000009L, 112);
        assertEquals(result.getCardNumber(), new Long(340000000000009L));
        assertEquals(result.getStatus(), "Valid");
        assertEquals(result.getCardType(), "AMEX");
        assertEquals(result.getFullName(), "John Doe");
    }

    @Test
    public void testShouldReturnInvalidStatusWhenCreditCardNotvalid() throws Exception {
        ValidationResponse result = validatorService.validateCreditCard("John Doe",340000001400009L, 112);
        assertEquals(result.getCardNumber(), new Long(340000001400009L));
        assertEquals(result.getStatus(), "Invalid");
        assertEquals(result.getCardType(), null);
    }
}
