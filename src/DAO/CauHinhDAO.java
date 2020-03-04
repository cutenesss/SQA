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
    
    public CauHinh getCauHinh(int i){
        CauHinh cauHinh = new CauHinh();
        String sql = "SELECT * FROM qlnuoc.cauhinh WHERE qlnuoc.cauhinh.idcauhinh = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            CauHinh s = new CauHinh();
            s.setChiSoMuc1(rs.getDouble("chiSoMuc1"));
            s.setMuc1(rs.getDouble("muc1"));
            s.setChiSoMuc2(rs.getDouble("chiSoMuc2"));
            s.setMuc2(rs.getDouble("muc2"));
            s.setChiSoMuc3(rs.getDouble("chiSoMuc3"));
            s.setMuc3(rs.getDouble("muc3"));
            s.setMuc4(rs.getDouble("muc4"));
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return cauHinh;
    }
}
