#include "view_Cpu.h"
#include<jni.h>
#include<stdio.h>

JNIEXPORT void JNICALL Java_view_Cpu_getCpu(JNIEnv *env, jobject obj) {

	FILE* file = fopen("/proc/cpuinfo", "r");
	char * line = NULL;
	size_t len = 0;
	ssize_t read;	
	int i = 0;
	while ((read = getline(&line, &len, file)) != -1) {
		i += 1;
		if (i == 5) {
			printf("%s", line);
		}	
	}
	close(file);
	printf("Jakis testowy text");

	return;
}

