package baseDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

import gestorAplicacion.confirmacion.Datos;

public class Serializador {

    private static File rutaTemp = Path.of("src", "baseDatos", "temp").toFile();

    static {
        Serializador.rutaTemp.mkdirs();
    }

    public static void serializar() {
        crearArchivos();
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = rutaTemp.listFiles() != null ? rutaTemp.listFiles() : new File[0];
        for (File file : docs) {
            for (String[] element : Datos.filesList) {
                if (file.getAbsolutePath().endsWith(element[0])) {
                    try {
                        fos = new FileOutputStream(file);
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(Datos.class.getMethod(element[2]).invoke(new Datos()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private static void crearArchivos() {
        for (String[] file : Datos.filesList) {
            File f = Path.of(Serializador.rutaTemp.getAbsolutePath(), file[0]).toFile();
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
