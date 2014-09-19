

package logicaDeNegocios;
import java.util.*;
import java.text.*;

public class Cuenta {

private int numCuenta = 0;
private String duenio = null;
private double saldo = 0;
private static int sCantCuentas = 0;
private Date fechaCreacion;


	public Cuenta(String pNombre, double pMonto ) {
		sCantCuentas++ ;
		setNumCuenta(sCantCuentas);
		depositar(pMonto);
		setDuenio(pNombre);
		setFechaCreacion();
		
				
	}
	



	public int getNumCuenta() {
		return numCuenta;
	}


	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}


	public String getDuenio() {
		return duenio;
	}


	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String depositar(double pMonto){
		saldo +=pMonto;
		return "El saldo actual despues del deposito es: " + saldo;
	}
	private boolean validarRetiro (double pMonto){
		return pMonto <= saldo;
	}

	public String retirar (double pMonto){
		if (validarRetiro(pMonto)){
			saldo -= pMonto ; 
			return "El saldo actual despues del retiro es: "+ saldo;
		}
		else{
			return "No tiene suficiente dinero";
		}
	}
	@Override
	public String toString() {
		String msg;
		
		msg = "Cuenta Numero: " +getNumCuenta() + "\n";
		msg	+= "Fecha Creacion: " + getFechaCreacion() + "\n";
		msg	+= "Duenno: " + getDuenio() + "\n";
		msg	+= "Saldo" + getSaldo() + "\n";
		return msg;
	}
	
	public void setFechaCreacion(){
		Calendar calendario;
		calendario = Calendar.getInstance();
		fechaCreacion = calendario.getTime();
		
	}
	
	public String getFechaCreacion(){
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
		return mascara.format(fechaCreacion);
	}
	
}




