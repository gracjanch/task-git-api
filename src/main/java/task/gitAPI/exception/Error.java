package task.gitAPI.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class Error {

    private final LocalDateTime timestamp;
    private final int httpCode;
    private final String error;
    private final String errorMessage;
}
