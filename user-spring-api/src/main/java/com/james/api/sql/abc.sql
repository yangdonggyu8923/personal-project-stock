show tables;
select * from users;
select * from articles;
select * from boards;
select * from masters;

drop table users, articles, boards, masters, accounts, products;

DROP PROCEDURE IF EXISTS insertLoop;

CREATE PROCEDURE insertLoop()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 50
        DO
            INSERT INTO articles(title, content, register_date)
            VALUES (concat('title', i), concat('content', i), concat('registerDate', i));
            SET i = i + 1;
END WHILE;

END;

CALL insertLoop;

DROP PROCEDURE IF EXISTS Loop1;
CREATE PROCEDURE Loop1()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 10
        DO
            INSERT INTO users(user_id, username, password, check_password, name, phone, job, height, weight)
            VALUES (i, concat('username', i), concat('password', i), concat('checkPassword', i),
                    concat('name', i), concat('phone', i), concat('job', i), (i+180), (i+80));
            SET i = i + 1;
END WHILE;
END;
CALL Loop1;
