/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author Acer
 */
public class SanPhamServices {

    public SanPhamServices() {
    }

    private List<SanPham> listSP;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;

    public List<SanPham> getListSP() {
        listSP = new ArrayList<>();
        sql = "select IdSanPham, Ma,ten,TrangThai,NgayTao,NgaySua from SanPham;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listSP.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public int insertSanPham(SanPham sanPham) {
        int check = -1;
        sql = "insert into SanPham(Ma,Ten,TrangThai) values(?,?,?);";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sanPham.getMaSP());
            ps.setString(2, sanPham.getTenSp());
            ps.setInt(3, sanPham.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return check = 0;
        }
        return check;
    }

    public int updateSP(int idSp, SanPham sp) {
        int check = -1;
        sql = " update SanPham set ma = ?,Ten =?,TrangThai = ? where IdSanPham =?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSp());
            ps.setInt(3, sp.getTrangThai());
            ps.setInt(4, idSp);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return check = 0;
        }
        return check;
    }

}
