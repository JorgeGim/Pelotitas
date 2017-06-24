package juego;

import java.awt.Color;
import java.util.Random;

import entorno.Entorno;

public class Pelotita 
{
	private int x, y;
	private double diametro;
	private int velocidad;
	private boolean atrapada;
	
	public Pelotita() 
	{
		this.diametro = 20;
		Random gen = new Random();
		
		this.x = gen.nextInt(800);
		this.y = 0;
		this.velocidad = 1 + gen.nextInt(5);
		this.atrapada=false;
	}

	public void dibujarse(Entorno entorno) 
	{
		entorno.dibujarCirculo(this.x, this.y, this.diametro, Color.white);
	}

	public void avanzar() 
	{
		this.y+= this.velocidad;
	}

	public int getY() 
	{
		return this.y;
	}

	public int getX() 
	{
		return this.x;
	}

	public boolean getAtrapada() 
	{
		return this.atrapada;
	}

	public void setAtrapada(boolean atrapada)
	{
		this.atrapada = atrapada;
	}
}
