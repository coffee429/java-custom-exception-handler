package ms1.controller;

import ms1.model.GetSampleResponse;
import ms1.service.MS1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MS1Controller implements MS1ControllerApi {

    private final MS1Service service;

    @Override
    public ResponseEntity<GetSampleResponse> getSampleData (boolean hasError)
    throws Exception {
        return service.getSampleData(hasError);
    }
}
