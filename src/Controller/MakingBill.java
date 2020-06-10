/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Object.CauHinh;

/**
 *
 * @author cuteness
 */
public class MakingBill {
    public MakingBill() {
    }
    
    public static double tinh(CauHinh c, double a){
        if (a <= c.getChiSoMuc1()) return a * c.getMuc1();
        else if (a <= c.getChiSoMuc2() ) {
            double s = c.getChiSoMuc1()* c.getMuc1() + (a-c.getChiSoMuc1()) * c.getMuc2();
            return s;
        }
        else if (a <= c.getChiSoMuc3() ){
            double s = c.getChiSoMuc1()* c.getMuc1() + c.getChiSoMuc2() * c.getMuc2() + (a-c.getChiSoMuc3()) * c.getMuc3();
            return s;
        }
        else {
            double s = c.getChiSoMuc1()* c.getMuc1() + c.getChiSoMuc2() * c.getMuc2() + c.getChiSoMuc3() * c.getMuc3() + (a-c.getChiSoMuc3()) * c.getMuc4();
            return s;
        }
    }
}
