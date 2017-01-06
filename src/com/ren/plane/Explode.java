package com.ren.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.ren.util.GameUtil;

/**
 * 爆炸
 * @author RenJie
 *
 */
public class Explode {
	
	double x,y;
	static Image[] imgs = new Image[16];
	int count;
	
	static {
		for (int i = 0; i < 16; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	public void draw(Graphics g,double x, double y) {
		if (count<16) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}

	public Explode() {

	}

}
