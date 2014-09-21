package com.jgames.lightspeed.input;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.jgames.lightspeed.data.Settings;
import com.jgames.lightspeed.graphics.Sprite;

public class Joystick
{
	private Sprite knob;
	private Vector2 location;
	private boolean isActive;
	
	public Joystick(Texture knobTexture)
	{
		this.knob = new Sprite(knobTexture);
		this.location = new Vector2(Settings.GetInstance().JOYSTICK_POSITION);
		this.knob.SetLocation(this.location.x, this.location.y);
		this.isActive = false;
	}
}
