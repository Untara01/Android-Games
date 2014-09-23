package com.jgames.lightspeed.teams;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.graphics.Sprite;
import com.jgames.lightspeed.graphics.game.Ship;
import com.jgames.lightspeed.screens.GameScreen;

public class Team 
{
	public ArrayList<Ship> Elements;
	public String Name;
	
	public Team(String Name, int Elements, Ship[] Ships,
			GameScreen screen, Texture laserTexture,
			Vector2 position, float rotation, Texture shipTexture)
	{
		this.Name = Name;
		
		this.Elements = new ArrayList<Ship>();
		for(int i = 0; i < Ships.length; i++)
		{
			this.Elements.add(Ships[i]);
		}
		for(int i = 0; i < Elements; i++)
		{
			Vector2 newPosition = new Vector2((float)Math.cos(rotation + 90) * (i * 60), (float)Math.sin(rotation + 90) * (i * 60));
			
			this.Elements.add(new Ship(new Sprite(new Vector2(position.x + newPosition.x, position.y + newPosition.y), rotation, shipTexture), laserTexture, screen));
		}
	}
}
