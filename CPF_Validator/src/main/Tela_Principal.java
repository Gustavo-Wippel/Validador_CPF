package main;

import java.util.Scanner;

import validadores.Validador_CPF;

public class Tela_Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Validador_CPF validador = new Validador_CPF();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe um valor de cpf: ");
		String cpf = sc.next();
		
		boolean verificaCpf = validador.calculaValoresCpf(cpf);
		if (verificaCpf) {
			System.out.println("Número de CPF válido: " + cpf);
			
		} else {
			System.out.println("Número de CPF inválido: " + cpf);
		}


	}

}
