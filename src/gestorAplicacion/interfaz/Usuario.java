package gestorAplicacion.interfaz;
import java.util.ArrayList;
import java.io.Serializable;


public class Usuario implements Serializable{


	private static final long serialVersionUID = -64431385135968757L;


	//atributos
	private int cedula;
	private String nombre;
	private String correo;
	
	private ArrayList<Ahorro> ahorros = new ArrayList<Ahorro>();
	private ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
	private ArrayList<Retiro> retiros = new ArrayList<Retiro>();
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	private ArrayList<Meta> metas = new ArrayList<Meta>();
	
	public Usuario(int cedula, String nombre, String correo) {

		this.cedula=cedula;

		this.nombre=nombre;
		
		this.correo=correo;
		
		}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	public int getCedula() {
		return cedula;
	}

	public ArrayList <Ahorro> getAhorros() {
        	return ahorros;
    }
    	public ArrayList <Ingreso> getIngresos() {
        	return ingresos;
    }
    	public ArrayList <Retiro> getRetiros() {
        	return retiros;
    }
    	public ArrayList <Prestamo> getPrestamos() {
        	return prestamos;
    }
   	public ArrayList <Meta> getMetas() {
        	return metas;
    }
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setCorreo(String correo) {
		this.correo=correo;
	}
	public void setCedula(int cedula) {
		this.cedula=cedula;}
	
	public void setAhorros(ArrayList<Ahorro> ahorros) {
        this.ahorros = ahorros;
    }
	public void setIngresos(ArrayList<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

	public void setRetiros(ArrayList<Retiro> retiros) {
	    this.retiros = retiros;
	    }
	
	public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
	
	public void setMetas(ArrayList<Meta> metas) {
        this.metas = metas;
    }

	//métodos

	public void nuevoIngreso(Ingreso ingreso) {
		if (ingreso.getCuentaDestino()!=null){
			ingreso.getCuentaDestino().depositar(ingreso.getMonto());
		    ingresos.add(ingreso);
		}
	}

	//Se realiza un retiro validando su consistencia origen del usuario y se genera una salida en el historial

	public boolean nuevoRetiro(Retiro retiro) {

        if(retiro.getCuentaOrigen()!=null){
		    boolean salida = retiro.getCuentaOrigen().retirar(retiro.getMonto());

		    if(salida){

			    retiros.add(retiro);

	        }
		    return salida;
	    }
		else{
			if (retiro.getCategoria().getSaldo()<=retiro.getMonto()){
				return true;

			}
			else{
				return false;
			}
		}
    }


	public void nuevoAhorro(Ahorro ahorro) {

		ahorros.add(ahorro);

	}

	public void nuevaMeta(Meta meta) {

		metas.add(meta);

	}

	//Se realiza una separacion del dinero del usuario por divisas guardada en bolsillos, colchones y metas

	public int getDineroCuenta() {

		int total = 0;

		for (Ahorro i : ahorros) {

			total+=i.getSaldo();
		}

		for (Categoria i: Categoria.values()){
			total+=i.getSaldo();

		}

		for (Meta i:metas){
			total+=i.getSaldo();
		}

		return total;
	}


	public void nuevoPrestamo(Prestamo prestamo, Categoria bolsillo) {
		prestamos.add(prestamo);
		bolsillo.setSaldo(bolsillo.getSaldo() + prestamo.getMontoPrestado());
	}
}
