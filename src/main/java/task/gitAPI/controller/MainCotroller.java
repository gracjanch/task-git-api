package task.gitAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.gitAPI.model.GitInfo;
import task.gitAPI.service.MainService;

@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class MainCotroller {

    private final MainService mainService;

    @GetMapping("/{owner}/{repositoryName}")
    public ResponseEntity<GitInfo> getInformation(
            @PathVariable String owner, @PathVariable String repositoryName) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(mainService.getGitInformation(owner, repositoryName));
    }
}
