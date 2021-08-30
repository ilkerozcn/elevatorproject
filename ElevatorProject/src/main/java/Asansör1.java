
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ilker
 */
public class Asansör1 extends Thread {

    public static int kapasite = 10;
    public static int kat = 0;
    public static int hedef;
    public static int doluluk = 0;
    public static int[] içeri = new int[9];
    public static int kat0 = 0;
    public static int kat1 = 0;
    public static int kat2 = 0;
    public static int kat3 = 0;
    public static int kat4 = 0;
 
    public static BlockingQueue<Integer> kuyrukas1 = new ArrayBlockingQueue<>(11);
    public static Iterator<Integer> iterator = kuyrukas1.iterator();

    Asansör1() {
    }

    public static synchronized void doldur() throws InterruptedException {

        if (kat == 0) {
            while (doluluk < 10) {
                if (!gir.kuyrukgir.isEmpty()) {
                  kuyrukas1.put(gir.kuyrukgir.peek());
                doluluk++;
                kat0--;
                gir.kuyrukgir.remove(); 
                }
                else break;

            }
        }
        if (kat == 1) {
            while (doluluk < 10) {
                if (!çık.Kat1.isEmpty()) {
                kuyrukas1.put(çık.Kat1.peek());
                doluluk++;
                kat1--;
                çık.Kat1.remove();
                }
                else break;
            }
        }
        if (kat == 2) {
            while (doluluk < 10) {
                if (!çık.Kat2.isEmpty()) {
                    kuyrukas1.put(çık.Kat2.peek());
                doluluk++;
                kat2--;
                çık.Kat2.remove();
                }else break;
                
            }
        }
        if (kat == 3) {
            while (doluluk < 10) {
                if (!çık.Kat3.isEmpty()) {
                  kuyrukas1.put(çık.Kat3.peek());
                doluluk++;
                kat3--;
                çık.Kat3.remove();  
                }
                else break;
            }
        }
        if (kat == 4) {
            while (doluluk < 10) {
                if (!çık.Kat4.isEmpty()) {
                  kuyrukas1.put(çık.Kat4.peek());
                doluluk++;
                kat4--;
                çık.Kat4.remove(); 
                }
                else break;
            }
        }
    }

    public synchronized static void boşalt() throws InterruptedException {
        Iterator it = kuyrukas1.iterator();

        if (kat == 0 && hedef == 0) {
            while (it.hasNext()) {
                if (it.next().equals(0)) {

                    kuyrukas1.remove();
                    doluluk--;
                    hedef();
                }
            }
        }
        if (kat == 1 && hedef == 1) {
            while (it.hasNext()) {
                if (it.next().equals(1)) {

                    kuyrukas1.remove();
                    doluluk--;
                    kat1++;
                    hedef();
                }
            }
        }
        if (kat == 2 && hedef == 2) {
            while (it.hasNext()) {
                if (it.next().equals(2)) {

                    kuyrukas1.remove();
                    doluluk--;
                    kat2++;
                    hedef();
                }
            }
        }
        if (kat == 3 && hedef == 3) {
            while (it.hasNext()) {
                if (it.next().equals(3)) {

                    kuyrukas1.remove();
                    doluluk--;
                    kat3++;
                    hedef();
                }
            }
        }
        if (kat == 4 && hedef == 4) {
            while (it.hasNext()) {
                if (it.next().equals(4)) {

                    kuyrukas1.remove();

                    doluluk--;
                    kat4++;
                    hedef();
                }
            }
        }

    }

    public synchronized static void hedef() throws InterruptedException {
        doldur();
        if (kuyrukas1.isEmpty() ) {
            Asansör1.hedef = 0;

        } else {
            Asansör1.hedef = Asansör1.kuyrukas1.peek();
        }

    }

    public static void up() throws InterruptedException {
        if (Asansör1.hedef > Asansör1.kat) {
            Asansör1.kat++;
        }
    }

    public static void down() throws InterruptedException {
        if (Asansör1.hedef < Asansör1.kat) {
            Asansör1.kat--;
        }

    }

    public  void run() {
        while (true)
        try {
            Thread.sleep(200);
            hedef();

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Katlardaki insan sayısı: \n1. Kat:" + Asansör1.kat1 + "   2. Kat:" + Asansör1.kat2 + "   3. Kat:" + Asansör1.kat3 + "   4. Kat:" + Asansör1.kat4);
            System.out.println("Katlardaki çıkmak için sıra bekleyenlerin sayısı: \n0. Kat: " + gir.kuyrukgir.size() + "   1. Kat:" + çık.Kat1.size() + "   2. Kat:" + çık.Kat2.size() + "   3. Kat:" + çık.Kat3.size() + "   4. Kat:" + çık.Kat4.size());
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("----------------------------ASANSÖR1---------------------------------------------------");
            System.out.println("1. Asansörün İçindeki İnsanlar: " + Asansör1.kuyrukas1);
            System.out.println("1. Asansörün Bulunduğu Kat: " + Asansör1.kat);
            System.out.println("1. Asansörün Hedefi: " + Asansör1.hedef + ". kat");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("----------------------------ASANSÖR2---------------------------------------------------");
            if (Asansör2.kontrol == 0) {
                System.out.println("2. Asansör Çalışma durumu: Pasif");
            } else {
                System.out.println("2. Asansör Çalışma durumu: Aktif");
            }
            System.out.println("2. Asansörün İçindeki İnsanlar: " + Asansör2.kuyrukas2);
            System.out.println("2. Asansörün Bulunduğu Kat: " + Asansör2.kat);
            System.out.println("2. Asansörün Hedefi: " + Asansör2.hedef + ". kat");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("----------------------------ASANSÖR3---------------------------------------------------");
            if (Asansör2.kontrol == 0) {
                System.out.println("3. Asansör Çalışma durumu: Pasif");
            } else {
                System.out.println("3. Asansör Çalışma durumu: Aktif");
            }
            System.out.println("3. Asansörün İçindeki İnsanlar: " + Asansör3.kuyrukas3);
            System.out.println("3. Asansörün Bulunduğu Kat: " + Asansör3.kat);
            System.out.println("3. Asansörün Hedefi: " + Asansör3.hedef + ". kat");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("----------------------------ASANSÖR4---------------------------------------------------");
            if (Asansör2.kontrol == 0) {
                System.out.println("4. Asansör Çalışma durumu: Pasif");
            } else {
                System.out.println("4. Asansör Çalışma durumu: Aktif");
            }
            System.out.println("4. Asansörün İçindeki İnsanlar: " + Asansör4.kuyrukas4);
            System.out.println("4. Asansörün Bulunduğu Kat: " + Asansör4.kat);
            System.out.println("4. Asansörün Hedefi: " + Asansör4.hedef + ". kat");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("----------------------------ASANSÖR5---------------------------------------------------");
            if (Asansör2.kontrol == 0) {
                System.out.println("5. Asansör Çalışma durumu: Pasif");
            } else {
                System.out.println("5. Asansör Çalışma durumu: Aktif");
            }
            System.out.println("5. Asansörün İçindeki İnsanlar: " + Asansör5.kuyrukas5);
            System.out.println("5. Asansörün Bulunduğu Kat: " + Asansör5.kat);
            System.out.println("5. Asansörün Hedefi: " + Asansör5.hedef + ". kat");
            System.out.println("---------------------------------------------------------------------------");
            up();
            down();
            boşalt();

        } catch (InterruptedException e) {

        }

    }
}
