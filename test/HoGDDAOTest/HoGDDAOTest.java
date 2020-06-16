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

    public HoGDDAOTest() {
    }

    @Test
    public void testGetListHoGD() {
        HoGDDAO st = new HoGDDAO();
        ArrayList<HoGiaDinh> listHoGD = st.getListHoGD();
        Assert.assertNotNull(listHoGD);
        Assert.assertEquals(4, listHoGD.size());
        return;
    }

    @Test
    public void testGetListHoGDByDistrict() {
        HoGDDAO st = new HoGDDAO();
        //exception scenario
        ArrayList<HoGiaDinh> listHoGiaDinh = st.getListHoGDByDistrict("Hoàn Kiếm");
        Assert.assertNotNull(listHoGiaDinh);
        Assert.assertEquals(2, listHoGiaDinh.size());
        return;
    }

    @Test
    public void testGetHoGD0() {
        HoGDDAO st = new HoGDDAO();
        ArrayList<HoGiaDinh> listHoGD = st.getListHoGD();
        HoGiaDinh hgd = listHoGD.get(0);
        System.out.println(hgd.toString());
        DiaChi dc = new DiaChi(1, 1, "a", "aa", "Hoàn Kiếm", "hn");
        HoTen ten = new HoTen(1, "pham", "huy");
        HoGiaDinh testHgd = new HoGiaDinh(1, ten, dc, "123", "1a", "hoangdat1020@gmail.com");
        System.out.println(testHgd.toString());
        Assert.assertNotNull(listHoGD);
        Assert.assertEquals(testHgd.toString(), hgd.toString());
        return;
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
