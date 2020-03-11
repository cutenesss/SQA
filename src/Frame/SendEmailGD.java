/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Controller.SendMailBySite;
import DAO.HoGDDAO;
import Object.HoGiaDinh;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class SendEmailGD extends javax.swing.JFrame {
    public static int index = -1;
    public static HoGDDAO dao = new HoGDDAO();
    public static ArrayList<HoGiaDinh> listHoGD;
    public static String USER = "hoanv.ptit@gmail.com";
    public static String PASS = "hyh@114141";
    public static String SUB = "Yeu cau thanh toan tien nuoc";
    private int allRow;
    Calendar calendar;
    DefaultTableModel model;

    public SendEmailGD() {
        initComponents();

        setLocationRelativeTo(null);
        model = (DefaultTableModel) tbl_ListCustomer.getModel();
        listHoGD = dao.getListHoGD();
        //
//        calendar = new Calendar();
        for (HoGiaDinh hgd : listHoGD) {
            int id = hgd.getIdHoGD();
            String ten = hgd.getTenChuHo();
            String email = hgd.getEmail();
            String diachi = hgd.getDiaChi();
            String maHo = hgd.getMaHoGD();
            String sdt = hgd.getSdt();
            model.addRow(new Object[]{false,maHo, ten, email, sdt,diachi});
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

        cb_tatca = new javax.swing.JCheckBox();
        cb_dongtien = new javax.swing.JCheckBox();
        cb_khac = new javax.swing.JCheckBox();
        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ListCustomer = new javax.swing.JTable();
        btn_xemhd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cb_tatca.setText("Chọn tất cả");
        cb_tatca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tatcaActionPerformed(evt);
            }
        });

        cb_dongtien.setText("Yêu cầu đóng tiền");

        cb_khac.setText("Khác");

        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        tbl_ListCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Mã Hộ", "Tên chủ hộ", "Email", "Số điện thoại", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_ListCustomer);

        btn_xemhd.setText("Xem hoá đơn");
        btn_xemhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemhdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(cb_tatca, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(69, 69, 69)
                .addComponent(cb_dongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addComponent(cb_khac, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btn_xemhd)
                .addGap(61, 61, 61)
                .addComponent(btn_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tatca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_dongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_khac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xemhd)
                    .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
         this.dispose();
         new Menu().setVisible(true);
      
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_xemhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemhdActionPerformed
          allRow = model.getRowCount();// new 
          int noSelect = 0;
        for(int i = 0;i<allRow;i++){
           if(model.getValueAt(i,0).equals(true)){
              index = i;
              this.dispose();
            new chitietHoadonGD().setVisible(true);
           }
           else noSelect++;
       }
//        System.out.println("noselect = "+noSelect+"\n allrow = "+allRow);
        if(noSelect == allRow){
            JOptionPane.showMessageDialog(null,"Chọn 1 hộ gia đình để xem chi tiết hoá đơn");
//            new SendEmailGD().setVisible(true);
        }
        
    }//GEN-LAST:event_btn_xemhdActionPerformed

    private void cb_tatcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tatcaActionPerformed
        allRow = model.getRowCount();
        if(cb_tatca.isSelected()){
            for(int i = 0;i<allRow;i++){
                model.setValueAt(true,i,0);
            }
        }else{
            for(int i = 0;i<allRow;i++){
                model.setValueAt(false,i,0);
            }
        }
    }//GEN-LAST:event_cb_tatcaActionPerformed

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
            java.util.logging.Logger.getLogger(SendEmailGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendEmailGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendEmailGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendEmailGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendEmailGD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_xemhd;
    private javax.swing.JCheckBox cb_dongtien;
    private javax.swing.JCheckBox cb_khac;
    private javax.swing.JCheckBox cb_tatca;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_ListCustomer;
    // End of variables declaration//GEN-END:variables
}
