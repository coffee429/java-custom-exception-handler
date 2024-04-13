package ms1.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ms1.model.Error;
import ms1.model.MS1ErrorResponse;
import ms1.model.MS2ErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = RestException.class)
    ResponseEntity<MS1ErrorResponse> handleMyRestTemplateException (RestException ex, HttpServletRequest request)
    throws JsonProcessingException {
        String messageBody = ex.getMessage();
        HttpStatusCode statusCode = ex.getCode();
        String mess = "";
        try{
            Error err = parseXml(messageBody);
            mess = err.getMessage();
        } catch (JsonProcessingException e) {
            MS2ErrorResponse ms2Res = objectMapper.readValue(messageBody,
                                                             MS2ErrorResponse.class);
            mess = ms2Res.getError().getMessage();
        }


        MS1ErrorResponse error = MS1ErrorResponse.builder()
                                                 .code("400")
                                                 .message(mess)
                                                 .build();
        return new ResponseEntity<>(error,
                                    statusCode);
    }

    private Error parseXml(String xml)
    throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, Error.class);
    }
}
