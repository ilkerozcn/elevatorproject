
import java.util.Iterator;
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
public class Asansör2 extends Thread {

    public static int kontrol;
    public static int kapasite = 10;
    public static int kat = 0;
    public static int hedef;
    public static int doluluk = 0;
    public static int[] içeri = new int[9];

    public static BlockingQueue<Integer> kuyrukas2 = new ArrayBlockingQueue<>(11);
    public static Iterator<Integer> iterator = kuyrukas2.iterator();

    Asansör2() {
    }

     public static synchronized void doldur() throws InterruptedException {

        if (kat == 0) {
            while (doluluk < 10) {
                if (!gir.kuyrukgir.isEmpty()) {
                  kuyrukas2.put(gir.kuyrukgir.peek());
                doluluk++;
                Asansör1.kat0--;
                gir.kuyrukgir.remove(); 
                }
                else break;

            }
        }
        if (kat == 1) {
            while (doluluk < 10) {
                if (!çık.Kat1.isEmpty()) {
                kuyrukas2.put(çık.Kat1.peek());
                doluluk++;
                Asansör1.kat1--;
                çık.Kat1.remove();
                }
                else break;
            }
        }
        if (kat == 2) {
            while (doluluk < 10) {
                if (!çık.Kat2.isEmpty()) {
                    kuyrukas2.put(çık.Kat2.peek());
                doluluk++;
                Asansör1.kat2--;
                çık.Kat2.remove();
                }
                else break;
            }
        }
        if (kat == 3) {
            while (doluluk < 10) {
                if (!çık.Kat3.isEmpty()) {
                  kuyrukas2.put(çık.Kat3.peek());
                doluluk++;
                Asansör1.kat3--;
                çık.Kat3.remove();  
                }
                else break;
            }
        }
        if (kat == 4) {
            while (doluluk < 10) {
                if (!çık.Kat4.isEmpty()) {
                  kuyrukas2.put(çık.Kat4.peek());
                doluluk++;
                Asansör1.kat4--;
                çık.Kat4.remove(); 
                }
                else break;
            }
        }
    }

    public static synchronized void boşalt() throws InterruptedException {
        Iterator it = kuyrukas2.iterator();

        if (kat == 0 && hedef == 0) {
            while (it.hasNext()) {
                if (it.next().equals(0)) {

                    kuyrukas2.remove();
                    doluluk--;

                    hedef();
                }
            }
        }
        if (kat == 1 && hedef == 1) {
            while (it.hasNext()) {
                if (it.next().equals(1)) {

                    kuyrukas2.remove();
                    doluluk--;
                    Asansör1.kat1++;
                    hedef();
                }
            }
        }
        if (kat == 2 && hedef == 2) {
            while (it.hasNext()) {
                if (it.next().equals(2)) {

                    kuyrukas2.remove();
                    doluluk--;
                    Asansör1.kat2++;
                    hedef();
                }
            }
        }
        if (kat == 3 && hedef == 3) {
            while (it.hasNext()) {
                if (it.next().equals(3)) {

                    kuyrukas2.remove();
                    doluluk--;
                    Asansör1.kat3++;
                    hedef();
                }
            }
        }
        if (kat == 4 && hedef == 4) {
            while (it.hasNext()) {
                if (it.next().equals(4)) {

                    kuyrukas2.remove();

                    doluluk--;
                    Asansör1.kat4++;
                    hedef();
                }
            }
        }

    }

    public static synchronized void hedef() throws InterruptedException {
        doldur();
        if (kuyrukas2.isEmpty() ) {

            Asansör2.hedef = 0;

        } else {
            Asansör2.hedef = kuyrukas2.peek();
        }

    }

    public static void up() throws InterruptedException {
        if (Asansör2.hedef > Asansör2.kat) {
            Asansör2.kat++;
        }
    }

    public static void down() throws InterruptedException {
        if (Asansör2.hedef < Asansör2.kat) {
            Asansör2.kat--;
        }

    }

    public static int getKontrol() {
        return kontrol;
    }

    public static void setKontrol(int kontrol) {
        Asansör2.kontrol = kontrol;
    }

    public  void run() {

        while (true) {
            if (gir.kuyrukgir.size() > 20 || çık.Kat1.size() > 20 || çık.Kat2.size() > 20 || çık.Kat3.size() > 20 || çık.Kat4.size() > 20 || kuyrukas2.size() > 0) {
                try {
                        if(Asansör2.kontrol==0){
                        kuyrukas2.clear();
                        Asansör2.doluluk=0;}
                    Thread.sleep(200);
                    hedef();

                    up();
                    down();
                    boşalt();
                    

                    //  System.out.println("Katlardaki insan sayısı: \n1. Kat:" + Asansör1.kat1 + "   2. Kat:" + Asansör1.kat2 + "   3. Kat:" + Asansör1.kat3 + "   4. Kat:" + Asansör1.kat4);
                } catch (InterruptedException e) {

                
            }
           
            }}}
}
