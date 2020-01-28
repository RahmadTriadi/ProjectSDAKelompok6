/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.antrian_bank.tool;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import strukturdata.linkedlist.LatihanList;

/**
 *
 * @author juna
 */
public class RunAntrianTeller implements Runnable{
    private final Thread tt;
    JTable table2, table3;
    public boolean kendaliRun=true;
    public RunAntrianTeller(JTable table2,JTable table3){
        tt=new Thread(this);
        tt.start();
        this.table2=table2;
        this.table3=table3;
    }

    @Override
    public void run() {
        while(kendaliRun){
            
            try {
                WaktuPelayanan w[]=new WaktuPelayanan[table3.getRowCount()];
                int j=0;
                while(j<table3.getRowCount()){
                    if(table3.getValueAt(j, 4).toString().equalsIgnoreCase("")){
                    String no_antrian="";
                    String waktu_antrian="0";
                    String status="";
                int [] value=LatihanList.cariPrioritas();
                DefaultTableModel m=(DefaultTableModel)table2.getModel();
                int i=0;
                while(i<m.getRowCount()){
                //for(int i=0;i<m.getRowCount();i++){
                    
                    //String tel=m3.getValueAt(i, 0).toString() ;
                    if(value[1]==Integer.parseInt(
                        m.getValueAt(i, 0).toString())){
                        no_antrian=m.getValueAt(i, 0).toString();
                        no_antrian=m.getValueAt(i, 0).toString();
                        waktu_antrian=m.getValueAt(i, 2).toString();
                        status=m.getValueAt(i, 1).toString();
                        DefaultTableModel m3=(DefaultTableModel)table3.getModel();
                        //Thread t=new Thread();
                        //t.start();
                        String html="<html><body><font size=3 color=#ff0000><b>No antrian "+no_antrian+
                                " ditunggu </b></font></body></html>";
                        m3.setValueAt(html
                                , j, 1);
                        //t.sleep(500);                        
                        m3.setValueAt("No "+no_antrian+" status "+status, j, 1);
                        m3.setValueAt(waktu_antrian, j, 2);                        
                        m.removeRow(i);
                        LatihanList.deleteKeretaPrioritas(value[0]);
                        LatihanList.cetakAntrianTeller();
                    }
                    i++;
                }
                StopWatchku sto=new StopWatchku(new Waktuku(0, 0, 0));
                w[j]=new WaktuPelayanan(sto,
                        table3, 
                        Integer.parseInt(table3.getValueAt(j, 0).toString()), 
                        Integer.parseInt(waktu_antrian),true);
                    }
                j++;
                    
                }
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                //kendaliRun=false;
                
            }
        }
    }
    
}
