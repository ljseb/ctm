package com.ctm.creditcardvalidator;

import com.ctm.creditcardvalidator.model.ValidationResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardValidatorControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/validate?fullName=John Doe&cardNumber=340000000000009&csvNumber=112");
    }

   @Test
    public void testShouldValidateCreditCardSuccessfully() {
       ValidationResponse response = template.getForObject(base.toString(), ValidationResponse.class);
        assertEquals(response.getStatus(),"Valid");
    }

}
