package service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.ChiTietSanPham;

public class ChiTietSanPhamService {

    public List loadDataTableCTSP() {
        List<ChiTietSanPham> litsctsp = new ArrayList<>();
        try {
            String sql = "select ChiTietSanPham.IdCTSP,SanPham.Ma,ChiTietSanPham.SoLuong,ChiTietSanPham.DonGia,MauSac.Ten,KichThuoc.Ten,ThuongHieu.TenThuongHieu,XuatXu.Ten,ChiTietSanPham.TrangThai\n"
                    + "from ChiTietSanPham join SanPham on ChiTietSanPham.IdSanPham = SanPham.IdSanPham \n"
                    + "join XuatXu on XuatXu.IdXuatXu = ChiTietSanPham.IdXuatXu join ThuongHieu on ThuongHieu.IdThuongHieu = ChiTietSanPham.IdThuongHieu \n"
                    + "join KichThuoc on KichThuoc.IdKichThuoc = ChiTietSanPham.IdKichThuoc join MauSac on MauSac.IdMauSac = ChiTietSanPham.IdMauSac";
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
    public List loadCboMaSP(){
    List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select Ma from SanPham";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString(1));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List loadCboThuongHieu(){
    List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select TenThuongHieu from ThuongHieu";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString(1));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List loadCboMauSac(){
    List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select Ten from MauSac";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString(1));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List loadCboXuatxu(){
    List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select ten from XuatXu";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString(1));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List loadCboKichThuoc(){
    List<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "select Ten from KichThuoc";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiTietSanPham ctsp = new ChiTietSanPham(rs.getString(1));
                list.add(ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
