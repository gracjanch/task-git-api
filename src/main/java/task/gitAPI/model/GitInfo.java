package task.gitAPI.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class GitInfo {

    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private LocalDateTime createdAt;
}
