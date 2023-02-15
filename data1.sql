CREATE DATABASE demoQuanLySV;
GO
USE demoQuanLySV;
GO
CREATE TABLE SinhVien (
    MaSV INTEGER PRIMARY KEY IDENTITY,
    HoTen VARCHAR(50),
    NgaySinh DATE,
    GioiTinh BIT,
    DiemTB FLOAT
);
GO
INSERT INTO SinhVien (MaSV, HoTen, NgaySinh, GioiTinh, DiemTB)
VALUES (1, 'Nguyen Van A', '2000-01-01', 1, 8.0);
GO
SELECT * FROM SinhVien;
GO
UPDATE SinhVien
SET HoTen = 'Nguyen Van B', NgaySinh = '2001-01-01', GioiTinh = 0, DiemTB = 7.5
WHERE MaSV = 1;
GO
--DELETE FROM SinhVien WHERE MaSV = 1;
