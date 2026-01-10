CREATE TABLE universities (
                              id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              university_name VARCHAR(255) NOT NULL,
                              university_location VARCHAR(255) NOT NULL,
                              create_at DATETIME NOT NULL,
                              modify_at DATETIME NOT NULL
) ENGINE=InnoDB;