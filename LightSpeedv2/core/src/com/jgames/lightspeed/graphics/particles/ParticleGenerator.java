package com.jgames.lightspeed.graphics.particles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.sun.prism.TextureMap;

public class ParticleGenerator 
{
	public ArrayList<Particle> Particles;
	public ArrayList<TextureMap> Textures;
	
	public Vector2 Position;
	public int MinParticleLife;
	public int MaxParticleLife;
	public int MinRotationRate;
	public int MaxRotationRate;
	public int MinExpansionRate;
	public int MaxExpansionRate;
	public int MinSpeedX;
	public int MaxSpeedX;
	public int MinSpeedY;
	public int MaxSpeedY;
	public int MinAccelerationX;
	public int MaxAccelerationX;
	public int MinAccelerationY;
	public int MaxAccelerationY;
	
	public int ParticleDensity;
	public int MinPositionX;
	public int MaxPositionX;
	public int MinPositionY;
	public int MaxPositionY;
	
	public ParticleGenerator(TextureRegion... textures)
	{
		
	}
}
