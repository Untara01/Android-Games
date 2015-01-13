package com.jgames.lightspeed.graphics.particles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.game.MovingSprite;

public class Particle extends MovingSprite
{
	public int ParticleLife;
	public float ParticleTimer;
	public float ExpansionRate;
	public float RotationRate;
	public Vector2 Acceleration;
	
	public Particle(int particleLife, float expansionRate, float rotationRate,
			Vector2 speed, Vector2 acceleration,
			TextureRegion texture, float positionX, float positionY)
	{
		super(new Sprite(texture), speed);
		this.setPosition(positionX, positionY);
		
		this.Acceleration = acceleration;
		this.ParticleLife = particleLife;
		this.ExpansionRate = expansionRate;
		this.RotationRate = rotationRate;
	}
	
	public boolean updateParticle()
	{
		super.update();
		
		this.Speed.x += this.Acceleration.x;
		this.Speed.y += this.Acceleration.y;
		this.rotate(this.RotationRate);
		this.scale(this.ExpansionRate);
		
		if(this.ParticleTimer > this.ParticleLife)
		{
			return true;
		}
		
		return false;
	}
}
