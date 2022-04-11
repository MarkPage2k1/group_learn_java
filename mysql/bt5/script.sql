USE tintuc;
CREATE TABLE tintuc(
    id_tintuc int NOT NULL AUTO_INCREMENT,
    tentintuc varchar(255),
    mota varchar(255),
    hinhanh char(20),
    chitiet varchar(255),
    ngaydang date,
    id_danhmuctin int,
    PRIMARY KEY(id_tintuc), 
    CONSTRAINT fk_tintuc_danhmuctin FOREIGN KEY(id_tintuc) REFERENCES tintuc(id_tintuc)
);

INSERT INTO tintuc(tentintuc, mota, hinhanh, id_danhmuctin)
VALUES 
("Thị trấn truyền thống Uchiko – Nhật Bản", "Thị trấn truyền thống của Uchiko được bao quanh bởi vẻ đẹp tự nhiên", "hinh1.jpg", 1),
("Đền thiêng Sefa Utaki ở Okinawa", "Sefa Utaki nằm ở phía đông nam của đảo Okinawa Honto", "hinh2.jpg", 1),
("Cây cầu lớn Seto Naikai", "Người ta có thể đáp xe lửa nhanh chóng", "hinh3.jpg", 2),
("Những bảo tàng có một không hai ở Nhật Bản", "Bảo tàng thuốc lá và muối hay bảo tàng Takoyaki chỉ là hai trong", "hinh4.jpg", 3),
("Thiếu nữ Nhật Bản xinh tươi đón lễ Thành nhân", "Lễ thành nhân – buổi lễ dành cho thanh niên bước sang tuổi 20 (tuổi trưởng thành tại Nhật Bản) – được coi là một trong những ngày lễ đặc biệt nhất tại đất nước Mặt trời mọc.", "hinh5.jpg", 1),
("Tắm nước lạnh, ôm tảng băng lớn để cầu may", "Nhiệt độ ngoài trời khi đó vào khoảng 6 độ C, những người đàn ông cởi bỏ y phục, chỉ mặc trên mình một chiếc khố truyền thống mỏng manh. Họ cùng đầm mình xuống một bể nước lạnh, được đặt trước đền Teppozu Inari", "hinh6.jpg", 1),
("Tạo khác biệt thu hút FDI Nhật Bản", "Trong bối cảnh suy giảm kinh tế toàn cầu, ngày càng có nhiều DN Nhật Bản tìm kiếm cơ hội đầu tư tại Việt Nam. Dòng vốn đầu tư của DN Nhật Bản liên tục gia tăng, củng cố vị trí là quốc gia dẫn đầu về vốn đầu tư nước", "hinh7.jpg", 2);

-- request1
UPDATE tintuc SET hinhanh = "hinh8.jpg" WHERE id_tintuc = 4;

-- request2
UPDATE tintuc SET chitiet = "https://www.tintuc24h.com/abc", ngaydang = '2022-04-11';

-- request3
SELECT id_tintuc, tentintuc, hinhanh, id_danhmuctin FROM tintuc WHERE id_tintuc = 2;

--request4
SELECT * FROM tintuc WHERE id_danhmuctin = 1;

--request6
SELECT COUNT(id_tintuc) FROM tintuc WHERE id_danhmuctin = 1;

--request7
SELECT tintuc.id_tintuc, tintuc.tentintuc, tintuc.id_danhmuctin, danhmuctin.tendanhmuctin FROM (danhmuctin INNER JOIN tintuc ON danhmuctin.id_danhmuctin = tintuc.id_danhmuctin) WHERE id_tintuc = 2;

--request8
SELECT tintuc.tentintuc, danhmuctin.tendanhmuctin FROM (danhmuctin INNER JOIN tintuc ON danhmuctin.id_danhmuctin = tintuc.id_danhmuctin) WHERE id_tintuc = 5;
