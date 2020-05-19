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
    public static int index = -1;// id ho gia dinh
    DefaultTableModel dtm;
    public static ArrayList<HoaDon> listHoaDon;
    public static ArrayList<CauHinh> ListcauHinh;
    public static HoaDon hoadon;
    public static HoGiaDinh hgd;
    public static SoNuoc soNuoc;
    public static double Tieumuc1 = 0;// cac muc tieu thu
    public static double Tieumuc2 = 0;
    public static double Tieumuc3 = 0;
    public static double Tieumuc4 = 0;
    public static double muc1 = 0;// cac muc gia tien nuoc
    public static double muc2 = 0;
    public static double muc3 = 0;
    public static double muc4 = 0;
    public static double chiso1 = 0;// cac muc trong thang do so nuoc
    public static double chiso2 = 0;
    public static double chiso3 = 0;
    public static double chisoBD = 0;
    public static double chisoKT = 0;
    public static double tongNuoc = 0;
    public static double tien = 0;
    public static Date nTT;//ngay thanh toan
    public static Date nbd;
    public static Date nkt;

    public chitietHoadonGD() {
        initComponents();
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jTable1.getModel();
        hgd = new HoGiaDinh();
        index = SendEmailGD.index;// id ho gia dinh
        for(HoGiaDinh h:SendEmailGD.listHoGD){
            if(h.getIdHoGD() == index){
                hgd.setTenChuHo(h.getTenChuHo());
                hgd.setEmail(h.getEmail());
                hgd.setSdt(h.getSdt());
                hgd.setDiaChi(h.getDiaChi());
                hgd.setMaHoGD(h.getMaHoGD());
            }
          
        }
        if(hgd!= null){
            edt_tenchuho.setText(hgd.getTenChuHo().toString());
            edt_tenchuho.setEditable(false);
        edt_diachi.setText(hgd.getDiaChi().toString());
        edt_diachi.setEditable(false);
        edt_maho.setText(hgd.getMaHoGD());
        edt_maho.setEditable(false);
        edt_sdt.setText(hgd.getSdt());
        edt_sdt.setEditable(false);
        edt_email.setText(hgd.getEmail());
        edt_email.setEditable(false);
        }
    }

    //Tach so nuoc
    public void taobang(int index) {
        HoaDonDAO st = new HoaDonDAO();
        listHoaDon = st.getListHoaDon(index);
        CauHinhDAO st2 = new CauHinhDAO();
        //
        hoadon = new HoaDon();

        if (!listHoaDon.isEmpty()) {
            hoadon = listHoaDon.get(listHoaDon.size() - 1);
        }

        if (hoadon != null) {
            soNuoc = hoadon.getSoNuoc();
            ListcauHinh = st2.getCauHinh(hoadon.getCauHinh().getIdcauhinh());
            nbd = soNuoc.getNgayBD();
            nkt = soNuoc.getNgayKT();
            chisoBD = soNuoc.getChiSoBD();
            chisoKT = soNuoc.getChiSoKT();
            // so tien tung muc
            CauHinh cauHinh = ListcauHinh.get(0);
            muc1 = cauHinh.getMuc1();
            muc2 = cauHinh.getMuc2();
            muc3 = cauHinh.getMuc3();
            muc4 = cauHinh.getMuc4();
            // thong so cac muc
            chiso1 = cauHinh.getChiSoMuc1();
            chiso2 = cauHinh.getChiSoMuc2();
            chiso3 = cauHinh.getChiSoMuc3();
            //
            nTT = hoadon.getNgayThanhToan();
            tongNuoc = chisoKT - chisoBD;
            //tach so nuoc
            TachSoNuoc(cauHinh, tongNuoc);
            tien = tinh(cauHinh, tongNuoc);
            System.out.println("tien = "+tien);
            // set vao cac cot
            dtm.addRow(new Object[]{nbd, nkt, chisoBD, chisoKT, nTT, tongNuoc, Tieumuc1, muc1, Tieumuc1 * muc1, null});
            if (Tieumuc2 > 0) {
                dtm.addRow(new Object[]{null, null, null, null, null, null, Tieumuc2, muc2, Tieumuc2 * muc2, null});
            }
            if (Tieumuc3 > 0) {
                dtm.addRow(new Object[]{null, null, null, null, null, null, Tieumuc3, muc3, Tieumuc3 * muc3, null});
            }
            if (Tieumuc4 > 0) {
                dtm.addRow(new Object[]{null, null, null, null, null, null, Tieumuc4, muc4, Tieumuc4 * muc4, null});
            }
            dtm.addRow(new Object[]{null, null, null, null, null, null, null, null, null,tien});
        }
    }
    
    public static void TachSoNuoc(CauHinh c, double a) {
        if (a <= c.getChiSoMuc1()) {
            Tieumuc1 = a;
        } else if (a - c.getChiSoMuc1() <= c.getChiSoMuc2()) {
            Tieumuc1 = c.getChiSoMuc1();
            Tieumuc2 = a - c.getChiSoMuc1();
        } else if (a - c.getChiSoMuc1() - c.getChiSoMuc2() <= c.getChiSoMuc3()) {
            Tieumuc1 = c.getChiSoMuc1();
            Tieumuc2 = c.getChiSoMuc2();
            Tieumuc3 = a - c.getChiSoMuc2();
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

        jLabel1.setText("Chi tiết hóa đơn hộ gia đình");

        jLabel2.setText("Chủ hộ");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("SĐT");

        jLabel5.setText("Mã hộ gia đình");

        jLabel6.setText("Email");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày bắt đầu", "Ngày kết thúc", "Chỉ số đầu tháng", "Chỉ số cuối tháng", "Ngày thanh toán", "Tổng số nước", "Hạng mục", "Đơn giá", "Thành tiền", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_send)
                        .addGap(62, 62, 62)
                        .addComponent(btn_back))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(btn_send))
                .addContainerGap())
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

        String TO = hgd.getEmail();//dc email nguoi nhan
        
        String MESS = "Yêu cầu thanh toán tiền nước trước ngày: "+nTT;
        MESS += "\n"
                + "\n Tên chủ hộ: " + hgd.getTenChuHo()
                + "\n Số điện thoại: " + hgd.getSdt()
                + "\n Địa chỉ: " + hgd.getDiaChi();
     MESS+="\n\n"
             +" Chỉ số nước kì trước(ngày: "+nbd+"): "+chisoBD+"\t chỉ số nước kì này(ngày: "+nkt+"): "+chisoKT
             +"\n Các mức chi tiết:"
             +"\n Mức 1: "+Tieumuc1+"\t Đơn giá: "+muc1+"\t Tiền mức 1 = "+Tieumuc1*muc1
              +"\n Mức 2: "+Tieumuc2+"\t Đơn giá: "+muc2+"\t Tiền mức 2 = "+Tieumuc2*muc2
              +"\n Mức 3: "+Tieumuc3+"\t Đơn giá: "+muc3+"\t Tiền mức 3 = "+Tieumuc3*muc3
              +"\n Mức 4: "+Tieumuc4+"\t Đơn giá: "+muc4+"\t Tiền mức 4 = "+Tieumuc4*muc4
             +"\nTổng số nước đã tiêu thụ: "+tongNuoc
             +"\nTổng tiền: "+tien;
        SendMailBySite.send(TO, SUB, MESS, USER, PASS);
        JOptionPane.showMessageDialog(null, "Đã gửi xong!");
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
