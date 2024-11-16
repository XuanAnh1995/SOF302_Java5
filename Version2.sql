CREATE DATABASE assignment_Java5_Version2
GO

USE [assignment_Java5_Version2]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idKhachHang] [int] NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[ngayMuaHang] [date] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idSPCT] [int] NOT NULL,
	[idHoaDon] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[sdt] [varchar](50) NOT NULL,
	[maKH] [varchar](50) NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](50) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_KichThuoc] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](50) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_MauSac] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[maNV] [varchar](50) NOT NULL,
	[tenDangNhap] [varchar](50) NOT NULL,
	[matKhau] [varchar](50) NOT NULL,
	[trangThai] [int] NOT NULL,
	--[chucVu] [int] NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 7/16/2024 3:15:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPhamChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maSPCT] [varchar](50) NOT NULL,
	[idMauSac] [int] NOT NULL,
	[idKichThuoc] [int] NOT NULL,
	[idSanPham] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_SanPhamChiTiet] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([id])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet] FOREIGN KEY([idSPCT])
REFERENCES [dbo].[SanPhamChiTiet] ([id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_KichThuoc] FOREIGN KEY([idKichThuoc])
REFERENCES [dbo].[KichThuoc] ([id])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_KichThuoc]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_MauSac] FOREIGN KEY([idMauSac])
REFERENCES [dbo].[MauSac] ([id])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_MauSac]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_SanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([id])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_SanPham]
GO

-- 1. Thêm tính năng ON DELETE CASCADE cho bảng HoaDonChiTiet

ALTER TABLE [dbo].[HoaDonChiTiet] DROP CONSTRAINT [FK_HoaDonChiTiet_HoaDon];
ALTER TABLE [dbo].[HoaDonChiTiet] ADD CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([id]) ON DELETE CASCADE;

ALTER TABLE [dbo].[HoaDonChiTiet] DROP CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet];
ALTER TABLE [dbo].[HoaDonChiTiet] ADD CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet] FOREIGN KEY([idSPCT])
REFERENCES [dbo].[SanPhamChiTiet] ([id]) ON DELETE CASCADE;

-- 2. Thêm tính năng ON DELETE CASCADE cho bảng HoaDon

ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_KhachHang];
ALTER TABLE [dbo].[HoaDon] ADD CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([id]) ON DELETE CASCADE;

ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_NhanVien];
ALTER TABLE [dbo].[HoaDon] ADD CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([id]) ON DELETE CASCADE;

-- 3. Thêm tính năng ON DELETE CASCADE cho bảng SanPhamChiTiet
ALTER TABLE [dbo].[SanPhamChiTiet] DROP CONSTRAINT [FK_SanPhamChiTiet_KichThuoc];
ALTER TABLE [dbo].[SanPhamChiTiet] ADD CONSTRAINT [FK_SanPhamChiTiet_KichThuoc] FOREIGN KEY([idKichThuoc])
REFERENCES [dbo].[KichThuoc] ([id]) ON DELETE CASCADE;

ALTER TABLE [dbo].[SanPhamChiTiet] DROP CONSTRAINT [FK_SanPhamChiTiet_MauSac];
ALTER TABLE [dbo].[SanPhamChiTiet] ADD CONSTRAINT [FK_SanPhamChiTiet_MauSac] FOREIGN KEY([idMauSac])
REFERENCES [dbo].[MauSac] ([id]) ON DELETE CASCADE;

ALTER TABLE [dbo].[SanPhamChiTiet] DROP CONSTRAINT [FK_SanPhamChiTiet_SanPham];
ALTER TABLE [dbo].[SanPhamChiTiet] ADD CONSTRAINT [FK_SanPhamChiTiet_SanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([id]) ON DELETE CASCADE;

INSERT INTO KhachHang (ten, sdt, maKH, trangThai) 
VALUES 
('Nguyen Van A', '0901234567', 'KH01', 1),
('Tran Thi B', '0901234568', 'KH02', 0),
('Le Van C', '0901234569', 'KH03', 1),
('Nguyen Thi D', '0901234570', 'KH04', 1),
('Pham Van E', '0901234571', 'KH05', 0),
('Do Thi F', '0901234572', 'KH06', 1),
('Hoang Van G', '0901234573', 'KH07', 1),
('Ngo Thi H', '0901234574', 'KH08', 0),
('Vu Van I', '0901234575', 'KH09', 1),
('Dao Thi J', '0901234576', 'KH10', 1);

INSERT INTO NhanVien (ten, maNV, tenDangNhap, matKhau, trangThai) 
VALUES 
('Nguyen Van A', 'NV01', 'nva', 'pass123', 1),
('Tran Thi B', 'NV02', 'ttb', 'pass123', 1),
('Le Van C', 'NV03', 'lvc', 'pass123', 0),
('Nguyen Thi D', 'NV04', 'ntd', 'pass123', 1),
('Pham Van E', 'NV05', 'pve', 'pass123', 0),
('Do Thi F', 'NV06', 'dtf', 'pass123', 1),
('Hoang Van G', 'NV07', 'hvg', 'pass123', 1),
('Ngo Thi H', 'NV08', 'nth', 'pass123', 0),
('Vu Van I', 'NV09', 'vvi', 'pass123', 1),
('Dao Thi J', 'NV10', 'dtj', 'pass123', 1);


INSERT INTO SanPham (ma, ten, trangThai) 
VALUES 
('SP01', 'Nike Air Zoom', 1),
('SP02', 'Adidas Ultraboost', 1),
('SP03', 'Puma Suede Classic', 0),
('SP04', 'New Balance 574', 1),
('SP05', 'Asics Gel-Lyte', 0),
('SP06', 'Converse Chuck Taylor', 1),
('SP07', 'Vans Old Skool', 1),
('SP08', 'Reebok Classic Leather', 1),
('SP09', 'Fila Disruptor II', 0),
('SP10', 'Under Armour Curry', 1);


INSERT INTO MauSac (ma, ten, trangThai) 
VALUES 
('MS01', 'Bright Red', 1),
('MS02', 'Ocean Blue', 1),
('MS03', 'Forest Green', 0),
('MS04', 'Sunny Yellow', 1),
('MS05', 'Midnight Black', 1),
('MS06', 'Snow White', 0),
('MS07', 'Burnt Orange', 1),
('MS08', 'Royal Purple', 1),
('MS09', 'Rose Pink', 1),
('MS10', 'Chocolate Brown', 0);


INSERT INTO KichThuoc (ma, ten, trangThai) 
VALUES 
('KT01', 'Size 38', 0),
('KT02', 'Size 39', 1),
('KT03', 'Size 40', 1),
('KT04', 'Size 41', 1),
('KT05', 'Size 42', 0),
('KT06', 'Size 43', 1),
('KT07', 'Size 44', 1),
('KT08', 'Size 45', 0),
('KT09', 'Size 46', 1),
('KT10', 'Size 47', 1);


INSERT INTO SanPhamChiTiet (maSPCT, idMauSac, idKichThuoc, idSanPham, soLuong, donGia, trangThai) 
VALUES 
('SPCT01', 1, 1, 1, 100, 200000, 0),
('SPCT02', 2, 2, 2, 150, 220000, 1),
('SPCT03', 3, 3, 3, 120, 250000, 1),
('SPCT04', 4, 4, 4, 130, 230000, 1),
('SPCT05', 5, 5, 5, 140, 240000, 0),
('SPCT06', 6, 6, 6, 160, 260000, 1),
('SPCT07', 7, 7, 7, 170, 270000, 1),
('SPCT08', 8, 8, 8, 180, 280000, 1),
('SPCT09', 9, 9, 9, 190, 290000, 0),
('SPCT10', 10, 10, 10, 200, 300000, 1);


-- Thêm dữ liệu vào bảng HoaDon với 8 bản ghi
INSERT INTO HoaDon (idKhachHang, idNhanVien, ngayMuaHang, trangThai) 
VALUES 
(1, 1, '2024-10-01', 1),
(2, 2, '2024-10-02', 1),
(3, 3, '2024-10-03', 0),
(4, 4, '2024-10-04', 1),
(5, 5, '2024-10-05', 0),
(6, 6, '2024-10-06', 1),
(7, 7, '2024-10-07', 1),
(8, 8, '2024-10-08', 0);

-- Thêm dữ liệu vào bảng HoaDonChiTiet với 20 bản ghi
INSERT INTO HoaDonChiTiet (idSPCT, idHoaDon, soLuong, donGia, trangThai) 
VALUES 
(1, 1, 1, 200000, 1),
(2, 1, 2, 220000, 1),
(3, 1, 1, 250000, 1),
(4, 2, 1, 230000, 0),
(5, 2, 2, 240000, 0),
(6, 3, 1, 260000, 1),
(7, 3, 2, 270000, 1),
(8, 4, 1, 280000, 0),
(9, 4, 2, 290000, 0),
(10, 5, 1, 300000, 1),
(1, 5, 3, 200000, 1),
(2, 6, 1, 220000, 0),
(3, 7, 1, 250000, 1),
(4, 8, 1, 230000, 1),
(5, 8, 2, 240000, 1),
(6, 7, 1, 260000, 1),
(7, 6, 2, 270000, 0),
(8, 5, 3, 280000, 1),
(9, 4, 1, 290000, 0),
(10, 3, 1, 300000, 1);


SELECT * FROM MauSac
SELECT * FROM KichThuoc
SELECT * FROM SanPham
SELECT * FROM KhachHang
SELECT * FROM HoaDon
SELECT * FROM NhanVien
SELECT * FROM SanPhamChiTiet
SELECT * FROM HoaDonChiTiet

--SELECT * FROM MauSac WHERE ma LIKE %:ma%

--SELECT * FROM NhanVien WHERE maNV LIKE %:maNV%

--SELECT * FROM KichThuoc WHERE ma LIKE %:ma%

--SELECT * FROM KhachHang WHERE maKH LIKE %:maKH%

--SELECT * FROM SanPham WHERE ma LIKE %:ma%

--SELECT * FROM SanPhamChiTiet WHERE maSPCT LIKE %:maSPCT%

--SELECT * FROM HoaDonChiTiet WHERE idHoaDon = 


