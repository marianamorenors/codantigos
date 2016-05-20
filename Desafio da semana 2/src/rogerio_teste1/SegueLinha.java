package rogerio_teste1;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class SegueLinha
{
	private Port portME = MotorPort.A; // porta do brick do motor esquerdo
	private Port portMD = MotorPort.B; // porta do brick do motor direito
	private Port portSLE = SensorPort.S1; // porta do brick do sensor de linha esquerdo
	private Port portSLD = SensorPort.S2; // porta do brick do sensor de linha direito
	private Port portIR = SensorPort.S3; // porta do brick do sensor de IR para distancia
	private int lineColor = Color.BLACK; // cor da linha
	
	private Motor motorE = new Motor(portME);
	private Motor motorD = new Motor(portMD);
	
	private SensorLinha sLinhaE = new SensorLinha(lineColor, portSLE);
	private SensorLinha sLinhaD = new SensorLinha(lineColor, portSLD);
	private SensorIR sDistancia = new SensorIR(portIR);
	
	
	public void segueLinha()
	{		
		while(sDistancia.distancia()>6 && (!sLinhaE.naLinha() || !sLinhaD.naLinha()))
		{
			if(!sLinhaE.naLinha() && !sLinhaD.naLinha() && sDistancia.distancia()>6)
			{
				motorE.andarParaFrente(300);
				motorD.andarParaFrente(300);
			}
			else
			if(sLinhaE.naLinha() && !sLinhaD.naLinha() && sDistancia.distancia()>6) // detectou linha na esquerda
			{
				motorE.andarParaTras(100);
				motorD.andarParaFrente(130);
				Delay.msDelay(40);
				if(!sLinhaD.naLinha())
					Delay.msDelay(240);
			}
			else
			if(sLinhaD.naLinha() && !sLinhaE.naLinha() && sDistancia.distancia()>6) // detectou linha na direita
			{
				motorD.andarParaTras(100);
				motorE.andarParaFrente(130);
				Delay.msDelay(40);
				if(!sLinhaE.naLinha())
					Delay.msDelay(240);
			}
		}
		motorE.parar();
		motorD.parar();
		
	}
	
	public void alinharInicioSala2()
	{
		motorD.andarParaFrente(80);
		motorE.andarParaFrente(80);
		Delay.msDelay(2000);
		motorE.parar();
		motorD.parar();
		Delay.msDelay(20);
		motorE.andarParaTras(60);
		motorD.andarParaTras(60);
		
		while(!sLinhaD.naLinha() || !sLinhaE.naLinha())
		{
			if(sLinhaD.naLinha())
			motorD.parar();
			if(sLinhaE.naLinha())
			motorE.parar();
			
		}
	}	
}
