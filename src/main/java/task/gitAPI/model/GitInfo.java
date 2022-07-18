package task.gitAPI.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//@Builder
@Getter
@Setter
@RequiredArgsConstructor
public class GitInfo {

    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private LocalDateTime createdAt;
}
