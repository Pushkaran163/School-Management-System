CREATE DATABASE school_management;

USE school_management;

CREATE TABLE users(
	user_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);
