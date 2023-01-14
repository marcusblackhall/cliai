package com.ilovecoding.aicli.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AiRequest
 */
public class AiRequest {



    public AiRequest(String model,
                     String prompt,
                     Double frequencyPenalty,
                     List<String> stop, Integer maxTokens,
                     Double presencePenalty,
                     Double topP,
                     Double temperature
                     ) {
        this.model = model;
        this.prompt = prompt;
        this.frequencyPenalty = frequencyPenalty;
        this.stop = stop;
        this.maxTokens = maxTokens;
        this.presencePenalty = presencePenalty;
        this.topP = topP;
        this.temperature = temperature;
    }

    private String model;

    private String prompt;

    private Double frequencyPenalty;

    private List<String> stop = null;

    private Integer maxTokens;

    private Double presencePenalty;

    private Double topP;

    private Double temperature;

    public AiRequest model(String model) {
        this.model = model;
        return this;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public AiRequest prompt(String prompt) {
        this.prompt = prompt;
        return this;
    }



    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public AiRequest frequencyPenalty(Double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
        return this;
    }

    /**
     * Get frequencyPenalty
     *
     * @return frequencyPenalty
     */

    public Double getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(Double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public AiRequest stop(List<String> stop) {
        this.stop = stop;
        return this;
    }

    public AiRequest addStopItem(String stopItem) {
        if (this.stop == null) {
            this.stop = new ArrayList<>();
        }
        this.stop.add(stopItem);
        return this;
    }

    /**
     * Get stop
     *
     * @return stop
     */

    public List<String> getStop() {
        return stop;
    }

    public void setStop(List<String> stop) {
        this.stop = stop;
    }

    public AiRequest maxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
        return this;
    }

    /**
     * Get maxTokens
     *
     * @return maxTokens
     */

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public AiRequest presencePenalty(Double presencePenalty) {
        this.presencePenalty = presencePenalty;
        return this;
    }

    /**
     * Get presencePenalty
     *
     * @return presencePenalty
     */

    public Double getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(Double presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public AiRequest topP(Double topP) {
        this.topP = topP;
        return this;
    }

    /**
     * Get topP
     *
     * @return topP
     */

    public Double getTopP() {
        return topP;
    }

    public void setTopP(Double topP) {
        this.topP = topP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AiRequest aiRequest = (AiRequest) o;
        return Objects.equals(this.model, aiRequest.model) &&
                Objects.equals(this.prompt, aiRequest.prompt) &&
                Objects.equals(this.frequencyPenalty, aiRequest.frequencyPenalty) &&
                Objects.equals(this.stop, aiRequest.stop) &&
                Objects.equals(this.maxTokens, aiRequest.maxTokens) &&
                Objects.equals(this.presencePenalty, aiRequest.presencePenalty) &&
                Objects.equals(this.topP, aiRequest.topP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, prompt, frequencyPenalty, stop, maxTokens, presencePenalty, topP);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AiRequest {\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
        sb.append("    prompt: ").append(toIndentedString(prompt)).append("\n");
        sb.append("    frequencyPenalty: ").append(toIndentedString(frequencyPenalty)).append("\n");
        sb.append("    stop: ").append(toIndentedString(stop)).append("\n");
        sb.append("    maxTokens: ").append(toIndentedString(maxTokens)).append("\n");
        sb.append("    presencePenalty: ").append(toIndentedString(presencePenalty)).append("\n");
        sb.append("    topP: ").append(toIndentedString(topP)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}

