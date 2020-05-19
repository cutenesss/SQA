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
public class DiaChi {
    private int idDiaChi;
    private int soNha;
    private String pho;
    private String phuong;
    private String quan;
    private String thanhpho;

    public DiaChi() {
    }
    
    public DiaChi(int idDiaChi) {
        this.idDiaChi = idDiaChi;
    }

    public DiaChi(int idDiaChi, int soNha, String pho, String phuong, String quan, String thanhpho) {
        this.idDiaChi = idDiaChi;
        this.soNha = soNha;
        this.pho = pho;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhpho = thanhpho;
    }

    public int getIdDiaChi() {
        return idDiaChi;
    }

    public void setIdDiaChi(int idDiaChi) {
        this.idDiaChi = idDiaChi;
    }

    public int getSoNha() {
        return soNha;
    }

    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }

    public String getPho() {
        return pho;
    }

    public void setPho(String pho) {
        this.pho = pho;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }

    @Override
    public String toString() {
        return "Số "+soNha+" - "+pho+" - "+phuong+" - "+quan+" - "+thanhpho; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
