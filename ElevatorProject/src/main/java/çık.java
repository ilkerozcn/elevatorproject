
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ilker
 */
public class çık extends Thread{
    int kont=0;
   public static BlockingQueue<Integer> Kat1=new ArrayBlockingQueue<>(500);
   public static BlockingQueue<Integer> Kat2=new ArrayBlockingQueue<>(500);
   public static BlockingQueue<Integer> Kat3=new ArrayBlockingQueue<>(500);
   public static BlockingQueue<Integer> Kat4=new ArrayBlockingQueue<>(500);
    int kisiSayısı() throws InterruptedException{
    Random rand = new Random();
    int x= rand.nextInt(5)+1;
     //   System.out.println("Giren kisi: "+x);
    return x;
    }
    int katNo() throws InterruptedException{
    Random rand = new Random();
    int x= rand.nextInt(4)+1;
    //    System.out.println("Giren kisi: "+x);
    return x;
    }
    void cıkışKuyruğu() throws InterruptedException{
    int kat,kisi;
    kat=katNo();kisi=kisiSayısı();
    for(int i=0;i<kisi;i++){   
    if(kat==1 && Asansör1.kat1>=kisi){  
        Kat1.put(0);
      
                kont=1;
    }
      if(kat==2 && Asansör1.kat2>=kisi){
        Kat2.put(0);
      
       kont=2;
      }
        if(kat==3 && Asansör1.kat3>=kisi){
        Kat3.put(0);
         
         kont=3;
        }
          if(kat==4 && Asansör1.kat4>=kisi){
        Kat4.put(0);
         
        kont=4;
          }
    }
    if(kont==1){
    System.out.println("Kat 1 çıkış için "+kisi+" kişi kuyruğa girdi");
    kont=0;
    }
        if(kont==2){
    System.out.println("Kat 2 çıkış için "+kisi+" kişi kuyruğa girdi");
    kont=0;
    }
            if(kont==3){
    System.out.println("Kat 3 çıkış için "+kisi+" kişi kuyruğa girdi");
    kont=0;
    }
                if(kont==4){
    System.out.println("Kat 4 çıkış için "+kisi+" kişi kuyruğa girdi");
    kont=0;
    }
    }
    
    
     public void run()  
    {    while(true)
        try {Thread.sleep(1000);
            cıkışKuyruğu();
            
        } catch (InterruptedException e) {
            System.out.println ("Exception is caught");
        }
    }    
}
