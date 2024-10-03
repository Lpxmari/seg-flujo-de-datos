package uniquindio.co.autos.utils;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Persistencia {
    private static final String AUTOS = "C:\\Users\\MAR\\OneDrive\\Documentos\\GitHub\\untitled\\src\\main\\java\\uniquindio\\co\\autos\\persistencia\\autos.txt";
    private static final String LOG = "C:\\Users\\MAR\\OneDrive\\Documentos\\GitHub\\untitled\\src\\main\\java\\uniquindio\\co\\autos\\persistencia\\log\\movesLog.txt";
    private static final String PROPIEDADES = "C:\\Users\\MAR\\OneDrive\\Documentos\\GitHub\\untitled\\src\\main\\java\\uniquindio\\co\\autos\\persistencia\\props.txt";

    public static void guardarCarros(ArrayList<String> listaAutos) throws IOException {
        Set<String> autosExistentes = new HashSet<>(ArchivoUtil.leerArchivo(AUTOS));
        StringBuilder content = new StringBuilder();
        for (String auto: listaAutos){
            if(! autosExistentes.contains(auto)){
                content.append(auto).append("\n");
                autosExistentes.add(auto);
            }
        }
        ArchivoUtil.guardarArchivo(AUTOS, content.toString(),true);
    }
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, LOG);
    }

    public static ArrayList<String> cargarAutos() throws FileNotFoundException, IOException {
        return ArchivoUtil.leerArchivo(AUTOS);
    }
    public static void guardarPropiedades(String usuario, String password, String puerto, String host1, String host2, String endpoint1, String endpoint2) throws IOException {
        String content = usuario + "@" + password + "@" + puerto + "@" + host1 + "@" + host2 + "@" + endpoint1 + "@" + endpoint2;
        ArchivoUtil.guardarArchivo(PROPIEDADES, content,false);
    }
    public static ArrayList<String> cargarProps() throws FileNotFoundException, IOException {
        return ArchivoUtil.leerArchivo(PROPIEDADES);
    }
}
