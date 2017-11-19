CREATE TABLE ACC
(
    LOGIN VARCHAR(20) NOT NULL,
    DS VARCHAR(20),
    DE VARCHAR(20),
    VOL VARCHAR(20),
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL
);
CREATE TABLE AUTH
(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    LOGIN VARCHAR(20) NOT NULL,
    ROLE VARCHAR(10) NOT NULL,
    RES VARCHAR(100) NOT NULL
);
CREATE TABLE USERS
(
    LOGIN VARCHAR(20) PRIMARY KEY NOT NULL,
    PASS VARCHAR(50) NOT NULL,
    SALT VARCHAR(26) NOT NULL
);