/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DangNhap;


public class DangNhapServices {

    private List<DangNhap> listDangNhap;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;

    public List<DangNhap> getListSP() {
        listDangNhap = new ArrayList<>();
        sql = "select TenDangNhap,MatKhau,ChucVu from NguoiDung;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DangNhap dangNhap = new DangNhap(rs.getString(1), rs.getString(2), rs.getString(3));
                listDangNhap.add(dangNhap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDangNhap;
    }

    
    public int login_successful(String tenDn, String passW, List<DangNhap> list){
        boolean checkUserName = false;
        boolean checkPas=false;
        
      // check userName  
        for (DangNhap dangNhap : list) {
            if(dangNhap.getTenDN().equals(tenDn)){
                checkUserName = true;
                break;
            }
        }
        // kierm tra mat khau
        if(checkUserName){
            for (DangNhap dangNhap : list) {
                if(dangNhap.getTenDN().equals(tenDn)){
                    checkPas = dangNhap.getMatKhau().equals(passW);
                    break;
                }
            }
        }
        if(!checkUserName){
            return 0; // Tên đang nhập sai.
        }else if(!checkPas){
            return 1; // mật khẩu sai
        }else{
            return 2; // mật khẩu đúng.  
        }
        
        
        
        
       
    }
   
}
