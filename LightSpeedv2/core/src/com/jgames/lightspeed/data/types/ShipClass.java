package com.jgames.lightspeed.data.types;

import java.util.ArrayList;

public class ShipClass
{
	public static ArrayList<ShipClass> shipClasses = new ArrayList<ShipClass>();
	
	public String Name;
	public ShipType Ship;
	public ArrayList<GunType> Guns;
	public ArmorType Armor;
	public EngineType Engine;
	
	public ShipClass(String name, ShipType ship,
			ArrayList<GunType> guns, ArmorType armor, EngineType engine)
	{
		this.Name = name;
		this.Ship = ship;
		
		this.Guns = guns;
		this.Armor = armor;
		this.Engine = engine;
	}
}
