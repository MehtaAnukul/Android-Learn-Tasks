package com.anukul.notesrecycleviewtask.model;

public class NotesModel {
    private String title;
    private String category;
    private String details;

    public NotesModel(String title, String category, String details) {
        this.title = title;
        this.category = category;
        this.details = details;
    }

    public NotesModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
