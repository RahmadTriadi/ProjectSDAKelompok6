/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata;
/**
 *
 * @author junaidy
 */
public class Simpedes {
    String namaPenabung;
    double tabungan;
    public Simpedes(){
        
    }
    
    public double getTabungan(){
        return this.tabungan;
    }

    public void setTabungan(double tabungan) {
        this.tabungan = tabungan;
    }

    public void setNamaPenabung(String namaPenabung) {
        this.namaPenabung = namaPenabung;
    }
    public void ambilTabungan(double nominal){
        this.tabungan=this.tabungan-nominal;
    }
    public String getNamaPenabung(){
        return this.namaPenabung;
    }
    public void addBunga(double bunga){
        //bunga dalam persen;
        double bu=(bunga/100.0)*this.tabungan;
        
        this.tabungan=this.tabungan+bu;
    }
    public void potongAdministrasi(double potongan){
        double pot=(potongan/100.0)*this.tabungan;
        this.tabungan=this.tabungan-pot;
    }
    
    
}
