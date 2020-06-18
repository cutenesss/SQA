/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HoGDDAOTest;

import DAO.HoGDDAO;
import Object.HoGiaDinh;
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
    }
    
    @Test
    public void testGetListHoGDByDistrict(){
        HoGDDAO st = new HoGDDAO();
        //exception scenario
        ArrayList<HoGiaDinh> listHoGiaDinh = st.getListHoGDByDistrict("Hoàn Kiếm");
        Assert.assertNotNull(listHoGiaDinh);
        Assert.assertEquals(2, listHoGiaDinh.size());
    }
}
