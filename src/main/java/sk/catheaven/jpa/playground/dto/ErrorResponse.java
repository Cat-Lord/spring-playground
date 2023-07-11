package sk.catheaven.jpa.playground.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
    String title;
    String detail;
    String errorMessage;
}
