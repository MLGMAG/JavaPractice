@echo off

# Cleanup
rd -r "jni"
del jni_NativeApi.h
del jni_NativeApi.o
del native.dll


# Compile / Link
# Generate header file
javac -h . -d . NativeApi.java NativeApiDemo.java
# Compile the implementation
gcc -c -I${JAVA_HOME}\include -I${JAVA_HOME}\include\win32 jni_NativeApi.c -o jni_NativeApi.o
# Create shared object based on the object file
gcc -shared -o native.dll jni_NativeApi.o -Wl,--add-stdcall-alias


# Run
java -Djava.library.path=. jni.NativeApiDemo
