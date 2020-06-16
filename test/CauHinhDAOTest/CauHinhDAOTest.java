/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CauHinhDAOTest;

import DAO.CauHinhDAO;
import Object.CauHinh;
import java.sql.Connection;
import java.text.ParseException;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cuteness
 */
public class CauHinhDAOTest {
    public CauHinhDAOTest() {
    }
    
    @Test
    public void testGetCauHinh() throws ParseException{
        CauHinhDAO st = new CauHinhDAO();
        //exception scenario
        CauHinh cauHinh = st.getCauHinh(0);
        Assert.assertNull(cauHinh);
        //standard scenario
        Date date = Date.valueOf("2018-02-01");
        cauHinh = st.getCauHinh(1);
        Assert.assertNotNull(cauHinh);
        Assert.assertEquals(1, cauHinh.getIdcauhinh());
        Assert.assertEquals((long) 5.0,(long) cauHinh.getChiSoMuc1());
        Assert.assertEquals((long) 1000.0,(long) cauHinh.getChiSoMuc2());
        Assert.assertEquals((long) 1500.0, (long) cauHinh.getChiSoMuc3());
        Assert.assertEquals((long) 4000.0, (long) cauHinh.getMuc1());
        Assert.assertEquals((long) 5000.0, (long) cauHinh.getMuc2());
        Assert.assertEquals((long) 6000.0, (long) cauHinh.getMuc3());
        Assert.assertEquals((long) 7000.0, (long) cauHinh.getMuc4());
        Assert.assertEquals(date, cauHinh.getNgayApDung());
        return;
    }
    
    @Test
    public void testGetListCauHinh(){
        CauHinhDAO st = new CauHinhDAO();
        ArrayList<CauHinh> listCauHinh = st.getListCauHinh();
        Assert.assertNotNull(listCauHinh);
        Assert.assertEquals(4, listCauHinh.size());
        return;
    }
    
    @Test
    public void testAddCauHinh() throws ParseException{
        CauHinhDAO st = new CauHinhDAO();
        CauHinh cauHinh = new CauHinh(4, 7500.0, 8000.0, 8500.0, 9000.0, 15.0, 20.0, 25.0, Date.valueOf("2020-07-01"));
        Connection con = st.con;
        try{
        con.setAutoCommit(false);
        st.addCauHinh(cauHinh);
        Assert.assertNotNull(cauHinh);
        Assert.assertTrue(3 < cauHinh.getIdcauhinh()); 
        Assert.assertEquals(4, st.getListCauHinh().size()); 
 
        Date date=Date.valueOf("2020-07-01");
        CauHinh c = st.getCauHinh(cauHinh.getIdcauhinh());
        Assert.assertEquals(1, c.getIdcauhinh());
        Assert.assertEquals((long) 15.0,(long) c.getChiSoMuc1());
        Assert.assertEquals((long) 20.0,(long) c.getChiSoMuc2());
        Assert.assertEquals((long) 25.0, (long) c.getChiSoMuc3());
        Assert.assertEquals((long) 7500.0, (long) c.getMuc1());
        Assert.assertEquals((long) 8000.0, (long) c.getMuc2());
        Assert.assertEquals((long) 8500.0, (long) c.getMuc3());
        Assert.assertEquals((long) 9000.0, (long) c.getMuc4());
        Assert.assertEquals(date, c.getNgayApDung());
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            con.rollback();
            con.setAutoCommit(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    return;
    }
}
