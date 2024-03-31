package ms1.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ms1.model.MS1ErrorResponse;
import ms1.model.MS2ErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private final ObjectMapper objectMapper;

    @org.springframework.web.bind.annotation.ExceptionHandler(value = RestException.class)
    ResponseEntity<MS1ErrorResponse> handleMyRestTemplateException (RestException ex, HttpServletRequest request)
    throws JsonProcessingException {
        String messageBody = ex.getMessage();
        HttpStatusCode statusCode = ex.getCode();

        MS2ErrorResponse ms2Res = objectMapper.readValue(messageBody,
                                                         MS2ErrorResponse.class);

        MS1ErrorResponse error = MS1ErrorResponse.builder()
                                                 .code(ms2Res.getError()
                                                             .getCode())
                                                 .message(ms2Res.getError()
                                                                .getMessage())
                                                 .build();
        return new ResponseEntity<>(error,
                                    statusCode);
    }
}
