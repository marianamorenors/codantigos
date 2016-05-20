package roboSeguidorLinha;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Motor {

	// Cria as variáveis reponsaveis por representar cada mortor e as vincula a
	// uma porta

	private static EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.B); // Motor
																							// esquerdo
	private static EV3LargeRegulatedMotor motorE = new EV3LargeRegulatedMotor(MotorPort.A); // Motor
																							// Direito

	/**
	 * Metodo responsável por fazer os motores girarem pra frente
	 */
	public static void andar_frente() {
		motorD.setSpeed(250);
		motorE.setSpeed(250);
		motorD.forward();
		motorE.forward();
	}

	/**
	 * Metodo reponsável por fazer os motores girarem pra tras
	 */
	public static void andar_tras() {
		motorD.setSpeed(250);
		motorE.setSpeed(250);
		motorD.backward();
		motorE.backward();
	}

	/**
	 * Método que para os motores ao mesmo tempo.
	 */
	public static void parar() {
		motorD.stop();
		motorE.stop();
	}

	/**
	 * Método não finalizado mas operacional, que corrige a rota do robo.
	 */
	public static void corrigeRota() {
		float corD = Sensor.getCorDireita();
		float corE = Sensor.getCorEsquerda();

		if (corD == 7.0) {
			Motor.parar();

			while (corD == 7.0) {
				motorE.setSpeed(90);
				motorE.rotate(45);
				corD = Sensor.getCorDireita();
			}
		} else if (corE == 7.0) {
			Motor.parar();

			while (corE == 7.0) {
				motorD.setSpeed(90);
				motorD.rotate(45);
				corE = Sensor.getCorEsquerda();
			}
		}
	}
}
