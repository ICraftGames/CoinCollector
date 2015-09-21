package com.icraftgames.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelManager {
	private BitmapFont font;
	private int levelCount;
	private int[] levelTimeGap;
	private SpriteBatch batch;
	public void init() {
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		batch = new SpriteBatch();
		levelCount = 0;
	}
	
	public void levelCheck(CoinManager coinManager, TimeManager timeManager, BombManager bombManager) {
		if(coinManager.coins.size == 0) {
				timeManager.index++;
				
			
			bombManager = new BombManager(3);
			coinManager = new CoinManager(5);
			levelCount++;
			
			
			
			
			
		}
	}
	
	public int getLevel() {
		return levelCount;
	}
	
	public void render() {
		batch.begin();
		font.draw(batch, "Level: " + levelCount, Gdx.graphics.getWidth() / 2 - 75, Gdx.graphics.getHeight() / 2 -250);
		batch.end();
	}

}
