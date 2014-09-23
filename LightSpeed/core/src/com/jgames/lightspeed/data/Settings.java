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
	public boolean FRIENDLY_FIRE = false;
	
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
		this.FRIENDLY_FIRE = this.preferences.getBoolean("friendlyFire", false);
		
		this.CLASS_NUMBER = this.preferences.getInteger("classNumber", 1);
	}
	
	public void SetSFXVolume(float value)
	{
		this.preferences.putFloat("sfxVolume", value);
		this.SFX_VOLUME = value;
		this.preferences.flush();
	}
	
	public void SetMusicVolume(float value)
	{
		this.preferences.putFloat("musicVolume", value);
		this.MUSIC_VOLUME = value;
		this.preferences.flush();
	}

	public void SetJoystickFixed(boolean value)
	{
		this.preferences.putBoolean("joystickFixed", value);
		this.JOYSTICK_FIXED = value;
		this.preferences.flush();
	}
	
	public void SetJoystickPosition(Vector2 value)
	{
		this.preferences.putFloat("joystickPositionX", value.x);
		this.preferences.putFloat("joystickPositionY", value.y);
		this.JOYSTICK_POSITION = value;
		this.preferences.flush();
	}

	public void SetJoystickRadius(int value)
	{
		this.preferences.putInteger("joystickRadius", value);
		this.JOYSTICK_RADIUS = value;
		this.preferences.flush();
	}

	public void SetPlayerName(String value)
	{
		this.preferences.putString("playerName", value);
		this.PLAYER_NAME = value;
		this.preferences.flush();
	}
	
	public void SetFriendlyFire(boolean value)
	{
		this.preferences.putBoolean("friendlyFire", value);
		this.FRIENDLY_FIRE = value;
		this.preferences.flush();
	}
	
	public void SetClassNumber(int value)
	{
		this.preferences.putInteger("classNumber", value);
		this.CLASS_NUMBER = value;
		this.preferences.flush();
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
