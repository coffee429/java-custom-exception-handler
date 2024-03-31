package ms1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MS2ErrorResponse {
    private ErrorData error;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class ErrorData {
        private String code;
        private String message;
    }
}
