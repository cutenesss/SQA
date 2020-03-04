/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Date;

/**
 *
 * @author Cuteness
 */
public class SoNuoc {
    private int idsoNuoc;
    private Date ngayBD;
    private double chiSoBD;
    private Date ngayKT;
    private double chiSoKT;

    public SoNuoc() {
    }

    public SoNuoc(int idsoNuoc, Date ngayBD, double chiSoBD, Date ngayKT, double chiSoKT) {
        this.idsoNuoc = idsoNuoc;
        this.ngayBD = ngayBD;
        this.chiSoBD = chiSoBD;
        this.ngayKT = ngayKT;
        this.chiSoKT = chiSoKT;
    }

    public int getIdsoNuoc() {
        return idsoNuoc;
    }

    public void setIdsoNuoc(int idsoNuoc) {
        this.idsoNuoc = idsoNuoc;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public double getChiSoBD() {
        return chiSoBD;
    }

    public void setChiSoBD(double chiSoBD) {
        this.chiSoBD = chiSoBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public double getChiSoKT() {
        return chiSoKT;
    }

    public void setChiSoKT(double chiSoKT) {
        this.chiSoKT = chiSoKT;
    }
    
    
}
