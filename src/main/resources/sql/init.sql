
CREATE TABLE IF NOT EXISTS mark
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    time TIME,
    firstname VARCHAR(100) NOT NULL ,
    name VARCHAR(100) NOT NULL ,
    lastname VARCHAR(100) not null ,
    mark_name VARCHAR(100) not null ,
    application_number BIGINT NOT NULL
);

DROP TABLE user;
DROP TABLE mark;

