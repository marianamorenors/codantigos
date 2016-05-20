package roboSeguidorLinha;

import lejos.hardware.Button;

public class Anda_teste {

	private static float corD; // Cria as vari�vel que vai receber o valor do sensor de cor direito.
	private static float corE; // Cria a vari�vel que vai receber o valor do sensor  de cor esquerdo.

	public static void main(String[] args) {

		while (!Button.ESCAPE.isDown()) {
			
			corD = Sensor.getCorDireita(); // Recebe o valor do sensor de cor.
			corE = Sensor.getCorEsquerda(); // Recebe o valor do sensor de cor.
			
			if(corD != 7.0 && corE != 7.0){ // Compara se o valor que os sensores retornam n�o � 7.0 (Preto). 
				
				Motor.andar_frente(); // Caso n�o seja preto o nosso menino anda.
				
			}else{
				
				Motor.corrigeRota(); // Caso seja preto a rota ser� corrijida.
				
			}
			
		}
	}
}
