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
	Image currentImg;
	Image heroImg[][]=new Image[4][3];//左0，右1，上3，下2

	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
		try
		{
			for(i=0;i<4;i++)
				for(j=0;j<3;j++){
                  heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			currentImg=heroImg[2][0];
			x=120;
			y=100;
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
			
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
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);

		
		 if(action==LEFT)
			{
			 if(leftFlag==1)
				{ currentImg=heroImg[0][2];
			       leftFlag++;
				}
			 else if(leftFlag==2)
				{ currentImg=heroImg[0][1];
			          leftFlag=1;
				}
				x=x-1;
			}
		

		 else if(action==RIGHT)		
		{
			{
			  if(rightFlag==1)
				{ currentImg=heroImg[1][2];
			       rightFlag++;
				}
			 else if(rightFlag==2)
				{ currentImg=heroImg[1][1];
			          rightFlag=1;
				}
				x=x+1;
			}
		}

		 else if(action==UP)
		{
			 if(upFlag==1)
				{ currentImg=heroImg[3][2];
			       upFlag++;
				}
			 else if(upFlag==2)
				{ currentImg=heroImg[3][1];
			          upFlag=1;
				}
				y=y-1;
		}
		
		 else if(action==DOWN)
		{
			 if(downFlag==1)
				{ currentImg=heroImg[2][2];
			       downFlag++;
				}
			 else if(downFlag==2)
				{ currentImg=heroImg[2][1];
			          downFlag=1;
				}
				y=y+1;
		}
	      repaint();
	 }
	
	
	}


