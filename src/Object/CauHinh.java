/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Cuteness
 */
public class CauHinh {
    private int idcauhinh;
    private double muc1;
    private double muc2;
    private double muc3;
    private double muc4;
    private double chiSoMuc1;
    private double chiSoMuc2;
    private double chiSoMuc3;
    private Date ngayApDung;

    public Date getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(Date ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public CauHinh(){
    }

    public CauHinh(int idcauhinh, double muc1, double muc2, double muc3, double muc4, double chiSoMuc1, double chiSoMuc2, double chiSoMuc3, Date ngayApDung) {
        this.idcauhinh = idcauhinh;
        this.muc1 = muc1;
        this.muc2 = muc2;
        this.muc3 = muc3;
        this.muc4 = muc4;
        this.chiSoMuc1 = chiSoMuc1;
        this.chiSoMuc2 = chiSoMuc2;
        this.chiSoMuc3 = chiSoMuc3;
        this.ngayApDung = ngayApDung;
    }

    public CauHinh(int idcauhinh) {
        this.idcauhinh = idcauhinh;
    }

    public int getIdcauhinh() {
        return idcauhinh;
    }

    public void setIdcauhinh(int idcauhinh) {
        this.idcauhinh = idcauhinh;
    }

    public double getMuc1() {
        return muc1;
    }

    public void setMuc1(double muc1) {
        this.muc1 = muc1;
    }

    public double getMuc2() {
        return muc2;
    }

    public void setMuc2(double muc2) {
        this.muc2 = muc2;
    }

    public double getMuc3() {
        return muc3;
    }

    public void setMuc3(double muc3) {
        this.muc3 = muc3;
    }

    public double getMuc4() {
        return muc4;
    }

    public void setMuc4(double muc4) {
        this.muc4 = muc4;
    }

    public double getChiSoMuc1() {
        return chiSoMuc1;
    }

    public void setChiSoMuc1(double chiSoMuc1) {
        this.chiSoMuc1 = chiSoMuc1;
    }

    public double getChiSoMuc2() {
        return chiSoMuc2;
    }

    public void setChiSoMuc2(double chiSoMuc2) {
        this.chiSoMuc2 = chiSoMuc2;
    }

    public double getChiSoMuc3() {
        return chiSoMuc3;
    }

    public void setChiSoMuc3(double chiSoMuc3) {
        this.chiSoMuc3 = chiSoMuc3;
    }
    
    public Object[] getObject(int order){
        String pattern = "dd-MM-YYYY";
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String ngay = simpleDateFormat.format(this.getNgayApDung());
        return new Object[]{ 
            order, ngay
        };
    }
}
