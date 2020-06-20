/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoGDDAOTest;

import DAO.HoGDDAO;
import Object.DiaChi;
import Object.HoGiaDinh;
import Object.HoTen;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author cuteness
 */
public class HoGDDAOTest {
    public HoGDDAOTest(){
    }
    
    @Test
    public void testGetListHoGD(){
        HoGDDAO st = new HoGDDAO();
        ArrayList<HoGiaDinh> listHoGD = st.getListHoGD();
        Assert.assertNotNull(listHoGD);
        Assert.assertEquals(4, listHoGD.size());
        HoGiaDinh hgd = listHoGD.get(0);
        DiaChi dc = new DiaChi(1, 1, "a", "aa", "Hoàn Kiếm", "hn");
        HoTen ten = new HoTen(1, "pham", "huy");
        HoGiaDinh testHgd = new HoGiaDinh(1, ten, dc, "123", "1a", "hoangdat1020@gmail.com");
        Assert.assertEquals(testHgd.getIdHoGD(), hgd.getIdHoGD());
        Assert.assertEquals(testHgd.getTenChuHo().getIdHoTen(), hgd.getTenChuHo().getIdHoTen());
        Assert.assertEquals(testHgd.getTenChuHo().getHo(), hgd.getTenChuHo().getHo());
        Assert.assertEquals(testHgd.getTenChuHo().getTen(), hgd.getTenChuHo().getTen());
        Assert.assertEquals(testHgd.getDiaChi().getIdDiaChi(), hgd.getDiaChi().getIdDiaChi());
        Assert.assertEquals(testHgd.getDiaChi().getPho(), hgd.getDiaChi().getPho());
        Assert.assertEquals(testHgd.getDiaChi().getPhuong(), hgd.getDiaChi().getPhuong());
        Assert.assertEquals(testHgd.getDiaChi().getQuan(), hgd.getDiaChi().getQuan());
        Assert.assertEquals(testHgd.getDiaChi().getSoNha(), hgd.getDiaChi().getSoNha());
        Assert.assertEquals(testHgd.getDiaChi().getThanhpho(), hgd.getDiaChi().getThanhpho());
        Assert.assertEquals(testHgd.getEmail(), hgd.getEmail());
        Assert.assertEquals(testHgd.getMaHoGD(), hgd.getMaHoGD());
        Assert.assertEquals(testHgd.getSdt(), hgd.getSdt());
    }
        
    @Test
    public void testGetListHoGDByDistrict(){
        HoGDDAO st = new HoGDDAO();
        //exception scenario
        ArrayList<HoGiaDinh> listHoGiaDinh = st.getListHoGDByDistrict("Cầu Giấy");
        Assert.assertNotNull(listHoGiaDinh);
        Assert.assertEquals(1, listHoGiaDinh.size());
        HoGiaDinh hgd = listHoGiaDinh.get(0);
        DiaChi dc = new DiaChi(3, 3, "c", "ac", "Cầu Giấy", "hn");
        HoTen ten = new HoTen(3, "le", "ha");
        HoGiaDinh testHgd = new HoGiaDinh(3, ten, dc, "789", "1c", "zhaoyun2nd1998@gmail.com");
        Assert.assertEquals(testHgd.getIdHoGD(), hgd.getIdHoGD());
        Assert.assertEquals(testHgd.getTenChuHo().getIdHoTen(), hgd.getTenChuHo().getIdHoTen());
        Assert.assertEquals(testHgd.getTenChuHo().getHo(), hgd.getTenChuHo().getHo());
        Assert.assertEquals(testHgd.getTenChuHo().getTen(), hgd.getTenChuHo().getTen());
        Assert.assertEquals(testHgd.getDiaChi().getIdDiaChi(), hgd.getDiaChi().getIdDiaChi());
        Assert.assertEquals(testHgd.getDiaChi().getPho(), hgd.getDiaChi().getPho());
        Assert.assertEquals(testHgd.getDiaChi().getPhuong(), hgd.getDiaChi().getPhuong());
        Assert.assertEquals(testHgd.getDiaChi().getQuan(), hgd.getDiaChi().getQuan());
        Assert.assertEquals(testHgd.getDiaChi().getSoNha(), hgd.getDiaChi().getSoNha());
        Assert.assertEquals(testHgd.getDiaChi().getThanhpho(), hgd.getDiaChi().getThanhpho());
        Assert.assertEquals(testHgd.getEmail(), hgd.getEmail());
        Assert.assertEquals(testHgd.getMaHoGD(), hgd.getMaHoGD());
        Assert.assertEquals(testHgd.getSdt(), hgd.getSdt());
    }
    
     @Test
    public void testGetHoGDNotDistric() {
        HoGDDAO st = new HoGDDAO();
        //exception scenario
        ArrayList<HoGiaDinh> listHoGiaDinh = st.getListHoGDByDistrict("Thanh Trì");
        Assert.assertNotNull(listHoGiaDinh);
        Assert.assertEquals(0, listHoGiaDinh.size());
    }
}
