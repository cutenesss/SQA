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
public class HoaDon {

    private int idHoaDon;
    private HoGiaDinh hoGD;
    private CauHinh cauHinh;
    private SoNuoc soNuoc;
    private Date ngayThanhToan;

    public HoaDon() {
    }
    
    public HoaDon(int idHoaDon, HoGiaDinh hoGD, CauHinh cauHinh, SoNuoc soNuoc, Date ngayThanhToan) {
        this.idHoaDon = idHoaDon;
        this.hoGD = hoGD;
        this.cauHinh = cauHinh;
        this.soNuoc = soNuoc;
        this.ngayThanhToan = ngayThanhToan;
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

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
    
    public Object[] getObject(int order, double bill){
        String pattern = "dd-MM-YYYY";
        DateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String bd = simpleDateFormat.format(this.getSoNuoc().getNgayBD());
        String kt = simpleDateFormat.format(this.getSoNuoc().getNgayKT());
        return new Object[]{ 
            order, bd, kt, this.getSoNuoc().getChiSoBD(), this.getSoNuoc().getChiSoKT(), bill, this.getNgayThanhToan()
        };
    }
}
