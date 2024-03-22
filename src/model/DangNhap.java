/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author Acer
 */
public class DangNhap {

    private int idNguoiDung;
    private  String tenNguoiDung;
    private String maNV;
    private  String tenDN;
    private String matKhau;
    private   String chucVu;
    private int trangThaiNGuoiDung;
    private Date ngayTao;
    private Date ngaySua;

    public DangNhap() {
    }
    
    public DangNhap(String tenDN, String matKhau, String chucVu) {
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public DangNhap(int idNguoiDung, String tenNguoiDung, String maNV, String tenDN, String matKhau, String chucVu, int trangThaiNGuoiDung, Date ngayTao, Date ngaySua) {
        this.idNguoiDung = idNguoiDung;
        this.tenNguoiDung = tenNguoiDung;
        this.maNV = maNV;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.trangThaiNGuoiDung = trangThaiNGuoiDung;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public  String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThaiNGuoiDung() {
        return trangThaiNGuoiDung;
    }

    public void setTrangThaiNGuoiDung(int trangThaiNGuoiDung) {
        this.trangThaiNGuoiDung = trangThaiNGuoiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
//    public  boolean checkUser(){
//        if(this.getChucVu().equals("Quản lý")){
//            return true;
//        }else{
//            return false;
//        }
//    }
}
