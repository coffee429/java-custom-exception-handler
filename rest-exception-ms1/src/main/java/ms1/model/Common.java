package ms1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Common {

    private HttpStatusCode status;
    private String message;
}
