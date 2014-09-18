package com.jgames.lightspeed.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;

public class Settings 
{
	public Preferences preferences;
	public final String PREF_NAME = "mainOptions";
	
	public float SFX_VOLUME = 1.0f;
	public float MUSIC_VOLUME = 1.0f;
	public boolean JOYSTICK_FIXED = true;
	public Vector2 JOYSTICK_POSITION = new Vector2(0, 0);
	public int JOYSTICK_RADIUS = 75;
	public String PLAYER_NAME = "New Player";
	
	public int CLASS_NUMBER = 1;
	
	private static Settings instance;
	
	public Settings()
	{
		this.preferences = Gdx.app.getPreferences(this.PREF_NAME);
		this.LoadConfig();
	}
	
	private void LoadConfig()
	{
		this.SFX_VOLUME = this.preferences.getFloat("sfxVolume", 1.0f);
		this.MUSIC_VOLUME = this.preferences.getFloat("musicVolume", 1.0f);
		this.JOYSTICK_FIXED = this.preferences.getBoolean("joystickFixed", true);
		this.JOYSTICK_POSITION.x = this.preferences.getFloat("joystickPositionX", 100);
		this.JOYSTICK_POSITION.y = this.preferences.getFloat("joystickPositionY", 100);
		this.JOYSTICK_RADIUS = this.preferences.getInteger("joystickRadius", 75);
		this.PLAYER_NAME = this.preferences.getString("playerName", "New Player");
		this.CLASS_NUMBER = this.preferences.getInteger("classNumber", 1);
	}
	
	public void SetSFXVolume(float value)
	{
		this.preferences.putFloat("sfxVolume", value);
	}
	
	public void SetMusicVolume(float value)
	{
		this.preferences.putFloat("musicVolume", value);
	}

	public void SetJoystickFixed(boolean value)
	{
		this.preferences.putBoolean("joystickFixed", value);
	}
	
	public void SetJoystickPosition(Vector2 value)
	{
		this.preferences.putFloat("joystickPositionX", value.x);
		this.preferences.putFloat("joystickPositionY", value.y);
	}

	public void SetJoystickRadius(int value)
	{
		this.preferences.putInteger("joystickRadius", value);
	}

	public void SetPlayerName(String value)
	{
		this.preferences.putString("playerName", value);
	}
	
	public void SetClassNumber(int value)
	{
		this.preferences.putInteger("classNumber", value);
	}
	
	public static Settings GetInstance()
	{
		if(instance != null)
		{
			return instance;
		}
		
		instance = new Settings();
		return instance;
	}
}
