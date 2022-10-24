package model;

import utils.Utils;

public class Conta implements Transacao {

	//TRABALHO CINTHIA
	 private static int accountCounter = 1;

	    private int numero;
	    private Pessoa pessoa;
	    private Double valor_na_conta = 0.0;


	    public Conta(Pessoa pessoa) {
	        this.numero = Conta.accountCounter;
	        this.pessoa = pessoa;
	        this.updateSaldo();
	        Conta.accountCounter += 1;
	    }


	    public int getNumero() {
	        return numero;
	    }
	    public Pessoa getClient() {
	        return pessoa;
	    }
	    public void setClient(Pessoa pessoa) {
	        this.pessoa = pessoa;
	    }
	    public Double getValor_na_conta() {
	        return valor_na_conta;
	    }
	    public void setValor_na_conta(Double valor_na_conta) {
	        this.valor_na_conta = valor_na_conta;
	    }

	    private void updateSaldo() {
	        this.valor_na_conta = this.getValor_na_conta();
	    }

	    public String toString() {

	        return "\nBank account: " + this.getNumero() +
	                "\nCliente: " + this.pessoa.getName() +
	                "\nCPF: " + this.pessoa.getCpf() +
	                "\nNumero: " + this.pessoa.getNumero() +
	                "\nSaldo: " + Utils.doubleToString(this.getValor_na_conta()) +
	                "\n" ;
	    }

	
	
	
	
//	private static int accountCounter = 1;
//	 
//	private String nome;
//	private String cpf;
//	private int numero;
//	private double valor_na_conta;
//	
//	
//	//Instanciando o Construtor 
//	public Conta(String nome, String cpf, int numero, double valor_na_conta) {
//		super();
//		this.nome = nome;
//		this.cpf = cpf;
//		this.numero = numero;
//		//this.valor_na_conta = valor_na_conta; // Mudar para 0 ou instancia com Null ?
//		this.valor_na_conta = 0.0; // Mudar para 0 ou instancia com Null ?
//	}
//
//		
//	public Conta(Pessoa cliente) {
//		// TODO Auto-generated constructor stub
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getCpf() {
//		return cpf;
//	}
//
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//
//	public int getNumero() {
//		return numero;
//	}
//
//	public void setNumero(int numero) {
//		this.numero = numero;
//	}
//
//	public double getValor_na_conta() {
//		return valor_na_conta;
//	}
//
//	public void setValor_na_conta(double valor_na_conta) {
//		this.valor_na_conta = valor_na_conta;
//	}


	@Override
	public void deposito(double valor) {
		if(valor > 0) {
			setValor_na_conta(getValor_na_conta() + valor);
			//this.saldo = this.getSaldo() + valor;
			System.out.println("Seu deposito foi realizado com sucesso!");
		}else {
			System.out.println("Nao foi possivel realizar o deposito!");
		}		
	}

	@Override
	public void saque(double valor) {
		if(valor > 0 && this.getValor_na_conta() >= valor) {
			setValor_na_conta(getValor_na_conta() - valor);
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Nao foi possivel realizar o saque!");
		}
	}


	@Override
	public double saldo() {
		// TODO Auto-generated method stub
		return 0;
	}


	//@Override
		//public void transferencia(double valor, Conta conta) {
	@Override
	public void transferencia(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getValor_na_conta() >= valor) {
			setValor_na_conta(getValor_na_conta() - valor);
			//this.saldo = this.getSaldo() - valor;
			contaParaDeposito.valor_na_conta = contaParaDeposito.getValor_na_conta() + valor;
			System.out.println("Transferencia realizada com sucesso!");
		}else {
			System.out.println("Nao foi possivel realizar a tranferencia");
		}
	}


	@Override
	public void transferencia(double valor, Conta conta) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public void transferencia(double valor, Conta conta) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
//    private static int accountCounter = 1;
//
//    private int numeroConta;
//    private Pessoa pessoa;
//    private Double saldo = 0.0;
//
//
//    public Conta(Pessoa pessoa) {
//        this.numeroConta = Conta.accountCounter;
//        this.pessoa = pessoa;
//        this.updateSaldo();
//        Conta.accountCounter += 1;
//    }
//
//
//    public int getNumeroConta() {
//        return numeroConta;
//    }
//    public Pessoa getClient() {
//        return pessoa;
//    }
//    public void setClient(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }
//    public Double getSaldo() {
//        return saldo;
//    }
//    public void setSaldo(Double saldo) {
//        this.saldo = saldo;
//    }
//
//    private void updateSaldo() {
//        this.saldo = this.getSaldo();
//    }
//
//    public String toString() {
//
//        return "\nBank account: " + this.getNumeroConta() +
//                "\nCliente: " + this.pessoa.getName() +
//                "\nCPF: " + this.pessoa.getCpf() +
//                "\nEmail: " + this.pessoa.getEmail() +
//                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
//                "\n" ;
//    }
//
//    public void depositar(Double valor) {
//        if(valor > 0) {
//            setSaldo(getSaldo() + valor);
//            //this.saldo = this.getSaldo() + valor;
//            System.out.println("Seu deposito foi realizado com sucesso!");
//        }else {
//            System.out.println("Nao foi possivel realizar o deposito!");
//        }
//    }
//
//    public void sacar(Double valor) {
//        if(valor > 0 && this.getSaldo() >= valor) {
//            setSaldo(getSaldo() - valor);
//            System.out.println("Saque realizado com sucesso!");
//        }else {
//            System.out.println("Nao foi possivel realizar o saque!");
//        }
//    }
//
//    public void transferencia(Conta contaParaDeposito, Double valor) {
//        if(valor > 0 && this.getSaldo() >= valor) {
//            setSaldo(getSaldo() - valor);
//            //this.saldo = this.getSaldo() - valor;
//            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
//            System.out.println("Transferencia realizada com sucesso!");
//        }else {
//            System.out.println("Nao foi possivel realizar a tranferencia");
//        }
//
//    }

}