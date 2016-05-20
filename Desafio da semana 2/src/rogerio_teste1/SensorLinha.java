package rogerio_teste1;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;

public class SensorLinha
{
	private int corDaLinha = Color.NONE;
	private EV3ColorSensor sensorLinha;
	private SampleProvider sample;
	private float[] amostracor = new float[1];
	
	/**
	 * Construtor para os sensores de cor que são responsaveis por
	 * manter o robo na linha
	 * @param corDaLinha
	 * utilizar constantes da classe Color: Color.BLACK
	 * @param port
	 * utilizar a porta referente com a a classe SensorPort: SensorPort.S1
	 */
	public SensorLinha(int corDaLinha, Port port)
	{
		sensorLinha = new EV3ColorSensor(port);
		this.corDaLinha = corDaLinha;
		sample = sensorLinha.getColorIDMode();
	}
	
	/**
	 * verifica se o sensor esta na linha
	 * @return
	 * @true para sensor na linha
	 * @false para sensor fora da linha
	 */
	public boolean naLinha()
	{		
		sample.fetchSample(amostracor, 0);
		if(amostracor[0] == corDaLinha)
			return true;
		else 
			return false;
	}
}
