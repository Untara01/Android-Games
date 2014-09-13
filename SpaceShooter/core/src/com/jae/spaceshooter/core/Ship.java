package com.jae.spaceshooter.core;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;

public class Ship extends jSprite
{
	public float MaxSpeed = 400f;
	public float CurrentSpeed = 0f;
	public float Acceleration = 1f;
	public float RotationSpeed = 3.5f;
	public float ShotTimer = 0;
	public float ShotInterval = 0.3f;
	public float LaserSpeed = 25f;
	
	public Texture LaserTexture;
	public List<Laser> Lasers = new ArrayList<Laser>();
	
	public Ship(jSprite sprite, Texture laserTexture)
	{
		super(sprite);
		
		this.LaserTexture = laserTexture;
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
			
			System.out.println(this.Lasers.size());
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
			this.Lasers.add(new Laser(new jSprite(new Vector2(this.Position.x + this.getSpeedFromRotation(1, 13).x, this.Position.y + this.getSpeedFromRotation(1, 13).y), this.Rotation, this.getSpeedFromRotation(1, this.LaserSpeed), this.LaserTexture)));
			this.ShotTimer = 0;
		}
		
		for(int i = 0; i < this.Lasers.size(); i++)
		{
			this.Lasers.get(i).Update();
		}
		Vector2 speed = this.getSpeedFromRotation(deltaTime, this.CurrentSpeed);
		this.Move(speed.x, speed.y);
		this.ShotTimer += deltaTime;
	}
}
