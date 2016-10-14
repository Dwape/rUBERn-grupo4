import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/9/2016.
 */
public class Invoice {
    private ArrayList<String> identificadoresDeOperacion = new ArrayList<>();
    private ArrayList<String> tiposDeOperacion = new ArrayList<>();
    private ArrayList<DateTime> fechas = new ArrayList<>();
    private ArrayList<Long> numerosDeTarjeta = new ArrayList<>();
    private ArrayList<String> descripciones = new ArrayList<>();
    private ArrayList<Double> montos = new ArrayList<>();

    public void addIdentificador(String identificadorDeOperacion){
        identificadoresDeOperacion.add(identificadorDeOperacion);
    }
    public void addTipoOper(String tipoDeOperacion){
        tiposDeOperacion.add(tipoDeOperacion);
    }
    public void addFecha(DateTime aDate){
        fechas.add(aDate);
    }
    public void addTarjeta(long tarjNum){
        numerosDeTarjeta.add(tarjNum);
    }
    public void addDescripcion(String description){
        descripciones.add(description);
    }
    public void addMonto(double amount){
        montos.add(amount);
    }

    public void print(){
        for (int i =0; i<montos.size(); i++){
            System.out.println(identificadoresDeOperacion.get(i));
            System.out.println(tiposDeOperacion.get(i));
            System.out.println(fechas.get(i));
            System.out.println(numerosDeTarjeta.get(i));
            System.out.println(descripciones.get(i));
            System.out.println(montos.get(i));
            System.out.println("\n"+"***********************************************************"+"\n");
        }
    }
}
