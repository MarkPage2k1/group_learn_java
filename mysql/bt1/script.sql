-- New database
CREATE DATABASE tintuc;

USE tintuc;
-- New Table
CREATE TABLE danhmuctin (
    id_danhmuctin int NOT NULL AUTO_INCREMENT,
    tendanhmuctin varchar(255),
    PRIMARY KEY(id_danhmuctin)
);

-- Insert datas in database
INSERT INTO danhmuctin (tendanhmuctin)
VALUES ("Toàn cảnh Nhật Bản");

INSERT INTO danhmuctin (tendanhmuctin)
VALUES ("Tin tức Việt Nhật");

INSERT INTO danhmuctin (tendanhmuctin)
VALUES ("Tin Tức giải trí");

INSERT INTO danhmuctin (tendanhmuctin)
VALUES ("Du học Nhật Bản");

INSERT INTO danhmuctin (tendanhmuctin)
VALUES ("Tin thể thao");

INSERT INTO danhmuctin (tendanhmuctin)
VALUES ("Tin xã hội");
