-- New database
CREATE DATABASE shophoa;

USE shophoa;
-- New Table
CREATE TABLE loai_hoa (
    id_cat int NOT NULL AUTO_INCREMENT,
    ten_cat varchar(255),
    PRIMARY KEY(id_cat)
);

-- Insert datas in database
INSERT INTO loai_hoa(ten_cat)
VALUES ("Khai trương"), ("Sinh nhật"), ("Ngày cưới"), ("Kỷ niệm"), ("Tình yêu"), ("Hoa bán"), ("Hoa chia buồn"), ("Hoa hạnh phúc"), ("Hoa bí"), ("Hoa bầu");