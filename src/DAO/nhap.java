/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Object.CauHinh;
import Object.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class nhap {
    public static void main(String[] args) {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        ArrayList<HoaDon> list = new ArrayList<>();
        list = hoaDonDAO.getListHoaDon(2);
        System.out.println("size = "+list.size());
        for(HoaDon hd:list){
           CauHinh cauHinh = hd.getCauHinh();
            System.out.println("cau hinh id"+cauHinh.getIdcauhinh());
            System.out.println("chi so 1 = "+cauHinh.getChiSoMuc1());
        }
    }
}
