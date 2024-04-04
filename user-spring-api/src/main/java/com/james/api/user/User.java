package com.james.api.user;

import com.james.api.article.Article;
import com.james.api.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;

    @OneToMany(mappedBy = "writer")
    private List<Article> article;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password,
                String name, String phone, String job) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.job = job;

    }

    public void setPassword(String password) {
        this.password = password;
    }
}