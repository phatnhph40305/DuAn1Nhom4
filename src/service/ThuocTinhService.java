package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ThuocTinh;

public class ThuocTinhService {

    public List loadDataKichThuoc() {
        List<ThuocTinh> listKichThuoc = new ArrayList<>();
        try {
            String sql = "select IdKichThuoc,Ten,TrangThai from KichThuoc";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh kt = new ThuocTinh(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listKichThuoc.add(kt);
            }
            return listKichThuoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadDataMauSac() {
        List<ThuocTinh> listmausac = new ArrayList<>();
        try {
            String sql = "select IdMauSac,Ten,TrangThai from MauSac";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh ms = new ThuocTinh(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listmausac.add(ms);
            }
            return listmausac;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadDataThuongHieu() {
        List<ThuocTinh> listth = new ArrayList<>();
        try {
            String sql = "select IdThuongHieu,TenThuongHieu,TrangThai from ThuongHieu";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh th = new ThuocTinh(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listth.add(th);
            }
            return listth;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List loadDataXuatXu() {
        List<ThuocTinh> listXuatXu = new ArrayList<>();
        try {
            String sql = "select IdXuatXu,Ten,TrangThai from XuatXu";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuocTinh xx = new ThuocTinh(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listXuatXu.add(xx);
            }
            return listXuatXu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertMauSac(String ten, int trangthai) {
        try {
            String sql = "insert into MauSac(Ten,TrangThai) values(?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }

    }

    public void insertKichThuoc(String ten, int trangthai) {
        try {
            String sql = "insert into KichTHuoh(Ten,TrangThai) values(?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }

    }

    public void insertXuatXu(String ten, int trangthai) {
        try {
            String sql = "insert into XuatXu(Ten,TrangThai) values(?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }

    }

    public void insertThuongHieu(String ten, int trangthai) {
        try {
            String sql = "insert into ThuongHieu(TenThuongHieu,TrangThai) values(?,?);";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }

    public void deleteMauSac(int id) {
        try {
            String sql = "update MauSac set TrangThai = 0\n"
                    + "where IdMauSac = ?";
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

    public void deleteKichThuoc(int id) {
        try {
            String sql = "update KichThuoc set TrangThai = 0\n"
                    + "where IdKichThuoc = ?";
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

    public void deleteThuongHieu(int id) {
        try {
            String sql = "update THuongHieu set TrangThai = 0\n"
                    + "where IdThuongHieu= ?";
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

    public void deleteXuatXu(int id) {
        try {
            String sql = "update XuatXu set TrangThai = 0\n"
                    + "where IdXuatXu = ?";
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

    public void updateXuatXu(String ten,int id, int trangthai) {
        try {
            String sql = "update XuatXu set Ten =?, TrangThai = ?,NgaySua= getdate()\n"
                    + "where IdXuatXu = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.setInt(3, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sửa thất bại");
        }
    }

    public void updateMauSac(String ten,int id, int trangthai) {
        try {
            String sql = "update MauSac set Ten =?, TrangThai = ?,NgaySua= getdate()\n"
                    + "where IdMauSac = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.setInt(3, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sửa thất bại");
        }
    }

    public void updateThuongHieu(String ten,int id, int trangthai) {
        try {
            String sql = "update ThuongHieu set TenThuongHieu=?,TrangThai = ?,NgaySua= getdate()\n"
                    + "where IdThuongHieu = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.setInt(3, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sửa thất bại");
        }
    }

    public void updateKichThuoc(String ten,int id, int trangthai) {
        try {
            String sql = "update KichThuoc set Ten =?, TrangThai = ?,NgaySua= getdate()\n"
                    + "where IdKichThuoc = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, trangthai);
            ps.setInt(3, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "sửa thất bại");
        }
    }
}
