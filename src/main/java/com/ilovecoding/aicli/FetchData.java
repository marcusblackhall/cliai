package com.ilovecoding.aicli;

import com.ilovecoding.aicli.config.AiProperties;
import com.ilovecoding.aicli.model.AiRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import picocli.CommandLine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Spliterator;


public class FetchData {

    private String aiUrl;

    private final CreateJsonFromRequest createJsonFromRequest = new CreateJsonFromRequest();


    public int execute(AiRequest aiRequest) throws IOException, URISyntaxException, InterruptedException {

        String requestAsJson = createJsonFromRequest.aiRequestAsJson(aiRequest);


        HttpRequest httpRequest =
                HttpRequest.newBuilder(getAiUrl())
                        .header("Authorization", getAuthBearer())
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestAsJson))
                        .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != HttpURLConnection.HTTP_OK) {
            if (response.body() != null && ! response.body().isEmpty()) {
                System.out.println(formError(response.body()));
            }
            return 4;
        }

        formResponse(response.body());
        return 0;
    }

    private String formError(String body) {
        JSONObject jsonObject = new     JSONObject(body);
        JSONObject errorObject = (JSONObject) jsonObject.get("error");
        System.out.println(CommandLine.Help.Ansi.AUTO.string( "@|red,underline Error Message |@"));
        return (String) errorObject.get("message");
    }

    private void formResponse(String body) {

        JSONObject jsonObject = new JSONObject(body);
        Object choices = jsonObject.get("choices");

        JSONArray array = null;
        if (choices != null) {
            array = (JSONArray) choices;
            if (array.isEmpty()) {
                System.out.println("No text is available");
                return;
            }
        }
        Spliterator<Object> spliterator = array.spliterator();
        spliterator.forEachRemaining(r -> {
            JSONObject firstOption = (JSONObject) r;
            System.out.println(CommandLine.Help.Ansi.AUTO.string( "@|green,underline Response |@"));
            String text = (String) firstOption.get("text");
            text = text.replace("\\n", "\\`");
            System.out.println(text);

        });



    }

    private static String getAuthBearer() {
        String aiApiKey = System.getenv("AI_API_KEY");
        return "Bearer " + aiApiKey;


    }

    public URI getAiUrl() throws URISyntaxException {
       if (this.aiUrl == null ){
           aiUrl = AiProperties.aiUrl();
       }
        return new URI(this.aiUrl);

    }

    public void setAiUrl(String aiUrl) {
        this.aiUrl = aiUrl;
    }
}
