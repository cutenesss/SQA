/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Cuteness
 */
public class HoGiaDinh {
    private int idHoGD;
    private HoTen tenChuHo;
    private DiaChi diaChi;
    private String sdt;
    private String maHoGD;
    private String email;

    public HoGiaDinh() {
    }

    public HoGiaDinh(int idHoGD, HoTen tenChuHo, DiaChi diaChi, String sdt, String maHoGD, String email) {
        this.idHoGD = idHoGD;
        this.tenChuHo = tenChuHo;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.maHoGD = maHoGD;
        this.email = email;
    }
    
    public int getIdHoGD() {
        return idHoGD;
    }

    public void setIdHoGD(int idHoGD) {
        this.idHoGD = idHoGD;
    }

    public HoTen getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(HoTen tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaHoGD() {
        return maHoGD;
    }

    public void setMaHoGD(String maHoGD) {
        this.maHoGD = maHoGD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Object[] getObject1(int order){
        return new Object[]{ 
            order, this.getTenChuHo(), this.getDiaChi(), this.getSdt(), this.getMaHoGD(),this.getEmail()
        };
    }
}
