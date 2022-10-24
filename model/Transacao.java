package model;

//import trabalho_Conta_Bancaria.Conta;

public interface Transacao {
	
	public void deposito(double valor);
	public void saque(double valor);
	public double saldo(); 			// public void saldo();
	public void transferencia (double valor, Conta conta);
	void transferencia(Conta contaParaDeposito, Double valor);

}
