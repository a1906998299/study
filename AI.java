import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int	i,j;
	int flag;
	Image bossImg;
	Image currentImg;
	Image heroImg[][]=new Image[4][3];//左0，右1，上3，下2

	Random rd=new Random();

	public MainCanvas(){
		try
		{
			for(i=0;i<4;i++)
				for(j=0;j<3;j++){
                  heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][0];
			heroX=120;
			heroY=100;
			flag=1;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);
			try
			{
			    Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if(rdNumber%3==0){
				if(bossX<heroX){
					bossX++;
				}
				else bossX--;
				if(bossY<heroY){
					bossY++;
				}
				else bossY--;
			}
				repaint();
		}
	}


	public void paint(Graphics g){
		g.setColor(230,97,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);//120x坐标，100y坐标
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void changepicdirect(int direction)
	{
        if(flag==1)
				{ currentImg=heroImg[direction][2];
			       flag++;
				}
			 else if(flag==2)
				{ currentImg=heroImg[direction][1];
			          flag=1;
				}
				repaint();
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);

		
		 if(action==LEFT)
		{
            changepicdirect(0);
				heroX=heroX-1;
		}
		

		 else if(action==RIGHT)		
		{
			{
			  changepicdirect(1);
				heroX=heroX+1;
			}
		}

		 else if(action==UP)
		{
			changepicdirect(2);
				heroY=heroY-1;
		}
		
		 else if(action==DOWN)
		{
			 changepicdirect(3);
				heroY=heroY+1;
		}
	}
}


