/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.linkedlist;

import java.awt.List;
import strukturdata.antrian_bank.tool.Antrian;

/**
 *
 * @author kantor-linux
 */
class Kereta{
    Antrian antrianTeller;
    int data;
    Kereta gerbong;
    public Kereta(){
        
    }
    public Kereta(int data){
        this.data=data;
    }

    public Antrian getAntrianTeller() {
        return antrianTeller;
    }

    public void setAntrianTeller(Antrian antrianTeller) {
        this.antrianTeller = antrianTeller;
    }

    

    
}
public class LatihanList {
    static int dataCari=0;
    static Kereta kereta=null;
    public LatihanList(){
        
    }
    public static void insertKeretaAwal(int data){
        Kereta keretaSementara = new Kereta(data);
        if(kereta == null) {
            kereta = keretaSementara;
        }
        else {
            keretaSementara.gerbong = kereta;
            kereta = keretaSementara;           
        }
    }
    public static void insertKeretaAwal(int data, Antrian antri){
        Kereta keretaSementara = new Kereta(data);
        keretaSementara.setAntrianTeller(antri);
        if(kereta == null) {
            kereta = keretaSementara;
        }
        else {
            keretaSementara.gerbong = kereta;
            kereta = keretaSementara;           
        }
    }
    public static void cetakKereta(){
        System.out.println("Kereta keretaku");
        Kereta k = LatihanList.kereta;
        while( k!= null) {
            System.out.print(k.data + "->");
            
            k = k.gerbong;
        }
        System.out.println("");
    }
    public static void cetakAntrianTeller(){
        System.out.println("Kereta keretaku");
        Kereta k = LatihanList.kereta;
        while( k!= null) {
            System.out.print(k.getAntrianTeller().getNo_urut() + " "+                   
                    k.getAntrianTeller().getWaktu()+" point-> "+k.getAntrianTeller().getPoint()+" => ");
            
            k = k.gerbong;
        }
        System.out.println("");
    }
    
    public static void insertKeretaAkhir(int data){
        
        Kereta keretaSementara=new Kereta(data);
        if(kereta==null){
            kereta=keretaSementara;                    
        }else{
            
            Kereta gerbongBaru=kereta;
            while(gerbongBaru.gerbong!=null){
                gerbongBaru=gerbongBaru.gerbong;
            }
            gerbongBaru.gerbong=keretaSementara;
        }
    }
    
    public static void deleteKeretaAwal(){
         if(kereta==null){
             System.out.println("Kereta masih kosong tidak bisa dihapus");
         }else{
             System.out.println("Yang di ambil: "+kereta.data);
             dataCari=kereta.data;
             Kereta k=kereta.gerbong;
             kereta=k;
             
         }
     }
     public static int dataYangdiCari(){
         return dataCari;
     }
     public static void deleteKeretaAkhir(){
         
         if(kereta==null){
             System.out.println("Kereta masih kosong tidak bisa dihapus");
         }else{
            Kereta k=kereta;
            while(k.gerbong.gerbong!=null){         
                k=k.gerbong;
            }
            k.gerbong=null;
            
         }
     }
     
    
     public static Object[] cariPosisiKereta(int cari){
         System.out.println("---------- Cari Posisi Kereta ----------");
         Object object[]=new Object[2];         
         if(kereta==null){
             System.out.println("Tidak dapat dilakukan pencarian, kereta kosong");
         }else{
             int nomor=1;
             Kereta k=kereta;
             while(k.gerbong!=null){
                 if(k.data==cari){                    
                     object[0]=nomor;
                     object[1]=cari;                     
                 }
                 k=k.gerbong;
                 nomor++;
             }
         }         
         return object;
     }
     public static void cetakHasilPencarian(Object [] cari){
         System.out.println("Data yang dicari diposisi ke "+cari[0]+" bernilai: "+cari[1]);
     }
     public static void menggantiKereta(int yangdiganti, int pengganti){
         System.out.println("---------- Mengganti kereta ----------");
         if(kereta==null){
             System.out.println("Tidak dapat dilakukan penggatian, kereta kosong");
         }else{
             Kereta k=kereta;
             while(k.gerbong!=null){
                 if(k.data==yangdiganti){
                     k.data=pengganti;
                 }
                 k=k.gerbong;             
             }
         }      
     }
     public static int[] cariPrioritas(){
         int max=0;
         int no_urut=0;
         if(kereta==null){
             //System.out.println("Tidak dapat mencari prioritas, kereta kosong");
         }else{             //Kereta sementara=new Kereta(yangdicari);
             
             if(kereta.gerbong!=null){
             Kereta k=kereta;
             max=k.gerbong.getAntrianTeller().getPoint();
             no_urut=k.gerbong.getAntrianTeller().getNo_urut();
             while(k.gerbong!=null){
                 System.out.println(max+" = "+k.gerbong.getAntrianTeller().getPoint());
                 if(k.gerbong.getAntrianTeller().getPoint()<max){
                     max=k.gerbong.getAntrianTeller().getPoint();
                     no_urut=k.gerbong.getAntrianTeller().getNo_urut();
                 }
                 k=k.gerbong;
             }
             System.out.println("Nilai terakhir: "+kereta.getAntrianTeller().getPoint());
             if(kereta.getAntrianTeller().getPoint()<max){
                 max=kereta.getAntrianTeller().getPoint();
                 no_urut=kereta.getAntrianTeller().getNo_urut();
             }
             System.out.println("max: "+max+" no urut "+no_urut);
             }else{
                 max=kereta.getAntrianTeller().getPoint();
                 no_urut=kereta.getAntrianTeller().getNo_urut();
             }
             
         }   
         return new int[]{max,no_urut};
     }
     public static void deleteKeretaPrioritas(int prioritas){
         System.out.println("---------- Menghapus antrian kereta yang dicari ----------");
         if(kereta==null){
             System.out.println("Tidak dapat dilakukan penggantian, kereta kosong");
         }else{
             //Kereta sementara=new Kereta(yangdicari);
             if(kereta.gerbong!=null){
                 Kereta k=kereta;
             while(k.gerbong.getAntrianTeller().getPoint() != prioritas && k.gerbong.gerbong != null) {
                k=k.gerbong;
            }
            if(k.gerbong.getAntrianTeller().getPoint() != prioritas) {
                //System.out.println("Data yang dicari tidak ditemukan");
                Kereta kk=kereta.gerbong;
                if(kereta.getAntrianTeller().getPoint()==prioritas){
                    kereta=kk;
                }
            }
            else{                
                k.gerbong=k.gerbong.gerbong;
            }
             }else{
                 deleteKeretaAwal();
             }
             
         }      
     }
     public static void deleteKeretaYangdiCari(int yangdicari){
         System.out.println("---------- Menghapus kereta yand dicari ----------");
         if(kereta==null){
             System.out.println("Tidak dapat dilakukan penggatian, kereta kosong");
         }else{
             //Kereta sementara=new Kereta(yangdicari);
             Kereta k=kereta;
             while(k.gerbong.data != yangdicari && k.gerbong.gerbong != null) {
                k=k.gerbong;
            }
            if(k.gerbong.data != yangdicari) {
                System.out.println("Data yang dicari tidak ditemukan");
            }
            else{                
                k.gerbong=k.gerbong.gerbong;
            }
         }      
     }
     
    public static void main(String arg[]){
        LatihanList.insertKeretaAwal(30);
        LatihanList.insertKeretaAwal(610);
        LatihanList.insertKeretaAwal(640);
        LatihanList.insertKeretaAwal(602);
        LatihanList.insertKeretaAwal(601);
        LatihanList.insertKeretaAwal(60);
        LatihanList.insertKeretaAwal(50);
        LatihanList.insertKeretaAkhir(89);
        LatihanList.cetakKereta();
        LatihanList.deleteKeretaAwal();
        LatihanList.cetakKereta();
        //LatihanList.deleteKeretaAkhir();
        Object o[]=LatihanList.cariPosisiKereta(60);
        LatihanList.cetakHasilPencarian(o);
        LatihanList.menggantiKereta(601, 300);
        LatihanList.cetakKereta();
        LatihanList.deleteKeretaYangdiCari(50);
        LatihanList.cetakKereta();
    }
}
