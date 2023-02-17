#include "jni_hello_world_HelloWorldApi.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_jni_hello_1world_HelloWorldApi_sayHello
  (JNIEnv* env, jobject thisObject) {
	printf("Hello World from C language!\n");
}

