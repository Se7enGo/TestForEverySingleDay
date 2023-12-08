package day0605;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

//@RunWith(SpringJUnit4ClassRunner.class)
public class TestForPermutationAndCombination {


    private volatile Thread runner;

    private static final long runnerOffset;

    private static final Unsafe UNSAFE;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            UNSAFE = (Unsafe) f.get(null);
            //UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = TestForPermutationAndCombination.class;
            runnerOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("runner"));

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    //@Test
    public void RepeatableCombination(){

//        int m = 10;
//        BigInteger n = BigInteger.ONE.multiply(BigInteger.TEN).divide(BigInteger.ONE.add(BigInteger.ONE));
//        BigInteger s =  BigInteger.ONE;

        int m = 5;
        int n =10;
        final Long s =new Long(1);
        //输出从n个数中可重复抽取m个数的所有组合个数
        //由可重复组合公式可以知道
        // Cnm可重复= C n+m-1|m = An+m-1 |m /Amm
        //则最后的结果等于
        //(n+m-1)! /m!/(n+m-1-m)!
        // Stream.iterate(s,t -> t.multiply(n.subtract(BigInteger.ONE))).limit(5).forEach(System.out::println);

        //long ss = factorial(n +m -1)/(factorial(m) * factorial(n -1)) ;
       // System.out.println(ss);
        long sum ;


    }
    /*private static final sun.misc.Unsafe UNSAFE;
    private static final long SEED;
    private static final long PROBE;
    private static final long SECONDARY;
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> tk = Thread.class;
            SEED = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomSeed"));
            PROBE = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomProbe"));
            SECONDARY = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomSecondarySeed"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }*/

    public static void main(String[] args) {
        int m = 5;

        int r = 2;


        int SQMASK       = 0x007e;
        int q =  m & r & SQMASK;


        int [] a = new int[7];
        a[0] = 10; a[1] = 20; a[2] = 30;
        int baseOffset = UNSAFE.arrayBaseOffset(a.getClass());
        int indexScale = UNSAFE.arrayIndexScale(a.getClass());

        System.out.println(baseOffset);
        System.out.println(indexScale);

         int  TERMINATED = 1 << 30;
        int  SHUTDOWN   = 1 << 31;


        System.out.println(TERMINATED);
        System.out.println(SHUTDOWN);


        int d ,b ,c ;
        d = 5;
        b = 4 ;
         c =3 ;
         if (b<d){
             System.out.println(1);
         }else if (c<d){
             System.out.println(2);
         }else if (c<b){
             System.out.println(3);
         }

    }

    public static long factorial(long number) {

        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}
