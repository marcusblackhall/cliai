package com.ilovecoding.aicli;

import com.ilovecoding.aicli.model.AiRequest;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class FetchData {

    private final CreateJsonFromRequest createJsonFromRequest = new CreateJsonFromRequest();
    public static final String AI_URL = "https://api.openai.com/v1/completions";

    public int execute(AiRequest aiRequest) throws IOException, URISyntaxException, InterruptedException {

        String requestAsJson = createJsonFromRequest.aiRequestAsJson(aiRequest);

        HttpRequest httpRequest =
                HttpRequest.newBuilder(new URI(AI_URL))
                        .header("Authorization", getAuthBearer())
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestAsJson))
                        .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            formResponse(response.body());
            return 4;
        }

        formResponse(response.body());
        return 0;
    }

    private void formResponse(String body) {

        JSONObject jsonObject = new JSONObject(body);
        System.out.println(jsonObject.toString(5));

    }

    private String aiRequestAsJson(AiRequest aiRequest) {


        return createJsonFromRequest.aiRequestAsJson(aiRequest);
    }

    private static String getAuthBearer() {
        String aiApiKey = System.getenv("AI_API_KEY");
        return "Bearer " + aiApiKey;


    }
}
