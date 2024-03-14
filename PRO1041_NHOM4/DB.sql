CREATE DATABASE KrantsStore
GO
USE KrantsStore
GO 
CREATE TABLE [TaiKhoan] (
  [MaTK] varchar(10),
  [UserName] varchar(20),
  [PassWord] varchar(20),
  [Role] varchar(10),
  [TrangThai] bit,
  PRIMARY KEY ([MaTK])
);
CREATE TABLE [NhanVien] (
  [MaNV] varchar(10),
  [MaTK] varchar(10) not null,
  CONSTRAINT FK_NV_TK foreign key(MaTK) references TaiKhoan(MaTK),
  [HoTen] nvarchar(50),
  [GioiTinh] bit,
  [DiaChi] nvarchar(100),
  [SoDienThoai] varchar(10),
  [CCCD] nvarchar(50),
  [NgayVaoLam] date,
  [TrangThai] bit,
  [Anh] varchar(MAX),
  PRIMARY KEY ([MaNV])
);

CREATE TABLE [KhachHang] (
  [MaKH] varchar(10),
  [HoTen] nvarchar(50),
  [NgaySinh] date,
  [SoDienThoai] varchar(10),
  [Email] varchar(100),
  [GioiTInh] bit,
  [DiaChi] nvarchar(100),
  PRIMARY KEY ([MaKH])
);
CREATE TABLE [Events] (
  [MaEV] varchar(10),
  [TenEV] nvarchar(50),
  [HinhThuc] bit,
  [MucGiamGia] varchar(100),
  [ThoiGianBatDau] date,
  [ThoiGianKetThuc] date,
  [MoTa] nvarchar(100),
  [TrangThai] bit,
  [DieuKienApDung] bit,--1:tien--0%
  [DieuKienTongTien] nvarchar(50)
  PRIMARY KEY ([MaEV])
);
CREATE TABLE [LoaiSanPham] (
  [MaLSP] varchar(10),
  [TenLSP] nvarchar(50),
  [TrangThai] bit,
  [Mota] nvarchar(100),
  PRIMARY KEY ([MaLSP])
);
CREATE TABLE [SanPham] (
  [MaSanPham] varchar(10),
  [TenSanPham] nvarchar(150),
  [TrangThai] bit,
  [MaLSP] varchar(10) not null,
  CONSTRAINT FK_SP_LSP foreign key(MaLSP) references LoaiSanPham(MaLSP),
  [XuatXu] nvarchar(50),
  PRIMARY KEY ([MaSanPham])
);

CREATE TABLE [MauSac] (
  [MaMauSac] varchar(10),
  [TenMauSac] nvarchar(50),
  [TrangThai] bit,
  PRIMARY KEY ([MaMauSac])
);

CREATE TABLE [ChatLieu] (
  [MaChatLieu] varchar(10),
  [TenChatLieu] nvarchar(50),
  [TrangThai] bit,
  PRIMARY KEY ([MaChatLieu])
);

CREATE TABLE [KichThuoc] (
  [MaKichThuoc] varchar(10),
  [TenKichThuoc] nvarchar(50),
  [TrangThai] bit,
PRIMARY KEY ([MaKichThuoc])
);

CREATE TABLE [ChiTietSanPham] (
  [MaCTSP] varchar(10),
  [MaSanPham] varchar(10) not null,
  CONSTRAINT FK_CTSP_SP foreign key(MaSanPham) references SanPham(MaSanPham),
  [MaMauSac] varchar(10) not null,
  CONSTRAINT FK_CTSP_MS foreign key(MaMauSac) references MauSac(MaMauSac),
  [MaChatLieu] varchar(10) not null,
   CONSTRAINT FK_CTSP_CL foreign key(MaChatLieu) references ChatLieu(MaChatLieu),
  [MaKichThuoc] varchar(10) not null,
   CONSTRAINT FK_CTSP_KT foreign key(MaKichThuoc) references KichThuoc(MaKichThuoc),
  [SoLuong] int,
  [Gia] money,
  [TrangThai] bit,
  PRIMARY KEY ([MaCTSP])
);









CREATE  TABLE HoaDon (
    MaHoaDon varchar(5) PRIMARY KEY,
	MaKH varchar(10),	
	MaNV varchar(10),
	HinhThucThanhToan bit,
    NgayTao DATE,
    TongTien MONEY,
	TrangThai nvarchar(20),
	GhiChu		nvarchar(200),
	MaEvents    varchar(10)
    -- Các cột khác
);

insert into HoaDon values('HD02','KH03','NV01',1,GETDATE(),800000,N'Chờ Thanh toán',N'Khách hàng quên đem tiền','')
insert into HoaDon values('HD01','KH01','NV01',1,GETDATE(),800000,N'Đã Thanh Toán',N'Khách hàng quên đem tiền','')
insert into HoaDon values('HD03','KH01','NV01',1,GETDATE(),1347000,N'Chờ Thanh toán',N'Khách hàng quên đem tiền','')


CREATE   TABLE HoaDonChiTiet (
    MaHoaDon varchar(5),
	MaKH varchar(10), 
    MaNV varchar(10),  
    NgayTao DATE,  
    GhiChu nvarchar(200),  
    MaSanPham varchar(10),
    TenSanPham nvarchar(100),
    SoLuong INT,
    MauSac nvarchar(10),
    KichThuoc varchar(5),
    DonGia money,
    ThanhTien money,
    MaEvents varchar(10),  
	TongTien MONEY,  
	TongTienGiam MONEY,
	TongTienSauGiam MONEY, 
	TrangThai nvarchar(20),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)
);

CREATE  TABLE GioHang (
	STT int ,
    MaHoaDon varchar(5),
    MaSanPham varchar(10),
	TenSanPham nvarchar(100),
    SoLuong INT,
    MauSac nvarchar(10),
	KichThuoc varchar(5),
	DonGia money,
	ThanhTien money,
    PRIMARY KEY (MaHoaDon, MaSanPham),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)
);
insert into GioHang values 
(1,'HD03','SP02',N'Áo Khoác Gió Nam Nữ Krants Design Studio Jacket New Collection Blue',1,'Be','XL',800000,800000)
insert into GioHang values 
(2,'HD03','SP04',N'Áo Polo Local Brand Krants Signature Polo Shirt Premium',1,N'Đỏ','XL',547000,547000)
insert into GioHang values 
(1,'HD01','SP02',N'Áo Khoác Gió Nam Nữ Krants Design Studio Jacket New Collection Blue',1,'Be','XL',800000,800000)
insert into GioHang values 
(2,'HD01','SP04',N'Áo Polo Local Brand Krants Signature Polo Shirt Premium',1,N'Đỏ','XL',547000,547000)








-- Lấy dữ liệu test 
select hd.MaHoaDon,hd.ManV,hd.hinhthucthanhtoan, sum(gh.ThanhTien) as'Tổng tiền' from HoaDon hd inner join GioHang gh on gh.MaHoaDon= hd.MaHoaDon where hd.MaHoaDon='HD01'
group by hd.maHoaDon
insert into GioHang values 
select * from hoaDon 
select * from GioHang
select * from SanPham
select top 1 STT from GioHang where MaHoaDon='HD01' order by STT desc  
SELECT 
    HoaDon.MaHoaDon,
    HoaDon.MaKH,
    HoaDon.MaNV,
    HoaDon.NgayTao,
    HoaDon.TongTien,
    HoaDon.GhiChu,
    HoaDon.MaEvents,
    GioHang.STT,
    GioHang.MaSanPham,
    GioHang.TenSanPham,
    GioHang.SoLuong,
    GioHang.MauSac,
    GioHang.KichThuoc,
    GioHang.DonGia,
    GioHang.ThanhTien
FROM 
    HoaDon
JOIN 
    GioHang ON HoaDon.MaHoaDon = GioHang.MaHoaDon;
	select * from HoaDonChiTiet
select * from Events
select hd.MaHoaDon,hd.MaKH,hd.MaNV,GETDATE(),hd.GhiChu,MaSanPham,TenSanPham,SoLuong,MauSac,KichThuoc,DonGia,ThanhTien,hd.MaEvents,TongTien from HoaDon hd inner join GioHang gh on gh.MaHoaDon=hd.MaHoaDon
where hd.MaHoaDon='HD01'

-- insert 

	INSERT INTO HoaDonChiTiet (
    MaHoaDon, MaKH, MaNV, NgayTao, GhiChu, MaSanPham, TenSanPham, SoLuong, MauSac, KichThuoc,
    DonGia, ThanhTien, MaEvents, TongTien, TongTienGiam, TongTienSauGiam, TrangThai
)
SELECT 
    hd.MaHoaDon, hd.MaKH,hd.MaNV,GETDATE() AS NgayTao,hd.GhiChu,gh.MaSanPham, 
    gh.TenSanPham,gh.SoLuong,gh.MauSac, gh.KichThuoc, gh.DonGia,gh.ThanhTien,hd.MaEvents,hd.TongTien, 
    NULL AS TongTienGiam, 
    NULL AS TongTienSauGiam, 
    N'Đã Hủy' AS TrangThai 
FROM 
    HoaDon hd INNER JOIN  GioHang gh ON gh.MaHoaDon = hd.MaHoaDon
WHERE 
    hd.MaHoaDon = 'HD01';
	select * from HoaDonChiTiet
  delete from hoadon where MaHoaDon='HD04'