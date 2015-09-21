package com.icraftgames.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HighScoreManager {
	
	BitmapFont font;
	
	public void init() {
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
	}
	
	public void render(SpriteBatch sb) {
		sb.begin();
		font.draw(sb, "High Scoresssss", 5, 5);
		sb.end();
	}

}
