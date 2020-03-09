/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Object.HoGiaDinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cuteness
 */
public class HoGDDAO extends DAO {
    public HoGDDAO() {
        getInstance();
    }
    
    public ArrayList<HoGiaDinh> getListHoGD(){
        ArrayList<HoGiaDinh> listHoGD = new ArrayList<>();
        String sql = "SELECT * FROM qlnuoc.ho_gia_dinh";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoGiaDinh s = new HoGiaDinh();
                s.setIdHoGD(rs.getInt("idHoGD"));
                s.setTenChuHo(rs.getString("tenChuHo"));
                s.setDiaChi(rs.getString("diaChi"));
                s.setSdt(rs.getString("sdt"));
                s.setMaHoGD(rs.getString("maHoGD"));
                s.setEmail(rs.getString("email"));
                listHoGD.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return listHoGD;
    }
    public List<HoGiaDinh> getCustomerByName(String tenchuho) {
         List<HoGiaDinh>  listHoGD = new ArrayList<>();
           HoGiaDinh hoGiaDinh = new HoGiaDinh();
        try {
//            DBConnection dbc = new DBConnection();
//            conn = dbc.getConnection();
            String sql = "Select * form qlnuoc.ho_gia_dinh where tenChuHo = '"+tenchuho+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoGiaDinh s = new HoGiaDinh();
                s.setIdHoGD(rs.getInt("idHoGD"));
                s.setTenChuHo(rs.getString("tenChuHo"));
                s.setDiaChi(rs.getString("diaChi"));
                s.setSdt(rs.getString("sdt"));
                s.setMaHoGD(rs.getString("maHoGD"));
                s.setEmail(rs.getString("email"));
                listHoGD.add(s);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  listHoGD;
    }

    public HoGiaDinh getCustomerByID(int id) {
          HoGiaDinh hoGiaDinh = new HoGiaDinh();
        try {
            String sql = "Select * form qlnuoc.ho_gia_dinh where idHoGD = '"+id+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                hoGiaDinh.setIdHoGD(rs.getInt("idHoGD"));
                hoGiaDinh.setTenChuHo(rs.getString("tenChuHo"));
                hoGiaDinh.setDiaChi(rs.getString("diaChi"));
                hoGiaDinh.setSdt(rs.getString("sdt"));
                hoGiaDinh.setMaHoGD(rs.getString("maHoGD"));
                hoGiaDinh.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  hoGiaDinh;
    }
}
