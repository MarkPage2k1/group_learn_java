-- problem1
CREATE DATABASE QLSV;

USE QLSV;
CREATE TABLE DMKHOA(
    MaKH varchar(6) NOT NULL,
    TenKhoa varchar(30),
    PRIMARY KEY (MaKH)
);

CREATE TABLE SINHVIEN(
    MaSV varchar(6) NOT NULL,
    HoSV varchar(30),
    TenSV varchar(15),
    GioiTinh char(1),
    NgaySinh datetime,
    NoiSinh varchar(50),
    DiaChi varchar(50),
    MaKH varchar(6),
    HocBong int,
    PRIMARY KEY (MaSV),
    CONSTRAINT pk_sinhvien_khoa FOREIGN KEY(MaKH) REFERENCES DMKHOA(MaKH)
);

CREATE TABLE MONHOC(
	MaMH varchar(6) NOT NULL,
    TenMH text(50),
    SoTiet int,
    PRIMARY KEY(MaMH)
);

CREATE TABLE KETQUA(
    MaSV varchar(6) NOT NULL,
    MaMH varchar(6) NOT NULL,
    Diem int,
    CONSTRAINT pk_ketqua_sinhVien FOREIGN KEY(MaSV) REFERENCES SINHVIEN(MaSV),
    CONSTRAINT pk_ketqua_monhoc FOREIGN KEY(MaMH) REFERENCES MONHOC(MaMH)
);

-- problem2
INSERT INTO dmkhoa
VALUES
("AV", "Anh Văn"), 
("TH", "Tin Học"),
("TR", "Triết Học"),
("VL", "Vật Lý");

INSERT INTO sinhvien
VALUES 
('A01', 'Nguyễn thị', 'Hải', '0', '1977-02-23', 'Sài Gòn', '12 B Võ văn Tần', 'TH', '10000'),
('A02', 'Trần văn', 'Chính', '1', '1977-12-24', 'Sài Gòn', '34 Nguyễn Bỉnh Khiêm', 'TH', '120000'),
('A03', 'Lê Bạch', 'Yến', '0', '1996-02-21', 'Hà Nội', '765 PasTeur', 'TH', '140000'),
('B01', 'Trần Thanh', 'Mai', '0', '1977-08-12', 'Bến Tre', '32 Lê lai', 'TH', null),
('B02', 'Trần thu', 'Thủy', '0', '1977-01-01', 'Sài Gòn', '45 Nguyễn Thái sơn', 'TH', null),
('B03', 'Lê thị', 'Thanh', '0', '1975-01-01', 'Sài Gòn', '345 Nguyễn Kiệm', 'AV', null),
('B04', 'Trần trọng', 'Kim', '1', '1977-12-20', 'Sài Gòn', '123 Lê văn sỹ', 'AV', '120000'),
('C01', 'Tào hồng', 'Thiên', '1', '1978-07-01', 'Sài Gòn', '56 Hòang Diệu', 'TH', null),
('C02', 'Hoàng minh', 'Châu', '1', '1976-05-03', 'Sài Gòn', '102 Kỳ Đồng', 'AV', null),
('C03', 'Phan quỳnh', 'Hương', '0', '1979-05-05', 'Sài Gòn', '234 Phạm văn hai', 'AV', null);

INSERT INTO monhoc 
VALUES 
('01', 'Cơ sở dữ liệu', 45),
('02', 'Trí tuệ nhân tạo', 45),
('03', 'Truyền Tin', 45),
('04', 'Đồ Họa', 60),
('05', 'Văn Phạm', 60),
('06', 'Đàm Thoại', 60);

INSERT INTO ketqua 
VALUES 
('A01', '01', 2),
('A01', '03', 7),
('A02', '01', 5),
('A02', '05', 9),
('A03', '01', 5),
('A03', '03', 3),
('B01', '03', 3),
('B01', '02', 6),
('B02', '04', 10),
('B02', '01', 7),
('B03', '03', 6),
('B04', '05', 3),
('B04', '06', 4);

-- problem3
-- request1
SELECT MaSV, HoSV, TenSV, NgaySinh, GioiTinh FROM sinhvien;

-- request2
SELECT MaSV, HoSV, TenSV, NgaySinh, GioiTinh, MaKH, HocBong FROM sinhvien ORDER BY MaKH ASC, MaSV DESC;

-- request3
SELECT sinhvien.MaSV, sinhvien.HoSV, sinhvien.TenSV, ketqua.MaMH, ketqua.Diem 
FROM ketqua INNER JOIN sinhvien ON sinhvien.MaSV = ketqua.MaSV;

-- request4
SELECT * FROM sinhvien WHERE sinhvien.TenSV = 'Chính';

-- request5
SELECT * FROM sinhvien WHERE sinhvien.NoiSinh = 'Sài Gòn';

-- request6
SELECT * FROM sinhvien WHERE sinhvien.NoiSinh = 'Hà Nội' AND sinhvien.MaKH = 'TH';

-- request7
SELECT * FROM sinhvien WHERE sinhvien.HoSV LIKE 'Trần%' AND sinhvien.MaKH = 'AV';

-- request8
SELECT * FROM sinhvien WHERE sinhvien.MaSV LIKE 'B%' AND sinhvien.MaKH = 'AV';

-- request9
UPDATE sinhvien SET HocBong = HocBong + 50000 WHERE sinhvien.MaKH = 'TH';

-- request10
UPDATE ketqua SET diem = diem + 0.5 
WHERE ketqua.MaMH = (SELECT MaMH FROM monhoc WHERE TenMH = 'Cơ sở dữ liệu') AND ketqua.Diem < 5;

-- request11
DELETE FROM ketqua WHERE ketqua.MaSV = 'B04';
