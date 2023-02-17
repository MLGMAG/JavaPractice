package jni.hello_world;

public class HelloWorldApi {

    static {
        System.loadLibrary("hello");
    }

    public native void sayHello();

}
