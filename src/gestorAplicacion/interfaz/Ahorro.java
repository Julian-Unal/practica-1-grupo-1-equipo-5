package gestorAplicacion.interfaz;
import java.time.LocalDate;

public class Ahorro extends Cuenta{


	private static final long serialVersionUID = 514183129515203955L;


	private LocalDate fechaRetiro;
	
	public Ahorro(Usuario usuario, String nombre, LocalDate fechaRetiro) {
		super(nombre,usuario);
		setUsuario(usuario);
		this.fechaRetiro=fechaRetiro;
	}
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
