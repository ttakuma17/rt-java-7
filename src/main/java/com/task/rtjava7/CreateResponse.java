package com.task.rtjava7;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "message"})
public class CreateResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("message")
    private String message;

    public CreateResponse(long id, String message){
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
