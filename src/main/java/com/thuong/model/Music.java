package com.thuong.model;

public class Music {
    private int id;
    private String name;
    private String producer;
    private String classification;
    private String link;

    public Music() {
    }

    public Music(int id, String name, String producer, String classification, String link) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.classification = classification;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
