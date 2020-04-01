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
    
    public ArrayList<HoaDon> getListHoaDon(int i){
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = "SELECT qlnuoc.hoadon.idhoadon, qlnuoc.hoadon.idSoNuoc, qlnuoc.hoadon.id_cauHinh, qlnuoc.hoadon.id_ho_GD, qlnuoc.hoadon.ngayThanhToan, qlnuoc.sonuoc.ngayBD, qlnuoc.sonuoc.chiSoBD, qlnuoc.sonuoc.ngayKT, qlnuoc.sonuoc.chiSoKT\n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and (qlnuoc.ho_gia_dinh.idHoGD=?)\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon s = new HoaDon();
                s.setIdHoaDon(rs.getInt("idhoadon"));
                s.setHoGD(new HoGiaDinh());
                CauHinh c = new CauHinh(rs.getInt("id_cauHinh"));
                s.setCauHinh(c);
                s.setNgayThanhToan(rs.getDate("ngayThanhToan"));
                SoNuoc s1 = new SoNuoc();
                s1.setIdsoNuoc(rs.getInt("idSoNuoc"));
                s1.setChiSoBD(rs.getDouble("chiSoBD"));
                s1.setNgayBD(rs.getDate("ngayBD"));
                s1.setChiSoKT(rs.getDouble("chiSoKT"));
                s1.setNgayKT(rs.getDate("ngayKT"));
                s.setSoNuoc(s1);
                listHoaDon.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
    public ArrayList<Double> getTotalWaterUsed(String sd, String ed){
        ArrayList<Double> totalWaterUsed = new ArrayList<>();
        String sql = "SELECT sum(qlnuoc.sonuoc.chiSoKT - qlnuoc.sonuoc.chiSoBD)\n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc\n" +
"and qlnuoc.hoadon.ngayThanhToan != ''"+ 
"and qlnuoc.sonuoc.ngayBD>=?\n" +
"and qlnuoc.sonuoc.ngayBD<=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sd);
            ps.setString(2, ed);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Double s = rs.getDouble("sum(qlnuoc.sonuoc.chiSoKT - qlnuoc.sonuoc.chiSoBD)");
                totalWaterUsed.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return totalWaterUsed;
    }
    
    public ArrayList<Integer> getUsedCount(String sd, String ed){
        ArrayList<Integer> totalUsedCount = new ArrayList<>();
        String sql = "SELECT qlnuoc.hoadon.id_cauHinh \n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc\n" +
"and qlnuoc.hoadon.ngayThanhToan != ''"+ 
"and qlnuoc.sonuoc.ngayBD>=?\n" +
"and qlnuoc.sonuoc.ngayBD<=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sd);
            ps.setString(2, ed);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int s = rs.getInt("id_cauHinh");
                totalUsedCount.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return totalUsedCount;
    }
    
    public ArrayList<Double> getTotalWater(String sd, String ed){
        ArrayList<Double> totalWater = new ArrayList<>();
        String sql = "SELECT sum(qlnuoc.sonuoc.chiSoKT - qlnuoc.sonuoc.chiSoBD)\n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc\n"+ 
"and qlnuoc.sonuoc.ngayBD>=? \n" +
"and qlnuoc.sonuoc.ngayBD<=? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sd);
            ps.setString(2, ed);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Double s = rs.getDouble("sum(qlnuoc.sonuoc.chiSoKT - qlnuoc.sonuoc.chiSoBD)");
                totalWater.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return totalWater;
    }
    
    public ArrayList<Integer> getTotalUser(String sd, String ed){
        ArrayList<Integer> totalUser = new ArrayList<>();
        String sql = "SELECT COUNT(qlnuoc.sonuoc.chiSoKT)\n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc\n"+ 
"and qlnuoc.sonuoc.ngayBD>=? \n" +
"and qlnuoc.sonuoc.ngayBD<=? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sd);
            ps.setString(2, ed);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int s = rs.getInt("COUNT(qlnuoc.sonuoc.chiSoKT)");
                totalUser.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return totalUser;
    }
    
    public ArrayList<Integer> getTotalPaidUser(String sd, String ed){
        ArrayList<Integer> totalPaidUser = new ArrayList<>();
        String sql = "SELECT COUNT(qlnuoc.sonuoc.chiSoKT)\n" +
"FROM qlnuoc.hoadon, qlnuoc.sonuoc, qlnuoc.ho_gia_dinh\n" +
"where qlnuoc.hoadon.id_ho_GD=qlnuoc.ho_gia_dinh.idHoGD\n" +
"and qlnuoc.sonuoc.idsoNuoc=qlnuoc.hoadon.idSoNuoc\n"+ 
"and qlnuoc.hoadon.ngayThanhToan != ''"+ 
"and qlnuoc.sonuoc.ngayBD>=? \n" +
"and qlnuoc.sonuoc.ngayBD<=? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sd);
            ps.setString(2, ed);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int s = rs.getInt("COUNT(qlnuoc.sonuoc.chiSoKT)");
                totalPaidUser.add(s);
            }
        } catch(SQLException e){ 
            e.printStackTrace();
        }
        return totalPaidUser;
    }
}
