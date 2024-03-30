package ms1.controller;

import ms1.model.GetSampleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1")
public interface MS1ControllerApi {

    @GetMapping("/data")
    public ResponseEntity<GetSampleResponse> getSampleData (@RequestParam boolean hasError)
    throws Exception;


}
