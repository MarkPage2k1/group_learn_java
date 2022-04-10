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
VALUES ("Khai trương");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Sinh nhật");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Ngày cưới");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Kỷ niệm");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Tình yêu");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Hoa bán");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Hoa chia buồn");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Hoa hạnh phúc");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Hoa bí");

INSERT INTO loai_hoa(ten_cat)
VALUES ("Hoa bầu");