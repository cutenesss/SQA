/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoaDonDAOTest;

import DAO.HoaDonDAO;
import Object.HoaDon;
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
        Assert.assertEquals(1, listHoaDon.size());
        return;
    }
    
    @Test
    public void testGetTotalWaterUsed(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        double usedWater = st.getTotalWaterUsed("2020-02-01","2020-02-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((long) 0.0,(long) usedWater);
        // standard
        usedWater = st.getTotalWaterUsed("2020-01-01","2020-01-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((long) 150.0,(long) usedWater);
        return;
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
        return;
    }
    
    @Test
    public void testGetUsedCount(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        ArrayList<Integer> usedWater = st.getUsedCount("2020-02-01","2020-02-28");
        Assert.assertNotNull(usedWater);
        Assert.assertEquals((int) 1,(int) usedWater.get(0));
        return;
    }
    
    @Test
    public void testGetTotalPaidUser(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        ArrayList<Integer> user = st.getTotalPaidUser("2020-02-01","2020-02-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 0,(int) user.get(0));
        // standard
        user = st.getTotalUser("2020-01-01","2020-01-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 4,(int) user.get(0));
        return;
    }
    
    @Test
    public void testGetTotalUser(){
        HoaDonDAO st = new HoaDonDAO();
        // exception
        ArrayList<Integer> user = st.getTotalUser("2020-02-01","2020-02-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 0,(int) user.get(0));
        // standard
        user = st.getTotalUser("2020-01-01","2020-01-28");
        Assert.assertNotNull(user);
        Assert.assertEquals((int) 4,(int) user.get(0));
        return;
    }
}
