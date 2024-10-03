package uniquindio.co.autos.utils;

import java.io.IOException;
import java.util.ArrayList;

public class CarSales {

    public static void main(String[] args) {

        ArrayList<String> listaAutos = new ArrayList<String>();
        listaAutos.add("Toyota;RAV4;2021;33000");
        listaAutos.add("Ford;EcoSport;2017;25000");
        try{
            Persistencia.guardarCarros(listaAutos);
            Persistencia.guardaRegistroLog("Reg auto",1, "Create");
        }catch (IOException e){
            e.printStackTrace();
        }
        //cargar
        try{
            ArrayList<String> autosCargados = Persistencia.cargarAutos();
            System.out.println("Autos cargados: ");
            Persistencia.guardaRegistroLog("cargar auto",1, "create");
            for (String auto : autosCargados){
                System.out.println(auto);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //base de datos
        try {
            Persistencia.guardarPropiedades("admin", "admin123", "2806", "1.67", "456", "test3", "mongov2");
            Persistencia.guardarPropiedades("Choki", "choki123", "1204", "1.92", "234", "test", "test2");
            Persistencia.guardaRegistroLog("cargar props",1, "create");
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            ArrayList<String> propsCargadas = Persistencia.cargarProps();
            System.out.println("propsCargadas: ");
            Persistencia.guardaRegistroLog("cargar props",1, "create");
            for (String propiedades : propsCargadas){
                System.out.println(propsCargadas);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}