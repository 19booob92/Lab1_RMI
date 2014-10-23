package mainPack;


import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainLoader {

    public static void printMethodsNames(Method[] methods) {
        List<Method> meths = Arrays.asList(methods);

        for (Method m : meths) {
            System.out.println(m.getName());
        }
    }


    public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        ClassLoader classLoader = MainLoader.class.getClassLoader();
        // getOneClass(classLoader);
        List<String> results = new ArrayList<String>();
        List<Class> clases = new ArrayList<Class>();

        File[] files = new File("/home/booob/Documents/workspace-sts-3.5.1.RELEASE/ClassLoaders/bin/clazzPack").listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        for (String classFile : results) {
            Class classToLoad = classLoader.loadClass(classFile);
            List<Annotation> annotationLists = Arrays.asList(classToLoad.getAnnotations());
            for (Annotation a : annotationLists) {
                if (a.getClass().equals("Ciastko")) {
                    clases.add(classToLoad);
                }
            }
        }

    }


    private static void getOneClass(ClassLoader classLoader) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {


        try {
            Class aClass = classLoader.loadClass("clazzPack.Klasa");
            System.out.println("aClass.getName() = " + aClass.getName());

            Object a = new clazzPack.Klasa();

            clazzPack.Klasa k = (clazzPack.Klasa) a;

            aClass.getMethod("biegaj", String.class, int.class).invoke(a, new Object[] { "bieg", 5 });

            Method[] methods = aClass.getMethods();
            printMethodsNames(methods);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
