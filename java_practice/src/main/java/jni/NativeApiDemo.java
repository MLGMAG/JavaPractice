package jni;

public class NativeApiDemo {

    public static void main(String[] args) {
        NativeApi nativeApi = new NativeApi();

        System.out.println("nativeApi.sayHello():");
        nativeApi.sayHello();
        System.out.println();

        System.out.println("nativeApi.sumIntegers(1, 2):");
        int sumIntegers = nativeApi.sumIntegers(1, 2);
        System.out.println(sumIntegers);
        System.out.println();

        System.out.println("nativeApi.sayHelloToMe(\"Mahomed\", false):");
        String sayHelloToMe = nativeApi.sayHelloToMe("Mahomed", false);
        System.out.println(sayHelloToMe);
    }

}
