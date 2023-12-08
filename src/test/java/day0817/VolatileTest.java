package day0817;

public class VolatileTest implements Runnable {

    public static volatile Object AA = new Object();

    private Object bb ;

    public VolatileTest(Object bb) {
        this.bb = bb;
    }

    public static void main(String[] args) {

        Object BB = AA;
        Object CC = BB;

        System.out.println("BB: " + Integer.toHexString(BB.hashCode()));
        System.out.println("AA: " + Integer.toHexString(AA.hashCode()));
        System.out.println("CC: " + Integer.toHexString(CC.hashCode()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread nThread = new Thread(new VolatileTest(new Object()));
        nThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            nThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("BB: " + Integer.toHexString(BB.hashCode()));
        System.out.println("AA: " + Integer.toHexString(AA.hashCode()));
        System.out.println("CC: " + Integer.toHexString(CC.hashCode()));
    }




    @Override
    public void run() {

        this.AA =  this.bb;
    }
}
