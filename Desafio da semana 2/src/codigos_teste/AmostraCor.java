package codigos_teste;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class AmostraCor {

	private static EV3ColorSensor sensorCor = new EV3ColorSensor(SensorPort.S1);
	private static float cor;
	
	public static void main(String[] args){
		
		while(!Button.ESCAPE.isDown() && cor != 7.0){
			amostraCor();
			System.out.println("Cor: " + cor);
		}
		
	}
	private static void amostraCor(){
		SampleProvider cores = sensorCor.getColorIDMode();
		float amostraCor[] = new float [sensorCor.sampleSize()];
		cores.fetchSample(amostraCor, 0);
		cor = amostraCor[0];
	}
}
