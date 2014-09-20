package aplicacion;
import logicaDeNegocios.Cliente;
import logicaDeNegocios.Cuenta;
import logicaDeNegocios.CuentaAhorro;
import logicaDeNegocios.CuentaCorriente;

public class AplCuenta {

	public AplCuenta() {
	
	}

	public static void main(String[] args) {
	Cliente cliente1 = new Cliente("123", "Sebastian", "Rojas");
	Cliente cliente2 = new Cliente("345", "Fiorella", "Hernadez");
	Cuenta cuenta1 = new CuentaAhorro(cliente1, 3000);
	Cuenta cuenta2 = new CuentaCorriente(cliente2, 1500);

	cuenta1.depositar(1500);
	cuenta1.depositar(2000);
	cuenta1.retirar(300);
	cuenta2.retirar(200);
	
	
	System.out.println(cuenta1.cobrarComisiones());
	System.out.println(cuenta2.cobrarComisiones());
	System.out.println( cuenta1.toString() );
	System.out.println( cuenta2.toString() );
	
	
	}
}
