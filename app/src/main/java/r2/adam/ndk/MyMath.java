package r2.adam.ndk;

public class MyMath {

    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    public native long primeNumbersNative(long number);


    public long primeNumberJava(long iteration) {
        long l1 = 0, l2 = 1, temp = 0;

        for (long i = 0; i < iteration; ++i) {
            temp = l1 + l2;
            l1 = l2;
            l2 = temp;
        }

        return temp;
    }
}
