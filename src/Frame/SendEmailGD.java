/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.HoGDDAO;
import Object.HoGiaDinh;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DELL
 */
public class SendEmailGD extends javax.swing.JFrame {
    public static int index = -1;
    public static HoGDDAO dao = new HoGDDAO();
    public static ArrayList<HoGiaDinh> listHoGD;
    public static HoGiaDinh hogd;
    public static String USER = "cloneforfun1998@gmail.com";
    public static String PASS = "S2YoshinoS2";
    public static String SUB = "Yêu cầu thanh toán tiền nước:";
    public boolean isPushed;
    private String Quan = "Tất cả";
    Calendar calendar;
    DefaultTableModel model;

    public SendEmailGD() {
        initComponents();

        setLocationRelativeTo(null);
        model = (DefaultTableModel) tbl_ListCustomer.getModel();
        listHoGD = dao.getListHoGD();
         tbl_ListCustomer.getColumn("Xem Hoá Đơn").setCellRenderer(new SendEmailGD.ButtonRenderer());
         tbl_ListCustomer.getColumn("Xem Hoá Đơn").setCellEditor(new SendEmailGD.ButtonEditor(new JCheckBox()));
        for (HoGiaDinh hgd : listHoGD) {
            String ten = hgd.getTenChuHo().toString();
            String email = hgd.getEmail();
            String diachi = hgd.getDiaChi().toString();
            String maHo = hgd.getMaHoGD();
            String sdt = hgd.getSdt();
            model.addRow(new Object[]{maHo, ten, email, sdt,diachi});
        }
    }
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "Xem chi tiết hoá đơn" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            index = listHoGD.get(row).getIdHoGD();
            label = (value == null) ? "Xem chi tiết hoá đơn" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                chitietHoadonGD dsf = new chitietHoadonGD();
                dsf.taobang(index);
                dsf.setVisible(true);
            }
            dispose();
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
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

        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ListCustomer = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Quan_selected = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                "Mã Hộ", "Tên chủ hộ", "Email", "Số điện thoại", "Địa chỉ", "Xem Hoá Đơn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_ListCustomer);

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Danh sách hộ gia đình");

        Quan_selected.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Hoàn Kiếm", "Cầu Giấy", "Đống Đa", "Nam Từ Liêm" }));
        Quan_selected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quan_selectedActionPerformed(evt);
            }
        });

        jLabel2.setText("Quận");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(Quan_selected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_back)
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Quan_selected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
         this.dispose();
         new Menu().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Quan_selectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quan_selectedActionPerformed
        // hiển thị danh sách hộ gia đình theo quận
        Quan = Quan_selected.getSelectedItem().toString().trim();
        // nếu chọn tất cả
        listHoGD = dao.getListHoGD();
        if (listHoGD.size() != 0) {
            if (Quan.equals("Tất cả")) {
                System.out.println("trong combo box tất cả");
                model.setRowCount(0);
                for (int i = 0; i < listHoGD.size(); i++) {
                    model.addRow(listHoGD.get(i).getObject1(i + 1));
                }
            } else {// hiển thị dánh sách hộ gia đình theo quận
                ArrayList<HoGiaDinh> listHGD = dao.getListHoGDByDistrict(Quan);
                if (listHGD.size() != 0) {
                    model.setRowCount(0);
                    for (int i = 0; i < listHGD.size(); i++) {
                        model.addRow(listHGD.get(i).getObject1(i + 1));
                    }
                } else {
                     JOptionPane.showMessageDialog(null,"Không có dữ liệu");
                    HoGiaDinh s = new HoGiaDinh(0, null, null, "", "", "");
                    model.setRowCount(0);
                    for (int i = 0; i < 0; i++) {
                        model.addRow(s.getObject1(0));
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(null,"Không có dữ liệu");
            HoGiaDinh s = new HoGiaDinh(0, null, null, "", "", "");
            model.setRowCount(0);
            for (int i = 0; i < 0; i++) {
                model.addRow(s.getObject1(0));
            }
        }
    }//GEN-LAST:event_Quan_selectedActionPerformed

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
    private javax.swing.JComboBox Quan_selected;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_ListCustomer;
    // End of variables declaration//GEN-END:variables
}
