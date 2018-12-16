package com.kun.demo;

import java.io.Serializable;

public class DemoData implements Serializable {
    private int postId;
    private int id;
    private String name;
    private String email;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


//        "postId": 1,
//        "id": 1,
//        "name": "id labore ex et quam laborum",
//        "email": "Eliseo@gardner.biz",
