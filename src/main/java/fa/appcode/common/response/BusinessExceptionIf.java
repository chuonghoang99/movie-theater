package fa.appcode.common.response;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface BusinessExceptionIf {

    Optional<HttpStatus> getStatus();

    Optional<String> getResult();

    List<String> getMessageList();
}
