package com.jgames.lightspeed.data.types;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class InfoType 
{
	public static ArrayList<InfoType> InfoTypes = new ArrayList<InfoType>();
	
	public String Name;
	public TextureRegion Texture;
	
	public InfoType(String name, TextureRegion texture)
	{
		this.Name = name;
		this.Texture = texture;
		InfoTypes.add(this);
	}
	
	public InfoType getType(String name)
	{
		for(InfoType type : InfoTypes)
		{
			if(type.Name == name)
			{
				return type;
			}
		}
		
		return null;
	}
}