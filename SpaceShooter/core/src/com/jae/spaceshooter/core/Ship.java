package com.jae.spaceshooter.core;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.jae.spaceshooter.Settings;
import com.jae.spaceshooter.screens.GameScreen;

public class Ship extends jSprite
{
	Sprite sprite = new SPrite();
	
	public float MaxSpeed = 400f;
	public float CurrentSpeed = 0f;
	public float Acceleration = 800f;
	public float RotationSpeed = 3.5f;
	public float ShotTimer = 0;
	public float ShotInterval = 0.2f;
	public float LaserSpeed = 25f;
	public GameScreen ContScreen;
	
	public Texture LaserTexture;
	public List<Laser> Lasers = new ArrayList<Laser>();
	
	public Ship(jSprite sprite, Texture laserTexture, GameScreen contScreen)
	{
		super(sprite);
		
		this.LaserTexture = laserTexture;
		this.ContScreen = contScreen;
	}
	
	public void DrawShip(SpriteBatch batch)
	{
		this.Draw(batch);
		
		for(int i = 0; i < this.Lasers.size(); i++)
		{
			batch.draw(this.Lasers.get(i).Texture, 
					this.Lasers.get(i).Position.x - this.Lasers.get(i).Origin.x, this.Lasers.get(i).Position.y - this.Lasers.get(i).Origin.y, this.Lasers.get(i).Origin.x, this.Lasers.get(i).Origin.y, 
					this.Lasers.get(i).Texture.getWidth(), this.Lasers.get(i).Texture.getHeight(), this.Lasers.get(i).Scale.x, this.Lasers.get(i).Scale.y, 
	    			(float)Math.toDegrees(this.Lasers.get(i).Rotation) - 90, 0, 0, 
	    			this.Lasers.get(i).Texture.getWidth(), this.Lasers.get(i).Texture.getHeight(), false, false);
		}
	}
	
	public void UpdateShip(float deltaTime)
	{
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.Rotation += this.RotationSpeed * deltaTime;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			this.Rotation += -this.RotationSpeed * deltaTime;
		}
		if(Gdx.input.isKeyPressed(Keys.UP))
		{
			this.CurrentSpeed += this.Acceleration;
			
			if(this.CurrentSpeed > this.MaxSpeed)
			{
				this.CurrentSpeed = this.MaxSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			this.CurrentSpeed -= this.Acceleration;
			
			if(this.CurrentSpeed < -this.MaxSpeed)
			{
				this.CurrentSpeed = -this.MaxSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE) && this.ShotTimer > this.ShotInterval)
		{
			this.Lasers.add(new Laser(new jSprite(new Vector2(this.Position.x + this.getSpeedFromRotation(1, 13).x, this.Position.y + this.getSpeedFromRotation(1, 13).y), this.Rotation, this.getSpeedFromRotation(1, this.LaserSpeed), this.LaserTexture), this));
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
		
		Vector2 speed = this.getSpeedFromRotation(deltaTime, this.CurrentSpeed);
		this.Move(speed.x, speed.y);
		
		if(this.Position.x > Gdx.graphics.getWidth())
		{
			this.Position.x = 0;
		}
		else if(this.Position.x < 0)
		{
			this.Position.x = Gdx.graphics.getWidth();
		}
		if(this.Position.y > Gdx.graphics.getHeight())
		{
			this.Position.y = 0;
		}
		else if(this.Position.y < 0)
		{
			this.Position.y = Gdx.graphics.getHeight();
		}
		
		this.ShotTimer += deltaTime;
	}
	
	public void UpdateShip(float deltaTime, jJoystick joystick)
	{
		int touchInt = -1;
		
		for(int i = 0; i < 5; i++)
		{
			if(TouchHandler.Data.get(i).isDown && TouchHandler.Data.get(i).x > Settings.width / 2)
			{
				touchInt = i;
			}
		}
		
		if(touchInt != -1)
		{
			if(TouchHandler.Data.get(touchInt).isDown && this.ShotTimer > this.ShotInterval)
			{
				this.Lasers.add(new Laser(new jSprite(new Vector2(this.Position.x + this.getSpeedFromRotation(1, 13).x, this.Position.y + this.getSpeedFromRotation(1, 13).y), this.Rotation, this.getSpeedFromRotation(1, this.LaserSpeed), this.LaserTexture), this));
				this.ShotTimer = 0;
			}
		}
		
		for(int i = 0; i < this.Lasers.size(); i++)
		{
			if(!this.Lasers.get(i).UpdateLaser())
			{
				this.Lasers.remove(i);
				i--;
			}
		}
		
		if(joystick.GetValues() != null)
		{
			if(joystick.GetValues().x < 0)
			{
				this.Rotation += this.RotationSpeed * deltaTime * (-joystick.GetValues().x / 75);
			}
			if(joystick.GetValues().x > 0)
			{
				this.Rotation += -this.RotationSpeed * deltaTime * (joystick.GetValues().x / 75);
			}
			if(joystick.GetValues().y > 0)
			{
				System.out.println(joystick.GetValues().y);
				
				this.CurrentSpeed += this.Acceleration * deltaTime * (joystick.GetValues().y / 75);
				
				if(this.CurrentSpeed > this.MaxSpeed)
				{
					this.CurrentSpeed = this.MaxSpeed;
				}
			}
			if(joystick.GetValues().y < 0)
			{
				this.CurrentSpeed -= this.Acceleration * deltaTime * (joystick.GetValues().y / -75);;
				
				if(this.CurrentSpeed < -this.MaxSpeed)
				{
					this.CurrentSpeed = -this.MaxSpeed;
				}
			}
		}
		
		Vector2 speed = this.getSpeedFromRotation(deltaTime, this.CurrentSpeed);
		this.Move(speed.x, speed.y);
		
		if(this.Position.x > Settings.width)
		{
			this.Position.x = 0;
		}
		else if(this.Position.x < 0)
		{
			this.Position.x = Settings.width;
		}
		if(this.Position.y > Settings.height)
		{
			this.Position.y = 0;
		}
		else if(this.Position.y < 0)
		{
			this.Position.y = Settings.height;
		}
		
		this.ShotTimer += deltaTime;
	}
}
