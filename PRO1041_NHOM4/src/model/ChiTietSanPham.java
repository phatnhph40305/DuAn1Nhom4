package model;

public class ChiTietSanPham {

    private int id;
    private String maSP;
    private int soluong;
    private double dongia;
    private String mauSac;
    private String kichThuoc;
    private String thuongHieu;
    private String xuatXu;
    private int trangThai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String maSP) {
        this.maSP = maSP;
    }

    public ChiTietSanPham(int id, String maSP, int soluong, double dongia, String mauSac, String kichThuoc, String thuongHieu, String xuatXu, int trangThai) {
        this.id = id;
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
    }

    public ChiTietSanPham(String maSP, int soluong, double dongia, String mauSac, String kichThuoc, String thuongHieu, String xuatXu, int trangThai) {
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
    }

    public String trangthai() {
        if (trangThai == 1) {
            return "Hoạt động";
        } else {
            return " Không hoạt động";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
