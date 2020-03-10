/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
        list = hoaDonDAO.getListHoaDon();
        System.out.println("size = "+list.size());
        for(HoaDon hd:list){
            System.out.println("name = "+hd.getIdHoaDon());
        }
    }
}
