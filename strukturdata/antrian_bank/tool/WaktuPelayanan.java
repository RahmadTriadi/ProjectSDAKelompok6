/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.antrian_bank.tool;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kantor-linux
 */
public class WaktuPelayanan implements Runnable{
    StopWatchku stop;
    Thread tt;
    JTable table;
    DefaultTableModel m;
    int noTeller;
    int waktuHabis;
    public  boolean kendali=true;
    public WaktuPelayanan(StopWatchku stopWatch, JTable table, int noTeller, int waktuHabis, boolean cek){        
        this.stop=stopWatch;
        tt=new Thread(this);
        tt.start();   
        this.table=table;
        this.m=(DefaultTableModel) table.getModel();
        this.noTeller=noTeller;
       // System.out.println("no teller "+this.noTeller);
        this.waktuHabis=waktuHabis;
        kendali=cek;
    }
    
    public void destroy(){
        tt.stop();
        stop.getTimer().stop();        
    }
    public void paused(){
        kendali=false;
    }
    public void resume(){
        
        kendali=true;
    }
    @Override
    public void run() {
        while(kendali){
            try {
                
                m.setValueAt(""+stop.getJam()+":"+stop.getMenit()+":"+stop.getDetik(), noTeller-1, 3);
                m.setValueAt("Sibuk", noTeller-1, 4);
                if(this.waktuHabis==stop.getDetik()){
                    //System.out.println("WAKTU HABIS ="+this.waktuHabis+" STOP "+ stop.getDetik());
                    m.setValueAt("", noTeller-1, 1);
                    m.setValueAt("", noTeller-1, 2);
                    m.setValueAt("", noTeller-1, 3);
                    m.setValueAt("", noTeller-1, 4);
                    this.paused();
                }
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                this.kendali=false;
            }
        }
    }
}
