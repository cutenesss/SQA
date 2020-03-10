/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Controller.SendMailBySite;
import DAO.CauHinhDAO;
import DAO.HoaDonDAO;
import static Frame.SendEmailGD.PASS;
import static Frame.SendEmailGD.SUB;
import static Frame.SendEmailGD.USER;
import static Frame.SendEmailGD.listHoGD;
import Object.CauHinh;
import Object.HoGiaDinh;
import Object.HoaDon;
import Object.SoNuoc;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cuteness
 */
public class chitietHoadonGD extends javax.swing.JFrame {

    /**
     * Creates new form DetailHoGD
     */
    public static int index = -1;
    DefaultTableModel dtm;
    public static ArrayList<HoaDon> listHoaDon;
    public static CauHinh cauHinh;
    public static HoaDon hoadon;
    public static HoGiaDinh hgd;
    public static double Tieumuc1 = 0;
    public static double Tieumuc2 = 0;
    public static double Tieumuc3 = 0;
    public static double Tieumuc4 = 0;

    public chitietHoadonGD() {
        initComponents();
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jTable1.getModel();
        index = SendEmailGD.index;
        if (index > -1) {
            hgd = SendEmailGD.listHoGD.get(index);
        }
        edt_tenchuho.setText(hgd.getTenChuHo());
        edt_diachi.setText(hgd.getDiaChi());
        edt_maho.setText(hgd.getMaHoGD());
        edt_sdt.setText(hgd.getSdt());
        edt_email.setText(hgd.getEmail());
        // luu het cac file lai di
        HoaDonDAO st = new HoaDonDAO();
        listHoaDon = st.getListHoaDon();
         System.out.println("size1 = "+listHoaDon.size());
        CauHinhDAO st2 = new CauHinhDAO();
        //
        hoadon = new HoaDon();
        ArrayList<HoaDon> listHoaDon_rieng = new ArrayList<HoaDon>();
//        HoGiaDinh hoGiaDinh = new HoGiaDinh();
//        HoaDon hoadon = new HoaDon();
        for (HoaDon hd : listHoaDon) {
            if (hd.getHoGD().equals(hgd)) {
                listHoaDon_rieng.add(hd);
               
            }
        }
         System.out.println("size2 = "+listHoaDon_rieng.size());
       if(!listHoaDon_rieng.isEmpty()) hoadon = listHoaDon_rieng.get(listHoaDon_rieng.size() - 1);
       /*
        if (hoadon != null) {
            SoNuoc soNuoc = hoadon.getSoNuoc();
            CauHinh cauHinh = hoadon.getCauHinh();
            Date nbd = soNuoc.getNgayBD();
            Date nkt = soNuoc.getNgayKT();
            Double chisoBD = soNuoc.getChiSoBD();
            Double chisoKT = soNuoc.getChiSoKT();
            // so tien tung muc
            Double muc1 = cauHinh.getMuc1();
            Double muc2 = cauHinh.getMuc2();
            Double muc3 = cauHinh.getMuc3();
            Double muc4 = cauHinh.getMuc4();
            // thong so cac muc
            double chiso1 = cauHinh.getChiSoMuc1();
            double chiso2 = cauHinh.getChiSoMuc2();
            double chiso3 = cauHinh.getChiSoMuc3();
            //
            Date nTT = hoadon.getNgayThanhLap();
            double tongNuoc = chisoKT - chisoBD;
            //tach so nuoc
            TachSoNuoc(cauHinh, tongNuoc);
            double tien = tinh(cauHinh, tongNuoc);
            // set vao cac cot
            dtm.addRow(new Object[]{nbd, nkt, chisoBD, chisoKT, nTT, tongNuoc,Tieumuc1,muc1,Tieumuc1*muc1,null});
            if(Tieumuc2>0)  dtm.addRow(new Object[]{null,null,null,null,null,null,Tieumuc2,muc2,Tieumuc2*muc2,null});
             if(Tieumuc3>0)  dtm.addRow(new Object[]{null,null,null,null,null,null,Tieumuc3,muc3,Tieumuc3*muc3,null});
              if(Tieumuc4>0)  dtm.addRow(new Object[]{null,null,null,null,null,null,Tieumuc4,muc4,Tieumuc4*muc4,null});
              dtm.addRow(new Object[]{null,null,null,null,null,null,null,null,null,Tieumuc1*muc1+Tieumuc2*muc2+Tieumuc3*muc3+Tieumuc4*muc4});
        }
       */
    }

    //Tach so nuoc

    public static void TachSoNuoc(CauHinh c, double a) {
        if (a <= c.getChiSoMuc1()) {
            Tieumuc1 = a;
        } else if (a <= c.getChiSoMuc2()) {
            Tieumuc1 = c.getChiSoMuc1();
            Tieumuc2 = c.getChiSoMuc2() - a;
        } else if (a <= c.getChiSoMuc3()) {
            Tieumuc1 = c.getChiSoMuc1();
            Tieumuc2 = c.getChiSoMuc2();
            Tieumuc3 = c.getChiSoMuc3() - a;
        } else {
            Tieumuc1 = c.getChiSoMuc1();
            Tieumuc2 = c.getChiSoMuc2();
            Tieumuc3 = c.getChiSoMuc3();
            Tieumuc4 = a - c.getChiSoMuc3();
        }
    }

    // tính tien nuoc

    public static double tinh(CauHinh c, double a) {
        if (a <= c.getChiSoMuc1()) {
            return a * c.getMuc1();
        } else if (a <= c.getChiSoMuc2()) {
            double s = c.getChiSoMuc1() * c.getMuc1() + (a - c.getChiSoMuc1()) * c.getMuc2();
            return s;
        } else if (a <= c.getChiSoMuc3()) {
            double s = c.getChiSoMuc1() * c.getMuc1() + c.getChiSoMuc2() * c.getMuc2() + (a - c.getChiSoMuc3()) * c.getMuc3();
            return s;
        } else {
            double s = c.getChiSoMuc1() * c.getMuc1() + c.getChiSoMuc2() * c.getMuc2() + c.getChiSoMuc3() * c.getMuc3() + (a - c.getChiSoMuc3()) * c.getMuc4();
            return s;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        edt_tenchuho = new javax.swing.JTextField();
        edt_diachi = new javax.swing.JTextField();
        edt_maho = new javax.swing.JTextField();
        edt_sdt = new javax.swing.JTextField();
        edt_email = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();
        btn_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Chi tiết hộ gia đình");

        jLabel2.setText("Chủ hộ");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("SĐT");

        jLabel5.setText("Mã hộ gia đình");

        jLabel6.setText("Email");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ngày bắt đầu", "Ngày kết thúc", "Chỉ số đầu tháng", "Chỉ số cuối tháng", "Ngày thanh toán", "Tổng số nước", "Hạng mục", "Đơn giá", "Thành tiền", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        edt_tenchuho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_tenchuhoActionPerformed(evt);
            }
        });

        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_send.setText("Gửi");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btn_back)
                .addGap(56, 56, 56)
                .addComponent(btn_send)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edt_diachi))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edt_tenchuho, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edt_maho)
                            .addComponent(edt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(edt_tenchuho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(edt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_maho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(btn_send))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edt_tenchuhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_tenchuhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_tenchuhoActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
        new SendEmailGD().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
//        HoGiaDinh hgd = listHoGD.get(i);
//        String TO = hgd.getEmail();//dc email nguoi nhan
//        String MESS = "Yêu cầu thanh toán tiền nước tháng: ";
//        MESS += "\n"
//                + "\n Tên chủ hộ: " + hgd.getTenChuHo()
//                + "\n Số điện thoại: " + hgd.getSdt()
//                + "\n Địa chỉ: " + hgd.getDiaChi();
//        SendMailBySite.send(TO, SUB, MESS, USER, PASS);
//        JOptionPane.showMessageDialog(null, "Đã gửi xong!");
    }//GEN-LAST:event_btn_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chitietHoadonGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chitietHoadonGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chitietHoadonGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chitietHoadonGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chitietHoadonGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_send;
    private javax.swing.JTextField edt_diachi;
    private javax.swing.JTextField edt_email;
    private javax.swing.JTextField edt_maho;
    private javax.swing.JTextField edt_sdt;
    private javax.swing.JTextField edt_tenchuho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
