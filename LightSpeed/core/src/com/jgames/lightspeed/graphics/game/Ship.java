package com.jgames.lightspeed.graphics.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.jgames.lightspeed.LightSpeed;
import com.jgames.lightspeed.graphics.MovingSprite;
import com.jgames.lightspeed.graphics.Sprite;
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
			this.CurrentSpeed += this.Acceleration * deltaTime;
			
			if(this.CurrentSpeed > this.MaxSpeed)
			{
				this.CurrentSpeed = this.MaxSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			this.CurrentSpeed -= this.Acceleration * deltaTime;
			
			if(this.CurrentSpeed < -this.MaxSpeed)
			{
				this.CurrentSpeed = -this.MaxSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE) && this.ShotTimer > this.ShotInterval)
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
}
