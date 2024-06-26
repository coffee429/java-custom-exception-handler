package ms1.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


public class RestErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError (ClientHttpResponse response) throws IOException {
        if (response.getStatusCode()
                    .is4xxClientError() || response.getStatusCode()
                                                   .is5xxServerError()) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
                String httpBodyResponse = reader.lines()
                                                .collect(Collectors.joining(""));

                String errorMessage = httpBodyResponse;

                throw new RestException(response.getStatusCode(),
                                           errorMessage);
            }
        }
    }

}
