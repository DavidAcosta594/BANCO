package app;

import java.util.ArrayList;

public class Banco {
	
	private String nombre;
	private ArrayList<Cuenta> cuentas;

	/**
	 * @param nombre
	 * @param cuentas
	 */
	public Banco(String nombre) {
		this.nombre = nombre;
		this.cuentas = new ArrayList<Cuenta>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	
	// Busca una cuenta en el Banco dado su IBAN. Devuelve la información de la cuenta si se encuentra en el Banco,
	// null en caso contrario
	public Cuenta getCuentaByIban(String iban) {
		for(Cuenta c : this.getCuentas()) {
			if(iban.equals(c.getIban())) return c;
		}
		return null;
	}
	
	// Permite agregar una cuenta al Banco, devolviendo su información.
	// En caso de que ya exista, devuelve null
	public Cuenta agregarCuenta(String iban, String contrasenya) {
		Cuenta c = this.getCuentaByIban(iban);
		if(c == null) {
			c = new Cuenta(iban, contrasenya);
			this.cuentas.add(c);
		}
		return c;
		
	}
	
	// Permite realizar una transferencia de una cantidad dada entre dos cuentas.
	// Si la operación ha sido autorizada y ha sido posible realizarla, devuelve la información de la Cuenta origen
	// En caso contrario, devuelve null
	public Cuenta hacerTransferecia(Cuenta origen, Cuenta destino, double cantidad, String contrasenya) {
		if(origen.autorizarOperacion(contrasenya)) {
			return origen.transferir(destino, cantidad);
		}
		return null;
	}
	
	// Dado el IBAN, quita la cuenta del Banco devolviendo el saldo restante de la cuenta,
	// -1 en caso de que la Cuenta no estuviera en el Banco
	public double quitarCuenta(String iban) {
		Cuenta c = this.getCuentaByIban(iban);
		if (c != null) {
			double saldo = c.getSaldo();
			this.getCuentas().remove(c);
			return saldo;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", cuentas=" + cuentas + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ho");
	}
	

}
