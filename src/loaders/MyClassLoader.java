package loaders;


public class MyClassLoader extends ClassLoader {


    public MyClassLoader() {
        super();
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Ładuję klasę : " + name);
        return super.loadClass(name);
    }

}
