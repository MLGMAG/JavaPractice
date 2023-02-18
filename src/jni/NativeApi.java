package jni;

public class NativeApi {

    static {
        System.loadLibrary("native");
    }

    public native void sayHello();

    public native int sumIntegers(int first, int second);

    public native String sayHelloToMe(String name, boolean isFemale);

}
