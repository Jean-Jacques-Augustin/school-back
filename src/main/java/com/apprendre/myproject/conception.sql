CREATE TABLE student
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name        VARCHAR(255)        NOT NULL,
    last_name         VARCHAR(255)        NOT NULL,
    date_of_birth     DATE,
    gender            ENUM('MALE', 'FEMALE', 'OTHER'),
    email             VARCHAR(255) UNIQUE NOT NULL,
    phone_number      VARCHAR(20),
    address           VARCHAR(255),
    nationality       VARCHAR(50),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    graduation_date   DATE,
    is_active         BOOLEAN   DEFAULT true,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE course
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(20) UNIQUE NOT NULL,
    course_name VARCHAR(255)       NOT NULL,
    description TEXT,
    start_date  DATE,
    end_date    DATE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE student_course
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id      BIGINT,
    course_id       BIGINT,
    enrollment_date DATE,
    grade           VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (course_id) REFERENCES course (id),
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Users
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     ENUM('ADMIN', 'USER') DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)