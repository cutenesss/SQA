/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MakingBillTest;

import Controller.MakingBill;
import Object.CauHinh;
import java.sql.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cuteness
 */
public class MakingBillTest {
    public MakingBillTest() {
    }
    
    @Test
    public void testTinh1(){
        Date date = Date.valueOf("2018-02-01");
        CauHinh c = new CauHinh(1, 4000, 5000, 6000, 7000, 5, 10, 15, date);
        double bill = MakingBill.tinh(c, 0);
        Assert.assertEquals((long) 0,(long) bill);
    }
    
    @Test
    public void testTinh2(){
        Date date = Date.valueOf("2018-02-01");
        CauHinh c = new CauHinh(1, 4000, 5000, 6000, 7000, 5, 10, 15, date);
        double bill = MakingBill.tinh(c, 3);
        Assert.assertEquals((long) 12000.0,(long) bill);
    }
    
    @Test
    public void testTinh3(){
        Date date = Date.valueOf("2018-02-01");
        CauHinh c = new CauHinh(1, 4000, 5000, 6000, 7000, 5, 10, 15, date);
        double bill = MakingBill.tinh(c, 8);
        Assert.assertEquals((long) 35000.0,(long) bill);
    }
    
    @Test
    public void testTinh4(){
        Date date = Date.valueOf("2018-02-01");
        CauHinh c = new CauHinh(1, 4000, 5000, 6000, 7000, 5, 10, 15, date);
        double bill = MakingBill.tinh(c, 12);
        Assert.assertEquals((long) 52000.0,(long) bill);}
    
    @Test
    public void testTinh5(){
        Date date = Date.valueOf("2018-02-01");
        CauHinh c = new CauHinh(1, 4000, 5000, 6000, 7000, 5, 10, 15, date);
        double bill = MakingBill.tinh(c, 20);
        Assert.assertEquals((long) 195000.0,(long) bill);
    }
}
