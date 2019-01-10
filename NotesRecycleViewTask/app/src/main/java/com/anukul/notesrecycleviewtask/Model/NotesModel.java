package com.anukul.notesrecycleviewtask.Model;

public class NotesModel {
    private String title;
    private String category;
    private String deteils;

    public NotesModel(String title, String category, String deteils) {
        this.title = title;
        this.category = category;
        this.deteils = deteils;
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

    public String getDeteils() {
        return deteils;
    }

    public void setDeteils(String deteils) {
        this.deteils = deteils;
    }
}
