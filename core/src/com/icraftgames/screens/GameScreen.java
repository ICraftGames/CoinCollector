package com.icraftgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.icraftgames.entities.Coin;
import com.icraftgames.entities.Player;
import com.icraftgames.util.BombManager;
import com.icraftgames.util.CoinManager;
import com.icraftgames.util.LevelManager;
import com.icraftgames.util.TimeManager;

public class GameScreen implements Screen {

	SpriteBatch batch;
	public Texture img;
	public static Player player;
	private BitmapFont font;
	private String coins;
	private CoinManager coinManager;
	public static int pointCount;
	private LevelManager levelManager;
	private Texture sTexture;
	private Sprite sSprite;
	private Texture backgroundTexture;
	private Sprite backgroundSprite;
	public static TimeManager timeManager;
	private BombManager bombManager;
	
	@Override
	public void show() {
		
		batch = new SpriteBatch();
		img = new Texture("Player.png");
		sTexture = new Texture("ShopButton.png");
		sSprite = new Sprite(sTexture);
		backgroundTexture = new Texture("Background.png");
		backgroundSprite = new Sprite(backgroundTexture);
		player = new Player();
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		coins = "Coins: ";
		pointCount = 0;
		coinManager = new CoinManager(5);
		coinManager.init();
		player.init();
		levelManager = new LevelManager();
		levelManager.init();
		timeManager = new TimeManager();
		timeManager.init(levelManager);
		bombManager = new BombManager(3);
		bombManager.init();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		backgroundSprite.draw(batch);
		font.draw(batch, coins + pointCount, Gdx.graphics.getWidth() / 2 - 75, Gdx.graphics.getHeight() / 2 + 250);
		batch.draw(sSprite, 0, 0, 128, 64);
		batch.end();
		player.render(Gdx.graphics.getDeltaTime());
		coinManager.render(batch);
		levelManager.render();
		timeManager.render();
		
		batch.begin();
		bombManager.render(batch);
		batch.end();
		

		
		for(Coin c: CoinManager.coins)
			coinManager.collisionCheck(player, c);
		
		levelManager.levelCheck(coinManager, timeManager, bombManager);
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}
	
}
