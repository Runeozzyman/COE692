-- Run this statement first, and then go under "Other databases" and set LMS it as "Default Catelog",
-- then you can run the create statements after the above step.
CREATE DATABASE LMS;

CREATE TABLE USER (
id int NOT NULL AUTO_INCREMENT,
username VARCHAR(50),
password VARCHAR(20),
PRIMARY KEY (id),
UNIQUE (username)
);

CREATE TABLE SONG (
id int NOT NULL AUTO_INCREMENT,
songName VARCHAR(20),
artist VARCHAR(50),
genre VARCHAR(20),
PRIMARY KEY (id)
);

CREATE TABLE PLAYLIST (
playlistName VARCHAR(50),
userID INT,
songID INT,
PRIMARY KEY (playlistName),
foreign key (userID) references USER (id),
foreign key (songID) references song (id)
)