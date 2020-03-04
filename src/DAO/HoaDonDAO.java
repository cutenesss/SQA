/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Object.CauHinh;
import Object.HoGiaDinh;
import Object.SoNuoc;
import Object.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Cuteness
 */
public class HoaDonDAO extends DAO {
    public HoaDonDAO(){
        getInstance();
    }
    
    public ArrayList<HoaDon> getListHoaDon(){
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT qlnuoc.hoadon.idhoadon, qlnuoc.hoadon.idSoNuoc, qlnuoc.hoadon.id_cauHinh, qlnuoc.hoadon.id_ho_GD, qlnuoc.hoadon.ngayThanhToan, qlnuoc.sonuoc.ngayBD, qlnuoc.sonuoc.chiSoBD, qlnuoc.sonuoc.ngayKT, qlnuoc.sonuoc.chiSoKT\n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and qlnuoc.ho_gia_dinh.idHoGD=1\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon s = new HoaDon();
                s.setIdHoaDon(rs.getInt("idhoadon"));
                s.setHoGD(new HoGiaDinh());
                CauHinh c = new CauHinh(rs.getInt("id_cauHinh"));
                s.setCauHinh(c);
                s.setNgayThanhLap(rs.getDate("ngayThanhToan"));
                SoNuoc s1 = new SoNuoc();
                s1.setIdsoNuoc(rs.getInt("idSoNuoc"));
                s1.setChiSoBD(rs.getFloat("chiSoBD"));
                s1.setNgayBD(rs.getDate("ngayBD"));
                s1.setChiSoKT(rs.getFloat("chiSoKT"));
                s1.setNgayKT(rs.getDate("ngayKT"));
                s.setSoNuoc(s1);
                listHoaDon.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return listHoaDon;
    }
}
