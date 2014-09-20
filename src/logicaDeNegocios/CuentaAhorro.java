package logicaDeNegocios;

import java.util.Calendar;

public class CuentaAhorro extends Cuenta {
	private static int scantCuentas = 0;
	private double cuotaMantenimiento;
	
	public CuentaAhorro( Cliente pDuenio,double pMonto) {
		super("Cuenta de Ahorro", ++scantCuentas, pDuenio, pMonto);
		setCuotaMantenimiento(300);//Cuota Mantenimiento por omision
	}
	public CuentaAhorro(Cliente pDuenio, double pMonto, double pCuota){
		super("Cuenta de Ahorro", ++scantCuentas, pDuenio, pMonto);
		setCuotaMantenimiento(pCuota);
	}
	

	public static int getScantCuentas() {
		return scantCuentas;
	}
	public static void setScantCuentas(int scantCuentas) {
		CuentaAhorro.scantCuentas = scantCuentas;
	}
	public double getCuotaMantenimiento() {
		return cuotaMantenimiento;
	}
	public void setCuotaMantenimiento(double cuotaMantenimiento) {
		this.cuotaMantenimiento = cuotaMantenimiento;
	}
	
	public String cobrarComisiones(){
		String msg = " ";
		Calendar calendario;
		calendario = Calendar.getInstance();
		
		int dia  = calendario.get(Calendar.DAY_OF_MONTH);
		if (dia == 1){
			
			retirar(cuotaMantenimiento);
			numOperaciones = 0;
			msg ="Se cobro por comision: "+ cuotaMantenimiento;
		}
		return msg;
	}

}
