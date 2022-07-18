package task.gitAPI.connection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import task.gitAPI.exception.RepositoryNotExistsException;
import task.gitAPI.exception.UserNotExistsException;
import task.gitAPI.model.GitInfo;
import task.gitAPI.model.GitInfoDto;

@Component
@RequiredArgsConstructor
public class GitApiConnection {

    private static final String GIT_API_URL = "https://api.github.com/users/";
    private RestTemplate restTemplate = new RestTemplate();

    public GitInfo getInfoForUserAndRepoName(String owner, String repositoryName) {

        GitInfoDto[] repositories = callGitApi(owner);
        for (int i = 0; i < repositories.length; i++) {
            GitInfoDto gitInfoDto = repositories[i];
            String repName = gitInfoDto.getName().toLowerCase();

            if (repName.equals(repositoryName.toLowerCase())) {
                return GitInfo.builder()
                        .fullName(gitInfoDto.getFull_name())
                        .description(gitInfoDto.getDescription())
                        .cloneUrl(gitInfoDto.getClone_url())
                        .stars(gitInfoDto.getStargazers_count())
                        .createdAt(gitInfoDto.getCreated_at())
                        .build();
            }
        }
        throw new RepositoryNotExistsException();
    }

    private GitInfoDto[] callGitApi(String owner) {
        try {
            return restTemplate.getForObject(
                    GIT_API_URL + "{owner}/repos",
                    GitInfoDto[].class,
                    owner);
        } catch (Exception e) {
            throw new UserNotExistsException();
        }
    }
}
