package com.jgames.lightspeed.graphics.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.graphics.MovingSprite;
import com.jgames.lightspeed.graphics.Sprite;
import com.jgames.lightspeed.input.InputPair;
import com.jgames.lightspeed.input.Joystick;
import com.jgames.lightspeed.input.TouchHandler;
import com.jgames.lightspeed.screens.GameScreen;

public class Ship extends MovingSprite
{
	public float MaxSpeed = 400f;
	public float CurrentSpeed = 0f;
	public float Acceleration = 800f;
	public float RotationSpeed = 3.5f;
	public float ShotTimer = 0;
	public float ShotInterval = 0.2f;
	public float LaserSpeed = 25f;
	public GameScreen ThisScreen;
	
	public Texture LaserTexture;
	public List<Laser> Lasers = new ArrayList<Laser>();
	
	public Ship(Sprite sprite, Texture laserTexture, GameScreen thisScreen)
	{
		super(sprite);
		
		this.LaserTexture = laserTexture;
		this.ThisScreen = thisScreen;
	}
	
	public void DrawShip(SpriteBatch batch)
	{
		this.Draw(batch);
		
		for(int i = 0; i < this.Lasers.size(); i++)
		{
			this.Lasers.get(i).Draw(batch);
		}
	}
	
	public void UpdateShip(float deltaTime, float[] values)
	{
		if(values[1] != 0)
		{
			this.CurrentSpeed += this.Acceleration * deltaTime;
			
			if(this.CurrentSpeed > this.MaxSpeed)
			{
				this.CurrentSpeed = this.MaxSpeed;
			}
		}
		if(values[2])
		{
			this.Rotation += this.RotationSpeed * deltaTime;
		}
		if(values[3])
		{
			this.Rotation += -this.RotationSpeed * deltaTime;
		}
		if(values[2] == 1 && this.ShotTimer > this.ShotInterval)
		{
			this.Lasers.add(new Laser(new MovingSprite(new Sprite(new Vector2(this.GetLocation().x, this.GetLocation().y), this.Rotation, this.LaserTexture)), this, this.getSpeedFromRotation(1, this.LaserSpeed)));
			this.ShotTimer = 0;
		}
		
		for(int i = 0; i < this.Lasers.size(); i++)
		{
			if(!this.Lasers.get(i).UpdateLaser())
			{
				this.Lasers.remove(i);
				i--;
			}
		}
		
		this.Speed = this.getSpeedFromRotation(deltaTime, this.CurrentSpeed);
		this.move();
		
		if(this.GetLocation().x > LightSpeed.screenWidth)
		{
			this.SetLocation(0, this.GetLocation().y);
		}
		else if(this.GetLocation().x < 0)
		{
			this.SetLocation(LightSpeed.screenWidth, this.GetLocation().y);;
		}
		if(this.GetLocation().y > LightSpeed.screenHeight)
		{
			this.SetLocation(this.GetLocation().x, 0);
		}
		else if(this.GetLocation().y < 0)
		{
			this.SetLocation(this.GetLocation().x, LightSpeed.screenHeight);
		}
		
		this.ShotTimer += deltaTime;
	}
	
	public float[] GetInputs(Joystick joystick)
	{
		float movement = joystick.GetValues().y / 75;
		float rotation = joystick.GetValues().x / 75;
		float shoot = 0;
		
		for(int i = 0; i < TouchHandler.Data.size(); i++)
		{
			if(TouchHandler.Data.get(i).isDown && TouchHandler.Data.get(i).x > LightSpeed.screenWidth / 2)
			{
				shoot = 1;
			}
		}
		
		return new float[] {movement, rotation, shoot};
	}
}
