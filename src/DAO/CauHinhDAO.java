/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Object.CauHinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Cuteness
 */
public class CauHinhDAO extends DAO {
    public CauHinhDAO(){
        getInstance();
    }
    
    public ArrayList<CauHinh> getCauHinh(int i){
        ArrayList<CauHinh> cauHinh = new ArrayList<>();
        String sql = "SELECT * FROM qlnuoc.cauhinh WHERE qlnuoc.cauhinh.idcauhinh = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CauHinh s = new CauHinh();
                s.setIdcauhinh(rs.getInt("idcauhinh"));
                s.setChiSoMuc1(rs.getDouble("chiSoMuc1"));
                s.setMuc1(rs.getDouble("muc1"));
                s.setChiSoMuc2(rs.getDouble("chiSoMuc2"));
                s.setMuc2(rs.getDouble("muc2"));
                s.setChiSoMuc3(rs.getDouble("chiSoMuc3"));
                s.setMuc3(rs.getDouble("muc3"));
                s.setMuc4(rs.getDouble("muc4")); 
                s.setNgayApDung(rs.getDate("ngayNhap"));
                cauHinh.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return cauHinh;
    }
    
    public ArrayList<CauHinh> getListCauHinh(){
        ArrayList<CauHinh> listCauHinh = new ArrayList<>();
        String sql = "SELECT * FROM qlnuoc.cauhinh";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CauHinh s = new CauHinh();
                s.setIdcauhinh(rs.getInt("idcauhinh"));
                s.setChiSoMuc1(rs.getDouble("chiSoMuc1"));
                s.setMuc1(rs.getDouble("muc1"));
                s.setChiSoMuc2(rs.getDouble("chiSoMuc2"));
                s.setMuc2(rs.getDouble("muc2"));
                s.setChiSoMuc3(rs.getDouble("chiSoMuc3"));
                s.setMuc3(rs.getDouble("muc3"));
                s.setMuc4(rs.getDouble("muc4")); 
                s.setNgayApDung(rs.getDate("ngayNhap"));
                listCauHinh.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return listCauHinh;
    }
    
    public void addCauHinh(CauHinh c) throws SQLException{
        String sql="INSERT INTO qlnuoc.cauhinh(idcauhinh, muc1, muc2, muc3, muc4, ngayNhap, chiSoMuc1, chiSoMuc2, chiSoMuc3) values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prstm = null;
        try {
          prstm = con.prepareStatement(sql);
          prstm.setDouble(1, c.getMuc1());
          prstm.setDouble(2, c.getMuc2());
          prstm.setDouble(3, c.getMuc3());
          prstm.setDouble(4, c.getMuc4());
          prstm.setDate(5, (java.sql.Date) c.getNgayApDung());
          prstm.setDouble(6, c.getChiSoMuc1());
          prstm.setDouble(7, c.getChiSoMuc2());
          prstm.setDouble(8, c.getChiSoMuc3());
          prstm.executeUpdate();
        } catch (SQLException e ) {
            throw e;
        } 
    }
}
