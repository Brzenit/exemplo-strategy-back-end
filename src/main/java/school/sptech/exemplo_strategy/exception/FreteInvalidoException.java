package school.sptech.exemplo_strategy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FreteInvalidoException extends RuntimeException {

  public FreteInvalidoException() {

  }

  public FreteInvalidoException(String message) {
    super(message);
  }
}
