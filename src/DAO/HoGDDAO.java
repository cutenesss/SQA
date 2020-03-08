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
import java.util.*;

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
}
