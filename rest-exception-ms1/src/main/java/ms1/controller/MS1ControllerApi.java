package ms1.controller;

import ms1.model.GetSampleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/ms1/")
public interface MS1ControllerApi {

    @GetMapping("/json")
    public ResponseEntity<GetSampleResponse> getJsonData (@RequestParam boolean hasError);

    @GetMapping("/xml")
    public ResponseEntity<GetSampleResponse> getXmlData ();
}
