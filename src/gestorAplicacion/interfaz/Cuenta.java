package gestorAplicacion.interfaz;

import java.io.Serializable;

public abstract class Cuenta implements Serializable{


	private static final long serialVersionUID = -5757213716524384183L;



	private String nombre;
	private Usuario usuario;
	private double saldo;
	Transaccion[] transacciones;
	
	//constructor
	protected Cuenta(String nombre, Usuario usuario) {
		this.nombre=nombre;
		this.usuario=usuario;
		saldo=0;
		}

	protected Cuenta (Usuario usuario) {
		this (null, usuario);}
	//getters y setters

	public String getNombre() {

		return nombre;

		}

	public void setNombre(String nombre) {

		this.nombre = nombre;

		}
	public Usuario getUsuario() {

		return usuario;

		}
	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;

		}
	public void setSaldo(double saldo) {
		this.saldo=saldo;}
	
	public double getSaldo() {
		return saldo;
	}

	public void depositar(double cantidad) {
        saldo = saldo + cantidad;
    }

    public boolean retirar(double cantidad) {
    	if(cantidad<=saldo) {
    		saldo = saldo - cantidad;
    		return true;
    	}else {
    		return false;
    	}
    }
		


}
