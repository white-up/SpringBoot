package com.example.springboot.entity;

import lombok.Data;

@Data
public class News {
    String title;
    String data;
    String category;
    String author_name;
}