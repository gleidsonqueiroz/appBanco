
package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pessoa;
import model.Conta;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("+----------------------------------------------------+");
        System.out.println("+------------ Bem vindos ao BANCO FAESA v1.0 --------+");
        System.out.println("+----------------------------------------------------+");
        System.out.println("+---- Selecione uma operacao que deseja realizar ----+");
        System.out.println("+----------------------------------------------------+");
        System.out.println("+   Opcao 1 - Criar conta   		 	     +");
        System.out.println("+   Opcao 2 - Depositar     			     +");
        System.out.println("+   Opcao 3 - Sacar         			     +");
        System.out.println("+   Opcao 4 - Transferir    			     +");
        System.out.println("+   Opcao 5 - Listar        			     +");
        System.out.println("+   Opcao 6 - Sair          			     +");
        System.out.println("+----------------------------------------------------+");
        int operacao = input.nextInt();;

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                deposito();
                break;

            case 3:
                saque();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                System.out.println("\n\nFim do Programa...\nAte mais!");
                System.exit(0); // para o sistema

            default:
                System.out.println("Opcao invalida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("+----------------------------------------------------+");
        System.out.println("+----Voce esta criando uma Conta no BANCO FAESA------+");
        System.out.println("+----------------------------------------------------+\n");
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("CPF: ");
        String cpf = input.next();

        System.out.println("Numero Conta:\nConta Simples comeca com '01'\nConta Especial comeca com '02'");
        int numero = input.nextInt();

        Pessoa cliente = new Pessoa(nome, cpf, numero);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---\n\n");

        operacoes();

    }

    private static Conta encontrarConta(int numero) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumero() == numero) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void deposito() {
        System.out.println("Numero da conta: ");
        int numero = input.nextInt();
        Conta conta = encontrarConta(numero);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.deposito(valorDeposito);
        }else {
            System.out.println("--- Conta nao encontrada ---");
        }

        operacoes();

    }

    public static void saque() {
        System.out.println("Numero da conta: ");
        int numero = input.nextInt();

        Conta conta = encontrarConta(numero);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.saque(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta nao encontrada ---");
        }

        operacoes();

    }

    public static void transferir() {
        System.out.println("Numero da conta do Remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Numero da conta do Destinatario: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);

            }else {
                System.out.println("--- A conta para deposito nao foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferencia nao encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("--- Nao ha contas cadastradas ---");
        }

        operacoes();
    }
}
