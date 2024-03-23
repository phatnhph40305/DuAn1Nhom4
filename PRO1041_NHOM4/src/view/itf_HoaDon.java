package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.ThuocTinh;
import service.HoaDonService;

public class itf_HoaDon extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelhd0 = new DefaultTableModel();
    DefaultTableModel modelhd1 = new DefaultTableModel();
    DefaultTableModel modelhd2 = new DefaultTableModel();
    DefaultTableModel modelfind = new DefaultTableModel();

    DefaultTableModel modelhdct = new DefaultTableModel();

    HoaDonService hds = new HoaDonService();

    public itf_HoaDon() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        this.setSize(1300, 755);
        loadTableSanPham(hds.loadDataTableCTSP());
        loadTableHoaDon0(hds.loadTableHoaDon0());
        loadTableHoaDon1(hds.loadTableHoaDon1());
        loadTableHoaDon2(hds.loadTableHoaDon2());
    }

    private void loadTableHoaDon0(List<HoaDon> listhd) {
        modelhd0 = (DefaultTableModel) tblHoaDon0.getModel();
        modelhd0.setRowCount(0);
        for (HoaDon hoaDon : listhd) {
            modelhd0.addRow(new Object[]{hoaDon.getId(), hoaDon.getTenkh(), hoaDon.getTennv(), hoaDon.trangThai(), hoaDon.getNgaytao()});
        }
    }

    private void loadTableHoaDon1(List<HoaDon> listhd) {
        modelhd1 = (DefaultTableModel) tblHoaDon1.getModel();
        modelhd1.setRowCount(0);
        for (HoaDon hoaDon : listhd) {
            modelhd1.addRow(new Object[]{hoaDon.getId(), hoaDon.getTenkh(), hoaDon.getTennv(), hoaDon.trangThai(), hoaDon.getNgaytao()});
        }
    }

    private void loadTableHoaDon2(List<HoaDon> listhd) {
        modelhd2 = (DefaultTableModel) tblHoaDon2.getModel();
        modelhd2.setRowCount(0);
        for (HoaDon hoaDon : listhd) {
            modelhd2.addRow(new Object[]{hoaDon.getId(), hoaDon.getTenkh(), hoaDon.getTennv(), hoaDon.trangThai(), hoaDon.getNgaytao()});
        }
    }

    private void loadTableSanPham(List<ChiTietSanPham> listctsp) {
        model = (DefaultTableModel) BangSanPham.getModel();
        model.setRowCount(0);
        for (ChiTietSanPham chiTietSanPham : listctsp) {
            model.addRow(new Object[]{
                chiTietSanPham.getId(),
                chiTietSanPham.getMaSP(),
                chiTietSanPham.getTen(),
                chiTietSanPham.getSoluong(),
                chiTietSanPham.getMauSac(),
                chiTietSanPham.getKichThuoc(),
                chiTietSanPham.getThuongHieu(),
                chiTietSanPham.getXuatXu(),
                chiTietSanPham.getDongia()
            });
        }
    }

    private void fillTableHoaDonCT(List<HoaDonChiTiet> listhdct) {
        modelhdct = (DefaultTableModel) BangGioHang.getModel();
        modelhdct.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : listhdct) {
            modelhdct.addRow(new Object[]{hoaDonChiTiet.getIdhoadon(),
                hoaDonChiTiet.getMasp(),
                hoaDonChiTiet.getTensp(),
                hoaDonChiTiet.getSoluong(),
                hoaDonChiTiet.getMausac(),
                hoaDonChiTiet.getKichthuoc(),
                hoaDonChiTiet.getThuonghieu(),
                hoaDonChiTiet.getXuatxu(),
                hoaDonChiTiet.getGia(),
                hoaDonChiTiet.getThanhtien()});
        }
    }

    private void inserttoGioHang() {
        String soluong = JOptionPane.showInputDialog("nhập số lượng");
        int index = BangSanPham.getSelectedRow();
        int index1 = tblHoaDon0.getSelectedRow();
        if (soluong == null) {
            return;
        }
        if (soluong.equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập số lượng");
            return;
        }
        try {
            int soluong1 = Integer.valueOf(soluong);
            if (soluong1 < 0) {
                JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn không");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên dương");
            return;
        }
        if (Integer.valueOf(soluong) > Integer.valueOf(BangSanPham.getValueAt(index, 3).toString())) {
            JOptionPane.showMessageDialog(null, "Số lượng trong kho không đủ");
            return;
        }

        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());
        int idctsp = Integer.valueOf(BangSanPham.getValueAt(index, 0).toString());
        List<HoaDonChiTiet> list = hds.loadDataHoaDonChiTiet(idhoadon);

        hds.setSoluongSanPham(idctsp, Integer.valueOf(soluong));
        loadTableSanPham(hds.loadDataTableCTSP());

        for (HoaDonChiTiet hoaDonChiTiet : list) {
            if (hoaDonChiTiet.getIdctsp() == idctsp) {
                hds.setSoluongSanPhamHD(idctsp, Integer.valueOf(soluong));
                fillTableHoaDonCT(hds.loadDataHoaDonChiTiet(idhoadon));
                return;
            }
        }

        hds.insertHoaDonChiTiet(idctsp, idhoadon, Integer.valueOf(soluong), Double.valueOf(BangSanPham.getValueAt(index, 8).toString()));
        fillTableHoaDonCT(hds.loadDataHoaDonChiTiet(idhoadon));

    }

    private void setTongTien() {
        int index1 = tblHoaDon0.getSelectedRow();
        if (index1 < 0) {
            return;
        }
        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());

        List<HoaDonChiTiet> list1 = hds.loadDataHoaDonChiTiet(idhoadon);
        double tongtien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : list1) {
            tongtien += hoaDonChiTiet.getThanhtien();
        }
        txtTongtien.setText(String.valueOf(tongtien));

    }

    private void thanhToan() {
        if (txtMaKhachHang.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "không được để trống tên khách hàng");
            return;
        }
        if (txtMaNhanVuen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "không được để trống tên nhân viên");
            return;
        }

        List<ThuocTinh> list = hds.idKhachHang(txtMaKhachHang.getText());
        int idkh = 0;
        for (ThuocTinh thuocTinh : list) {
            idkh = thuocTinh.getId();
        }
        List<ThuocTinh> list1 = hds.idNguoiDung(txtMaNhanVuen.getText());
        int idnd = 0;
        for (ThuocTinh thuocTinh : list1) {
            idnd = thuocTinh.getId();
        }
        int index1 = tblHoaDon0.getSelectedRow();
        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());

        hds.thanhtoantHoaDon(idkh, idnd, idhoadon);
        loadTableHoaDon0(hds.loadTableHoaDon0());
        loadTableHoaDon1(hds.loadTableHoaDon1());
        
    }

    private void huyHoaDon() {
        int index1 = tblHoaDon0.getSelectedRow();
        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());

        List<HoaDonChiTiet> list = hds.loadDataHoaDonChiTiet(idhoadon);

        for (HoaDonChiTiet hoaDonChiTiet : list) {
            hds.setSoluongSanPham1(hoaDonChiTiet.getIdctsp(), hoaDonChiTiet.getSoluong());
        }
    }

    private void xoaSanpham() {
        int index1 = tblHoaDon0.getSelectedRow();
        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());

        List<HoaDonChiTiet> list = hds.loadDataHoaDonChiTiet(idhoadon);
        int index = BangGioHang.getSelectedRow();
        hds.setHDCT1(list.get(index).getIdctsp());
        hds.setSoluongSanPham1(list.get(index).getIdctsp(), list.get(index).getSoluong());
        fillTableHoaDonCT(hds.loadDataHoaDonChiTiet(idhoadon));
        loadTableSanPham(hds.loadDataTableCTSP());

    }

    private void Find(List<ChiTietSanPham> listctsp) {
        modelfind = (DefaultTableModel) BangSanPham.getModel();
        modelfind.setRowCount(0);
        for (ChiTietSanPham chiTietSanPham : listctsp) {
            modelfind.addRow(new Object[]{
                chiTietSanPham.getId(),
                chiTietSanPham.getMaSP(),
                chiTietSanPham.getTen(),
                chiTietSanPham.getSoluong(),
                chiTietSanPham.getMauSac(),
                chiTietSanPham.getKichThuoc(),
                chiTietSanPham.getThuongHieu(),
                chiTietSanPham.getXuatXu(),
                chiTietSanPham.getDongia()
            });
        }
    }

    private void clear() {
        txtMaKhachHang.setText("");
        txtMaNhanVuen.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtTongtien.setText("");
        cbohttt.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangGioHang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbohttt = new javax.swing.JComboBox<>();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TaoHoaDon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        txtMaNhanVuen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BangSanPham = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDon0 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHoaDon1 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblHoaDon2 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(940, 657));
        setPreferredSize(new java.awt.Dimension(940, 657));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        BangGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "Mã sản phẩm ", "Tên sản phẩm ", "Số lượng ", "Màu Sắc", "Kích Thước", "Thương Hiệu", "Xuất Xứ", "Đơn giá ", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(BangGioHang);

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setText("Xóa sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setText("Xóa tất cả ");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tạo hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        cbohttt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbohttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cbohttt.setMaximumSize(null);
        cbohttt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbohtttActionPerformed(evt);
            }
        });

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaKhachHang.setMaximumSize(null);
        txtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhachHangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Hình thức thanh toán");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền");

        txtTongtien.setEditable(false);
        txtTongtien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTongtien.setMaximumSize(null);
        txtTongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongtienActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiền khách đưa");

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKhachDua.setMaximumSize(null);
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tiền thừa");

        TaoHoaDon.setBackground(new java.awt.Color(51, 255, 51));
        TaoHoaDon.setText("Tạo hóa đơn");
        TaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoHoaDonActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 0, 0));
        btnHuy.setText("Hủy ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(255, 153, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán ");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtMaNhanVuen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNhanVuen.setMaximumSize(null);
        txtMaNhanVuen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVuenActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tên Nhân Viên");

        txtTienThua.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(txtMaNhanVuen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbohttt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(btnThanhToan)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(TaoHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addGap(58, 58, 58))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaNhanVuen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbohttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btnThanhToan)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaoHoaDon)
                    .addComponent(btnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        BangSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID CTSP", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Màu sắc", "Kích thước", "Thương hiệu", "Xuất xứ", "Đơn giá"
            }
        ));
        BangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(BangSanPham);

        jLabel7.setText("Tìm kiếm sản phẩm(Theo thương hiệu) :");

        txtFind.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFindCaretUpdate(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 255, 51));
        jButton5.setText("Thêm sản phẩm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        tblHoaDon0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "Tên KH", "Tên NV", "Trạng Thái", "Ngày Tạo"
            }
        ));
        tblHoaDon0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon0MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDon0);

        jTabbedPane1.addTab("Chưa thanh toán", jScrollPane6);

        tblHoaDon1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "Tên KH", "Tên NV", "Trạng Thái", "Ngày Tạo"
            }
        ));
        jScrollPane7.setViewportView(tblHoaDon1);

        jTabbedPane1.addTab("Đã Thanh Toán", jScrollPane7);

        tblHoaDon2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "Tên KH", "Tên NV", "Trạng Thái", "Ngày Tạo"
            }
        ));
        jScrollPane8.setViewportView(tblHoaDon2);

        jTabbedPane1.addTab("Đã Hủy", jScrollPane8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        huyHoaDon();
        int index1 = tblHoaDon0.getSelectedRow();
        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());
        hds.setHDCT(idhoadon);
        loadTableSanPham(hds.loadDataTableCTSP());
        modelhdct.setRowCount(0);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbohtttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbohtttActionPerformed
        // TODO add your handling code here:
        if (cbohttt.getSelectedIndex() == 1) {
            txtTienKhachDua.setText(txtTongtien.getText());
        }
    }//GEN-LAST:event_cbohtttActionPerformed

    private void txtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhachHangActionPerformed

    private void txtTongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongtienActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed

    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void TaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoHoaDonActionPerformed
        hds.insertHoaDon0();
        loadTableHoaDon0(hds.loadTableHoaDon0());
    }//GEN-LAST:event_TaoHoaDonActionPerformed

    private void txtMaNhanVuenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVuenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVuenActionPerformed


    private void BangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangSanPhamMouseClicked

    }//GEN-LAST:event_BangSanPhamMouseClicked

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int index = tblHoaDon0.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn Hóa Đơn");
        } else {

            int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index, 0).toString());
            huyHoaDon();
            hds.setTrangthaiHuyHD(idhoadon);
            loadTableHoaDon0(hds.loadTableHoaDon0());
            loadTableSanPham(hds.loadDataTableCTSP());
            loadTableHoaDon2(hds.loadTableHoaDon2());
            modelhdct.setRowCount(0);
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int index = tblHoaDon0.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn Hóa Đơn");

        } else {
            thanhToan();
            clear();
            modelhdct.setRowCount(0);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int index = tblHoaDon0.getSelectedRow();
        int index1 = BangSanPham.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn Hóa Đơn");
        } else if (index1 < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm");
        } else {
            inserttoGioHang();
            setTongTien();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        if (txtTienKhachDua.getText().equals("")) {
            return;
        }
        String tongtien1 = txtTongtien.getText();
        String tienkhachdua = txtTienKhachDua.getText();
        double tienthua = Float.valueOf(tienkhachdua) - Float.valueOf(tongtien1);
        txtTienThua.setText(String.valueOf(tienthua));
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void tblHoaDon0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon0MouseClicked
        int index1 = tblHoaDon0.getSelectedRow();
        int idhoadon = Integer.valueOf(tblHoaDon0.getValueAt(index1, 0).toString());
        fillTableHoaDonCT(hds.loadDataHoaDonChiTiet(idhoadon));

        List<HoaDonChiTiet> list = hds.loadDataHoaDonChiTiet(idhoadon);
        double tongtien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : list) {
            tongtien += hoaDonChiTiet.getThanhtien();
        }
        txtTongtien.setText(String.valueOf(tongtien));

    }//GEN-LAST:event_tblHoaDon0MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index1 = BangGioHang.getSelectedRow();

        if (index1 < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm");
        } else {
            xoaSanpham();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFindCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFindCaretUpdate
        Find(hds.findDataTableCTSP(txtFind.getText()));
    }//GEN-LAST:event_txtFindCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangGioHang;
    private javax.swing.JTable BangSanPham;
    private javax.swing.JButton TaoHoaDon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cbohttt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblHoaDon0;
    private javax.swing.JTable tblHoaDon1;
    private javax.swing.JTable tblHoaDon2;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNhanVuen;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
