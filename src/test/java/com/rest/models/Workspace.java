package com.rest.models;

public class Workspace {
    private String id;
    private String name;
    private String type;
    private String description;
    private String visibility;
    private String createdBy;
    private String updatedBy;
    private String createdAt;
    private String updatedAt;

    public Workspace(){}
    public Workspace(String name, String type, String description,
                     String visibility){
        this.name = name;
        this.type = type;
        this.description = description;
        this.visibility = visibility;
    }

    public Workspace (Workspace workspace){
        this.id = workspace.id;
        this.name = workspace.name;
        this.type = workspace.type;
        this.description = workspace.description;
        this.visibility = workspace.visibility;
        this.createdBy = workspace.createdBy;
        this.updatedBy = workspace.updatedBy;
        this.createdAt = workspace.createdAt;
        this.updatedAt = workspace.updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getVisibility() {
        return visibility;
    }
}
