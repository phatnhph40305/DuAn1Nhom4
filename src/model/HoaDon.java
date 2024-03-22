package model;

public class HoaDon {

    private int id;
    private String tenkh;
    private String tennv;
    private int trangthai;
    private String ngaytao;

    public HoaDon(int id, String tenkh, String tennv, int trangthai, String ngaytao) {
        this.id = id;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.trangthai = trangthai;
        this.ngaytao = ngaytao;
    }

    public HoaDon() {
    }

    public String trangThai() {
        if (trangthai == 1) {
            return "Đã thanh toán";
        } else if (trangthai == 0) {
            return "Chưa thanh toán";

        } else {
            return "Đã hủy";     
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }
    
}
