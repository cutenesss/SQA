/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Object.CauHinh;
import Object.DiaChi;
import Object.HoGiaDinh;
import Object.HoTen;
import Object.HoaDon;
import Object.SoNuoc;
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
        String sql = "SELECT qlnuoc.ho_gia_dinh.idHoGD,qlnuoc.ho_gia_dinh.idHoTen,qlnuoc.ho_gia_dinh.idDiaChi,qlnuoc.ho_gia_dinh.sdt,qlnuoc.ho_gia_dinh.maHoGD,qlnuoc.ho_gia_dinh.email,qlnuoc.hoten.ho,qlnuoc.hoten.ten,qlnuoc.diachi.soNha,qlnuoc.diachi.pho,qlnuoc.diachi.phuong,qlnuoc.diachi.quan,qlnuoc.diachi.thanhpho\n"
                + "FROM qlnuoc.ho_gia_dinh, qlnuoc.hoten, qlnuoc.diachi\n"
                +"where qlnuoc.ho_gia_dinh.idHoTen = qlnuoc.hoten.idHoTen\n"
                +"and qlnuoc.ho_gia_dinh.idDiaChi = qlnuoc.diachi.idDiaChi";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoGiaDinh s = new HoGiaDinh();
                s.setIdHoGD(rs.getInt("idHoGD"));
                HoTen hoten = new HoTen();
                hoten.setIdHoTen(rs.getInt("idHoTen"));
                hoten.setHo(rs.getString("ho"));
                hoten.setTen(rs.getString("ten"));
                s.setTenChuHo(hoten);
                DiaChi diachi = new DiaChi();
                diachi.setIdDiaChi(rs.getInt("idDiaChi"));
                diachi.setSoNha(rs.getInt("soNha"));
                diachi.setPho(rs.getString("pho"));
                diachi.setPhuong(rs.getString("phuong"));
                diachi.setQuan(rs.getString("quan"));
                diachi.setThanhpho(rs.getString("thanhpho"));
                s.setDiaChi(diachi);
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
   
    public ArrayList<HoGiaDinh> getListHoGDByDistrict(String quan){
        ArrayList<HoGiaDinh> listHoGD = new ArrayList<>();
        String sql = "SELECT qlnuoc.ho_gia_dinh.idHoGD,qlnuoc.ho_gia_dinh.idHoTen,qlnuoc.ho_gia_dinh.idDiaChi,qlnuoc.ho_gia_dinh.sdt,qlnuoc.ho_gia_dinh.maHoGD,qlnuoc.ho_gia_dinh.email,qlnuoc.hoten.ho,qlnuoc.hoten.ten,qlnuoc.diachi.soNha,qlnuoc.diachi.pho,qlnuoc.diachi.phuong,qlnuoc.diachi.quan,qlnuoc.diachi.thanhpho\n"
                + "FROM qlnuoc.ho_gia_dinh, qlnuoc.hoten, qlnuoc.diachi\n"
                +"where qlnuoc.ho_gia_dinh.idHoTen = qlnuoc.hoten.idHoTen\n"
                +"and qlnuoc.ho_gia_dinh.idDiaChi = qlnuoc.diachi.idDiaChi\n"
                +"and qlnuoc.diachi.quan = '"+quan+"'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoGiaDinh s = new HoGiaDinh();
                s.setIdHoGD(rs.getInt("idHoGD"));
                //
                HoTen hoten = new HoTen();
                hoten.setIdHoTen(rs.getInt("idHoTen"));
                hoten.setHo(rs.getString("ho"));
                hoten.setTen(rs.getString("ten"));
                s.setTenChuHo(hoten);
                //
//                s.setTenChuHo(rs.getString("tenChuHo"));
                //
                DiaChi diachi = new DiaChi();
                diachi.setIdDiaChi(rs.getInt("idDiaChi"));
                diachi.setSoNha(rs.getInt("soNha"));
                diachi.setPho(rs.getString("pho"));
                diachi.setPhuong(rs.getString("phuong"));
                diachi.setQuan(rs.getString("quan"));
                diachi.setThanhpho(rs.getString("thanhpho"));
                 s.setDiaChi(diachi);
                //
               
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
