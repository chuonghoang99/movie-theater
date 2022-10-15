package fa.appcode.common.response;

import org.springframework.http.HttpStatus;

public class ValidationErrorException extends BusinessRuntimeException{
    private static final long serialVersionUID = 1L;

    private ValidationErrorResponse validationErrorResponse;

    public ValidationErrorException(
            HttpStatus status, ValidationErrorResponse validationErrorResponse, String message) {
        super(status, message);
        this.validationErrorResponse = validationErrorResponse;
    }

    public ValidationErrorResponse getValidationErrorResponse() {
        return validationErrorResponse;
    }

}
