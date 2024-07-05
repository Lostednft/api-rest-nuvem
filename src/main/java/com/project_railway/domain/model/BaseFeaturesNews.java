package com.project_railway.domain.model;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseFeaturesNews {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String icon;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
