#include "jni_NativeApi.h"
#include <stdio.h>
#include <string.h>
#include <stdint.h>

JNIEXPORT void JNICALL Java_jni_NativeApi_sayHello
  (JNIEnv* env, jobject thisObject) {
	printf("Hello World from C language!\n");
}

JNIEXPORT jint JNICALL Java_jni_NativeApi_sumIntegers
  (JNIEnv * env, jobject thisObject, jint first, jint second) {
    printf("First NativeApiDemo '%d', second NativeApiDemo '%d'\n", first, second);
    return first + second;
}

JNIEXPORT jstring JNICALL Java_jni_NativeApi_sayHelloToMe
  (JNIEnv * env, jobject thisObject, jstring name, jboolean isFemale) {
    const char *nameCharPointer = (*env)->GetStringUTFChars(env, name, 0);
    size_t nameLength = strlen(nameCharPointer);

    size_t prefixLength = 4;
    char prefix[prefixLength + 1];
    if (isFemale) {
        strcpy(prefix, "Ms. ");
    } else {
        strcpy(prefix, "Mr. ");
    }

    size_t outputNameLength = prefixLength + nameLength + 1;
    char outputName[outputNameLength];
    outputName[0] = '\0';
    strcat(outputName, prefix);
    strcat(outputName, nameCharPointer);

    return (*env)->NewStringUTF(env, outputName);
}
