package com.jgames.lightspeed.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgames.lightspeed.LightSpeed;
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
	
	public TextureRegion LaserTexture;
	public List<Laser> Lasers = new ArrayList<Laser>();
	
	public Ship(Sprite sprite, TextureRegion laserTexture, GameScreen thisScreen)
	{
		super(sprite);
		
		this.LaserTexture = laserTexture;
		this.ThisScreen = thisScreen;
	}
	
	public void DrawShip(SpriteBatch batch)
	{
		this.draw(batch);
		
		for(int i = 0; i < this.Lasers.size(); i++)
		{
			this.Lasers.get(i).draw(batch);
		}
	}
	
	public void UpdateShip(float deltaTime, float[] values)
	{
		if(values[0] != 0)
		{
			this.CurrentSpeed += this.Acceleration * deltaTime * values[0];
			
			if(this.CurrentSpeed > this.MaxSpeed)
			{
				this.CurrentSpeed = this.MaxSpeed;
			}
			else if(this.CurrentSpeed < -this.MaxSpeed)
			{
				this.CurrentSpeed = -this.MaxSpeed;
			}
		}
		if(values[1] != 0)
		{
			this.setRotation(this.getRotation() + (this.RotationSpeed * deltaTime * values[1]));
		}
		if(values[2] == 1 && this.ShotTimer > this.ShotInterval)
		{
			Laser laser = new Laser(new MovingSprite(new Sprite(this.LaserTexture)), this, this.getSpeedFromRotation(1, this.LaserSpeed));
			laser.setPosition(this.getX(), this.getY());
			laser.setRotation(this.getRotation());
			laser.Speed = this.getSpeedFromRotation(1, this.LaserSpeed);
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
		
		if(this.getX() > LightSpeed.screenWidth)
		{
			this.setX(0);
		}
		else if(this.getX() < 0)
		{
			this.setX(LightSpeed.screenWidth);
		}
		if(this.getY() > LightSpeed.screenHeight)
		{
			this.setY(0);
		}
		else if(this.getY() < 0)
		{
			this.setY(LightSpeed.screenHeight);
		}
		
		this.ShotTimer += deltaTime;
	}
	
	public float[] GetInputs(Joystick joystick)
	{
		float movement = joystick.GetValues().y / 75;
		float rotation = -joystick.GetValues().x / 75;
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