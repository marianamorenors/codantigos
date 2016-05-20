package codigos_teste;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class AndarPraFrente {

	private static EV3LargeRegulatedMotor motorEsq = new EV3LargeRegulatedMotor(MotorPort.A);
	private static EV3LargeRegulatedMotor motorDir = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		motorEsq.forward();;
		motorDir.forward();
		Delay.msDelay(3000);
	}

}
