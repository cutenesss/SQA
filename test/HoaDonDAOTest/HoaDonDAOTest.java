/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDonDAOTest;

import DAO.HoaDonDAO;
import Object.CauHinh;
import Object.HoGiaDinh;
import Object.HoaDon;
import Object.SoNuoc;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cuteness
 */
public class HoaDonDAOTest {
    public HoaDonDAOTest() {
    }
    
    @Test
    public void testGetListHoaDon(){
        HoaDonDAO st = new HoaDonDAO();
        ArrayList<HoaDon> listHoaDon = st.getListHoaDon(1);
        Assert.assertNotNull(listHoaDon);
        HoaDon hoaDon = listHoaDon.get(0);
        Assert.assertEquals(1, listHoaDon.size());
        Date date = Date.valueOf("2020-02-09");
        Date date1 = Date.valueOf("2020-01-07");
        Date date2 = Date.valueOf("2020-02-04");
        Assert.assertEquals((long) 1.0,(long) hoaDon.getIdHoaDon());
        Assert.assertEquals((long) 4000.0,(long) hoaDon.getSoNuoc().getChiSoBD());
        Assert.assertEquals((long) 4025.0,(long) hoaDon.getSoNuoc().getChiSoKT());
        Assert.assertEquals( date1, hoaDon.getSoNuoc().getNgayBD());
        Assert.assertEquals( date2, hoaDon.getSoNuoc().getNgayKT());
        Assert.assertEquals((long) 1.0,(long) hoaDon.getSoNuoc().getIdsoNuoc());
        Assert.assertEquals((long) 1.0,(long) hoaDon.getHoGD().getIdHoGD());
        Assert.assertEquals((long) 1.0,(long) hoaDon.getCauHinh().getIdcauhinh());
        Assert.assertEquals(date, hoaDon.getNgayThanhToan());
        Assert.assertEquals(date, hoaDon.getNgayThanhToan());
    }
    
    @Test
    public void testGetTotalWaterUsed1(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        double usedWater = st.getTotalWaterUsed("2020-02-01","2020-02-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((long) 0.0,(long) usedWater);
    }
    
    @Test
    public void testGetTotalWaterUsed2(){
        HoaDonDAO st = new HoaDonDAO();
        // standard
        double usedWater = st.getTotalWaterUsed("2020-01-01","2020-01-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((long) 150.0,(long) usedWater);
    }
    
    @Test
    public void testGetTotalWater(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        double usedWater = st.getTotalWater("2020-02-01","2020-02-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((long) 0.0,(long) usedWater);
        // standard
        usedWater = st.getTotalWater("2020-01-01","2020-01-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((long) 150.0,(long) usedWater);
    }
    
    @Test
    public void testGetUsedCount1(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        int usedCount = st.getUsedCount("2020-02-01","2020-02-28");
        Assert.assertNotNull(usedCount);
        Assert.assertEquals((long) 0.0,(long) usedCount);
    }
    
    @Test
    public void testGetUsedCount2(){
        HoaDonDAO st = new HoaDonDAO();
        // standard
        int usedCount = st.getUsedCount("2020-01-01","2020-01-28");
        Assert.assertNotNull(usedCount);
        Assert.assertEquals((long) 1.0,(long) usedCount);
    }
    
    @Test
    public void testGetTotalPaidUser1(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        int user = st.getTotalPaidUser("2020-02-01","2020-02-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 0,(int) user);
    }
    
    @Test
    public void testGetTotalPaidUser2(){
        HoaDonDAO st = new HoaDonDAO();
        // standard
        int user = st.getTotalUser("2020-01-01","2020-01-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 4,(int) user);
    }
    
    @Test
    public void testGetTotalUser1(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        int user = st.getTotalUser("2020-02-01","2020-02-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 0,(int) user);
    }
    
     @Test
    public void testGetTotalUser2(){
        HoaDonDAO st = new HoaDonDAO();
        // standard
        int user = st.getTotalUser("2020-01-01","2020-01-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 4,(int) user);
        return;
    }
}
