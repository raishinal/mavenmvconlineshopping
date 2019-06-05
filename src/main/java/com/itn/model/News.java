/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Raishin
 */
@Entity
public class News {
   @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    
    private String tags;
    private String description;
    private String now;
    private int status;
    @Transient
    private MultipartFile image;
    private String imageName;

    public News() {
    }

    public News(String title, String tags, String description, String now, int status, MultipartFile image, String imageName) {
        this.title = title;
        this.tags = tags;
        this.description = description;
        this.now = now;
        this.status = status;
        this.image = image;
        this.imageName = imageName;
    }

    public News(int id, String title, String tags, String description, String now, int status, MultipartFile image, String imageName) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.description = description;
        this.now = now;
        this.status = status;
        this.image = image;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    
}
    