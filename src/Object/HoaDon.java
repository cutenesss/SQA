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
public class HoaDon {

    private int idHoaDon;
    private HoGiaDinh hoGD;
    private CauHinh cauHinh;
    private SoNuoc soNuoc;
    private Date ngayThanhLap;

    public HoaDon() {
    }
    
    public HoaDon(int idHoaDon, HoGiaDinh hoGD, CauHinh cauHinh, SoNuoc soNuoc, Date ngayThanhLap) {
        this.idHoaDon = idHoaDon;
        this.hoGD = hoGD;
        this.cauHinh = cauHinh;
        this.soNuoc = soNuoc;
        this.ngayThanhLap = ngayThanhLap;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public HoGiaDinh getHoGD() {
        return hoGD;
    }

    public void setHoGD(HoGiaDinh hoGD) {
        this.hoGD = hoGD;
    }

    public CauHinh getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(CauHinh cauHinh) {
        this.cauHinh = cauHinh;
    }

    public SoNuoc getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(SoNuoc soNuoc) {
        this.soNuoc = soNuoc;
    }

    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }
    
    public Object[] getObject(int order){
        return new Object[]{ 
            order, this.getHoGD(), this.getCauHinh(), this.getSoNuoc(), this.getNgayThanhLap()
        };
    }
}
