#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_r2_adam_ndk_MyMath_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


jlong prime_numbers(jlong iteration) {
    jlong l1 = 0;
    jlong l2 = 1;
    jlong temp = 0;

    for (jlong i = 0; i < iteration; ++i) {
        temp = l1 + l2;
        l1 = l2;
        l2 = temp;
    }

    return temp;
}

extern "C" JNIEXPORT jlong JNICALL
Java_r2_adam_ndk_MyMath_primeNumbersNative(JNIEnv *, jobject, jlong iteration) {
    return prime_numbers(iteration);
}
