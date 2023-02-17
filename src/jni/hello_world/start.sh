# Cleanup
rm -rf jni/*
rm jni_hello_world_HelloWorldApi.h
rm jni_hello_world_HelloWorldApi.o
rm libhello.so


# Compile / Link
# Generate header file
javac -h . -d . HelloWorldApi.java Main.java
# Compile the implementation
gcc -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux jni_hello_world_HelloWorldApi.c -o jni_hello_world_HelloWorldApi.o
# Create shared object based on the object file
gcc -shared -fPIC -o libhello.so jni_hello_world_HelloWorldApi.o


# Run
java -Djava.library.path=. jni.hello_world.Main
