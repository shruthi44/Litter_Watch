CREATE TABLE COMPLAINT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  PLACE VARCHAR(64) NOT NULL,
  DESCRIPTION VARCHAR(256) NOT NULL,
  STATUS VARCHAR(64) ,
  REGISTERED_DATE_TIME DATE,
  CLIENT_ID BIGINT FOREIGN KEY

);

CREATE TABLE CLIENT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(64) NOT NULL,
  LAST_NAME VARCHAR(256) NOT NULL,
  EMAIL_ID VARCHAR(256) NOT NULL,
  PASSWORD VARCHAR(256) NOT NULL,

  ADMIN BIT

);

CREATE TABLE CLIENT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(64) NOT NULL,
  LAST_NAME VARCHAR(256) NOT NULL,
  EMAIL_ID VARCHAR(256) NOT NULL,
  ADMIN BIT
);

