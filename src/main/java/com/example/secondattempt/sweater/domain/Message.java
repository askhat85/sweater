package com.example.secondattempt.sweater.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String tag;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public String getAuthorName() {
        return author!=null ? author.getUsername() : "Unknown";
    }
    public Message() {
    }

    public Message(String text, String tag, User author) {
        this.text = text;
        this.tag = tag;
        this.author = author;
    }


}
