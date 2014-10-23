package clazzPack;

import annotations.Ciastko;


@Ciastko
public class Klasa {

    public void rysuj() {
        
    }
    
    public String biegaj(String job, int count) {
        for (int i = 0 ; i < count; i++) {
            System.err.println(job);
        }
        return "";
    }
    
}
