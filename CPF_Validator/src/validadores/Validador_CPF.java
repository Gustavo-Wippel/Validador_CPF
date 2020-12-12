package validadores;

public class Validador_CPF {
	
	 /**
	  * M�todo respons�vel pela verifica��o de validez do CPF
	  * @param cpf - Cpf informado pelo usu�rio para a capt��o de caracteres
	  * @return Retorna true em caso de cpf v�lido e false em caso inv�lido
	  */
	  public boolean calculaValoresCpf (String cpf) {	 
		  char captaDigito;
		  String captaDigitoChar = "";
		  int digitoCpf = 0;
		  int primeiroDigitoVerificador = 0;
		  int segundoDigitoVerificador = 0;
		  int salvaPrimeiroDigito = 0;
		  int salvaSegundoDigito = 0;
		  int valorMultiplicatorio = 10;
		  String numerosCpf = "";
		  
		  //For para realizar o c�lculo do primeiro digito
		  for (int i = 0; i < 11; i++) {
			  captaDigito = cpf.charAt(i);
			  /**
			   * Em caso da condi��o ser verdadeira, os numeros do cpf s�o colocados em numerosCpf, 
			   * permitindo que os numeros sejam salvos sem as pontua��es.
			   */
			  if (captaDigito != '.' & captaDigito != '-') {
				  captaDigitoChar = String.valueOf(captaDigito);
				  numerosCpf += captaDigitoChar;
				  digitoCpf = Integer.parseInt(captaDigitoChar);
				  primeiroDigitoVerificador += digitoCpf * valorMultiplicatorio;
				  valorMultiplicatorio--;
			  }
		  }
		  primeiroDigitoVerificador = primeiroDigitoVerificador % 11;
		  
		 //Verifica se o resto da divis�o do primeiro digito � maior que 2, caso verdadeira, subtrai 11 do primeiro digito
		  if (primeiroDigitoVerificador >= 2) {
			  primeiroDigitoVerificador = 11 - primeiroDigitoVerificador;
			
		  } else {
			  primeiroDigitoVerificador = 0;
			
		  }
		  numerosCpf += primeiroDigitoVerificador;
		  valorMultiplicatorio = 11;
		  
		  //For para realizar o c�lculo do segundo digito
		  for (int i = 0; i < 9; i++) {
			  //Neste caso capta "numerosCpf", feito pelo for do primeiro digito.
			  captaDigito = numerosCpf.charAt(i);
			  if(captaDigito != '.' & captaDigito != '-') {
				captaDigitoChar = String.valueOf(captaDigito);
				digitoCpf = Integer.parseInt(captaDigitoChar);
				segundoDigitoVerificador += digitoCpf * valorMultiplicatorio;
				valorMultiplicatorio--;
			  }
			  //Verifica se o valor de multiplica��o est� em 2. Caso sim, ele pega o primeiro digito e multiplica esse valor por 2.
			  if (valorMultiplicatorio == 2) {
				segundoDigitoVerificador += primeiroDigitoVerificador * valorMultiplicatorio;
			  }
		
		}
		  segundoDigitoVerificador = segundoDigitoVerificador % 11;
		  
		  if (segundoDigitoVerificador >= 2) {
			segundoDigitoVerificador = 11 - segundoDigitoVerificador;
			
		  }else {
			  segundoDigitoVerificador = 0;
		  }
		  //Utiliza��o do captaDigito para pegar os �ltimos digitos indexados de 12 e 13 na String Cpf
		  captaDigito = cpf.charAt(12);
		  captaDigitoChar = String.valueOf(captaDigito);
		  salvaPrimeiroDigito = Integer.parseInt(captaDigitoChar);
		  
		  captaDigito = cpf.charAt(13);
		  captaDigitoChar = String.valueOf(captaDigito);
		  salvaSegundoDigito = Integer.parseInt(captaDigitoChar);
		  
		  /**
		   * Verifica a veracidade dos digitos calculados e compara com os digitos informados do cpf.
		   * E retorna true caso ambos digitos calculados sejam id�nticos aos informados.
		   */
		  if (primeiroDigitoVerificador == salvaPrimeiroDigito && segundoDigitoVerificador == salvaSegundoDigito) {
			  return true;
		  }
		  
		  return false;
		  
	 }

}
