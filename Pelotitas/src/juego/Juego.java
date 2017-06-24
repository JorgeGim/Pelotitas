package juego;

import java.awt.Color;

import entorno.*;


public class Juego extends InterfaceJuego
{
	private Entorno entorno;

	//Pelotita pelotita;
	Pelotita[] pelotita;
	Barra barra;
	private int atrapadas;


	Juego()
	{
		// Inicializa el objeto entorno, pero aun no lo inicia.
		entorno = new Entorno(this, "Pelotitas - Versi�n 0.01", 800, 600);
		
		barra = new Barra(100, entorno.alto()-70);
		this.pelotita = new Pelotita[15]; 
		for(int i = 0; i<this.pelotita.length; i++) {
			this.pelotita[i] = new Pelotita();
		}
		
		atrapadas = 0;

		
		
		/* 
		 * Es fundamental que reci�n al final del constructor de la clase Juego se 
		 * inicie el objeto entorno de la siguiente manera.
		 */
		entorno.iniciar();
	}

	/*
	 * Durante el juego, el m�todo tick() ser� ejecutado en cada instante y 
	 * por lo tanto es el m�todo m�s importante de esta clase. Aqu� se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		
		// Muestro cosas por pantalla
		for (int i=0;i<pelotita.length;i++)
		{
			if (!pelotita[i].getAtrapada())
			{
				pelotita[i].dibujarse(entorno);
			}		
		}
		
		barra.dibujarse(entorno);
		
		entorno.escribirTexto("Atrapadas: " + atrapadas, 20, 20);
		entorno.escribirTexto("Barra.x: " + barra.getX(), 20, 40);
		entorno.escribirTexto("Barra.y: " + barra.getY(), 20, 60);
		entorno.escribirTexto("p.x: " + pelotita[0].getX(), 20, 80);
		entorno.escribirTexto("p.y: " + pelotita[0].getY(), 20, 100);

		// Muevo las pelotitas
		if (!entorno.estaPresionada('P'))
		{
			for (int i=0;i<pelotita.length;i++)
			{
				if (!pelotita[i].getAtrapada())
				{
					pelotita[i].avanzar();
				}
			}
		}
	
		// Veo si se mueve la barra		
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && barra.getX() > 5)
			barra.moverIzquierda();
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) && barra.getX() < entorno.ancho() - 5)
			barra.moverDerecha();
		
		
		// Veo si hay colisiones
		for (int i = 0; i < pelotita.length; i++) 
		{
			if (!pelotita[i].getAtrapada())
				if (barra.colisionaCon(pelotita[i]))
				{
					pelotita[i].setAtrapada(true);
					atrapadas++;
				}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{		
		Juego juego = new Juego();
	}
}
