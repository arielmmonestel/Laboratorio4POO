

package logicaDeNegocios;
import java.util.*;
import java.text.*;

public abstract class Cuenta {

protected int numCuenta = 0;
protected Cliente duenio = null;
protected double saldo = 0;
protected static int sCantCuentas = 0;
protected Date fechaCreacion;
protected ArrayList<Operacion>operaciones;
protected int numOperaciones = 0;
protected String tipoCuenta;


	public Cuenta(Cliente pDuenio, double pMonto ) {
		operaciones = new ArrayList<Operacion> ();
		sCantCuentas++ ;
		setNumCuenta(sCantCuentas);
		depositar(pMonto);
		setDuenio(pDuenio);
		setFechaCreacion();
				
	}
	



	public int getNumCuenta() {
		return numCuenta;
	}


	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}


	public Cliente getDuenio() {
		return duenio;
	}


	public void setDuenio(Cliente pCliente) {
		duenio = pCliente;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String depositar(double pMonto){
		saldo +=pMonto;
		Operacion nuevaOperacion = new Operacion (++numOperaciones, "deposito", pMonto);
		operaciones.add(nuevaOperacion);
		return "saldo actual despues del deposito es: " + saldo;
	}

	private boolean validarRetiro (double pMonto){
		return pMonto <= saldo;
	}

	public String retirar (double pMonto){
		if (validarRetiro(pMonto)){
			saldo -= pMonto ; 
			Operacion nuevaOperacion = new Operacion(++numOperaciones,"retiro",pMonto);
			operaciones.add(nuevaOperacion);
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
		msg	+= duenio.toString() ;
		msg	+= "Saldo: C" + getSaldo() + "\n";
		msg += "Registro de Operaciones" + "\n";
		msg += "\tNumero\t"+"Fecha\t"+"\tOperacion\t"+"Monto"+"\n";
		for (int i = 0; i <operaciones.size();i++)
		{	
				Operacion unaOp = (Operacion) operaciones.get(i);
				msg += unaOp.toString();
		}
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




