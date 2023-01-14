package com.ilovecoding.aicli.model;

import java.util.Objects;

/**
 * AiError
 */

public class AiError {

    private String message;

    private String type;

    private String param;

    private String code;

    public AiError message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     */

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AiError type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AiError param(String param) {
        this.param = param;
        return this;
    }

    /**
     * Get param
     *
     * @return param
     */

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public AiError code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AiError aiError = (AiError) o;
        return Objects.equals(this.message, aiError.message) &&
                Objects.equals(this.type, aiError.type) &&
                Objects.equals(this.param, aiError.param) &&
                Objects.equals(this.code, aiError.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, type, param, code);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AiError {\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    param: ").append(toIndentedString(param)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

