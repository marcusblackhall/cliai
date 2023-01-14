package com.ilovecoding.aicli;

import com.ilovecoding.aicli.model.AiRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonFromRequest {
    public CreateJsonFromRequest() {
    }

    String aiRequestAsJson(AiRequest aiRequest) {

        JSONObject aiRequestJson = new JSONObject();
        aiRequestJson.put("model", aiRequest.getModel());
        aiRequestJson.put("prompt", aiRequest.getPrompt());
        aiRequestJson.put("temperature", aiRequest.getTemperature());
        aiRequestJson.put("max_tokens", aiRequest.getMaxTokens());
        aiRequestJson.put("top_p", aiRequest.getTopP());
        aiRequestJson.put("frequency_penalty", aiRequest.getFrequencyPenalty());
        aiRequestJson.put("presence_penalty", aiRequest.getPresencePenalty());
        JSONArray array = new JSONArray();
        array.put("#");
        array.put(";");
        aiRequestJson.put("stop", array);
        return aiRequestJson.toString();


    }
}