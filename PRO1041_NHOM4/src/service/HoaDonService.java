package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.ThuocTinh;

public class HoaDonService {

    public List loadTableHoaDon0() {
        List<HoaDon> litshd = new ArrayList<>();
        try {
            String sql = "select IdHoaDon,TrangThai,NgayTao from HoaDon where TrangThai = 0";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), "", "", rs.getInt(2), rs.getString(3));
                litshd.add(hd);
            }
            return litshd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadTableHoaDon1() {
        List<HoaDon> litshd = new ArrayList<>();
        try {
            String sql = "select HoaDon.IdHoaDon,KhachHang.Ten,NguoiDung.Ten,HoaDon.TrangThai,HoaDon.NgayTao from HoaDon join KhachHang on HoaDon.IdKhachHang = KhachHang.IdKhachHang join NguoiDung on HoaDon.IdNguoiDung = NguoiDung.IdNguoiDung\n"
                    + "		where HoaDon.TrangThai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                litshd.add(hd);
            }
            return litshd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadTableHoaDon2() {
        List<HoaDon> litshd = new ArrayList<>();
        try {
            String sql = "select IdHoaDon,TrangThai,NgayTao from HoaDon where TrangThai = 2";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), "", "", rs.getInt(2), rs.getString(3));
                litshd.add(hd);
            }
            return litshd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertHoaDon0() {
        try {
            String sql = "insert into HoaDon(TrangThai) values (0); ";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List loadDataTableCTSP() {
        List<ChiTietSanPham> litsctsp = new ArrayList<>();
        try {
            String sql = " select ChiTietSanPham.IdCTSP,SanPham.Ma,SanPham.Ten,ChiTietSanPham.SoLuong,MauSac.Ten,KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,ChiTietSanPham.DonGia\n"
                    + "                    from ChiTietSanPham join SanPham on ChiTietSanPham.IdSanPham = SanPham.IdSanPham \n"
                    + "                    join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu join ThuongHieu on ThuongHieu.IdThuongHieu = ChiTietSanPham.IdThuongHieu\n"
                    + "                    join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac where ChiTietSanPham.TrangThai = 1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDouble(9));
                litsctsp.add(ctsp);
            }
            return litsctsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public List findDataTableCTSP(String th) {
        List<ChiTietSanPham> litsctsp = new ArrayList<>();
        try {
            String sql = " select ChiTietSanPham.IdCTSP,SanPham.Ma,SanPham.Ten,ChiTietSanPham.SoLuong,MauSac.Ten,KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,ChiTietSanPham.DonGia\n" +
"                                       from ChiTietSanPham join SanPham on ChiTietSanPham.IdSanPham = SanPham.IdSanPham\n" +
"                                       join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu join ThuongHieu on ThuongHieu.IdThuongHieu = ChiTietSanPham.IdThuongHieu\n" +
"                                      join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac where ChiTietSanPham.TrangThai = 1 and ThuongHieu.TenThuongHieu like ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, th+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDouble(9));
                litsctsp.add(ctsp);
            }
            return litsctsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setSoluongSanPham(int id, int soluong) {
        try {
            String sql = "update ChiTietSanPham set SoLuong = SoLuong - ? where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setSoluongSanPham1(int id, int soluong) {
        try {
            String sql = "update ChiTietSanPham set SoLuong = SoLuong + ? where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setSoluongSanPhamHD(int id, int soluong) {
        try {
            String sql = "update HoaDonChiTiet set SoLuong = SoLuong + ? where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertHoaDonChiTiet(int idctsp, int idhoadon, int soluong, double dongia) {
        try {
            String sql = "insert into HoaDonChiTiet(IdCTSP,IDHoaDon,SoLuong,DonGia) values(?,?,?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idctsp);
            ps.setInt(2, idhoadon);
            ps.setInt(3, soluong);
            ps.setDouble(4, dongia);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List loadDataHoaDonChiTiet(int idhoadon) {
        List<HoaDonChiTiet> listhdct = new ArrayList<>();
        try {
            String sql = "select HoaDon.IdHoaDon,SanPham.Ma,SanPham.Ten,HoaDonChiTiet.SoLuong,MauSac.Ten,\n"
                    + "KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,HoaDonChiTiet.DonGia,\n"
                    + "HoaDonChiTiet.SoLuong*HoaDonChiTiet.DonGia as 'Thành tiền',HoaDonChiTiet.IdCTSP\n"
                    + "from HoaDonChiTiet join HoaDon on HoaDonChiTiet.IDHoaDon = HoaDon.IdHoaDon\n"
                    + "join ChiTietSanPham on HoaDonChiTiet.IdCTSP = ChiTietSanPham.IdCTSP \n"
                    + "join SanPham on SanPham.IdSanPham = ChiTietSanPham.IdSanPham\n"
                    + "join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac\n"
                    + "join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc\n"
                    + "join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu\n"
                    + "join ThuongHieu on ChiTietSanPham.IdThuongHieu = ThuongHieu.IdThuongHieu\n"
                    + "where HoaDonChiTiet.IDHoaDon = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idhoadon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getInt(11));
                listhdct.add(hdct);
            }
            return listhdct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void thanhtoantHoaDon(int idkh, int idnv, int idhd) {
        try {
            String sql = "update HoaDon \n"
                    + "set IdKhachHang = ?,IdNguoiDung = ?,NgayMuaHang = GETDATE(),TrangThai = 1 where IdHoaDon = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idkh);
            ps.setInt(2, idnv);
            ps.setInt(3, idhd);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List idKhachHang(String ten) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdKhachHang from KhachHang where Ten = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List idNguoiDung(String ten) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select IdNguoiDung from NguoiDung  where Ten = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh tt = new ThuocTinh(rs.getInt(1), "", 0);
                list.add(tt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTrangthaiHuyHD(int id) {
        try {
            String sql = "update HoaDon set TrangThai = 2 where IdHoaDon = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setHDCT(int id){
        try {
            String sql = "update HoaDonChiTiet set IdCTSP = null,SoLuong = null,DonGia = null where IDHoaDon = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
      public void setHDCT1(int id){
        try {
            String sql = "update HoaDonChiTiet set IdCTSP = null,SoLuong = null,DonGia = null where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
