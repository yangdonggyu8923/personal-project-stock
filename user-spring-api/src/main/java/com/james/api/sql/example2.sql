--1번 더미데이터 추가
DROP PROCEDURE IF EXISTS insertLoop;

CREATE PROCEDURE insertLoop()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 5000
        DO
            INSERT INTO articles(id, title, content, writer, register_date)
            VALUES (i, concat('title', i), concat('content', i), concat('writer', i), concat('registerDate', i));
            SET i = i + 1;
END WHILE;
END;

CALL insertLoop;

--2번 더미데이터 추가
ALTER TABLE `articles` MODIFY COLUMN `id` bigint NOT NULL AUTO_INCREMENT;
DELIMITER $$
DROP PROCEDURE IF EXISTS insertLoop$$
CREATE PROCEDURE insertLoop()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 50 DO
        INSERT INTO articles(title, content, writer, register_date)
        VALUES (concat('title', i), concat('content', i), concat('writer', i), concat('registerDate', i));
        SET i = i + 1;
END WHILE;
END$$
DELIMITER ;
CALL insertLoop();