/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class ThuocTinh {
    private int id;
    private String ten;
    private int trangThai;

    public ThuocTinh(int id, String ten, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public ThuocTinh() {
    }

    public ThuocTinh(String ten, int trangThai) {
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public String trangthai() {
        if (trangThai == 1) {
            return "Hoạt động";
        } else {
            return " Không hoạt động";
        }
    }
}
