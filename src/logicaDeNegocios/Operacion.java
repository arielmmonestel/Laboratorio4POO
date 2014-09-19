package logicaDeNegocios;

//mport java.sql.Date;
import java.text.*;
import java.util.*;

public class Operacion {
	private int numero;
	private String tipo;
	private double monto;
	private Date fechaOperacion;
	

	public Operacion(int pNumero, String pTipo, double pMonto) {
		setNumero(pNumero);
		setTipo(pTipo);
		setMonto(pMonto);
		setFechaOperacion();
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public Date getfechaOperacion() {
		return fechaOperacion;
	}


	//public void setFechaOperacion(Date fechaOperacion) {
		//this.fechaOperacion = fechaOperacion;
//	}
	public void setFechaOperacion(){
		Calendar calendario;
		calendario = Calendar.getInstance();
		fechaOperacion = (Date) calendario.getTime();
	
	}
	public String getFechaOperacion(){
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
		return mascara.format(fechaOperacion);	
	}

	public String toString(){
		String msg;
		msg = "\t"+ getNumero() + "\t" +getFechaOperacion() + "\t" + getTipo() + "\t" + getMonto() + "\n";
		return msg;
	}
}
