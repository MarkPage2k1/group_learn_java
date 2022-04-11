-- request1
UPDATE loai_hoa SET ten_cat = 'Sinh Nhật' WHERE id_cat = 2;

-- request2
UPDATE loai_hoa SET ten_cat = 'Hoa Hạnh Phúc' WHERE id_cat = 8;

-- request3
SELECT * FROM loai_hoa;

-- request4
UPDATE loai_hoa SET ten_cat = 'Kỷ Niệm' WHERE id_cat = 4;

-- request5
SELECT COUNT(id_cat) FROM loai_hoa WHERE id_cat > 5;

-- request6
DELETE FROM loai_hoa WHERE ten_cat = 'Hoa Bí' OR ten_cat = 'Hoa Bầu';

-- request7
SELECT ten_cat FROM loai_hoa;