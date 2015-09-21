package com.icraftgames.util;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.icraftgames.entities.Coin;
import com.icraftgames.entities.Player;
import com.icraftgames.screens.GameScreen;

public class CoinManager {
	
	public static Array<Coin> coins;
	private SaveHandler sh;
	
	
	
	public void init() {
		sh = new SaveHandler();
	}
	
	public CoinManager(int amount) {
		coins = new Array<Coin>(true, amount);
		for(int i = 0; i <= amount; i++) {
			int x = MathUtils.random(0, Gdx.graphics.getWidth());
			int y = MathUtils.random(0, Gdx.graphics.getHeight());
			Coin c = new Coin(new Vector2(x, y));
			c.setBounds((new Circle(x, y, 20f)));
			coins.add(c);
		}
	}
	
	
	public void addPoint(Coin c) {
		coins.removeValue(c, true);
		sh.setTempCoins(sh.getTempCoins() + 1);
		GameScreen.pointCount++;
	}
	
	public void collisionCheck(Player p, Coin c) {
			if(c.getBounds().overlaps(p.bounds)) {
				addPoint(c);
			}
		}
	
	
	
	
	public void render(SpriteBatch sb) {
		for(Coin c : coins) {
			sb.begin();
			c.render(sb);
			sb.end();
		}
		
		
	}
	
	
	
	
	

}
