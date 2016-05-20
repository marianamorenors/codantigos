package rogerio_teste1;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class SensorCor {
	private EV3ColorSensor sensorCor;
	private SampleProvider sample;
	private float[] amostraCor = new float[1];
	
	/**
	 * Construtor para o SensorCor que vai detectar a cor do boneco
	 * @param port
	 * utilizar a porta referente com a a classe SensorPort: SensorPort.S1
	 */
	public SensorCor(Port port)
	{
		sensorCor = new EV3ColorSensor(port);
		sample = sensorCor.getColorIDMode();
	}
	
	/**
	 * Retorna um inteiro referente a uma cor:<br>
	 * 7: Color.BLACK<br>
	 * 0: Color.RED<br>
	 * 6: Color.WHITE<br>
	 * -1: Color.NONE<br>
	 */
	public int getCor()
	{
		sample.fetchSample(amostraCor, 0);
		return (int)amostraCor[0];
	}
}
