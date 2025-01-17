package gestorAplicacion.interfaz;

// Ana Guarín
// Isabela Hernandez
// Cristian Menaa
// Julián Álvarez

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Double.valueOf;

public class Estadistica {

    /**
     * Calculates the possible loan amount that a user
     * can get based on their income, age, number of children,
     * and type of collateral they can provide. 
     *  
     */
    public static double calcularPosibleCantidadPrestamo(Usuario usuario, double ingresos, int edad, int hijos, int opcGarantia) {
        if (!usuario.getAhorros().isEmpty()){
            double promedioAhorros = calcularPromedioAhorros(usuario);

            return promediarVariablesDelUsuario(ingresos, promedioAhorros, edad, hijos, opcGarantia);
        }
        else {
            return promediarVariablesDelUsuario(ingresos, 0, edad, hijos, opcGarantia);
        }
    }

    /**
     * Is calculating the average savings of a given `Usuario`
     * object by iterating over their list of `Ahorro` objects
     * and summing up their `saldo` values. The total sum is
     * then divided by the number of `Ahorro` objects to get
     * the average savings.
     * 
     */
    private static double calcularPromedioAhorros(Usuario usuario) {
        AtomicReference<Double> totalAhorros = new AtomicReference<>((double) 0);
        usuario.getAhorros().stream().forEach(ahorro -> totalAhorros.updateAndGet(v -> valueOf(v + ahorro.getSaldo())));
        int cantidadAhorros =  usuario.getAhorros().size();

        double promedioAhorros = Double.valueOf(String.valueOf(totalAhorros))/ Double.valueOf(cantidadAhorros);
        //System.out.println(promedioAhorros);

        return promedioAhorros;
    }

    /**
     * Is calculating the possible loan amount that a user can
     * get based on their income, age, number of children, and
     * type of collateral they can provide.
     * 
     */
    private static double promediarVariablesDelUsuario(double ingresos, double promedioAhorros, int edad, int hijos, int opcGarantia) {
        // puntaje
        int multiplicadorCantidadAPrestar = 3;
        double posiblePrestamo = 7 * (ingresos*0.3);
        
        double ingresoDe8Meses = ingresos * 8;
        // Se espera que el usuario tenga por lo menos 8 meses de ahorro de sus ingresos
        // Buscando validar su disciplina
        if (promedioAhorros > ingresoDe8Meses) {
            multiplicadorCantidadAPrestar += 4;
        } else if (promedioAhorros > ingresoDe8Meses / 2) {
            multiplicadorCantidadAPrestar += 3;
        } else if (promedioAhorros > ingresoDe8Meses / 2) {
            multiplicadorCantidadAPrestar += 2;
        }
        if (edad > 72 || edad < 16) {
            multiplicadorCantidadAPrestar -= 3;
        }
        if (hijos > 0) {
            multiplicadorCantidadAPrestar -= 2;
        }
        if (opcGarantia > 0) {
            Garantia garantia = Garantia.values()[opcGarantia];
            switch (garantia) {
                case Vivienda -> multiplicadorCantidadAPrestar += 7;
                case Lote -> multiplicadorCantidadAPrestar += 5;
                case Carro -> multiplicadorCantidadAPrestar += 3;
                case Moto -> multiplicadorCantidadAPrestar += 1;
            }
        }

        posiblePrestamo = (posiblePrestamo + promedioAhorros) * multiplicadorCantidadAPrestar;
        
        return posiblePrestamo;
    }

}
