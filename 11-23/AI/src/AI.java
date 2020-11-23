import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

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
class MainCanvas extends Canvas
{
	int x,y,i,j;
	int flag;
	Image currentImg;
	Image heroImg[][]=new Image[4][3];//左0，右1，上3，下2

	public MainCanvas(){
		try
		{
			for(i=0;i<4;i++)
				for(j=0;j<3;j++){
                  heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			currentImg=heroImg[3][0];
			x=120;
			y=100;
			flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(230,97,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120x坐标，100y坐标
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
				x=x-1;
		}
		

		 else if(action==RIGHT)		
		{
			{
			  changepicdirect(1);
				x=x+1;
			}
		}

		 else if(action==UP)
		{
			changepicdirect(2);
				y=y-1;
		}
		
		 else if(action==DOWN)
		{
			 changepicdirect(3);
				y=y+1;
		}
	}
}


