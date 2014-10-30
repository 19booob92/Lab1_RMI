package mainPack;


import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import loaders.MyClassLoader;


public class MainLoader {

    public static void printMethodsNames(Method[] methods) {
        List<Method> meths = Arrays.asList(methods);

        for (Method m : meths) {
            System.out.println(m.getName());
        }
    }


    public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        ClassLoader classLoader = new MyClassLoader();
        getOneClass(classLoader);
        getClasses(classLoader);
    }


    private static void getClasses(ClassLoader classLoader) throws ClassNotFoundException {
        List<String> results = new ArrayList<String>();
        List<Class> clases = new ArrayList<Class>();

        File[] files = new File("/home/booob/Documents/workspace-sts-3.5.1.RELEASE/Lab3_ClassLoaders/bin/clazzPack").listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        for (String classFile : results) {
            String clazzName = "clazzPack." + classFile.split("\\.")[0];
            Class classToLoad = classLoader.loadClass(clazzName);
            List<Annotation> annotationLists = Arrays.asList(classToLoad.getAnnotations());
            for (Annotation a : annotationLists) {
                String annoName = a.annotationType().getName().split("\\.")[1];
                if (annoName.equals("Ciastko")) {
                    clases.add(classToLoad);
                } else {
                    // load out
                }

            }
        }
        System.err.println(clases);
    }


    private static void getOneClass(ClassLoader classLoader) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {


        try {
            Class aClass = classLoader.loadClass("clazzPack.Klasa");
            System.out.println("aClass.getName() = " + aClass.getName());

            Object a = new clazzPack.Klasa();

            clazzPack.Klasa k = (clazzPack.Klasa) a;
            Method metoda = aClass.getDeclaredMethod("biegaj", String.class, int.class);
            metoda.setAccessible(true);
            metoda.invoke(a, new Object[] { "bieg", 5 });

            Method[] methods = aClass.getMethods();
            printMethodsNames(methods);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
