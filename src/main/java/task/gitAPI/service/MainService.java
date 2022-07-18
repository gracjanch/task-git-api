package task.gitAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task.gitAPI.connection.GitApiConnection;
import task.gitAPI.model.GitInfo;

@Service
@RequiredArgsConstructor
public class MainService {

    private final GitApiConnection gitApiConnection;

    public GitInfo getGitInformation(String owner, String repositoryName) {
        return gitApiConnection.getInfoForUserAndRepoName(owner, repositoryName);
    }
}
