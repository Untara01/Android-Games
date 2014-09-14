package com.jae.spaceshooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jae.spaceshooter.SpaceShooter;

public class DesktopLauncher
{
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SpaceShooter(), config);
		
		config.title = "Space Shooter";
		config.width = 800;
		config.height = 480;
	}
}
