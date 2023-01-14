package com.ilovecoding.aicli.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AiResponse
 */

public class AiResponse {

    private String id;

    public AiUsage getUsage() {
        return usage;
    }

    public void setUsage(AiUsage usage) {
        this.usage = usage;
    }

    private AiUsage usage;

    private String _object;

    private Long created;

    private String model;

    private List<AiChoice> choices = null;

    public AiResponse id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AiResponse _object(String _object) {
        this._object = _object;
        return this;
    }

    /**
     * Get _object
     *
     * @return _object
     */

    public String getObject() {
        return _object;
    }

    public void setObject(String _object) {
        this._object = _object;
    }

    public AiResponse created(Long created) {
        this.created = created;
        return this;
    }

    /**
     * Get created
     *
     * @return created
     */

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public AiResponse model(String model) {
        this.model = model;
        return this;
    }

    /**
     * Get model
     *
     * @return model
     */

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public AiResponse choices(List<AiChoice> choices) {
        this.choices = choices;
        return this;
    }

    public AiResponse addChoicesItem(AiChoice choicesItem) {
        if (this.choices == null) {
            this.choices = new ArrayList<>();
        }
        this.choices.add(choicesItem);
        return this;
    }

    /**
     * Get choices
     *
     * @return choices
     */
    public List<AiChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<AiChoice> choices) {
        this.choices = choices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AiResponse aiResponse = (AiResponse) o;
        return Objects.equals(this.id, aiResponse.id) &&
                Objects.equals(this._object, aiResponse._object) &&
                Objects.equals(this.created, aiResponse.created) &&
                Objects.equals(this.model, aiResponse.model) &&
                Objects.equals(this.choices, aiResponse.choices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, _object, created, model, choices);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AiResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
        sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
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

