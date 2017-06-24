package juego;

import java.awt.Color;

import entorno.Entorno;

public class Barra 
{
	// Variables de instancia
	private int x, y;
	private int ancho;
	private int alto;

	public Barra(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.ancho = 100;
		this.alto = 10;
	}

	public void moverIzquierda() 
	{
		this.x -= 10;
	}
	
	public void moverDerecha() 
	{
		this.x += 10;
	}

	public void dibujarse(Entorno entorno) 
	{
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.yellow);
		
	}

	public int getX() 
	{
		return this.x;
	}

	public boolean colisionaCon(Pelotita p) 
	{
		if (p.getY() >= this.y - (this.alto / 2) && p.getY() <= this.y + (this.alto / 2) &&
			p.getX() >= this.x - (this.ancho / 2) && p.getX() <= this.x + (this.ancho / 2))
		{
			return true;
		}
		
		return false;			
	}

	public int getY() 
	{
		return this.y;
	}

	
	
	
	
	
	
	
	
}
