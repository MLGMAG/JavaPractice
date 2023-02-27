#include "jni_NativeApi.h"
#include <stdio.h>
#include <string.h>
#include <stdint.h>

void setupPrefix(jboolean isFemale, char prefix[]);

JNIEXPORT void JNICALL Java_jni_NativeApi_sayHello
  (JNIEnv* env, jobject thisObject) {
    char message[] = "Hello World from C language!";
    puts(message);
}

JNIEXPORT jint JNICALL Java_jni_NativeApi_sumIntegers
  (JNIEnv * env, jobject thisObject, jint first, jint second) {
    char messagePattern[] = "First NativeApiDemo '%d', second NativeApiDemo '%d'\n";
    printf(messagePattern, first, second);

    int output = first + second;
    return output;
}

JNIEXPORT jstring JNICALL Java_jni_NativeApi_sayHelloToMe
  (JNIEnv * env, jobject thisObject, jstring name, jboolean isFemale) {
    // Get name
    const char *nameCharPointer = (*env)->GetStringUTFChars(env, name, 0);
    size_t nameLength = strlen(nameCharPointer);

    // Get prefix
    size_t prefixLength = 4;
    char prefix[prefixLength + 1];
    setupPrefix(isFemale, prefix);

    // Get greetings
    char greetings[] = "Hello ";
    size_t greetingsLength = strlen(greetings);

    // Get emphasis
    char emphasis[] = "!!!";
    size_t emphasisLength = strlen(emphasis);

    // Init output string
    size_t outputLength = greetingsLength + prefixLength + nameLength + + emphasisLength + 1;
    char output[outputLength];
    memset(output, '\0', outputLength);

    // Concat all together
    strcat(output, greetings);
    strcat(output, prefix);
    strcat(output, nameCharPointer);
    strcat(output, emphasis);

    return (*env)->NewStringUTF(env, output);
}

void setupPrefix(jboolean isFemale, char prefix[]) {
    char femalePrefix[] = "Ms. ";
    char malePrefix[] = "Mr. ";

    if (isFemale) {
        strcpy(prefix, femalePrefix);
    } else {
        strcpy(prefix, malePrefix);
    }
}
