-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS boot_board;

-- 'test' 사용자 생성 및 권한 부여
CREATE USER 'test'@'%' IDENTIFIED BY 'test123';

-- 'boot_board' 데이터베이스에 대한 모든 권한 부여
GRANT ALL PRIVILEGES ON boot_board.* TO 'test'@'%';

-- 데이터베이스 사용
USE boot_board;

-- 사용자 테이블 생성
CREATE TABLE tbl_users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    passwd VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

-- 사용자 역할 테이블 생성
CREATE TABLE tbl_users_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    role_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tbl_users(user_id)
);

-- 'tbl_users' 테이블에 대한 SELECT, INSERT, DELETE 권한 부여
GRANT SELECT, INSERT, DELETE ON tbl_users TO 'test'@'%';

-- 'tbl_users_roles' 테이블에 대한 SELECT, INSERT, DELETE 권한 부여
GRANT SELECT, INSERT, DELETE ON tbl_users_roles TO 'test'@'%';
