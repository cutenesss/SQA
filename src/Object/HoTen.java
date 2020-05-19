/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author DELL
 */
public class HoTen {
    private int idHoTen;
    private String ho;
    private String ten;

    public HoTen() {
    }
    
    public HoTen(int idHoTen, String ho, String ten) {
        this.idHoTen = idHoTen;
        this.ho = ho;
        this.ten = ten;
    }

    public int getIdHoTen() {
        return idHoTen;
    }

    public void setIdHoTen(int idHoTen) {
        this.idHoTen = idHoTen;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ho+" "+ten; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
