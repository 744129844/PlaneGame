package com.ren.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.ren.util.Constant;
import com.ren.util.GameUtil;
import com.ren.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image space = GameUtil.getImage("images/space.jpg");
	Plane p = new Plane("images/earth.jpg", 50, 50);
	
	ArrayList bulletlist = new ArrayList();  //泛型暂时没学
	
	Date startTime,endTime;
	
	Explode bz = new Explode();
	
	public void paint(Graphics g) {
		//画背景
		g.drawImage(space, 0, 0, null);
		//画飞机
		p.draw(g);
		if (p.isLive()) {
			//画一堆子弹
			for (int i = 0; i < bulletlist.size(); i++) {
				Bullet b = (Bullet)bulletlist.get(i);
				b.draw(g);
				//检测跟飞机的碰撞
				boolean peng = b.getRect().intersects(p.getRect());
				if (peng) {
					p.setLive(false);
					endTime = new Date();
				}
			}
			
		} else {
			bz.draw(g, p.x, p.y);
			int liveTime = (int)((endTime.getTime()-startTime.getTime())/1000);
		    GameInfo(g, 50, Color.white, "GameOver", 200, 200);
		    GameInfo(g, 20, Color.red , "Time:"+liveTime+"S", 200, 220);

		}

	}
	
	public void launchFrame(){
		super.launchFrame();
		//增加键盘监听
		addKeyListener(new KeyMonitor());
		//生成一堆子弹
		for (int i = 0; i < 10; i++) {
			Bullet b = new Bullet();
			bulletlist.add(b);
		}
		startTime = new Date();
	}
	
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.subDirection(e);
		}
		
		
	}
	
	public void GameOver(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		Font f = new Font("宋体", Font.BOLD, 50);
		g.setFont(f);
		g.drawString("Game Over!", Constant.GAME_WIDTH/2-175, Constant.GAME_HEIGHT/2);
		g.setColor(c);
	}
	
	public void GameInfo(Graphics g,int FontSize,Color color,String InfoStr,int x,int y){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体", Font.BOLD, FontSize);
		g.setFont(f);
		g.drawString(InfoStr, x, y);
		g.setColor(c);
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}

}
