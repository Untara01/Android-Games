package com.jgames.lightspeed.data.types;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgames.lightspeed.data.Assets;

public class ShipType extends InfoType
{
	public float MaxWeight;
	public float
	
	public ShipType(String name, TextureRegion texture,
			float maxSpeed, float acceleration, float rotationSpeed) 
	{
		super(name, texture);
	}
	
	public ShipType light1 = new ShipType("light1", Assets.shipYellow,
			450f, 800f, 240f);
	public ShipType light2 = new ShipType("light2", Assets.shipYellow,
			500f, 900f, 230f);
}