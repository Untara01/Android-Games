package com.jgames.lightspeed.graphics;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.jgames.lightspeed.data.Settings;

public class Assets 
{
	public static Texture background;
	
	public static Texture spriteSheet;
	
	public static void playSound(Sound sound)
	{
		sound.play(Settings.GetInstance().SFX_VOLUME);
	}
}
