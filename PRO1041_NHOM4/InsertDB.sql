INSERT INTO TaiKhoan VALUES
('TK01','phanmembanhang1','bimat1','Admin',1),
('TK02','phanmembanhang2','bimat2','Staff',1),
('TK03','phanmembanhang3','bimat3','Staff',1)
GO

INSERT INTO NhanVien VALUES
('NV01','TK02',N'Nguyễn Thành Trung',1,N'Ninh Bình','0358234123','037204007541','2023-04-10',1,'anh1.png'),
('NV02','TK02',N'Đào Đức Phiên',1,N'Hà Nội','0852123754','037201445789','2023-01-10',1,'anh2.png'),
('NV03','TK02',N'Lê Trọng An',0,N'Bắc Ninh','0575241471','038205004741','2023-01-13',1,'anh3.png'),
('NV04','TK01',N'Khương Trọng Đức',1,N'Hà Nam','0842123745','039542004176','2022-08-15',0,'anh4.png'),
('NV05','TK02',N'Hồ Đức Anh',0,N'Hòa Bình','0385412789','034245007454','2022-07-19',0,'anh5.png')
GO


INSERT INTO KhachHang Values
('KH01',N'Nguyễn Đức Việt','1999-10-13','0532687524','ducvietnguyen123@gmail.com',1,N'Hà Nội'),
('KH02',N'Phạm Nhật Nam','2000-05-01','0854247895','trunam3123czc@gmail.com',1,N'Thành Phố Hồ Chí Minh'),
('KH03',N'Phùng Bá Duy','2002-04-10','0175257987','duyzn3121@gmail.com',0,N'Nghệ An')
GO

INSERT INTO HinhThucThanhToan Values
('HTTT01',N'Tiền mặt',1),
('HTTT02',N'Chuyển khoản',1)
GO

INSERT INTO LoaiSanPham VALUES
('LSP01',N'Áo Khoác Krants',1,N'Hàng đẹp'),
('LSP02',N'Áo Thun Krants',1,N'Hàng đẹp'),
('LSP03',N'Áo Polo Krants',1,N'Hàng đẹp'),
('LSP04',N'Quần Tây Krants',0,N'Hàng đẹp'),
('LSP05',N'Quần Kaki Krants',1,N'Hàng đẹp')
GO

INSERT INTO SanPham VALUES
('SP01',N'Áo Khoác Hoodie Krants Local Brand Unisex Special Collection Premium',1,'LSP01',N'Việt Nam'),
('SP02',N'Áo Khoác Gió Nam Nữ Krants Design Studio Jacket New Collection Blue',1,'LSP01',N'Lào'),
('SP03',N'Áo Thun Local Brand Krants Signature Logo Brand',1,'LSP02',N'Thái Lan'),
('SP04',N'Áo Polo Local Brand Krants Signature Polo Shirt Premium',0,'LSP03',N'Hàn Quốc'),
('SP05',N'Quần Tây Nam Phong Cách Hàn Quốc Krants',0,'LSP04',N'Việt Nam'),
('SP06',N'Quần Kaki nam dáng baggy vải co giãn Krants',1,'LSP05',N'Campuchia'),
('SP07',N'Quần Tây Nam Ống Côn Krants',1,'LSP04',N'Việt Nam'),
('SP08',N'Áo Polo Local Brand Krants Signature Polo Shirt Premium',1,'LSP03',N'Việt Nam'),
('SP09',N'Quần Tây Nam Vải Cotton Krantst',1,'LSP04',N'Nhật Bản'),
('SP10',N'Áo Thun Local Brand Krants Premium 100% Cotton Most Famous',1,'LSP02',N'Việt Nam'),
('SP11',N'Quần Down Jacket',1,'LSP04',N'Việt Nam'),
('SP12',N'Quần Pea Coat ',0,'LSP04',N'Đài Loan')
GO

SELECT * FROM SanPham

INSERT INTO MauSac VALUES
('MS01',N'Đỏ',1),
('MS02',N'Đen',1),
('MS03',N'Trắng',1),
('MS04',N'Xanh',1),
('MS05',N'Be',1)
GO

INSERT INTO ChatLieu VALUES
('CL01',N'Vải cotton',1),
('CL02',N'Vải kaki',1),
('CL03',N'Vải Kate',1),
('CL04',N'Vải nỉ',1),
('CL05',N'Vải Jean',1)
GO

INSERT INTO KichThuoc VALUES
('KT01','S',1),
('KT02','M',1),
('KT03','L',1),
('KT04','XL',1)
GO

INSERT INTO Events VALUES
('EV01',N'Black Friday',1,'20000','2023-03-11','2023-03-15',N'Siêu giảm giá Black Friday',1,1,'2000000'),
('EV02',N'Ngày Phụ Nữ Việt Nam',1,'15000','2023-10-19','2023-10-21',N'Siêu giảm giá ngày 20/10',1,0,''),
('EV03',N'Sale 11/11',0,'40%','2023-11-03','2023-11-05',N'Siêu giảm giá ngày 11/11',1,1,'2500000')
GO


INSERT INTO ChiTietSanPham VALUES
('CTSP01','SP02','MS05','CL03','KT04',2,800000,1),
('CTSP02','SP05','MS02','CL01','KT01',1,574000,0),
('CTSP03','SP06','MS02','CL03','KT02',4,900000,1)
GO

INSERT INTO HoaDon VALUES
('HD01','NV05','KH03','HTTT01',getDate(),450000,50000,400000,1,N'Thành công','EV02'),
('HD02','NV03','KH02','HTTT02',getDate(),130000,50000,90000,0,N'Thất bại','EV01'),
('HD03','NV02','KH01','HTTT01',getDate(),750000,50000,700000,1,N'Thành công','EV03'),
('HD04','NV02','KH01','HTTT01',getDate(),800000,0,800000,1,N'Thành công','')

GO

INSERT INTO HoaDonChiTiet VALUES
('HDCT01','CTSP06','HD03',3,170000,510000,N'Ok',1)
('HDCT02','CTSP03','HD02',4,170000,680000,N'Ok',1),
('HDCT03','CTSP01','HD01',3,210000,630000,N'Not Ok',0)
GO

SELECT * FROM TaiKhoan
SELECT * FROM NhanVien
SELECT * FROM KhachHang
SELECT * FROM HinhThucThanhToan
SELECT * FROM LoaiSanPham
SELECT * FROM SanPham
SELECT * FROM MauSac
SELECT * FROM ChatLieu
SELECT * FROM KichThuoc
SELECT * FROM Events
SELECT * FROM ChiTietSanPham
SELECT * FROM HoaDon
SELECT * FROM HoaDonChiTiet
