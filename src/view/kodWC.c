#include"view_Cpu.h"
#include<jni.h>
#include<stdio.h>
#include<stdlib.h>
JNIEXPORT jstring JNICALL Java_view_Cpu_getCpu(JNIEnv *env, jobject obj) {

	FILE* file = fopen("/proc/cpuinfo", "r");
	char * line = NULL;
	size_t len = 0;
	ssize_t read;	
	int i = 0;
	while ((read = getline(&line, &len, file)) != -1) {
		i += 1;
		if (i == 5) {
			close(file);
			return (*env)->NewStringUTF(env, line);
		}	
	}
	close(file);

}

JNIEXPORT jstring JNICALL Java_view_Cpu_getMem(JNIEnv *env, jobject obj) {

	FILE* file = fopen("/proc/meminfo", "r");
	char * line = NULL;
	size_t len = 0;
	ssize_t read;	
	int i = 0;
	while ((read = getline(&line, &len, file)) != -1) {
		close(file);
		return (*env)->NewStringUTF(env, line);
	}
	close(file);

}

JNIEXPORT int JNICALL Java_view_Cpu_getBattery(JNIEnv *env, jobject obj) {
	system("/home/mateusz/git/Lab1_RMI/src/view/acpiRun.sh");

	FILE* file = fopen("fileWithBatteryInfo", "r");
	char * line = NULL;
	size_t len = 0;
	ssize_t read;	
	int i = 0, intBatt = 0;
	while ((read = getline(&line, &len, file)) != -1) {
		char batt[2];
		int charInLine = 0;
		for (charInLine = 0; charInLine <= 23; charInLine = charInLine + 1) {
			if (line[charInLine] == ',') {
				batt[0] = line[charInLine+2];
				batt[1] = line[charInLine+3];	
				int tmp = batt[0] - '0';
				intBatt = (tmp * 10) + (batt[1] - '0');
			}
		}
		return intBatt;
	}	
	close(file);

}

JNIEXPORT jobjectArray JNICALL Java_view_Cpu_getFileS(JNIEnv *env, jobject obj) {

	jobjectArray stringArray;
	jstring tmp;
	jclass clsString; 

	jobjectArray ret;  

	FILE* file = fopen("/proc/filesystems", "r");
	char * line = NULL;
	size_t len = 0;
	ssize_t read;	
	int i = 0;


	ret= (*env)->NewObjectArray(env, 15,  
			(*env)->FindClass(env, "java/lang/String"),  
			(*env)->NewStringUTF(env, ""));  

	for(i=0;i<15;i++) {  
		getline(&line, &len, file);
		(*env)->SetObjectArrayElement(  
			env,ret,i,(*env)->NewStringUTF(env,line));  
	}  
	return(ret);  

}


