/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package strukturdata.linkedlist;

class Node{
        public String namaKelompok;
        public Node kelompok;
        public String[] anggota=new String[5];

    public String[] getAnggota() {
        return anggota;
    }

    public void setAnggota(String[] anggota) {
        this.anggota = anggota;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public void setNamaKelompok(String namaKelompok) {
        this.namaKelompok = namaKelompok;
    }
    
    public boolean getNamaAnggota(String cari){
        int n=0;
        boolean ketemu=false;
        while(n<this.getAnggota().length){
            if(this.getAnggota()[n].equalsIgnoreCase(cari)){
                ketemu=true;
            }
        }
        return ketemu;
    }
}
/**
 *
 * @author junaidy
 */
public class LinkedList {
    private Node head;
    public LinkedList(){
        
    }
    public void cetak(){
        Node now=head;
        System.out.println("ISI LINKEDLIST: ");
        while(now!=null){
            System.out.println("Nama Kelompok: "+now.namaKelompok);
            for(int i=0;i<now.getAnggota().length;i++){
                System.out.println("Nama Anggota");
                System.out.println("Anggota ke "+i+"=>"+now.getAnggota()[i]);
            }
            System.out.println("Akhir Kelompok: "+now.namaKelompok);
            now=now.kelompok;
        }
    }
    
    public void insertAwal(String namaKelompok, String [] anggota){
        Node newNode=new Node();
        newNode.namaKelompok=namaKelompok;
        newNode.setAnggota(anggota);
        newNode.kelompok=head;
        head=newNode;
        
    }
    public Node cariPosisiKelompok(String cari){
         System.out.println("---------- Cari Posisi Kereta ----------");
         Object object[]=new Object[2];   
         Node c=new Node();
         if(head==null){
             System.out.println("Tidak dapat dilakukan pencarian, kelompok kosong");
         }else{
             int nomor=1;
             Node k=head;
             while(k.kelompok!=null){
                 if(k.getNamaKelompok().equalsIgnoreCase(cari)){                    
                     object[0]=nomor;
                     object[1]=cari;                     
                     c=k.kelompok;
                     return c;
                 }
                 k=k.kelompok;
                 nomor++;
             }
         }         
         return null;
     }
    public void insertAkhir(String namaKelompok, String[]anggota){
        Node now=head;
        while(now!=null){
            if(now.kelompok==null){
                now.namaKelompok=namaKelompok;
                now.setAnggota(anggota);                
                //System.out.println("node data: ");
            }
            now=now.kelompok;
        }
    }
    
    private boolean isEmptyNode(){
        return (head==null);
    }
    
    public void firstTake(){
        if (!this.isEmptyNode()){
            Node tempnode = head;
            head = tempnode.kelompok;
            tempnode.kelompok = null;        
            System.out.println("gerbong diambil : " + tempnode.namaKelompok);
        }else {
            System.out.println("kereta kosong kok... ");
        }
    }
    
    public static void main(String args[]){
        LinkedList list=new LinkedList();
        String [] anggota1=new String[]{"Juki","Jumar","Pardi","Solikin","Rudi"};
        String [] anggota2=new String[]{"Rusdi","Pagal","Lasmari","Rebi","Arfan"};
        String [] anggota3=new String[]{"Warno","Sutaji","Miftakul","Luari","Sugeng"};
        String [] anggota4=new String[]{"Ladi","Wagimun","Ahmad","Ngasiyan","Hariono"};
        
        list.insertAwal("Kelas1", anggota4);
        list.insertAkhir("Kelas2", anggota1);
        list.insertAwal("Kelas3", anggota2);
        list.insertAkhir("Kelas4", anggota3);
        list.cetak();
//        list.insertAwal(21);
//        list.insertAwal(29);
//        list.insertAwal(23);
//        list.insertAwal(34);
//        
//        list.cetak();
//        list.firstTake();
//        list.insertAkhir(78);
       // list.cetak();
        
    }
}
