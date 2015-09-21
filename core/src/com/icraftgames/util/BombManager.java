package com.icraftgames.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.icraftgames.entities.Bomb;
import com.icraftgames.entities.Coin;
import com.icraftgames.entities.Player;
import com.icraftgames.screens.GameScreen;

public class BombManager {
	
	public static Array<Bomb> bombs;
	
	public BombManager(int amount) {
		bombs = new Array<Bomb>(true, amount);
		for(int i = 0; i < amount; i++) {
			int x = MathUtils.random(0, Gdx.graphics.getWidth());
			int y = MathUtils.random(0, Gdx.graphics.getHeight());
			Bomb bomb = new Bomb(new Vector2(x, y));
			bomb.setBounds(new Circle(x , y, 20f));
			bombs.add(bomb);
		}
	}
	
	public void init() {
		
	}
	
	public void render(SpriteBatch batch) {
		
		for(Bomb b : bombs) {
			b.render(batch);
			collisionCheck(GameScreen.player, b);
		}
		
		
		
	}
	
	public void collisionCheck(Player p, Bomb b) {
		if(b.getBounds().overlaps(p.bounds)) {
			removeSeconds(5, GameScreen.timeManager);
			bombs.removeValue(b, true);
		}
	}
	
	public void removeSeconds(int amount, TimeManager timeManager) {
		timeManager.time[timeManager.index] -= 5;
	}

}
