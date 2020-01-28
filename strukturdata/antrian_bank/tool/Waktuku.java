/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.antrian_bank.tool;
import java.io.Serializable;
/**
 *
 * @author junaidy
 */
public class Waktuku implements Cloneable, Serializable{
    int jam=0;
    int menit=0;
    int detik=0;
    public Waktuku(){
        
    }
    public Waktuku(int jam, int menit, int detik){
        this.jam=jam;
        this.menit=menit;
        this.detik=detik;
    }
    public String getTime(){
        String sjam=String.valueOf(jam);
        String smenit=String.valueOf(menit);
        String sdetik=String.valueOf(detik);
        
        if(menit<10){
            smenit="0"+smenit;
        }
        if(jam<10){
            sjam="0"+sjam;
        }
        if(detik<10){
            sdetik="0"+sdetik;
        }
        return sjam+":"+smenit+":"+sdetik;
    }
    public int getDetik() {
        return detik;
    }

    public void setDetik(int detik) {
        this.detik = detik;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public int getMenit() {
        return menit;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
		return super.clone();
    }
}
