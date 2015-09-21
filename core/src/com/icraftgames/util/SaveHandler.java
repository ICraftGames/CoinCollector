package com.icraftgames.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class SaveHandler {
	
	private int totalCoins;
	private int tempCoins;
	
	
	public int getTotalCoins() { return totalCoins; }
	
	public void setTotalCoins(int amount) { totalCoins = amount; }
	
	public int getTempCoins() { return tempCoins; }
	
	public void setTempCoins(int amount) { tempCoins = amount; }
	
	public boolean saveFileExists(FileHandle f) {
		return f.exists();
	}
	
	public void loadTotalCoins() {
		FileHandle f = Gdx.files.internal("TotalCoins.sav");
		if(saveFileExists(f)) {
			InputStream inputStream = f.read();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			try {
				int totalCoins = dataInputStream.readInt();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} else if( saveFileExists(f) != true) {
			setTotalCoins(0);
			return;
		}
		
	}
	
	public void saveTotalCoins() {
		FileHandle f = Gdx.files.external(("TotalCoins.sav"));
		OutputStream outputStream = f.write(false);
		setTotalCoins(getTotalCoins() + getTempCoins());
		byte[] totalCoinBytes = ByteBuffer.allocate(999).putInt(getTotalCoins()).array();
		System.out.println("" + getTotalCoins());
		try {
			outputStream.write(totalCoinBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
