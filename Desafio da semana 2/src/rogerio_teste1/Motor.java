package rogerio_teste1;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

/**
 * Classe que controla o motor, falta muito de ser implementada ainda
 * @author Rogério
 *
 */
public class Motor {
	private EV3LargeRegulatedMotor motor;
	
	/**
	 * velocidade padrao 360 graus por s.
	 * @param port
	 * utilizar a classe MotorPort: MotorPort.A
	 */
	public Motor(Port port)
	{
		motor = new EV3LargeRegulatedMotor(port);
		motor.setSpeed(360);
	}
	
	public void andarParaFrente(int velo)
	{
		motor.setSpeed(velo);
		motor.forward();
	}
	
	public void andarParaTras(int velo)
	{
		motor.setSpeed(velo);
		motor.backward();
	}
	
	public int getEncoder()
	{
		return motor.getTachoCount();
	}
	
	public void parar()
	{
		motor.stop();
	}
	
	public void girar(int graus, boolean esperar)
	{
		motor.rotate(graus, esperar);
	}
}
