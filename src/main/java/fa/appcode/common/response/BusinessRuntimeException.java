package fa.appcode.common.response;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class BusinessRuntimeException extends RuntimeException implements BusinessExceptionIf {
    private Optional<String> result = Optional.empty();
    private Optional<HttpStatus> status = Optional.empty();
    private List<String> messageList = Collections.emptyList();

    public BusinessRuntimeException() {
    }

    public BusinessRuntimeException(HttpStatus status) {
        this.status = Optional.ofNullable(status);
    }

    public BusinessRuntimeException(HttpStatus status, Throwable cause) {
        super(cause);
        this.status = Optional.ofNullable(status);
    }

    public BusinessRuntimeException(HttpStatus status, String message) {
        super(message);
        this.status = Optional.ofNullable(status);
    }


    public BusinessRuntimeException(HttpStatus status, List<String> messageList) {
        this.status = Optional.ofNullable(status);
        if (messageList != null) {
            this.messageList = messageList;
        }
    }

    public BusinessRuntimeException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = Optional.ofNullable(status);
    }


    public BusinessRuntimeException(String result, HttpStatus status) {
        this.result = Optional.ofNullable(result);
        this.status = Optional.ofNullable(status);
    }


    public BusinessRuntimeException(String result, HttpStatus status, Throwable cause) {
        this.result = Optional.ofNullable(result);
        this.status = Optional.ofNullable(status);
    }


    public BusinessRuntimeException(String result, HttpStatus status, String message) {
        super(message);
        this.result = Optional.ofNullable(result);
        this.status = Optional.ofNullable(status);
    }


    public BusinessRuntimeException(String result, HttpStatus status, String message,
                                    Throwable cause) {
        super(message, cause);
        this.result = Optional.ofNullable(result);
        this.status = Optional.ofNullable(status);
    }

    public BusinessRuntimeException(String message) {
        super(message);
    }

    public BusinessRuntimeException(Throwable cause) {
        super(cause);
    }

    public BusinessRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessRuntimeException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public Optional<HttpStatus> getStatus() {
        return status;
    }

    @Override
    public Optional<String> getResult() {
        return result;
    }

    @Override
    public List<String> getMessageList() {
        return messageList;
    }

}
