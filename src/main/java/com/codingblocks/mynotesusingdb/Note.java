package com.codingblocks.mynotesusingdb;

public class Note {
    private String title,description,timeStamp;
    private Integer id;


    public Note(String title, String description, String timeStamp) {
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;

    }

    public Note(String title, String description, String timeStamp, Integer id) {
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;

        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
