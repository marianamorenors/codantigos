package roboSeguidorLinha;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class Sensor {
	
	private static EV3ColorSensor sensorDireita = new EV3ColorSensor(SensorPort.S2); // Sensor de cor EV3 do lado direto
	private static EV3ColorSensor sensorEsquerda = new EV3ColorSensor(SensorPort.S1); // Sensor de cor Ev3 do lado Esquerdo
	private static float corEsquerda = 0; // Variável que recebe o retorno do sensor de cor do lado esquerdo
	private static float corDireita = 0; // Variável que recebe o retorno do sensor de cor do lado direito
	 
	/**
	 * Método que retorna o valor da variável corEsquerda
	 * @return
	 */
	public static float getCorEsquerda(){
		SampleProvider cores1 = sensorEsquerda.getColorIDMode();
		float amostraCor1[] = new float[sensorEsquerda.sampleSize()];
		cores1.fetchSample(amostraCor1, 0);
		corEsquerda = amostraCor1[0];
		return corEsquerda;
	}
	/**
	 * Método que retorna o valor da variável corDireita
	 * @return
	 */
	public static float getCorDireita(){
		SampleProvider cores = sensorDireita.getColorIDMode();
		float amostraCor[] = new float[sensorDireita.sampleSize()];
		cores.fetchSample(amostraCor, 0);
		corDireita = amostraCor[0];
		return corDireita;
	}
}
