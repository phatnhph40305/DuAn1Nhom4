package model;

public class HoaDonChiTiet {
    
    private int idhoadon;
    private String masp;
    private String tensp;
    private int soluong;
    private String mausac;
    private String kichthuoc;
    private String thuonghieu;
    private String xuatxu;
    private double gia;
    private double thanhtien;
    private int idctsp;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idhoadon, String masp, String tensp, int soluong, String mausac, String kichthuoc, String thuonghieu, String xuatxu, double gia, double thanhtien,int idctsp) {
        this.idhoadon = idhoadon;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.mausac = mausac;
        this.kichthuoc = kichthuoc;
        this.thuonghieu = thuonghieu;
        this.xuatxu = xuatxu;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.idctsp = idctsp;
    }

    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(int idctsp) {
        this.idctsp = idctsp;
    }
    
    

}
