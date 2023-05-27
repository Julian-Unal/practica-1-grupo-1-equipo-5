package gestorAplicacion.interfaz;

// Ana Guarín
// Isabela Hernandez
// Cristian Menaa
// Julián Álvarez

public interface Abonable <T> {
	T abonar(double monto, Cuenta origen);
    T abonar(double monto, Categoria origen);
    Transaccion terminar(Cuenta cuenta);
    Transaccion terminar(Categoria categoria);
}
