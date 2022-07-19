package task.gitAPI;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import task.gitAPI.model.GitInfo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class AppTests {

    private static final String GIT_API_URL = "https://task-git-api.herokuapp.com/repositories/";
    private static final String CORRECT_USER_NAME = "gracjanch";
    private static final String CORRECT_REPOSITORY_NAME = "car-rental-service";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void shouldReturnGitInfoObject() {
        GitInfo gitInfo = new GitInfo();
        gitInfo.setFullName("gracjanch/Car-Rental-Service");
        gitInfo.setDescription(null);
        gitInfo.setCloneUrl("https://github.com/gracjanch/Car-Rental-Service.git");
        gitInfo.setStars(0);
        gitInfo.setCreatedAt(LocalDateTime.parse("2022-07-02T12:33:48"));

        String urlWithParams = GIT_API_URL + CORRECT_USER_NAME
                + "/" + CORRECT_REPOSITORY_NAME ;

        GitInfo response = restTemplate.getForObject(
                urlWithParams,
                GitInfo.class);

        Assert.assertEquals(gitInfo.getFullName(), response.getFullName());
    }

    @Test
    public void shouldReturnUserNotExistsException() throws Exception {
        String urlWithParams = GIT_API_URL + CORRECT_USER_NAME
                + "sthincorrect" + "/" + CORRECT_REPOSITORY_NAME;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(urlWithParams))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertTrue(response.body().contains("Wrong User name"));
    }

    @Test
    public void shouldReturnRepositoryNotExistsException() throws Exception {
        String urlWithParams = GIT_API_URL + CORRECT_USER_NAME
                + "/" + CORRECT_REPOSITORY_NAME + "sthincorrect" ;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(urlWithParams))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertTrue(response.body().contains("User don't have repository with this name"));
    }
}
