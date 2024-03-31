package ms1.service;

import ms1.model.GetSampleData;
import ms1.model.GetSampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MS1Service {

    private final RestTemplate restTemplate;
    @Value("${server.destination}")
    private String ms2Url;

    public ResponseEntity<GetSampleResponse> getSampleData (boolean hasError)
    throws Exception {
        try {
            ResponseEntity<GetSampleResponse> res = restTemplate.exchange(buildUri(hasError),
                                                                      HttpMethod.GET,
                                                                      null,
                                                                          GetSampleResponse.class);
            return new ResponseEntity(GetSampleResponse.builder()
                                                       .data(res.getBody()
                                                                .getData())
                                                       .status(res.getStatusCode())
                                                       .message("Success retrieve data")
                                                       .build(),
                                      res.getStatusCode());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String buildUri (boolean hasError) {
        return "http://" + ms2Url + "?hasError=" + hasError;
    }
}
