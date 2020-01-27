package com.ctm.creditcardvalidator.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.Size;

@Data
public class ValidationRequest {
    private String fullName;
    @Size(min = 1, max = 20)
    private Long cardNumber;
    private Integer csv;
}
