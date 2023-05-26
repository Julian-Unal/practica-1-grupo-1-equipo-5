package gestorAplicacion.interfaz;

// Ana Guarín
// Isabela Hernandez
// Cristian Menaa
// Julián Álvarez

import java.time.LocalDate;

public class Ahorro extends Cuenta{


	private static final long serialVersionUID = 514183129515203955L;


	private LocalDate fechaRetiro;
	
	public Ahorro(Usuario usuario, String nombre, LocalDate fechaRetiro) {
		super(nombre,usuario);
		setUsuario(usuario);
		this.fechaRetiro=fechaRetiro;
	}
 	/**
  	* Overriding
	* It checks if the `fechaRetiro` attribute of the `Ahorro` object
	* is before the current date, and if so, it calls the `retirar` 
	* method from the `Cuenta` class to withdraw the specified `monto`
	* from the account.
	* If the `fechaRetiro` is after the current date, it returns
	* `false` indicating that the withdrawal cannot be made.
  	* 
  	*/
	public boolean retirar(double monto){
		if(this.fechaRetiro.isBefore(LocalDate.now())){
			return super.retirar(monto);
		}
		return false;


	}
	public LocalDate getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(LocalDate fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}
}
