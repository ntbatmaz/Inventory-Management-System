/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nevzat_taha_batmaz_hw2;

/**
 *
 * @author Taha
 */
public class inventory {
    list ilk = null;
    list son = null;
    // List için class oluşturuldu
    public class list{
    int cntl;
    String namel,vall,typel;
    list next,prev;
    list(String namel,String typel,String vall,int cntl){
    this.cntl = cntl;
    this.namel = namel;
    this.typel= typel;
    this.vall = vall;
    this.next=null;
    this.prev=null;
    
    }
}
   // Add işlemleri
    
    
    public void addResistor(String val, Integer cnt) {
        String a = "Resistor";
        Device abc = new Device(a,null,val,cnt);
        abc.setValue();
        abc.setCount();
        abc.setName();
        list o = new list(abc.getName(),null,abc.getValue(),abc.getCount());
        list deneme =ilk;
       boolean asd=false;
       while(deneme != null){
           if(deneme.vall ==val){
               deneme.cntl += cnt;
               asd=true;
           }
           deneme = deneme.next;
       }
       if(asd==false){
        if(ilk==null){
           ilk = o;
           son = o;
           
       }else{
           ilk.prev = o;
           o.next = ilk;
           ilk =o;
            
       }
      
       }
    }

    
    public void addCapacitor(String val, String typ, Integer cnt) {
         String a = "Capacitor";
        Device abc = new Device(a,typ,val,cnt); 
        abc.setName();
        abc.setCount();
        abc.setValue();
        abc.setType();
        list o = new list(abc.getName(),abc.getType(),abc.getValue(),abc.getCount());
        list deneme = ilk;
       boolean asd=false;
       while(deneme != null){
            
           if(deneme.vall ==val && deneme.typel== typ){
                
               deneme.cntl += cnt;
               asd=true;
           }
           deneme = deneme.next;
       }
       if(asd==false){
            
        if(ilk==null){
             
           ilk = o;
           son = o;
        }    
       else{
           son.next = o;
           o.prev = son;
           son = o; 
       }
       }
       }
    
    
    
    public void addInductor(String val, Integer cnt) {
        String a = "Inductor";
        Device abc = new Device(a,null,val,cnt); 
        abc.setName();
        abc.setCount();
        abc.setValue();
        abc.setType();
        list o = new list(abc.getName(),abc.getType(),abc.getValue(),abc.getCount());
        list deneme = ilk;
       boolean asd=false;
       while(deneme != null){
           if(deneme.vall ==val){
               deneme.cntl += cnt;
               asd=true;
           }
           deneme = deneme.next;
       }
       if(asd==false){
        if(ilk==null){
           ilk = o;
           son = o;
        }    
       else{
     
            
           
           son.next = o;
           o.prev = son;
           son = o; 
       }
       }
    }

    
    public void addTransistor(String typ, Integer cnt) {
        String a = "Transistor";
        Device abc = new Device (a,typ,null,cnt);
        abc.setName();
        abc.setCount();
        abc.setValue();
        abc.setType();
        list o = new list(abc.getName(),abc.getType(),abc.getValue(),abc.getCount());
         list deneme = ilk;
         boolean asd=false;
       while(deneme != null){
           if(deneme.typel ==typ){
               deneme.cntl += cnt;
               asd=true;
           }
           deneme = deneme.next;
       }
       if(asd==false){
        if(ilk==null){
           ilk = o;
           son = o;
           
       }else{
           son.next = o;
           o.prev = son;
           son = o;
           
       }
       }
    }
// Delete işlemleri
    
    public int deleteResistor(String val, Integer cnt) {
       list deneme = ilk; 
       while(deneme != null){
           if(deneme.vall ==val && cnt<deneme.cntl)
           {
               
               deneme.cntl -= cnt;
           }else if(deneme.vall ==val && cnt>=deneme.cntl){
               System.out.println(deneme.cntl);
               int remain = deneme.cntl - cnt ;
               System.out.println("Resistor Delete işlemi için girdiğiniz eleman sayısı envanterdeki eleman sayısına eşit ya da daha büyük." + "Remain = " + remain);
               return -1;
           

           }
           deneme = deneme.next;
       }
     return 0;
    }

   
    public int deleteCapacitor(String val, String typ, Integer cnt) {
        
       list deneme = ilk; 
        
       while(deneme != null){
           if(deneme.vall ==val && cnt<deneme.cntl && deneme.typel==typ){
               deneme.cntl -= cnt;
           }else if(deneme.vall ==val && cnt>=deneme.cntl && deneme.typel==typ)
           {
               int remain = deneme.cntl - cnt ;
               System.out.println("Capacitor Delete işlemi için girdiğiniz eleman sayısı envanterdeki eleman sayısına eşit ya da daha büyük." + "Remain = " + remain);
               return -1;
               
           }
           deneme = deneme.next;
       }
     return 0;
    }

   
    public int deleteInductor(String val, Integer cnt) {
        list deneme = ilk; 
       while(deneme != null){
           if(deneme.vall ==val && cnt<deneme.cntl){
               deneme.cntl = deneme.cntl - cnt;
           }else if(deneme.vall ==val && cnt>=deneme.cntl){
               int remain = deneme.cntl - cnt ;
               System.out.println("Inductor Delete işlemi için girdiğiniz eleman sayısı envanterdeki eleman sayısına eşit ya da daha büyük." + "Remain = " + remain);
               return -1;

           }
           deneme = deneme.next;
       }
     return 0;
    }

    
    public int deleteTransistor(String typ, Integer cnt) {
       list deneme = ilk; 
       while(deneme != null){
           if(deneme.typel ==typ && cnt<deneme.cntl){
               deneme.cntl -= cnt;
           }else if(deneme.typel ==typ && cnt>=deneme.cntl){
              
              int remain = deneme.cntl - cnt ;
              System.out.println("Transistor Delete işlemi için girdiğiniz eleman sayısı envanterdeki eleman sayısına eşit ya da daha büyük." + "Remain = " + remain);
              return -1;

           }
           deneme = deneme.next;
       }
     return 0;
    }
 // yazdırma işlemleri
    
    public void printInventory() {
        list abc = ilk;
        list cde = ilk;
        list efg = ilk;
        list ntb = ilk;
     
      while(abc!=null){
           if(abc.namel=="Resistor"){
           System.out.println(abc.namel + " " + abc.typel + " " + abc.vall + " Ohm " + abc.cntl + " adet ");
           }
           abc = abc.next;
           } 
       while(cde!=null){
           if(cde.namel=="Capacitor"){
           System.out.println(cde.namel + " " + cde.typel + " " + cde.vall + " Farad " + cde.cntl + " adet ");
           
           }
           cde = cde.next;
           }
       while(efg!=null){
           if(efg.namel=="Inductor"){
           System.out.println(efg.namel + " " + efg.typel + " " + efg.vall + " Henry " + efg.cntl + " adet ") ;
           
           }
           efg = efg.next;
           }
       while(ntb!=null){
            if(ntb.namel=="Transistor"){
           System.out.println(ntb .namel + " " + ntb .typel + " " + ntb .vall + " " + ntb .cntl + " adet ");
            
           }
           ntb = ntb.next;
           
       }
    }
    
}
