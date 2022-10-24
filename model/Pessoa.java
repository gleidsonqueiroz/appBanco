package model;

import java.util.Date;

import utils.Utils;

public class Pessoa {

	//TRABALHO CINTHIA
	private static int counter = 1;

    private int numeroPessoa ;
    private String name;
    private String cpf;
    private int numero;
    private Date accountCreationDate;

    public Pessoa() { 
    	
    }

    public Pessoa(String name, String cpf, int numero) {
        this.numeroPessoa = Pessoa.counter;
        this.name = name;
        this.cpf = cpf;
        this.numero = numero;
        this.accountCreationDate = new Date();
        Pessoa.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
  
    public int getNumero() {
 		return numero;
 	}

 	public void setNumero(int numero) {
 		this.numero = numero;
 	}
    
    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nNumero: " + this.getNumero() +
                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
    }


}