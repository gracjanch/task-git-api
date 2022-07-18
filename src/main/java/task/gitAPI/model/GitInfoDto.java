package task.gitAPI.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
public class GitInfoDto {

    private String name;
    private String full_name;
    private String description;
    private String clone_url;
    private Integer stargazers_count;
    private LocalDateTime created_at;


}
