package gestorAplicacion.confirmacion;
import gestorAplicacion.interfaz.Categoria;

public class Alerta {

    public static String Incorrecto(double opcMin, double opcMax){
        return "PORFAVOR INGRESE UN DATO VALIDO,\n" +
        "RECUERDE USAR ',' EN CASO DE TENER DECIMALES \n" +
        "y que el valor este entre el "+ opcMin+" y el "+ opcMax;
    }

    public static String NoBolsillo(){
        System.out.println("");
        return "El usuario no cuenta con bolsillos";
    }

    public static String NoPrestamo(){
        System.out.println("");
        return "El usuario no cuenta con prestamos";
    }

    public static String NoAhorro(){
        System.out.println("");
        return "El usuario no cuenta con ahorros";
    }

    public static String NoMeta(){
        System.out.println("");
        return "El usuario no cuenta con metas";
    }

    public static String Excede(Categoria categoria){
        System.out.println("");
        return "Advertencia!!, has superado el presupuesto para "+ categoria.name();
    }

    public static String Insuficiente(){
        System.out.println("");
        return "No tiene saldo suficiente para realizar este retiro";
    }


}
