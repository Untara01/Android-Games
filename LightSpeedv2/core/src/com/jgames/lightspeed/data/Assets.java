package com.jgames.lightspeed.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jgames.lightspeed.graphics.Animation;

public class Assets 
{
	public static Texture background;
	public static TextureRegion backgroundRegion;

	public static Texture buttons;
	public static TextureRegion smallButton;
	public static TextureRegion largeButton;
	
	public static TextureRegion joystickKnob;
	public static TextureRegion joystickPoint;
	
	public static BitmapFont font;

	public static Texture loadTexture (String file) 
	{
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () 
	{
		Assets.background = loadTexture("GameBackground.png");
		Assets.backgroundRegion = new TextureRegion(Assets.background, 0, 0, 800, 480);

		Assets.buttons = loadTexture("ButtonSheet.png");
		Assets.smallButton = new TextureRegion(Assets.buttons, 64, 0, 32, 16);
		Assets.largeButton = new TextureRegion(Assets.buttons, 0, 0, 64, 16);
		
		Assets.joystickKnob = new TextureRegion(Assets.buttons, 16, 16, 16, 16);
		Assets.joystickPoint = new TextureRegion(Assets.buttons, 0, 16, 16, 16);

		Assets.font = new BitmapFont();
/*
		Assets.music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		Assets.music.setLooping(true);
		Assets.music.setVolume(Settings.GetInstance().MUSIC_VOLUME);
		
		if(Settings.GetInstance().MUSIC_VOLUME > 0)
		{
			Assets.music.play();
		}*/
	}

	public static void playSound (Sound sound) 
	{
		if(Settings.GetInstance().SFX_VOLUME > 0)
		{
			sound.play(Settings.GetInstance().SFX_VOLUME);
		}
	}
}
