-- request1
USE shophoa;
CREATE TABLE hoa(
    id_hoa int NOT NULL AUTO_INCREMENT,
    ten_hoa varchar(255),
    mo_ta varchar(255),
    hinh_anh char(50),
    gia_ban decimal(10, 2),
    id_cat int,
    PRIMARY KEY(id_hoa),
    CONSTRAINT pk_hoa_loaihoa FOREIGN KEY(id_cat) REFERENCES loai_hoa(id_cat)
);

INSERT INTO hoa(ten_hoa, mo_ta, hinh_anh, gia_ban, id_cat)
VALUES 
("Hoa thủy tiên", "Mô tả Hoa thủy tiên", "thuytien.jpg", 120000, 2),
("Hoa Violet", "Mô tả Hoa Violet", "violet.jpg", 140000, 1),
("Hoa Lilies", "Mô tả Hoa Lilies", "hoali.jpg",	200000,	1),
("Hoa lài", "Mô tả Hoa lài", "hoalai.jpg",400000,3),
("Hoa Phong Lan", "Mô tả Hoa Phong Lan", "phonglam.jpg", 135000, 4),
("Hoa cúc", "Mô tả Hoa cúc", "cuc.png",	100000,	1),
("Hoa Tỉ muội", "Mô tả Hoa Tỉ muội", "timuoi.gif", 80000, 1),
("Hoa Hồng Phấn ", "Mô tả Hoa hồng Phấn", "hongphan.png", 937000, 2),
("Hoa hồng kem", "Mô tả Hoa hồng kem", "hongkem.gif", 200000, 4),
("Hoa bát tiên", "Mô tả Hoa bát tiên", "baitien.png", 120000, 6);


-- request2
SELECT id_hoa, ten_hoa, gia_ban FROM hoa;

-- request3
SELECT hoa.id_hoa, hoa.ten_hoa, hoa.id_cat, loai_hoa.ten_cat FROM (loai_hoa INNER JOIN hoa ON loai_hoa.id_cat = hoa.id_cat);

-- request4
SELECT loai_hoa.ten_cat FROM (loai_hoa INNER JOIN hoa ON loai_hoa.id_cat = hoa.id_cat) WHERE hoa.ten_hoa = "Hoa thủy tiên";
SELECT ten_cat FROM loai_hoa WHERE id_cat = (SELECT id_cat FROM hoa WHERE ten_hoa = "Hoa thủy tiên");

--request5
SELECT hoa.id_hoa, hoa.ten_hoa, hoa.id_cat, loai_hoa.ten_cat FROM (loai_hoa INNER JOIN hoa ON loai_hoa.id_cat = hoa.id_cat) WHERE hoa.id_cat = 1;

--request6
SELECT hoa.id_hoa, hoa.ten_hoa, loai_hoa.ten_cat FROM (loai_hoa INNER JOIN hoa ON loai_hoa.id_cat = hoa.id_cat) WHERE hoa.id_cat = 2 OR hoa.id_cat = 3;

--request7
SELECT hoa.ten_hoa, hoa.hinh_anh, hoa.gia_ban, loai_hoa.ten_cat FROM (loai_hoa INNER JOIN hoa ON loai_hoa.id_cat = hoa.id_cat) WHERE hoa.id_hoa = 3;

--request8
SELECT hoa.id_hoa, hoa.ten_hoa, hoa.id_cat, loai_hoa.ten_cat FROM (loai_hoa INNER JOIN hoa ON loai_hoa.id_cat = hoa.id_cat) WHERE hoa.id_hoa LIKE '%hồng%';

--request9
UPDATE hoa SET hinh_anh = "battien.png", mo_ta = "Đây là mô tả về hoa bát tiên" WHERE id_hoa = 10;

--request10
UPDATE hoa SET id_cat = 5, gia_ban = 500000 WHERE id_hoa = 10 OR id_hoa = 8;

--request11
DELETE FROM hoa WHERE id_hoa >= 9 AND gia_ban > 150000;

--request12
SELECT COUNT(id_hoa) FROM hoa WHERE id_cat = 1;