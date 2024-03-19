package service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ChiTietSanPham;

public class ChiTietSanPhamService {

    public List loadDataTableCTSP() {
        List<ChiTietSanPham> litsctsp = new ArrayList<>();
        try {
            String sql = "select ChiTietSanPham.IdCTSP,SanPham.Ma,ChiTietSanPham.SoLuong,ChiTietSanPham.DonGia,MauSac.Ten,KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,ChiTietSanPham.TrangThai\n"
                    + "from ChiTietSanPham join SanPham on ChiTietSanPham.IdSanPham = SanPham.IdSanPham \n"
                    + "join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu join ThuongHieu on ThuongHieu.IdThuongHieu = ChiTietSanPham.IdThuongHieu \n"
                    + "join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac where trangthai =1";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));
                litsctsp.add(ctsp);
            }
            return litsctsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List loadCboMaSP() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdSanPham,Ma from SanPham";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboThuongHieu() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdThuongHieu,TenThuongHieu from ThuongHieu";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboMauSac() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdMauSac,Ten from MauSac";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboXuatxu() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdXuatXu,ten from XuatXu";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadCboKichThuoc() {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select IdKichThuoc,Ten from KichThuoc";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getInt(1), rs.getString(2));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertChiTietSP(int soluong, double dongia, int mausac, int kichthuoc, int thuonghieu, int xuatxu, int trangthai, int sanpham) {
        try {
            String sql = "insert into ChiTietSanPham(SoLuong,DonGia,IdMauSac,IdKichThuoc,IdThuongHieu,IdXuatXu,TrangThai,IdSanPham) values(?,?,?,?,?,?,?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, soluong);
            ps.setDouble(2, dongia);
            ps.setInt(3, mausac);
            ps.setInt(4, kichthuoc);
            ps.setInt(5, thuonghieu);
            ps.setInt(6, xuatxu);
            ps.setInt(7, trangthai);
            ps.setInt(8, sanpham);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }

    }

    public void deleteChiTietSP(int id) {
        try {
            String sql = "update ChiTietSanPham set TrangThai = 0\n"
                    + "where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }

    public void updateChiTietSP(int idctsp, int idsp, int soluong, double dongia, int idmausac, int idkichthuoc, int idthuonghieu, int idxuatxu, int trangthai) {
        try {
            String sql = "update ChiTietSanPham set IdSanPham = ?,SoLuong = ?,DonGia=?,IdMauSac=?,IdKichThuoc=?,IdThuongHieu=?,IdXuatXu=?,TrangThai=?,NgaySua= getdate()\n"
                    + "where IdCTSP = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idsp);
            ps.setInt(2, soluong);
            ps.setDouble(3, dongia);
            ps.setInt(4, idmausac);
            ps.setInt(5, idkichthuoc);
            ps.setInt(6, idthuonghieu);
            ps.setInt(7, idxuatxu);
            ps.setInt(8, trangthai);
            ps.setInt(9, idctsp);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sửa thất bại");
        }
    }
}
