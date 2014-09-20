package logicaDeNegocios;

import java.util.Calendar;

public class CuentaCorriente extends Cuenta {
	private static int scantCuentas = 0;
	private int operacionesExentas;
	private double cuotaOperaciones;
	
	public CuentaCorriente(Cliente pDuenio,
			double pMonto) {
		super("Cuenta Corriente",++scantCuentas, pDuenio, pMonto);
		setOperacionesExentas(30);
		setCuotaOperaciones(30);
	}
	
	public CuentaCorriente(Cliente pDuenio,double pMonto, int pOperExentas,double pCuotaOper){
		super("Cuenta Corriente",++scantCuentas, pDuenio, pMonto);
		setOperacionesExentas(30);
		setCuotaOperaciones(30);

	}
	
	
	
	public static int getScantCuentas() {
		return scantCuentas;
	}
	public static void setScantCuentas(int scantCuentas) {
		CuentaCorriente.scantCuentas = scantCuentas;
	}
	public int getOperacionesExentas() {
		return operacionesExentas;
	}
	public void setOperacionesExentas(int operacionesExentas) {
		this.operacionesExentas = operacionesExentas;
	}
	public double getCuotaOperaciones() {
		return cuotaOperaciones;
	}
	public void setCuotaOperaciones(double cuotaOperaciones) {
		this.cuotaOperaciones = cuotaOperaciones;
	}

	public String cobrarComisiones(){
		String msg = " ";
		int operacNoExentas;
		double monto;
		Calendar calendario = Calendar.getInstance();
		calendario= Calendar.getInstance();
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		if (dia == 1){
			operacNoExentas = numOperaciones  - getOperacionesExentas();
			if (operacNoExentas >0 ){
				monto = getCuotaOperaciones()* operacNoExentas;
				retirar(cuotaOperaciones);
				numOperaciones = 0;
				
				msg = "Se cobro por comision: C" +monto;
			}
			
			
		}
		return msg;
		
	}


}
