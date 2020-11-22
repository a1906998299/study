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
	int x,y,i;
	Image leftImg[]=new Image[3];
	Image rightImg[]=new Image[3];
	Image upImg[]=new Image[3];
	Image downImg[]=new Image[3];
	Image currentImg;
	//Image downImg,leftImg,upImg,rightImg,currentImg;
	//Image leftImg1,leftImg2,rightImg1,rightImg2,upImg1,upImg2,downImg1,downImg2;
	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
		try
		{
			for(i=0;i<3;i++)
			{
				leftImg[i]=Image.createImage("/sayo"+i+"2.png");
				rightImg[i]=Image.createImage("/sayo"+i+"6.png");
				upImg[i]=Image.createImage("/sayo"+i+"4.png");
				downImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			/*
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			*/
			currentImg=downImg[1];
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
		g.setColor(100,100,100);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120x×ø±ê£¬100y×ø±ê
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);

		
		 if(action==LEFT)
			{
			 if(leftFlag==1)
				{ currentImg=leftImg[2];
			       leftFlag++;
				}
			 else if(leftFlag==2)
				{ currentImg=leftImg[1];
			          leftFlag=1;
				}
				x=x-1;
			}
		

		 else if(action==RIGHT)		
		{
			{
			  if(rightFlag==1)
				{ currentImg=rightImg[2];
			       rightFlag++;
				}
			 else if(rightFlag==2)
				{ currentImg=rightImg[1];
			          rightFlag=1;
				}
				x=x+1;
			}
		}

		 else if(action==UP)
		{
			 if(upFlag==1)
				{ currentImg=upImg[2];
			       upFlag++;
				}
			 else if(upFlag==2)
				{ currentImg=upImg[1];
			          upFlag=1;
				}
				y=y-1;
		}
		
		 else if(action==DOWN)
		{
			 if(downFlag==1)
				{ currentImg=downImg[2];
			       downFlag++;
				}
			 else if(downFlag==2)
				{ currentImg=downImg[1];
			          downFlag=1;
				}
				y=y+1;
		}
	      repaint();
	 }
	
	
	}


