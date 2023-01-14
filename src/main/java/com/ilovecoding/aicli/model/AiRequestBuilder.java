package com.ilovecoding.aicli.model;

import java.util.List;

public class AiRequestBuilder {
    private String model;
    private String prompt;
    private Double frequencyPenalty = 0.0d;
    private List<String> stop = List.of("#", ";");
    private Integer maxTokens = 150;
    private Double presencePenalty = 0.0d;
    private Double topP = 1.0d;
    private Double temperature = 0.0d;

    public AiRequestBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public AiRequestBuilder setPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    public AiRequestBuilder setFrequencyPenalty(Double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
        return this;
    }

    public AiRequestBuilder setStop(List<String> stop) {
        this.stop = stop;
        return this;
    }

    public AiRequestBuilder setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
        return this;
    }

    public AiRequestBuilder setPresencePenalty(Double presencePenalty) {
        this.presencePenalty = presencePenalty;
        return this;
    }

    public AiRequestBuilder setTopP(Double topP) {
        this.topP = topP;
        return this;
    }

    public AiRequestBuilder setTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public AiRequest createAiRequest() {
        return new AiRequest(model, prompt, frequencyPenalty, stop, maxTokens, presencePenalty, topP,temperature);
    }
}