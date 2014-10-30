package clazzPack;

import java.lang.annotation.Annotation;

import annotations.Ciastko;


@Ciastko(randomString = "ciastko z wrozka")
public class Klasa {

    public void rysuj() {

    }

    private String biegaj(String job, int count) {
        for (int i = 0; i < count; i++) {
            System.err.println(job);
        }
        Annotation[] annotations = this.getClass().getDeclaredAnnotations();
        Annotation a = annotations[0];
        if (a instanceof Ciastko) {
            Ciastko myAnnotation = (Ciastko) a;
            System.out.println("Tekst z ciastka: " + myAnnotation.randomString());
        }

        return "";
    }

}
