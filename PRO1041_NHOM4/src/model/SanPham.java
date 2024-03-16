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
public class SanPham {
    private int idSP;
    private String maSP;
    private String tenSp;
    private int trangThai;
    private Date ngayTaoSp;
    private Date ngaySuaSP;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSp, int trangThai) {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.trangThai = trangThai;
    }

    public SanPham(String maSP, String tenSp, int trangThai, Date ngayTaoSp, Date ngaySuaSP) {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.trangThai = trangThai;
        this.ngayTaoSp = ngayTaoSp;
        this.ngaySuaSP = ngaySuaSP;
    }

    public SanPham(int idSP, String maSP, String tenSp, int trangThai, Date ngayTaoSp, Date ngaySuaSP) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.trangThai = trangThai;
        this.ngayTaoSp = ngayTaoSp;
        this.ngaySuaSP = ngaySuaSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTaoSp() {
        return ngayTaoSp;
    }

    public void setNgayTaoSp(Date ngayTaoSp) {
        this.ngayTaoSp = ngayTaoSp;
    }

    public Date getNgaySuaSP() {
        return ngaySuaSP;
    }

    public void setNgaySuaSP(Date ngaySuaSP) {
        this.ngaySuaSP = ngaySuaSP;
    }
    
    public Object[] getAllSp(){
        return new Object[]{
            this.getMaSP(),this.getTenSp(),this.getTrangThai(),this.ngayTaoSp,this.getNgaySuaSP()
        };
    };
}
