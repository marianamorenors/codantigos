package rogerio_teste1;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

public class SensorIR {
	private EV3IRSensor sensorIR;
	private SampleProvider sample;
	private float[] amostraDistancia = new float[1];
	
	/**
	 * Construtor para o sensor de IR responsavel por detectar obstaculos
	 * @param port
	 * utilizar a porta referente com a a classe SensorPort: SensorPort.S1
	 */
	public SensorIR(Port port)
	{
		sensorIR = new EV3IRSensor(port);
		sample = sensorIR.getDistanceMode();
	}
	
	/**
	 * metodo que retorna a distancia em cm INTEIRO. 
	 * Range é de 5~50.
	 * Retorna 0 se <5 ou infinity se >50<br>
	 * não confirmado o range do valor de retorno
	 */
	public int distancia()
	{
		sample.fetchSample(amostraDistancia, 0);
		return (int)amostraDistancia[0];
	}
}
