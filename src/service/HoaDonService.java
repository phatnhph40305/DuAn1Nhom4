package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import model.HoaDon;

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
    public void insertHoaDon(){
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

    public void setSoluongSanPham(int id, int soluong) {
        try {
            String sql = "update ChiTietSanPham set SoLuong = SoLuong - ? where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, soluong);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
