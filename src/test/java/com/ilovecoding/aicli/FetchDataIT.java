package com.ilovecoding.aicli;

import com.ilovecoding.aicli.model.AiRequest;
import com.ilovecoding.aicli.model.AiRequestBuilder;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import org.mockserver.client.MockServerClient;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@Testcontainers
class FetchDataIT {
    private static final DockerImageName MOCK_SERVER_IMAGE = DockerImageName
            .parse("mockserver/mockserver")
            .withTag("mockserver-" + MockServerClient.class.getPackage().getImplementationVersion());

    @Container
    private MockServerContainer mockServer = new MockServerContainer(MOCK_SERVER_IMAGE);


    @BeforeEach
    void setUp() {

        mockServer.start();
    }

    @AfterEach
    void tearDown() {

        mockServer.stop();
    }

    @Test
    void shouldReturnExitCode0IfSuccessful() throws IOException, URISyntaxException, InterruptedException {

        MockServerClient mockServerClient = new MockServerClient(mockServer.getHost(), mockServer.getServerPort());

        FetchData fetchData = new FetchData();
        fetchData.setAiUrl("http://" + mockServer.getHost() + ":" + mockServer.getServerPort());

        AiRequest aiRequest = new AiRequestBuilder()
                .setPrompt("Top 10 snooker players")
                .createAiRequest();

        mockServerClient.when(request()
                        .withMethod("POST"))
                .respond(response().withBody(getTestBody())
                        .withStatusCode(HttpStatus.SC_OK)
                );


        int execute = fetchData.execute(aiRequest);
        assertEquals(0, execute);


    }

    @Test
    void shouldReturnExitCode4IfResponseIsInvalid() throws IOException, URISyntaxException, InterruptedException {

        MockServerClient mockServerClient = new MockServerClient(mockServer.getHost(), mockServer.getServerPort());

        FetchData fetchData = new FetchData();
        fetchData.setAiUrl("http://" + mockServer.getHost() + ":" + mockServer.getServerPort());

        AiRequest aiRequest = new AiRequestBuilder()
                .setPrompt("Top 10 snooker players")
                .createAiRequest();

        mockServerClient.when(request()
                        .withMethod("POST"))
                .respond(response()
                        .withStatusCode(HttpStatus.SC_NOT_FOUND)

                );


        int execute = fetchData.execute(aiRequest);
        assertEquals(4, execute);


    }


    private String getTestBody() {

        return """
                {
                    "id": "cmpl-6bACAHQleyYG83PuMblGXbfdxQaH7",
                    "object": "text_completion",
                    "created": 1674315346,
                    "model": "text-davinci-003",
                    "choices": [
                        {
                            "text": "\\n\\nThe greatest snooker player of all time is widely considered to be Stephen Hendry. He won seven World Championships, a record five UK Championships, and a record five Masters titles. He also holds the record for the most competitive century breaks with over 800.",
                            "index": 0,
                            "logprobs": null,
                            "finish_reason": "stop"
                        }
                    ],
                    "usage": {
                        "prompt_tokens": 6,
                        "completion_tokens": 54,
                        "total_tokens": 60
                    }
                }
                """;
    }
}