#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_ben_xplain_main_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Title from C++";
    return env->NewStringUTF(hello.c_str());
}


