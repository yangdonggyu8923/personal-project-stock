package com.james.api.user;

import com.james.api.article.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(name = "check_password")
    private String checkPassword;
    private String name;
    private String phone;
    private String job;
    private double height;
    private double weight;

    @OneToMany(mappedBy = "writer")
    private List<Article> article;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, String checkPassword,
                String name, String phone, String job, double height, double weight) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.checkPassword = checkPassword;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}