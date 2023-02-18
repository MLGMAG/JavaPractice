# Cleanup
rm -rf jni/*
rm jni_NativeApi.h
rm jni_NativeApi.o
rm libnative.so


# Compile / Link
# Generate header file
javac -h . -d . NativeApi.java NativeApiDemo.java
# Compile the implementation
gcc -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux jni_NativeApi.c -o jni_NativeApi.o
# Create shared object based on the object file
gcc -shared -fPIC -o libnative.so jni_NativeApi.o


# Run
java -Djava.library.path=. jni.NativeApiDemo
