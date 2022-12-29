package com.task.rtjava7;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "foundationDay"})
public class Country {

    private final long id;
    private String name;
    private String foundationDay;

    public Country(long id, String name, String foundationDay) {
        this.id = id;
        this.name = name;
        this.foundationDay = foundationDay;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getFoundationDay(){
        return this.foundationDay;
    }

    public void setFoundationDay(String foundationDay){
        this.foundationDay = foundationDay;
    }
}
