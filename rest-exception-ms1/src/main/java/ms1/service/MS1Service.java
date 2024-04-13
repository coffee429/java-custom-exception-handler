package ms1.service;

import ms1.model.GetSampleData;
import ms1.model.GetSampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MS1Service {

    private final RestTemplate restTemplate;
    @Value("${server.destination}")
    private String ms2Url;

    public ResponseEntity<GetSampleResponse> getJsonData (boolean hasError) {
        String jsonUrl = ms2Url + "/json";
        ResponseEntity<GetSampleResponse> res = restTemplate.exchange(buildJsonUri(hasError),
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

    }

    public ResponseEntity<GetSampleResponse> getXmlData () {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        // Set the headers in HttpEntity
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GetSampleResponse> res = restTemplate.exchange(buildXmlUri(),
                                                                      HttpMethod.GET,
                                                                      entity,
                                                                      GetSampleResponse.class);
        return new ResponseEntity(GetSampleResponse.builder()
                                                   .data(res.getBody()
                                                            .getData())
                                                   .status(res.getStatusCode())
                                                   .message("Success retrieve data")
                                                   .build(),
                                  res.getStatusCode());
    }

    private String buildJsonUri (boolean hasError) {
        return "http://" + ms2Url + "/json?hasError=" + hasError;
    }

    private String buildXmlUri () {
        return "http://" + ms2Url + "/xml";
    }
}
