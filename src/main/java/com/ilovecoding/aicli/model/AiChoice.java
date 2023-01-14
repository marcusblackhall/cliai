package com.ilovecoding.aicli.model;

import java.util.Objects;

/**
 * AiChoice
 */

public class AiChoice {

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    private Integer index;

    private String logprobs;


    private String text;

    private String finishReason;

    public AiChoice text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AiChoice finishReason(String finishReason) {
        this.finishReason = finishReason;
        return this;
    }

    /**
     * Get finishReason
     *
     * @return finishReason
     */

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AiChoice aiChoice = (AiChoice) o;
        return Objects.equals(this.text, aiChoice.text) &&
                Objects.equals(this.finishReason, aiChoice.finishReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, finishReason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AiChoice {\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("    finishReason: ").append(toIndentedString(finishReason)).append("\n");
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
}

