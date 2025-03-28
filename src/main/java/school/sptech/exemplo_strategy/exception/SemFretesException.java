package school.sptech.exemplo_strategy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class SemFretesException extends RuntimeException {

    public SemFretesException(){};
    public SemFretesException(String message) {
        super(message);
    }
}
