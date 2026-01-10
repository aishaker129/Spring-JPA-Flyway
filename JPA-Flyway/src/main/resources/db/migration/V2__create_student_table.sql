CREATE TABLE students (
                          id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          student_name VARCHAR(255) NOT NULL,
                          department VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          phone_number VARCHAR(50) NOT NULL,
                          age INT NOT NULL,
                          intake INT NOT NULL,
                          section INT NOT NULL,
                          university_id BIGINT NOT NULL,
                          create_at DATETIME NOT NULL,
                          modify_at DATETIME NOT NULL,
                          FOREIGN KEY (university_id) REFERENCES universities(id)
) ENGINE=InnoDB;
