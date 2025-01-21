package app;

public class Cuenta {
	
	private String iban;
	private String contrasenya;
	private double saldo;
	
	/**
	 * @param iban
	 * @param contrasenya
	 * @param saldo
	 */
	public Cuenta(String iban, String contrasenya, double saldo) {
		this.iban = iban;
		this.contrasenya = contrasenya;
		this.saldo = saldo;
	}

	/**
	 * @param iban
	 * @param contrasenya
	 */
	public Cuenta(String iban, String contrasenya) {
		this.iban = iban;
		this.contrasenya = contrasenya;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	// Comprueba que se pueda realizar una operación pidiendo una contraseña
	public boolean autorizarOperacion(String contrasenya) {
		return contrasenya.equals(this.contrasenya);
	}
	
	// Permite transferir la cantidad indicada a la Cuenta destino, devolviendo la información de la Cuenta origen
	// En caso de no haber podido realizar la transferencia, devuelve null
	public Cuenta transferir(Cuenta destino, double cantidad) {
		if(this.saldo >= cantidad) {
			this.saldo -= cantidad;
			destino.saldo += cantidad;
			return this;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Cuenta [iban=" + iban + ", saldo=" + saldo + "]";
	}
}
