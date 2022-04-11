-- request1
UPDATE danhmuctin SET tendanhmuctin = 'Tin tức Việt - Nhật' WHERE tendanhmuctin = 'Tin tức Việt Nhật';

-- request2
UPDATE danhmuctin SET tendanhmuctin = 'Toàn cảnh Nhật Bản' WHERE tendanhmuctin = 'Toàn cảnh nhật Bản';

-- request3
SELECT tendanhmuctin FROM danhmuctin;

-- request4
SELECT id_danhmuctin, tendanhmuctin FROM danhmuctin WHERE id_danhmuctin > 4;

-- request5
SELECT tendanhmuctin FROM danhmuctin WHERE tendanhmuctin LIKE '%Nhật%';

-- request6
DELETE FROM danhmuctin WHERE id_danhmuctin IN (5, 6);