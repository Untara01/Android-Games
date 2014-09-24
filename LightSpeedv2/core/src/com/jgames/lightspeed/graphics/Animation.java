package com.jgames.lightspeed.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation 
{
	public static enum AnimationState
	{
		ANIMATION_LOOPING,
		ANIMATION_NONLOOPING
	}

	private final TextureRegion[] frames;
	private final float frameDuration;

	public Animation (float frameDuration, TextureRegion... frames) 
	{
		this.frameDuration = frameDuration;
		this.frames = frames;
	}

	public TextureRegion getFrame (float stateTime, AnimationState mode) 
	{
		int frameNumber = (int)(stateTime / frameDuration);

		if (mode == AnimationState.ANIMATION_NONLOOPING) 
		{
			frameNumber = Math.min(frames.length - 1, frameNumber);
		} 
		else 
		{
			frameNumber = frameNumber % frames.length;
		}
		
		return frames[frameNumber];
	}
}
