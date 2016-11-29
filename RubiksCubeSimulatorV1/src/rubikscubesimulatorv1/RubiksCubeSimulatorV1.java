package rubikscubesimulatorv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RubiksCubeSimulatorV1 implements ActionListener {
    // <editor-fold defaultstate="collapsed" desc=" DESCRIPTION ">
	int[] sideValues = new int[54];
	int[] m1values = new int[140];
	int[] m2values = new int[178];
	int[] m3values = new int[182];
	int pieceValue = 0;
	Color newOrange = new Color(240,102,0);
	JFrame window = new JFrame();
	Container arrangement;
	JFrame helpView = new JFrame();
	Container helpArrangement;
	JPanel title = new JPanel();
	JPanel leftButton = new JPanel();
	JPanel rightButton = new JPanel();
	JPanel cubeSpace = new JPanel();
	JPanel info = new JPanel();
	JPanel middleArea = new JPanel();
	JPanel drawAndButtons = new JPanel();
	JPanel results = new JPanel();
	JPanel ltfil1 = new JPanel();
	JPanel ltfil2 = new JPanel();
	JPanel rtfil1 = new JPanel();
	JPanel rtfil2 = new JPanel();
	JLabel time;
	Timer timer;
	Timer timeer;
	JButton mL;
	JButton mLp;
	JButton mR;
	JButton mRp;
	JButton mF;
	JButton mFp;
	JButton mB;
	JButton mBp;
	JButton mU;
	JButton mUp;
	JButton mD;
	JButton mDp;
	JLabel cell1= new JLabel();
	JLabel cell2= new JLabel();
	JLabel cell3= new JLabel();
	JLabel cell4= new JLabel();
	JLabel cell5= new JLabel();
	JLabel cell6= new JLabel();
	JLabel cell7= new JLabel();
	JLabel cell8= new JLabel();
	JLabel cell9= new JLabel();
	JLabel cell10= new JLabel();
	JLabel cell11= new JLabel();
	JLabel cell12= new JLabel();
	JLabel cell13= new JLabel();
	JLabel cell14= new JLabel();
	JLabel cell15= new JLabel();
	JLabel cell16= new JLabel();
	JLabel cell17= new JLabel();
	JLabel cell18= new JLabel();
	JLabel cell19= new JLabel();
	JLabel cell20= new JLabel();
	JButton method1;
	JButton method2;
	JButton method3;
	JButton doItYourself;
	JButton Start;
	JButton Stop;
	JButton Reset;
	JButton question;
	JButton goBack = new JButton("Go Back");
	double m1t1 = 0;
	double m1t2 = 0;
	double  m1t3 = 0;
	double m2t1 = 0;
	double m2t2 = 0;
	double m2t3 = 0;
	double m3t1 = 0;
	double m3t2 = 0;
	double m3t3 = 0;
	double avg1 = 0;
	double avg2 = 0;
	double avg3 = 0;
	String m1list;
	Random generator = new Random();
	double startTime = 0;
	double endTime = 0;
	double elapsedTime = 0;
	double startTimer = 0;
	double endTimer = 0;
	double elapsedTimer = 0;
	int side = 2;
	int turns = 0;
	int turnside = 0;
	int milliseconds = 0;
	int seconds = 0;
	int minutes = 0;
	int numm1 = 1;
	int numm2 = 1;
	int numm3 = 1;
	int transfer;
	int scramble;
	int woyrAxis = 0;
	int bogrAxis = 1;
	int wbygAxis = 2;
	int lastAxis = 1;
	int upSide = 2;
	int downSide = 2;
	int origSide = 2;
	final int startSide = 2;
	int manipSide = 2;
	int count = 0;
	int amount = 0;
	int numMod = 0;
	int numTimes = 0;
	int loopNumDet = 0;
	int moveAid = 0;
	int methodValue;
	int rectX = 260, rectY = 100;
	int store1, store2, store3, store4, store5, store6, store7, store8;
    Thread stopwatch;
    ActionListener taskPerformer;
    DecimalFormat dcf = new DecimalFormat("00.000");
	boolean firstRun = true;
	boolean firstTurn = true;
	boolean isTiming = false;
	boolean firstSwitch = true;
	boolean firstHelp = true;
	boolean startActivated = false;
	boolean rightAmount = true;
	boolean m1going = false;
	boolean doYourself = false;
        // </editor-fold> // Variables
	@SuppressWarnings("serial")
	public class graphics extends JComponent
	{
		public void paint(Graphics page)
		{
			if(firstRun==true)
			{
				for(count = 0; count < 54; count++)
				{
					if(count < 9)
					{
						sideValues[count] = 1;
					}
					else if(count >= 9 && count < 18)
					{
						sideValues[count] = 2;
					}
					else if(count >= 18 && count < 27)
					{
						sideValues[count] = 3;
					}
					else if(count >= 27 && count < 36)
					{
						sideValues[count] = 4;
					}
					else if(count >= 36 && count < 45)
					{
						sideValues[count] = 5;
					}
					else
					{
						sideValues[count] = 6;
					}
				}
				page.setColor(Color.blue);
				page.fillRect(260, 100, 50, 50);
				page.fillRect(320, 100, 50, 50);
				page.fillRect(380, 100, 50, 50);
				page.fillRect(260, 160, 50, 50);
				page.fillRect(320, 160, 50, 50);
				page.fillRect(380, 160, 50, 50);
				page.fillRect(260, 220, 50, 50);
				page.fillRect(320, 220, 50, 50);
				page.fillRect(380, 220, 50, 50);
				firstRun = false;
			}
			else
			{
				loopNumDet = side * 9;
				for(int i = loopNumDet - 9; i < loopNumDet; i++)
				{
					super.paint(page);
					pieceValue = sideValues[i];
					switch(pieceValue)
					{
						case 1:
							page.setColor(Color.yellow);
							break;
						case 2:
							page.setColor(Color.blue);
							break;
						case 3:
							page.setColor(newOrange);
							break;
						case 4:
							page.setColor(Color.green);
							break;
						case 5:
							page.setColor(Color.red);
							break;
						case 6:
							page.setColor(Color.white);
							break;
						default:
							method2.setText("Color: " + pieceValue);
					}
					page.fillRect(rectX, rectY, 50, 50);
					rectX += 60;
					if(rectX > 380)
					{
						rectX = 260;
						rectY += 60;
						if(rectY > 220)
						{
							rectX = 260;
							rectY = 100;
						}	
					}	
				}
			}
		}
	}
	public class sideDet
	{
		public void determineSide()
		{
			if(wbygAxis == 3)
				side = 1;
			else if(wbygAxis == 2)
				side = 2;
			else if(wbygAxis == 0 && woyrAxis == 2)
				side = 3;
			else if(wbygAxis == 4)
				side = 4;
			else if(wbygAxis == 0 && woyrAxis == 4)
				side = 5;
			else if(wbygAxis == 1)
				side = 6;
			else
				method3.setText("Failed sideDet");
		}
	}
	public class setAxis
	{
		public void setAxes()
		{
			if(side == 1)
			{
				wbygAxis = 3;
				woyrAxis = 3;
				bogrAxis = 0;
			}
			else if(side == 2)
			{
				wbygAxis = 2;
				woyrAxis = 0;
				bogrAxis = 1;
			}
			else if(side == 3)
			{
				wbygAxis = 0;
				woyrAxis = 2;
				bogrAxis = 2;
			}
			else if(side == 4)
			{
				wbygAxis = 4;
				woyrAxis = 0;
				bogrAxis = 3;
			}
			else if(side == 5)
			{
				wbygAxis = 0;
				woyrAxis = 4;
				bogrAxis = 4;
			}
			else if(side == 6)
			{
				wbygAxis = 1;
				woyrAxis = 1;
				bogrAxis = 0;
			}
			else
				method3.setText("Failed setAxis");
		}
	}
	public class Timing implements Runnable
	{
		public void Timer()
		{
			stopwatch = new Thread(this, "Stopwatch");
			stopwatch.start();
			
		}
		public void run()
		{
			seconds = 0;
			startTimer = System.currentTimeMillis();
			ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					endTimer = System.currentTimeMillis();
					elapsedTimer = (endTimer - startTimer);
					if(elapsedTimer > 999)
					{
						seconds++;
						startTimer = System.currentTimeMillis();
						elapsedTimer = 0;
					}
					if(seconds > 59)
					{
						minutes++;
						seconds = 0;
					}
					if(seconds < 10)
					{
						if(elapsedTimer < 10)
							time.setText("0" + minutes + ":0" + seconds + ":00" + elapsedTimer);
						else if(elapsedTimer < 100 && elapsedTimer >= 10)
							time.setText("0" + minutes + ":0" + seconds + ":0" + elapsedTimer);
						else
							time.setText("0" + minutes + ":0" + seconds + ":" + elapsedTimer);
					}
					else
					{
						if(elapsedTimer < 10)
							time.setText("0" + minutes + ":" + seconds + ":00" + elapsedTimer);
						else if(elapsedTimer < 100 && elapsedTimer >= 10)
							time.setText("0" + minutes + ":" + seconds + ":0" + elapsedTimer);
						else
							time.setText("0" + minutes + ":" + seconds + ":" + elapsedTimer);
					}
		        }
		    };
		    timeer = new Timer(0 , taskPerformer);
			timeer.setRepeats(true);
		    timeer.start();
			arrangement.validate();
		}
	}
	public class Moves
	{
		public void Lprime()
		{
			manipSide = startSide;
			origSide = startSide;
			
			upSide = 6;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[upSide * 9 - 9];
			store5 = sideValues[upSide * 9 - 6];
			store6 = sideValues[upSide * 9 - 3];
			sideValues[upSide * 9 - 9] = store1;
			sideValues[upSide * 9 - 6] = store2;
			sideValues[upSide * 9 - 3] = store3;
			
			manipSide = origSide + 2;
			if(manipSide > 5)
				manipSide -= 4;
			upSide = 1;
			store1 = sideValues[manipSide * 9 - 7];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 1] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 1;
			store4 = sideValues[manipSide * 9 - 7];
			store5 = sideValues[manipSide * 9 - 4];
			store6 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 7] = store1;
			sideValues[manipSide * 9 - 4] = store2;
			sideValues[manipSide * 9 - 1] = store3;
			
			manipSide = origSide;
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 9] = store6;
			manipSide = startSide;
			
			turnside = 5;
			new Moves().CounterClockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void L()
		{
			manipSide = startSide;
			origSide = startSide;
			
			downSide = 1;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[downSide * 9 - 7];
			store5 = sideValues[downSide * 9 - 4];
			store6 = sideValues[downSide * 9 - 1];
			sideValues[downSide * 9 - 1] = store1;
			sideValues[downSide * 9 - 4] = store2;
			sideValues[downSide * 9 - 7] = store3;
			
			manipSide = origSide + 2;
			if(manipSide > 5)
				manipSide -= 4;
			store1 = sideValues[manipSide * 9 - 7];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 7] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			
			manipSide = 6;
			store4 = sideValues[manipSide * 9 - 9];
			store5 = sideValues[manipSide * 9 - 6];
			store6 = sideValues[manipSide * 9 - 3];
			sideValues[manipSide * 9 - 3] = store1;
			sideValues[manipSide * 9 - 6] = store2;
			sideValues[manipSide * 9 - 9] = store3;
			
			manipSide = origSide;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 3] = store6;
			manipSide = startSide;
			
			turnside = 5;
			new Moves().Clockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void Rprime()
		{
			manipSide = startSide;
			origSide = startSide;
			
			manipSide += 2;
			if(manipSide > 5)
				manipSide -= 4;
			origSide = manipSide;
			upSide = 6;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[upSide * 9 - 1];
			store5 = sideValues[upSide * 9 - 4];
			store6 = sideValues[upSide * 9 - 7];
			sideValues[upSide * 9 - 1] = store1;
			sideValues[upSide * 9 - 4] = store2;
			sideValues[upSide * 9 - 7] = store3;
			
			manipSide = origSide + 2;
			if(manipSide > 5)
				manipSide -= 4;
			upSide = 1;
			store1 = sideValues[manipSide * 9 - 1];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 1] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 1;
			store4 = sideValues[manipSide * 9 - 3];
			store5 = sideValues[manipSide * 9 - 6];
			store6 = sideValues[manipSide * 9 - 9];
			sideValues[manipSide * 9 - 9] = store1;
			sideValues[manipSide * 9 - 6] = store2;
			sideValues[manipSide * 9 - 3] = store3;
			
			manipSide = origSide;
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 9] = store6;
			manipSide = startSide;
			
			turnside = 3;
			new Moves().CounterClockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void R()
		{
			manipSide = startSide;
			origSide = startSide;
			
			manipSide += 2;
			if(manipSide > 5)
				manipSide -= 4;
			origSide = manipSide;
			downSide = 1;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[downSide * 9 - 9];
			store5 = sideValues[downSide * 9 - 6];
			store6 = sideValues[downSide * 9 - 3];
			sideValues[downSide * 9 - 9] = store1;
			sideValues[downSide * 9 - 6] = store2;
			sideValues[downSide * 9 - 3] = store3;
			
			manipSide = origSide + 2;
			if(manipSide > 5)
				manipSide -= 4;
			store1 = sideValues[manipSide * 9 - 7];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 1] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 6;
			store4 = sideValues[manipSide * 9 - 7];
			store5 = sideValues[manipSide * 9 - 4];
			store6 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 7] = store1;
			sideValues[manipSide * 9 - 4] = store2;
			sideValues[manipSide * 9 - 1] = store3;
			
			manipSide = origSide;
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 9] = store6;
			manipSide = startSide;
			
			turnside = 3;
			new Moves().Clockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void Fprime()
		{
			manipSide = 3;
			origSide = manipSide;
			
			upSide = 6;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[upSide * 9 - 3];
			store5 = sideValues[upSide * 9 - 2];
			store6 = sideValues[upSide * 9 - 1];
			sideValues[upSide * 9 - 3] = store1;
			sideValues[upSide * 9 - 2] = store2;
			sideValues[upSide * 9 - 1] = store3;
			
			manipSide = 5;
			store1 = sideValues[manipSide * 9 - 1];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 1] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 1;
			store4 = sideValues[manipSide * 9 - 3];
			store5 = sideValues[manipSide * 9 - 2];
			store6 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 3] = store1;
			sideValues[manipSide * 9 - 2] = store2;
			sideValues[manipSide * 9 - 1] = store3;
			
			manipSide = 3;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 3] = store6;
			manipSide = startSide;
			
			turnside = 2;
			new Moves().CounterClockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void F()
		{
			manipSide = 3;
			origSide = manipSide;
			
			downSide = 1;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[downSide * 9 - 1];
			store5 = sideValues[downSide * 9 - 2];
			store6 = sideValues[downSide * 9 - 3];
			sideValues[downSide * 9 - 3] = store1;
			sideValues[downSide * 9 - 2] = store2;
			sideValues[downSide * 9 - 1] = store3;
			
			manipSide = 5;
			store1 = sideValues[manipSide * 9 - 1];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 7] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			
			manipSide = 6;
			store4 = sideValues[manipSide * 9 - 3];
			store5 = sideValues[manipSide * 9 - 2];
			store6 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 3] = store1;
			sideValues[manipSide * 9 - 2] = store2;
			sideValues[manipSide * 9 - 1] = store3;
			
			manipSide = 3;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 3] = store6;
			manipSide = startSide;
			
			turnside = 2;
			new Moves().Clockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void Bprime()
		{
			manipSide = 5;
			origSide = manipSide;
			
			upSide = 6;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[upSide * 9 - 7];
			store5 = sideValues[upSide * 9 - 8];
			store6 = sideValues[upSide * 9 - 9];
			sideValues[upSide * 9 - 7] = store1;
			sideValues[upSide * 9 - 8] = store2;
			sideValues[upSide * 9 - 9] = store3;
			
			manipSide = 3;
			store1 = sideValues[manipSide * 9 - 1];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 1] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 1;
			store4 = sideValues[manipSide * 9 - 7];
			store5 = sideValues[manipSide * 9 - 8];
			store6 = sideValues[manipSide * 9 - 9];
			sideValues[manipSide * 9 - 7] = store1;
			sideValues[manipSide * 9 - 8] = store2;
			sideValues[manipSide * 9 - 9] = store3;
			
			manipSide = 5;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 3] = store6;
			manipSide = startSide;
			
			turnside = 4;
			new Moves().CounterClockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void B()
		{
			manipSide = 5;
			origSide = manipSide;
			
			downSide = 1;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 6];
			store3 = sideValues[manipSide * 9 - 3];
			store4 = sideValues[downSide * 9 - 9];
			store5 = sideValues[downSide * 9 - 8];
			store6 = sideValues[downSide * 9 - 7];
			sideValues[downSide * 9 - 7] = store1;
			sideValues[downSide * 9 - 8] = store2;
			sideValues[downSide * 9 - 9] = store3;
			
			manipSide = 3;
			store1 = sideValues[manipSide * 9 - 7];
			store2 = sideValues[manipSide * 9 - 4];
			store3 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 7] = store4;
			sideValues[manipSide * 9 - 4] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			
			manipSide = 6;
			store4 = sideValues[manipSide * 9 - 7];
			store5 = sideValues[manipSide * 9 - 8];
			store6 = sideValues[manipSide * 9 - 9];
			sideValues[manipSide * 9 - 9] = store1;
			sideValues[manipSide * 9 - 8] = store2;
			sideValues[manipSide * 9 - 7] = store3;
			
			manipSide = origSide;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 6] = store5;
			sideValues[manipSide * 9 - 3] = store6;
			manipSide = startSide;
			
			turnside = 4;
			new Moves().Clockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void Uprime()
		{
			manipSide = 2;
			origSide = manipSide;
			
			upSide = 3;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 8];
			store3 = sideValues[manipSide * 9 - 7];
			store4 = sideValues[upSide * 9 - 9];
			store5 = sideValues[upSide * 9 - 8];
			store6 = sideValues[upSide * 9 - 7];
			sideValues[upSide * 9 - 9] = store1;
			sideValues[upSide * 9 - 8] = store2;
			sideValues[upSide * 9 - 7] = store3;
			
			manipSide = 4;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 8];
			store3 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 8] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 5;
			store4 = sideValues[manipSide * 9 - 9];
			store5 = sideValues[manipSide * 9 - 8];
			store6 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 9] = store1;
			sideValues[manipSide * 9 - 8] = store2;
			sideValues[manipSide * 9 - 7] = store3;
			
			manipSide = 2;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 8] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			manipSide = startSide;
			
			turnside = 6;
			new Moves().CounterClockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void U()
		{
			manipSide = 2;
			origSide = manipSide;
			
			upSide = 5;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 8];
			store3 = sideValues[manipSide * 9 - 7];
			store4 = sideValues[upSide * 9 - 9];
			store5 = sideValues[upSide * 9 - 8];
			store6 = sideValues[upSide * 9 - 7];
			sideValues[upSide * 9 - 9] = store1;
			sideValues[upSide * 9 - 8] = store2;
			sideValues[upSide * 9 - 7] = store3;
			
			manipSide = 4;
			store1 = sideValues[manipSide * 9 - 9];
			store2 = sideValues[manipSide * 9 - 8];
			store3 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 8] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			
			manipSide = 3;
			store4 = sideValues[manipSide * 9 - 9];
			store5 = sideValues[manipSide * 9 - 8];
			store6 = sideValues[manipSide * 9 - 7];
			sideValues[manipSide * 9 - 9] = store1;
			sideValues[manipSide * 9 - 8] = store2;
			sideValues[manipSide * 9 - 7] = store3;
			
			manipSide = 2;
			sideValues[manipSide * 9 - 9] = store4;
			sideValues[manipSide * 9 - 8] = store5;
			sideValues[manipSide * 9 - 7] = store6;
			manipSide = startSide;
			
			turnside = 6;
			new Moves().Clockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void Dprime()
		{
			manipSide = 2;
			origSide = manipSide;
			
			upSide = 5;
			store1 = sideValues[manipSide * 9 - 3];
			store2 = sideValues[manipSide * 9 - 2];
			store3 = sideValues[manipSide * 9 - 1];
			store4 = sideValues[upSide * 9 - 3];
			store5 = sideValues[upSide * 9 - 2];
			store6 = sideValues[upSide * 9 - 1];
			sideValues[upSide * 9 - 3] = store1;
			sideValues[upSide * 9 - 2] = store2;
			sideValues[upSide * 9 - 1] = store3;
			
			manipSide = 4;
			store1 = sideValues[manipSide * 9 - 3];
			store2 = sideValues[manipSide * 9 - 2];
			store3 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 2] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			
			manipSide = 3;
			store4 = sideValues[manipSide * 9 - 3];
			store5 = sideValues[manipSide * 9 - 2];
			store6 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 3] = store1;
			sideValues[manipSide * 9 - 2] = store2;
			sideValues[manipSide * 9 - 1] = store3;
			
			manipSide = 2;
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 2] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			manipSide = startSide;
			
			turnside = 1;
			new Moves().CounterClockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void D()
		{
			manipSide = 2;
			origSide = manipSide;
			
			upSide = 3;
			store1 = sideValues[manipSide * 9 - 3];
			store2 = sideValues[manipSide * 9 - 2];
			store3 = sideValues[manipSide * 9 - 1];
			store4 = sideValues[upSide * 9 - 3];
			store5 = sideValues[upSide * 9 - 2];
			store6 = sideValues[upSide * 9 - 1];
			sideValues[upSide * 9 - 3] = store1;
			sideValues[upSide * 9 - 2] = store2;
			sideValues[upSide * 9 - 1] = store3;
			
			manipSide = 4;
			store1 = sideValues[manipSide * 9 - 3];
			store2 = sideValues[manipSide * 9 - 2];
			store3 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 2] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			
			manipSide = 5;
			store4 = sideValues[manipSide * 9 - 3];
			store5 = sideValues[manipSide * 9 - 2];
			store6 = sideValues[manipSide * 9 - 1];
			sideValues[manipSide * 9 - 3] = store1;
			sideValues[manipSide * 9 - 2] = store2;
			sideValues[manipSide * 9 - 1] = store3;
			
			manipSide = 2;
			sideValues[manipSide * 9 - 3] = store4;
			sideValues[manipSide * 9 - 2] = store5;
			sideValues[manipSide * 9 - 1] = store6;
			manipSide = startSide;
			
			turnside = 1;
			new Moves().Clockwise();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		public void CounterClockwise()
		{
			store1 = sideValues[turnside*9 - 9];
			store2 = sideValues[turnside*9 - 8];
			store3 = sideValues[turnside*9 - 7];
			store4 = sideValues[turnside*9 - 6];
			store5 = sideValues[turnside*9 - 4];
			store6 = sideValues[turnside*9 - 3];
			store7 = sideValues[turnside*9 - 2];
			store8 = sideValues[turnside*9 - 1];
			sideValues[turnside*9 - 9] = store3;
			sideValues[turnside*9 - 8] = store5;
			sideValues[turnside*9 - 7] = store8;
			sideValues[turnside*9 - 6] = store2;
			sideValues[turnside*9 - 4] = store7;
			sideValues[turnside*9 - 3] = store1;
			sideValues[turnside*9 - 2] = store4;
			sideValues[turnside*9 - 1] = store6;
		}
		public void Clockwise()
		{
			store1 = sideValues[turnside*9 - 9];
			store2 = sideValues[turnside*9 - 8];
			store3 = sideValues[turnside*9 - 7];
			store4 = sideValues[turnside*9 - 6];
			store5 = sideValues[turnside*9 - 4];
			store6 = sideValues[turnside*9 - 3];
			store7 = sideValues[turnside*9 - 2];
			store8 = sideValues[turnside*9 - 1];
			sideValues[turnside*9 - 9] = store6;
			sideValues[turnside*9 - 8] = store4;
			sideValues[turnside*9 - 7] = store1;
			sideValues[turnside*9 - 6] = store7;
			sideValues[turnside*9 - 4] = store2;
			sideValues[turnside*9 - 3] = store8;
			sideValues[turnside*9 - 2] = store5;
			sideValues[turnside*9 - 1] = store3;
		}
	}
	public class Solve
	{
		public void Method1() throws IOException
		{
			m1values[0] = 1;
			m1values[1] = 1;
			m1values[2] = 5;
			m1values[3] = 5;
			m1values[4] = 11;
			m1values[5] = 1;
			m1values[6] = 11;
			m1values[7] = 1;
			m1values[8] = 1;
			m1values[9] = 9;
			m1values[10] = 7;
			m1values[11] = 7;
			m1values[12] = 10;
			m1values[13] = 1;
			m1values[14] = 1;
			m1values[15] = 10;
			m1values[16] = 10;
			m1values[17] = 1;
			m1values[18] = 9;
			m1values[19] = 2;
			m1values[20] = 4;
			m1values[21] = 10;
			m1values[22] = 3;
			m1values[23] = 9;
			m1values[24] = 9;
			m1values[25] = 3;
			m1values[26] = 9;
			m1values[27] = 4;
			m1values[28] = 9;
			m1values[29] = 9;
			m1values[30] = 7;
			m1values[31] = 10;
			m1values[32] = 8;
			m1values[33] = 10;
			m1values[34] = 4;
			m1values[35] = 9;
			m1values[36] = 3;
			m1values[37] = 6;
			m1values[38] = 9;
			m1values[39] = 5;
			m1values[40] = 9;
			m1values[41] = 3;
			m1values[42] = 10;
			m1values[43] = 4;
			m1values[44] = 8;
			m1values[45] = 9;
			m1values[46] = 7;
			m1values[47] = 9;
			m1values[48] = 1;
			m1values[49] = 10;
			m1values[50] = 2;
			m1values[51] = 2;
			m1values[52] = 9;
			m1values[53] = 1;
			m1values[54] = 9;
			m1values[55] = 5;
			m1values[56] = 10;
			m1values[57] = 6;
			m1values[58] = 9;
			m1values[59] = 9;
			m1values[60] = 8;
			m1values[61] = 9;
			m1values[62] = 7;
			m1values[63] = 9;
			m1values[64] = 1;
			m1values[65] = 10;
			m1values[66] = 2;
			m1values[67] = 2;
			m1values[68] = 10;
			m1values[69] = 8;
			m1values[70] = 9;
			m1values[71] = 7;
			m1values[72] = 1;
			m1values[73] = 1;
			m1values[74] = 9;
			m1values[75] = 2;
			m1values[76] = 9;
			m1values[77] = 1;
			m1values[78] = 9;
			m1values[79] = 9;
			m1values[80] = 2;
			m1values[81] = 6;
			m1values[82] = 10;
			m1values[83] = 5;
			m1values[84] = 10;
			m1values[85] = 6;
			m1values[86] = 9;
			m1values[87] = 9;
			m1values[88] = 5;
			m1values[89] = 2;
			m1values[90] = 7;
			m1values[91] = 2;
			m1values[92] = 5;
			m1values[93] = 5;
			m1values[94] = 1;
			m1values[95] = 8;
			m1values[96] = 2;
			m1values[97] = 5;
			m1values[98] = 5;
			m1values[99] = 1;
			m1values[100] = 1;
			m1values[101] = 10;
			m1values[102] = 4;
			m1values[103] = 5;
			m1values[104] = 4;
			m1values[105] = 7;
			m1values[106] = 7;
			m1values[107] = 3;
			m1values[108] = 6;
			m1values[109] = 4;
			m1values[110] = 7;
			m1values[111] = 7;
			m1values[112] = 3;
			m1values[113] = 3;
			m1values[114] = 9;
			m1values[115] = 9;
			m1values[116] = 7;
			m1values[117] = 7;
			m1values[118] = 9;
			m1values[119] = 3;
			m1values[120] = 2;
			m1values[121] = 7;
			m1values[122] = 7;
			m1values[123] = 1;
			m1values[124] = 4;
			m1values[125] = 9;
			m1values[126] = 7;
			m1values[127] = 7;
			m1values[128] = 7;
			m1values[129] = 7;
			m1values[130] = 9;
			m1values[131] = 3;
			m1values[132] = 2;
			m1values[133] = 7;
			m1values[134] = 7;
			m1values[135] = 1;
			m1values[136] = 4;
			m1values[137] = 9;
			m1values[138] = 7;
			m1values[139] = 7;
			taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					switch(m1values[numTimes])
					{
						case 1:
							new Moves().L();
							break;
						case 2:
							new Moves().Lprime();
							break;
						case 3:
							new Moves().R();
							break;
						case 4:
							new Moves().Rprime();
							break;
						case 5:
							new Moves().F();
							break;
						case 6:
							new Moves().Fprime();
							break;
						case 7:
							new Moves().B();
							break;
						case 8:
							new Moves().Bprime();
							break;
						case 9:
							new Moves().U();
							break;
						case 10:
							new Moves().Uprime();
							break;
						case 11:
							new Moves().D();
							break;
						case 12:
							new Moves().Dprime();
							break;
						default:	
					}
					drawAndButtons.add(new graphics());
					cubeSpace.repaint();
					if(numTimes >= 139)
					{
						timeer.stop();
						endTime = System.currentTimeMillis();
				       	elapsedTime = endTime - startTime;
				       	if(m1t1 == 0)
				       	{
				       		m1t1 = elapsedTime / 1000;
				       		avg1 = m1t1;
				       		dcf.format(m1t1);
				       		dcf.format(avg1);
				       	}
				       	else if(m1t1 != 0 && m1t2 == 0)
				       	{
				       		m1t2 = elapsedTime / 1000;
				       		avg1 = (m1t1 + m1t2) / 2;
				       		dcf.format(m1t2);
				       		dcf.format(avg1);
				       	}
				       	else
				       	{
				       		m1t3 = elapsedTime / 1000;
				       		avg1 = (m1t1 + m1t2 + m1t3) / 3;
				       		dcf.format(m1t3);
					       		dcf.format(avg1);
				       	}
				       	avg1 = Double.parseDouble(new DecimalFormat("00.000").format(avg1));
						cell2.setText("Tri-Layer");
						cell3.setText("   Trial 1");
						cell4.setText("" + m1t1 + "seconds");
						cell5.setText("   Trial 2");
						cell6.setText("" + m1t2 + "seconds");
						cell7.setText("   Trial 3");
						cell8.setText("" + m1t3 + "seconds");
						cell9.setText("   Average");
						cell10.setText("" + avg1 + "seconds");
						cell11.setText("Corner-Edge");
						cell12.setText("Modified Roux");
						cell13.setText("" + m2t1 + "seconds");
						cell14.setText("" + m3t1 + "seconds");
						cell15.setText("" + m2t2 + "seconds");
						cell16.setText("" + m3t2 + "seconds");
						cell17.setText("" + m2t3 + "seconds");
						cell18.setText("" + m3t3 + "seconds");
						cell19.setText("" + avg2 + "seconds");
						cell20.setText("" + avg3 + "seconds");
				       	numTimes = -1;
				       	startActivated = false;
						((Timer)evt.getSource()).stop();
					}
					numTimes++;
				}
	        };
	        timer = new Timer(0 , taskPerformer);
	      	timer.setRepeats(true);
	       	timer.start();
	       	startTime = System.currentTimeMillis();
	       	numm1++;
		}	
		public void Method2() throws IOException
		{
			m2values[0] = 1;
			m2values[1] = 7;
			m2values[2] = 7;
			m2values[3] = 11;
			m2values[4] = 8;
			m2values[5] = 9;
			m2values[6] = 9;
			m2values[7] = 2;
			m2values[8] = 12;
			m2values[9] = 1;
			m2values[10] = 5;
			m2values[11] = 4;
			m2values[12] = 6;
			m2values[13] = 3;
			m2values[14] = 5;
			m2values[15] = 4;
			m2values[16] = 6;
			m2values[17] = 3;
			m2values[18] = 12;
			m2values[19] = 5;
			m2values[20] = 4;
			m2values[21] = 6;
			m2values[22] = 3;
			m2values[23] = 5;
			m2values[24] = 4;
			m2values[25] = 6;
			m2values[26] = 3;
			m2values[27] = 12;
			m2values[28] = 5;
			m2values[29] = 4;//
			m2values[30] = 6;
			m2values[31] = 3;
			m2values[32] = 5;
			m2values[33] = 4;
			m2values[34] = 6;
			m2values[35] = 3;
			m2values[36] = 9;
			m2values[37] = 3;
			m2values[38] = 3;
			m2values[39] = 9;
			m2values[40] = 3;
			m2values[41] = 3;
			m2values[42] = 10;
			m2values[43] = 3;
			m2values[44] = 3;
			m2values[45] = 5;
			m2values[46] = 5;
			m2values[47] = 10;
			m2values[48] = 5;
			m2values[49] = 5;
			m2values[50] = 9;
			m2values[51] = 5;
			m2values[52] = 5;
			m2values[53] = 7;
			m2values[54] = 7;
			m2values[55] = 11;
			m2values[56] = 7;
			m2values[57] = 7;
			m2values[58] = 12;
			m2values[59] = 7;
			m2values[60] = 7;
			m2values[61] = 1;//
			m2values[62] = 1;
			m2values[63] = 12;
			m2values[64] = 1;
			m2values[65] = 1;
			m2values[66] = 11;
			m2values[67] = 1;
			m2values[68] = 1;
			m2values[69] = 10;
			m2values[70] = 1;
			m2values[71] = 10;
			m2values[72] = 11;
			m2values[73] = 6;
			m2values[74] = 11;
			m2values[75] = 1;
			m2values[76] = 9;
			m2values[77] = 12;
			m2values[78] = 8;
			m2values[79] = 10;
			m2values[80] = 4;
			m2values[81] = 9;
			m2values[82] = 12;
			m2values[83] = 5;
			m2values[84] = 9;
			m2values[85] = 9;
			m2values[86] = 2;
			m2values[87] = 10;
			m2values[88] = 11;
			m2values[89] = 5;
			m2values[90] = 12;
			m2values[91] = 12;
			m2values[92] = 1;//
			m2values[93] = 2;
			m2values[94] = 9;
			m2values[95] = 1;
			m2values[96] = 9;
			m2values[97] = 12;
			m2values[98] = 8;
			m2values[99] = 10;
			m2values[100] = 6;
			m2values[101] = 10;
			m2values[102] = 11;
			m2values[103] = 10;
			m2values[104] = 11;
			m2values[105] = 7;
			m2values[106] = 4;
			m2values[107] = 9;
			m2values[108] = 12;
			m2values[109] = 5;
			m2values[110] = 9;
			m2values[111] = 6;
			m2values[112] = 10;
			m2values[113] = 11;
			m2values[114] = 3;
			m2values[115] = 11;
			m2values[116] = 7;
			m2values[117] = 10;
			m2values[118] = 11;
			m2values[119] = 10;
			m2values[120] = 11;
			m2values[121] = 6;
			m2values[122] = 6;
			m2values[123] = 5;
			m2values[124] = 12;//
			m2values[125] = 1;
			m2values[126] = 2;
			m2values[127] = 9;
			m2values[128] = 1;
			m2values[129] = 10;
			m2values[130] = 11;
			m2values[131] = 6;
			m2values[132] = 12;
			m2values[133] = 9;
			m2values[134] = 1;
			m2values[135] = 9;
			m2values[136] = 12;
			m2values[137] = 8;
			m2values[138] = 9;
			m2values[139] = 11;
			m2values[140] = 11;
			m2values[141] = 3;
			m2values[142] = 10;
			m2values[143] = 11;
			m2values[144] = 8;
			m2values[145] = 10;
			m2values[146] = 9;
			m2values[147] = 12;
			m2values[148] = 3;
			m2values[149] = 3;
			m2values[150] = 10;
			m2values[151] = 11;
			m2values[152] = 7;
			m2values[153] = 7;
			m2values[154] = 5;
			m2values[155] = 5;
			m2values[156] = 9;
			m2values[157] = 12;
			m2values[158] = 5;
			m2values[159] = 9;
			m2values[160] = 12;
			m2values[161] = 1;
			m2values[162] = 9;
			m2values[163] = 12;
			m2values[164] = 7;
			m2values[165] = 7;
			m2values[166] = 10;
			m2values[167] = 11;
			m2values[168] = 1;
			m2values[169] = 10;
			m2values[170] = 11;
			m2values[171] = 5;
			m2values[172] = 10;
			m2values[173] = 11;
			m2values[174] = 3;
			m2values[175] = 3;
			m2values[176] = 5;
			m2values[177] = 5;
			taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					switch(m2values[numTimes])
					{
						case 1:
							new Moves().L();
							break;
						case 2:
							new Moves().Lprime();
							break;
						case 3:
							new Moves().R();
							break;
						case 4:
							new Moves().Rprime();
							break;
						case 5:
							new Moves().F();
							break;
						case 6:
							new Moves().Fprime();
							break;
						case 7:
							new Moves().B();
							break;
						case 8:
							new Moves().Bprime();
							break;
						case 9:
							new Moves().U();
							break;
						case 10:
							new Moves().Uprime();
							break;
						case 11:
							new Moves().D();
							break;
						case 12:
							new Moves().Dprime();
							break;
						default:	
					}
					drawAndButtons.add(new graphics());
					cubeSpace.repaint();
					if(numTimes >= 177)
					{
						timeer.stop();
						endTime = System.currentTimeMillis();
				       	elapsedTime = endTime - startTime;
				       	if(m2t1 == 0)
				       	{
				       		m2t1 = elapsedTime / 1000;
				       		avg2 = m2t1;
				       		dcf.format(m2t1);
				       		dcf.format(avg2);
				       	}
				       	else if(m2t1 != 0 && m2t2 == 0)
				       	{
				       		m2t2 = elapsedTime / 1000;
				       		avg2 = (m2t1 + m2t2) / 2;
				       		dcf.format(m2t2);
				       		dcf.format(avg2);
				       	}
				       	else
				       	{
				       		m2t3 = elapsedTime / 1000;
				       		avg2 = (m2t1 + m2t2 + m2t3) / 3;
				       		dcf.format(m2t3);
					       		dcf.format(avg2);
				       	}
				       	avg2 = Double.parseDouble(new DecimalFormat("00.000").format(avg2));
						cell2.setText("Tri-Layer");
						cell3.setText("   Trial 1");
						cell4.setText("" + m1t1 + "seconds");
						cell5.setText("   Trial 2");
						cell6.setText("" + m1t2 + "seconds");
						cell7.setText("   Trial 3");
						cell8.setText("" + m1t3 + "seconds");
						cell9.setText("   Average");
						cell10.setText("" + avg1 + "seconds");
						cell11.setText("Corner-Edge");
						cell12.setText("Modified Roux");
						cell13.setText("" + m2t1 + "seconds");
						cell14.setText("" + m3t1 + "seconds");
						cell15.setText("" + m2t2 + "seconds");
						cell16.setText("" + m3t2 + "seconds");
						cell17.setText("" + m2t3 + "seconds");
						cell18.setText("" + m3t3 + "seconds");
						cell19.setText("" + avg2 + "seconds");
						cell20.setText("" + avg3 + "seconds");
				       	numTimes = -1;
				       	startActivated = false;
						((Timer)evt.getSource()).stop();
					}
					numTimes++;
				}
	        };
	        timer = new Timer(0 , taskPerformer);
	      	timer.setRepeats(true);
	       	timer.start();
	       	startTime = System.currentTimeMillis();
	       	numm2++;
		}
		public void Method3() throws IOException
		{
			m3values[0] = 1;
			m3values[1] = 11;
			m3values[2] = 1;
			m3values[3] = 11;
			m3values[4] = 1;
			m3values[5] = 7;
			m3values[6] = 11;
			m3values[7] = 2;
			m3values[8] = 11;
			m3values[9] = 3;
			m3values[10] = 3;
			m3values[11] = 9;
			m3values[12] = 5;
			m3values[13] = 5;
			m3values[14] = 10;
			m3values[15] = 3;
			m3values[16] = 3;
			m3values[17] = 5;
			m3values[18] = 5;
			m3values[19] = 9;
			m3values[20] = 9;
			m3values[21] = 7;
			m3values[22] = 7;
			m3values[23] = 9;
			m3values[24] = 9;//
			m3values[25] = 5;
			m3values[26] = 5;
			m3values[27] = 9;
			m3values[28] = 1;
			m3values[29] = 9;
			m3values[30] = 2;
			m3values[31] = 9;
			m3values[32] = 4;
			m3values[33] = 10;
			m3values[34] = 3;
			m3values[35] = 9;
			m3values[36] = 9;
			m3values[37] = 5;
			m3values[38] = 9;
			m3values[39] = 6;
			m3values[40] = 9;
			m3values[41] = 3;
			m3values[42] = 9;
			m3values[43] = 9;
			m3values[44] = 4;
			m3values[45] = 10;
			m3values[46] = 3;
			m3values[47] = 9;
			m3values[48] = 4;
			m3values[49] = 1;
			m3values[50] = 10;//
			m3values[51] = 2;
			m3values[52] = 10;
			m3values[53] = 8;
			m3values[54] = 9;
			m3values[55] = 7;
			m3values[56] = 7;
			m3values[57] = 10;
			m3values[58] = 8;
			m3values[59] = 10;
			m3values[60] = 9;
			m3values[61] = 10;
			m3values[62] = 4;
			m3values[63] = 9;
			m3values[64] = 3;
			m3values[65] = 9;
			m3values[66] = 3;
			m3values[67] = 10;
			m3values[68] = 4;
			m3values[69] = 10;
			m3values[70] = 6;
			m3values[71] = 9;
			m3values[72] = 5;
			m3values[73] = 9;
			m3values[74] = 9;
			m3values[75] = 3;
			m3values[76] = 3;
			m3values[77] = 9;
			m3values[78] = 3;
			m3values[79] = 3;
			m3values[80] = 10;
			m3values[81] = 3;//
			m3values[82] = 3;
			m3values[83] = 5;
			m3values[84] = 5;
			m3values[85] = 10;
			m3values[86] = 5;
			m3values[87] = 5;
			m3values[88] = 9;
			m3values[89] = 5;
			m3values[90] = 5;
			m3values[91] = 10;
			m3values[92] = 12;
			m3values[93] = 1;
			m3values[94] = 10;
			m3values[95] = 11;
			m3values[96] = 6;
			m3values[97] = 11;
			m3values[98] = 11;
			m3values[99] = 5;
			m3values[100] = 9;
			m3values[101] = 12;
			m3values[102] = 2;
			m3values[103] = 11;
			m3values[104] = 11;
			m3values[105] = 1;
			m3values[106] = 10;
			m3values[107] = 11;
			m3values[108] = 6;
			m3values[109] = 10;
			m3values[110] = 6;
			m3values[111] = 9;
			m3values[112] = 12;//
			m3values[113] = 1;
			m3values[114] = 12;
			m3values[115] = 7;
			m3values[116] = 10;
			m3values[117] = 11;
			m3values[118] = 10;
			m3values[119] = 11;
			m3values[120] = 6;
			m3values[121] = 6;
			m3values[122] = 9;
			m3values[123] = 12;
			m3values[124] = 1;
			m3values[125] = 10;
			m3values[126] = 1;
			m3values[127] = 10;
			m3values[128] = 11;
			m3values[129] = 6;
			m3values[130] = 6;
			m3values[131] = 9;
			m3values[132] = 12;
			m3values[133] = 1;
			m3values[134] = 10;
			m3values[135] = 11;
			m3values[136] = 5;
			m3values[137] = 10;
			m3values[138] = 11;
			m3values[139] = 4;
			m3values[140] = 10;
			m3values[141] = 11;
			m3values[142] = 10;
			m3values[143] = 11;
			m3values[144] = 10;//
			m3values[145] = 11;
			m3values[146] = 9;
			m3values[147] = 12;
			m3values[148] = 5;
			m3values[149] = 5;
			m3values[150] = 10;
			m3values[151] = 11;
			m3values[152] = 3;
			m3values[153] = 3;
			m3values[154] = 9;
			m3values[155] = 12;
			m3values[156] = 1;
			m3values[157] = 1;
			m3values[158] = 10;
			m3values[159] = 11;
			m3values[160] = 5;
			m3values[161] = 5;
			m3values[162] = 9;
			m3values[163] = 12;
			m3values[164] = 5;
			m3values[165] = 9;
			m3values[166] = 12;
			m3values[167] = 1;
			m3values[168] = 9;
			m3values[169] = 12;
			m3values[170] = 7;
			m3values[171] = 7;
			m3values[172] = 10;
			m3values[173] = 11;
			m3values[174] = 1;
			m3values[175] = 10;
			m3values[176] = 11;//
			m3values[177] = 5;
			m3values[178] = 10;
			m3values[179] = 11;
			m3values[180] = 3;
			m3values[181] = 3;
			taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					switch(m3values[numTimes])
					{
						case 1:
							new Moves().L();
							break;
						case 2:
							new Moves().Lprime();
							break;
						case 3:
							new Moves().R();
							break;
						case 4:
							new Moves().Rprime();
							break;
						case 5:
							new Moves().F();
							break;
						case 6:
							new Moves().Fprime();
							break;
						case 7:
							new Moves().B();
							break;
						case 8:
							new Moves().Bprime();
							break;
						case 9:
							new Moves().U();
							break;
						case 10:
							new Moves().Uprime();
							break;
						case 11:
							new Moves().D();
							break;
						case 12:
							new Moves().Dprime();
							break;
						default:	
					}
					drawAndButtons.add(new graphics());
					cubeSpace.repaint();
					if(numTimes >= 181)
					{
						timeer.stop();
						endTime = System.currentTimeMillis();
				       	elapsedTime = endTime - startTime;
				       	if(m3t1 == 0)
				       	{
				       		m3t1 = elapsedTime / 1000;
				       		avg3 = m3t1;
				       		dcf.format(m3t1);
				       		dcf.format(avg3);
				       	}
				       	else if(m3t1 != 0 && m3t2 == 0)
				       	{
				       		m3t2 = elapsedTime / 1000;
				       		avg3 = (m3t1 + m3t2) / 2;
				       		dcf.format(m3t2);
				       		dcf.format(avg3);
				       	}
				       	else
				       	{
				       		m3t3 = elapsedTime / 1000;
				       		avg3 = (m3t1 + m3t2 + m3t3) / 3;
				       		dcf.format(m3t3);
					       	dcf.format(avg3);
				       	}
				       	avg3= Double.parseDouble(new DecimalFormat("00.000").format(avg3));
						cell2.setText("Tri-Layer");
						cell3.setText("   Trial 1");
						cell4.setText("" + m1t1 + "seconds");
						cell5.setText("   Trial 2");
						cell6.setText("" + m1t2 + "seconds");
						cell7.setText("   Trial 3");
						cell8.setText("" + m1t3 + "seconds");
						cell9.setText("   Modified Roux");
						cell10.setText("" + avg1 + "seconds");
						cell11.setText("Corner-Edge");
						cell12.setText("Minh Thai");
						cell13.setText("" + m2t1 + "seconds");
						cell14.setText("" + m3t1 + "seconds");
						cell15.setText("" + m2t2 + "seconds");
						cell16.setText("" + m3t2 + "seconds");
						cell17.setText("" + m2t3 + "seconds");
						cell18.setText("" + m3t3 + "seconds");
						cell19.setText("" + avg2 + "seconds");
						cell20.setText("" + avg3 + "seconds");
				       	numTimes = -1;
				       	startActivated = false;
						((Timer)evt.getSource()).stop();
					}
					numTimes++;
				}
	        };
	        timer = new Timer(0 , taskPerformer);
	      	timer.setRepeats(true);
	       	timer.start();
	       	startTime = System.currentTimeMillis();
	       	numm3++;
		}
	}
	public RubiksCubeSimulatorV1()
	{
		window.setSize(950,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Rubik's Cube Simulator");
		arrangement = window.getContentPane();
		arrangement.setLayout(new BorderLayout());
		title.setSize(800, 200);
		title.setBackground(Color.black);
		title.setLayout(new BorderLayout());
		middleArea.setSize(800, 400);
		middleArea.setBackground(Color.black);
		info.setSize(800, 200);
		info.setBackground(Color.black);
		arrangement.add(title, BorderLayout.NORTH);
		arrangement.add(middleArea, BorderLayout.CENTER);
		arrangement.add(info, BorderLayout.SOUTH);
		JLabel name = new JLabel("Rubik's Cube Simulator", JLabel.CENTER);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		name.setForeground(Color.white);
		title.add(name, BorderLayout.CENTER);
		question = new JButton("?");
		question.addActionListener(this);
		title.add(question, BorderLayout.WEST);
		JPanel b1 = new JPanel();
		JPanel b2 = new JPanel();
		JPanel b3 = new JPanel();
		JPanel b4 = new JPanel();
		JPanel b5 = new JPanel();
		JPanel b6 = new JPanel();
		info.setLayout(new GridLayout(1,6));
		info.add(b1);
		b1.setBackground(Color.black);
		info.add(b2);
		b2.setBackground(Color.black);
		info.add(b3);
		b3.setBackground(Color.black);
		info.add(b4);
		b4.setBackground(Color.black);
		info.add(b5);
		b5.setBackground(Color.black);
		info.add(b6);
		b6.setBackground(Color.black);
		
		//Bottom Row, Left Button
		b1.setLayout(new BorderLayout());
		JLabel fillb11 = new JLabel("     ");
		b1.add(fillb11, BorderLayout.WEST);
		JButton results = new JButton("Results");
		results.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		results.addActionListener(this);
		b1.add(results, BorderLayout.CENTER);
		JLabel fillb12 = new JLabel("     ");
		b1.add(fillb12, BorderLayout.EAST);
		
		//Bottom Row, Left Middle Button
		b2.setLayout(new BorderLayout());
		JLabel fillb21 = new JLabel("     ");
		b2.add(fillb21, BorderLayout.WEST);
		method1 = new JButton("Tri-Layer");
		method1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		method1.addActionListener(this);
		b2.add(method1, BorderLayout.CENTER);
		JLabel fillb22 = new JLabel("     ");
		b2.add(fillb22, BorderLayout.EAST);
		
		//Bottom Row, Middle Button
		b3.setLayout(new BorderLayout());
		JLabel fillb31 = new JLabel("     ");
		b3.add(fillb31, BorderLayout.WEST);
		method2 = new JButton("Corner-Edge");
		method2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		method2.addActionListener(this);
		b3.add(method2, BorderLayout.CENTER);
		JLabel fillb32 = new JLabel("     ");
		b3.add(fillb32, BorderLayout.EAST);
		
		//Bottom Row, Right Middle Button
		b4.setLayout(new BorderLayout());
		JLabel fillb41 = new JLabel("     ");
		b4.add(fillb41, BorderLayout.WEST);
		method3 = new JButton("Modified Roux");
		method3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		method3.addActionListener(this);
		b4.add(method3, BorderLayout.CENTER);
		JLabel fillb42 = new JLabel("     ");
		b4.add(fillb42, BorderLayout.EAST);
		
		//Bottom Row, Do it yourself button
		b5.setLayout(new BorderLayout());
		JLabel fillb51 = new JLabel("     ");
		b5.add(fillb51, BorderLayout.WEST);
		doItYourself = new JButton("Do it yourself");
		doItYourself.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		doItYourself.addActionListener(this);
		b5.add(doItYourself, BorderLayout.CENTER);
		JLabel fillb52 = new JLabel("     ");
		b5.add(fillb52, BorderLayout.EAST);
		
		//Bottom Row, Right Label(Time)
		time = new JLabel("00:00:000", JLabel.CENTER);
		time.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		time.setForeground(Color.white);
		b6.add(time);
		
		
		middleArea.setLayout(new BorderLayout());
		JPanel leftButton = new JPanel();
		JPanel lbm = new JPanel();
		JLabel ltopfil = new JLabel(" ");
		ltopfil.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		leftButton.setLayout(new GridLayout(3,1));
		ltfil1.setLayout(new GridLayout(3,1));
		ltfil2.setLayout(new GridLayout(3,1));
		mL = new JButton("L");
		mLp = new JButton("L prime");
		mR = new JButton("R");
		mRp = new JButton("R prime");
		mF = new JButton("F");
		mFp = new JButton("F prime");
		mB = new JButton("B");
		mBp = new JButton("B prime");
		mU = new JButton("U");
		mUp = new JButton("U prime");
		mD = new JButton("D");
		mDp = new JButton("D prime");
		mL.addActionListener(this);
		mLp.addActionListener(this);
		mR.addActionListener(this);
		mRp.addActionListener(this);
		mF.addActionListener(this);
		mFp.addActionListener(this);
		mB.addActionListener(this);
		mBp.addActionListener(this);
		mU.addActionListener(this);
		mUp.addActionListener(this);
		mD.addActionListener(this);
		mDp.addActionListener(this);
		JLabel lmfil1 = new JLabel("     "); //Left Middle Filler 1(To center button)
		JLabel lmfil2 = new JLabel("     "); //Left Middle Filler 2
		JButton lview = new JButton("<");
		lview.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lview.addActionListener(this);
		lbm.add(lmfil1, BorderLayout.WEST);
		lbm.add(lmfil2, BorderLayout.EAST);
		lbm.add(lview, BorderLayout.CENTER);
		lbm.add(ltopfil, BorderLayout.NORTH);
		leftButton.add(ltfil1);
		leftButton.add(lbm);
		leftButton.add(ltfil2);
		leftButton.setBackground(Color.black);
		ltopfil.setBackground(Color.black);
		ltfil1.setBackground(Color.black);
		ltfil2.setBackground(Color.black);
		lmfil1.setBackground(Color.black);
		lmfil2.setBackground(Color.black);
		lbm.setBackground(Color.black);
		middleArea.add(leftButton, BorderLayout.WEST);
		
		
		JPanel rightButton = new JPanel();
		JPanel rbm = new JPanel();
		JLabel rtopfil = new JLabel(" ");
		rtopfil.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		rightButton.setLayout(new GridLayout(3,1));
		rtfil1.setLayout(new GridLayout(3,1));
		rtfil2.setLayout(new GridLayout(3,1));
		JLabel rmfil1 = new JLabel("     "); //Left Middle Filler 1(To center button)
		JLabel rmfil2 = new JLabel("     "); //Left Middle Filler 2
		JButton rview = new JButton(">");
		rview.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		rview.addActionListener(this);
		rbm.add(rmfil1, BorderLayout.WEST);
		rbm.add(rmfil2, BorderLayout.EAST);
		rbm.add(rview, BorderLayout.CENTER);
		rbm.add(rtopfil, BorderLayout.NORTH);
		rightButton.add(rtfil1);
		rightButton.add(rbm);
		rightButton.add(rtfil2);
		rightButton.setBackground(Color.black);
		rtopfil.setBackground(Color.black);
		rtfil1.setBackground(Color.black);
		rtfil2.setBackground(Color.black);
		rmfil1.setBackground(Color.black);
		rmfil2.setBackground(Color.black);
		rbm.setBackground(Color.black);
		middleArea.add(rightButton, BorderLayout.EAST);
		
		
		cubeSpace.setLayout(new BorderLayout());
		JPanel topButton = new JPanel();
		topButton.setLayout(new GridLayout(1,3));
		JPanel tfil1 = new JPanel();
		JPanel tfil2 = new JPanel();
		JPanel tbutton = new JPanel();
		JPanel tlfil1 = new JPanel();
		JPanel tlfil2 = new JPanel();
		JButton tview = new JButton("^");
		tview.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tview.addActionListener(this);
		tbutton.setLayout(new GridLayout(1,3));
		tbutton.add(tlfil1);
		tbutton.add(tview);
		tbutton.add(tlfil2);
		topButton.add(tfil1);
		topButton.add(tbutton);
		topButton.add(tfil2);
		tfil1.setBackground(Color.black);
		tfil2.setBackground(Color.black);
		tlfil1.setBackground(Color.black);
		tlfil2.setBackground(Color.black);
		topButton.setBackground(Color.black);
		tbutton.setBackground(Color.black);
		cubeSpace.add(topButton, BorderLayout.NORTH);
		middleArea.add(cubeSpace);
		
		
		JPanel PPS = new JPanel();
		PPS.setLayout(new GridLayout(1,3));
		Start = new JButton("Start");
		Stop = new JButton("Stop");
		Reset = new JButton("Reset");
		Start.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Stop.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Reset.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Start.addActionListener(this);
		Stop.addActionListener(this);
		Reset.addActionListener(this);
		PPS.add(Start);
		PPS.add(Stop);
		PPS.add(Reset);
		PPS.setBackground(Color.black);
		cubeSpace.setBackground(Color.black);
		cubeSpace.add(PPS, BorderLayout.SOUTH);
		middleArea.setBackground(Color.black);
		
		drawAndButtons.setLayout(new BorderLayout());
		JPanel drawArea = new JPanel();
		JPanel bottomButton = new JPanel();
		bottomButton.setLayout(new GridLayout(1,3));
		JPanel bfil1 = new JPanel();
		JPanel bfil2 = new JPanel();
		JPanel bbutton = new JPanel();
		JPanel blfil1 = new JPanel();
		JPanel blfil2 = new JPanel();
		JButton bview = new JButton("\\/");
		bview.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		bview.addActionListener(this);
		bbutton.setLayout(new GridLayout(1,3));
		bbutton.add(blfil1);
		bbutton.add(bview);
		bbutton.add(blfil2);
		bottomButton.add(bfil1);
		bottomButton.add(bbutton);
		bottomButton.add(bfil2);
		bfil1.setBackground(Color.black);
		bfil2.setBackground(Color.black);
		blfil1.setBackground(Color.black);
		blfil2.setBackground(Color.black);
		bottomButton.setBackground(Color.black);
		bbutton.setBackground(Color.black);
		drawArea.setBackground(Color.black);
		drawAndButtons.setBackground(Color.black);
		drawAndButtons.add(drawArea, BorderLayout.NORTH);
		drawAndButtons.add(bottomButton, BorderLayout.SOUTH);
		cubeSpace.add(drawAndButtons, BorderLayout.CENTER);
		
		
		
		for(count = 0; count < 54; count++)
		{
			if(count < 9)
			{
				sideValues[count] = 1;
			}
			else if(count >= 9 && count < 18)
			{
				sideValues[count] = 2;
			}
			else if(count >= 18 && count < 27)
			{
				sideValues[count] = 3;
			}
			else if(count >= 27 && count < 36)
			{
				sideValues[count] = 4;
			}
			else if(count >= 36 && count < 45)
			{
				sideValues[count] = 5;
			}
			else
			{
				sideValues[count] = 6;
			}
		}

		drawAndButtons.add(new graphics());
		
		window.setVisible(true);
	}
	public class Scramble
	{
		public void scrambleCube()
		{
			if(methodValue == 1)
			{
				sideValues[0] = 6;
				sideValues[1] = 6;
				sideValues[2] = 1;
				sideValues[3] = 1;
				sideValues[4] = 1;
				sideValues[5] = 6;
				sideValues[6] = 4;
				sideValues[7] = 4;
				sideValues[8] = 5;
				sideValues[9] = 4;
				sideValues[10] = 5;
				sideValues[11] = 4;
				sideValues[12] = 6;
				sideValues[13] = 2;
				sideValues[14] = 1;
				sideValues[15] = 1;
				sideValues[16] = 3;
				sideValues[17] = 3;
				sideValues[18] = 3;
				sideValues[19] = 2;
				sideValues[20] = 6;
				sideValues[21] = 2;
				sideValues[22] = 3;
				sideValues[23] = 5;
				sideValues[24] = 6;
				sideValues[25] = 4;
				sideValues[26] = 2;
				sideValues[27] = 2;
				sideValues[28] = 5;
				sideValues[29] = 4;
				sideValues[30] = 4;
				sideValues[31] = 4;
				sideValues[32] = 2;
				sideValues[33] = 5;
				sideValues[34] = 5;
				sideValues[35] = 2;
				sideValues[36] = 1;
				sideValues[37] = 3;
				sideValues[38] = 6;
				sideValues[39] = 3;
				sideValues[40] = 5;
				sideValues[41] = 4;
				sideValues[42] = 3;
				sideValues[43] = 3;
				sideValues[44] = 2;
				sideValues[45] = 5;
				sideValues[46] = 2;
				sideValues[47] = 3;
				sideValues[48] = 1;
				sideValues[49] = 6;
				sideValues[50] = 6;
				sideValues[51] = 5;
				sideValues[52] = 1;
				sideValues[53] = 1;
			}
			else if(methodValue == 2)
			{
				sideValues[0] = 4;
				sideValues[1] = 4;
				sideValues[2] = 6;
				sideValues[3] = 1;
				sideValues[4] = 1;
				sideValues[5] = 1;
				sideValues[6] = 6;
				sideValues[7] = 3;
				sideValues[8] = 1;
				sideValues[9] = 4;
				sideValues[10] = 3;
				sideValues[11] = 2;
				sideValues[12] = 3;
				sideValues[13] = 2;
				sideValues[14] = 5;
				sideValues[15] = 5;
				sideValues[16] = 6;
				sideValues[17] = 3;
				sideValues[18] = 1;
				sideValues[19] = 6;
				sideValues[20] = 2;
				sideValues[21] = 2;
				sideValues[22] = 3;
				sideValues[23] = 3;
				sideValues[24] = 2;
				sideValues[25] = 5;
				sideValues[26] = 6;
				sideValues[27] = 5;
				sideValues[28] = 1;
				sideValues[29] = 6;
				sideValues[30] = 4;
				sideValues[31] = 4;
				sideValues[32] = 6;
				sideValues[33] = 5;
				sideValues[34] = 5;
				sideValues[35] = 2;
				sideValues[36] = 3;
				sideValues[37] = 6;
				sideValues[38] = 1;
				sideValues[39] = 4;
				sideValues[40] = 5;
				sideValues[41] = 1;
				sideValues[42] = 5;
				sideValues[43] = 2;
				sideValues[44] = 4;
				sideValues[45] = 4;
				sideValues[46] = 4;
				sideValues[47] = 1;
				sideValues[48] = 5;
				sideValues[49] = 6;
				sideValues[50] = 2;
				sideValues[51] = 3;
				sideValues[52] = 2;
				sideValues[53] = 3;
			}
			if(methodValue == 3)
			{
				sideValues[0] = 2;
				sideValues[1] = 3;
				sideValues[2] = 4;
				sideValues[3] = 2;
				sideValues[4] = 1;
				sideValues[5] = 2;
				sideValues[6] = 4;
				sideValues[7] = 5;
				sideValues[8] = 6;
				sideValues[9] = 6;
				sideValues[10] = 5;
				sideValues[11] = 3;
				sideValues[12] = 1;
				sideValues[13] = 2;
				sideValues[14] = 6;
				sideValues[15] = 5;
				sideValues[16] = 4;
				sideValues[17] = 5;
				sideValues[18] = 4;
				sideValues[19] = 3;
				sideValues[20] = 1;
				sideValues[21] = 4;
				sideValues[22] = 3;
				sideValues[23] = 3;
				sideValues[24] = 1;
				sideValues[25] = 5;
				sideValues[26] = 1;
				sideValues[27] = 3;
				sideValues[28] = 1;
				sideValues[29] = 6;
				sideValues[30] = 2;
				sideValues[31] = 4;
				sideValues[32] = 1;
				sideValues[33] = 5;
				sideValues[34] = 6;
				sideValues[35] = 1;
				sideValues[36] = 4;
				sideValues[37] = 4;
				sideValues[38] = 3;
				sideValues[39] = 2;
				sideValues[40] = 5;
				sideValues[41] = 5;
				sideValues[42] = 3;
				sideValues[43] = 6;
				sideValues[44] = 2;
				sideValues[45] = 5;
				sideValues[46] = 3;
				sideValues[47] = 2;
				sideValues[48] = 1;
				sideValues[49] = 6;
				sideValues[50] = 4;
				sideValues[51] = 2;
				sideValues[52] = 6;
				sideValues[53] = 6;
			}
		}
	}
	public static void main(String [] args) throws IOException
	{
		new RubiksCubeSimulatorV1();
	}	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(((JButton) arg0.getSource()).getText().equals("^"))
		{
			if(side == 2 || side == 3 || side == 4 || side == 5)
			{
				downSide = side;
				side = 6;
				new setAxis().setAxes();
			}
			else if(side == 1)
			{
				side = upSide;
				//new sideDet().determineSide();
				new setAxis().setAxes();
			}
			else if(side == 6){}
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("\\/"))
		{
			if(side == 2 || side == 3 || side == 4 || side == 5)
			{
				upSide = side;
				side = 1;
				new setAxis();
			}
			else if(side == 6)
			{
				side = downSide;
				//new sideDet().determineSide();
				new setAxis().setAxes();
			}
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("<"))
		{
			if(side == 2 || side == 3 || side == 4 || side == 5)
			{
				side -= 1;
				if(side == 1)
					side = 5;
				if(side == 2 || side == 4)
					lastAxis = 1;
				else if(side == 3 || side == 5)
					lastAxis = 2;
			}
			else if(side == 1)
			{
				upSide -= 1;
				if(upSide == 1)
					upSide = 5;
				if(upSide == 2 || upSide == 4)
					lastAxis = 1;
				else
					lastAxis = 2;
			}
			else if(side == 6)
			{
				downSide -= 1;
				if(downSide == 1)
					downSide = 5;
				if(downSide == 2 || downSide == 4)
					lastAxis = 1;
				else
					lastAxis = 2;
			}
			new setAxis().setAxes();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals(">"))
		{
			if(side == 2 || side == 3 || side == 4 || side == 5)
			{
				side += 1;
				if(side == 6)
					side = 2;
				if(side == 2 || side == 4)
					lastAxis = 1;
				else if(side == 3 || side == 5)
					lastAxis = 2;
			}
			else if(side == 1)
			{
				upSide += 1;
				if(upSide == 6)
					upSide = 2;
			}
			else if(side == 6)
			{
				downSide += 1;
				if(downSide == 6)
					downSide = 2;
			}
			new setAxis().setAxes();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("Tri-Layer"))
		{
			if(startActivated == false)
			{
				methodValue = 1;
				method1.setForeground(Color.red);
				method2.setForeground(Color.black);
				method3.setForeground(Color.black);
				doItYourself.setForeground(Color.black);
				if(doYourself == true)
				{
					window.setVisible(false);
					ltfil1.remove(mL);
					ltfil1.remove(mLp);
					ltfil1.remove(mR);
					ltfil2.remove(mRp);
					ltfil2.remove(mF);
					ltfil2.remove(mFp);
					rtfil1.remove(mB);
					rtfil1.remove(mBp);
					rtfil1.remove(mU);
					rtfil2.remove(mUp);
					rtfil2.remove(mD);
					rtfil2.remove(mDp);
					rightButton.remove(rtfil1);
					rightButton.remove(rtfil2);
					leftButton.remove(ltfil1);
					leftButton.remove(ltfil2);
					arrangement.validate();
					window.setVisible(true);
				}
				new Scramble().scrambleCube();
				if(numm1 == 1)
					side = 2;
				else if(numm1 == 2)
					side = 5;
				else if(numm1 == 3)
					side = 1;
				else if(numm1 == 4)
					side = 3;
				else if(numm1 == 5)
					side = 6;
				else if(numm1 == 6)
					side = 4;
				else
					side = 2;
				drawAndButtons.add(new graphics());
				cubeSpace.repaint();
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("Corner-Edge"))
		{
			if(startActivated == false)
			{
				methodValue = 2;
				method1.setForeground(Color.black);
				method2.setForeground(Color.red);
				method3.setForeground(Color.black);
				doItYourself.setForeground(Color.black);
				if(doYourself == true)
				{
					window.setVisible(false);
					ltfil1.remove(mL);
					ltfil1.remove(mLp);
					ltfil1.remove(mR);
					ltfil2.remove(mRp);
					ltfil2.remove(mF);
					ltfil2.remove(mFp);
					rtfil1.remove(mB);
					rtfil1.remove(mBp);
					rtfil1.remove(mU);
					rtfil2.remove(mUp);
					rtfil2.remove(mD);
					rtfil2.remove(mDp);
					rightButton.remove(rtfil1);
					rightButton.remove(rtfil2);
					leftButton.remove(ltfil1);
					leftButton.remove(ltfil2);
					arrangement.validate();
					window.setVisible(true);
				}
				new Scramble().scrambleCube();
				if(numm2 == 1)
					side = 2;
				else if(numm2 == 2)
					side = 3;
				else if(numm2 == 3)
					side = 6;
				else if(numm2 == 4)
					side = 1;
				else if(numm2 == 5)
					side = 4;
				else if(numm2 == 6)
					side = 5;
				else
					side = 2;
				drawAndButtons.add(new graphics());
				cubeSpace.repaint();
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("Modified Roux"))
		{
			if(startActivated == false)
			{
				methodValue = 3;
				method1.setForeground(Color.black);
				method2.setForeground(Color.black);
				method3.setForeground(Color.red);
				doItYourself.setForeground(Color.black);
				if(doYourself == true)
				{
					window.setVisible(false);
					ltfil1.remove(mL);
					ltfil1.remove(mLp);
					ltfil1.remove(mR);
					ltfil2.remove(mRp);
					ltfil2.remove(mF);
					ltfil2.remove(mFp);
					rtfil1.remove(mB);
					rtfil1.remove(mBp);
					rtfil1.remove(mU);
					rtfil2.remove(mUp);
					rtfil2.remove(mD);
					rtfil2.remove(mDp);
					rightButton.remove(rtfil1);
					rightButton.remove(rtfil2);
					leftButton.remove(ltfil1);
					leftButton.remove(ltfil2);
					arrangement.validate();
					window.setVisible(true);
				}
				new Scramble().scrambleCube();
				if(numm3 == 1)
					side = 2;
				else if(numm3 == 2)
					side = 6;
				else if(numm3 == 3)
					side = 4;
				else if(numm3 == 4)
					side = 1;
				else if(numm3 == 5)
					side = 3;
				else if(numm3 == 6)
					side = 5;
				else
					side = 2;
				drawAndButtons.add(new graphics());
				cubeSpace.repaint();
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("Start"))
		{
			startActivated = true;
			if(methodValue == 1)
				try {
					new Solve().Method1();
				} catch (IOException e) {
				}
			else if(methodValue == 2)
				try {
					new Solve().Method2();
				} catch (IOException e) {
				}
			else if(methodValue == 3)
				try {
					new Solve().Method3();
				} catch (IOException e) {
				}
			new Timing().Timer();
		}
		else if(((JButton) arg0.getSource()).getText().equals("Stop"))
		{
			if(startActivated == true)
			{
				timer.stop();
				timeer.stop();
			}
			startActivated = false;
			System.out.println(m1list);
		}
		else if(((JButton) arg0.getSource()).getText().equals("Reset"))
		{
			if(startActivated == false)
			{
				startTime = 0;
				endTime = 0;
				elapsedTime = 0;
				startTimer = 0;
				endTimer = 0;
				elapsedTimer = 0;
				minutes = 0;
				seconds = 0;
				milliseconds = 0;
				method1.setForeground(Color.black);
				method2.setForeground(Color.black);
				method3.setForeground(Color.black);
				doItYourself.setForeground(Color.black);
				time.setText("00:00:000");
				firstRun = true;
				drawAndButtons.add(new graphics());
				cubeSpace.repaint();
				arrangement.validate();
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("Results"))
		{
			if(startActivated == false)
			{
				if(firstSwitch == true)
				{
					results.setLayout(new GridLayout(3,2));
					JPanel rfil1 = new JPanel();
					JPanel rfil2 = new JPanel();
					JPanel rfil3 = new JPanel();
					JPanel rfil4 = new JPanel();
					JPanel table1 = new JPanel();
					rfil3.setLayout(new GridLayout(3,3));
					JPanel filfil1 = new JPanel();
					JPanel filfil2 = new JPanel();
					JPanel filfil3 = new JPanel();
					JPanel filfil4 = new JPanel();
					JPanel filfil5 = new JPanel();
					JPanel filfil6 = new JPanel();
					JPanel filfil7 = new JPanel();
					JPanel filfil8 = new JPanel();
					goBack.addActionListener(this);
					rfil3.add(filfil1);
					rfil3.add(filfil2);
					rfil3.add(filfil3);
					rfil3.add(filfil4);
					rfil3.add(filfil5);
					rfil3.add(filfil6);
					rfil3.add(goBack);
					rfil3.add(filfil7);
					rfil3.add(filfil8);
					filfil1.setBackground(Color.black);
					filfil2.setBackground(Color.black);
					filfil3.setBackground(Color.black);
					filfil4.setBackground(Color.black);
					filfil5.setBackground(Color.black);
					filfil6.setBackground(Color.black);
					filfil7.setBackground(Color.black);
					filfil8.setBackground(Color.black);
					table1.setLayout(new GridLayout(5,2));
					JPanel table2 = new JPanel();
					table2.setLayout(new GridLayout(5,2));
					cell1.setText("");
					cell2.setText("Tri-Layer");
					cell3.setText("   Trial 1");
					cell4.setText("" + m1t1 + "seconds");
					cell5.setText("   Trial 2");
					cell6.setText("" + m1t2 + "seconds");
					cell7.setText("   Trial 3");
					cell8.setText("" + m1t3 + "seconds");
					cell9.setText("   Average");
					cell10.setText("" + avg1 + "seconds");
					cell11.setText("Corner-Edge");
					cell12.setText("Modified Roux");
					cell13.setText("" + m2t1 + "seconds");
					cell14.setText("" + m3t1 + "seconds");
					cell15.setText("" + m2t2 + "seconds");
					cell16.setText("" + m3t2 + "seconds");
					cell17.setText("" + m2t3 + "seconds");
					cell18.setText("" + m3t3 + "seconds");
					cell19.setText("" + avg2 + "seconds");
					cell20.setText("" + avg3 + "seconds");
					cell1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell6.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell7.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell8.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell9.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell10.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell11.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell12.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell13.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell14.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell15.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell16.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell17.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell18.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell19.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell20.setFont(new Font("Times New Roman", Font.PLAIN, 28));
					cell1.setForeground(Color.white);
					cell2.setForeground(Color.white);
					cell3.setForeground(Color.white);
					cell4.setForeground(Color.white);
					cell5.setForeground(Color.white);
					cell6.setForeground(Color.white);
					cell7.setForeground(Color.white);
					cell8.setForeground(Color.white);
					cell9.setForeground(Color.white);
					cell10.setForeground(Color.white);
					cell11.setForeground(Color.white);
					cell12.setForeground(Color.white);
					cell13.setForeground(Color.white);
					cell14.setForeground(Color.white);
					cell15.setForeground(Color.white);
					cell16.setForeground(Color.white);
					cell17.setForeground(Color.white);
					cell18.setForeground(Color.white);
					cell19.setForeground(Color.white);
					cell20.setForeground(Color.white);
					table1.setBackground(Color.black);
					table2.setBackground(Color.black);
					rfil1.setBackground(Color.black);
					rfil2.setBackground(Color.black);
					rfil3.setBackground(Color.black);
					rfil4.setBackground(Color.black);
					table1.add(cell1);
					table1.add(cell2);
					table1.add(cell3);
					table1.add(cell4);
					table1.add(cell5);
					table1.add(cell6);
					table1.add(cell7);
					table1.add(cell8);
					table1.add(cell9);
					table1.add(cell10);
					table2.add(cell11);
					table2.add(cell12);
					table2.add(cell13);
					table2.add(cell14);
					table2.add(cell15);
					table2.add(cell16);
					table2.add(cell17);
					table2.add(cell18);
					table2.add(cell19);
					table2.add(cell20);
					results.add(rfil1);
					results.add(rfil2);
					results.add(table1);
					results.add(table2);
					results.add(rfil3);
					results.add(rfil4);
					firstSwitch = false;
				}	
				window.setVisible(false);
				arrangement.removeAll();
				arrangement.validate();
				arrangement.add(results, BorderLayout.CENTER);
				arrangement.validate();
				window.setVisible(true);
			}
		}
		else if(((JButton) arg0.getSource()).getText().equals("Go Back"))
		{
			window.setVisible(false);
			arrangement.remove(results);
			arrangement.validate();
			arrangement.add(title, BorderLayout.NORTH);
			arrangement.add(middleArea, BorderLayout.CENTER);
			arrangement.add(info, BorderLayout.SOUTH);
			arrangement.validate();
			window.setVisible(true);
		}
		else if(((JButton) arg0.getSource()).getText().equals("?"))
		{
			if(firstHelp == true)
			{
				helpView.setSize(600,500);
				helpView.setTitle("Rubik's Cube Simulator Help");
				helpArrangement = helpView.getContentPane();
				helpArrangement.setLayout(new BorderLayout());
				JPanel text = new JPanel();
				text.setBackground(Color.black);
				JLabel triex1 = new JLabel("Tri-Layer Method: This method involves solving");
				JLabel triex2 = new JLabel("the bottom side and edge, then the middle edges,");
				JLabel triex3 = new JLabel("and finally the top side and edge");
				triex1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				triex2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				triex3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				text.add(triex1);
				text.add(triex2);
				text.add(triex3);
				triex1.setForeground(Color.white);
				triex2.setForeground(Color.white);
				triex3.setForeground(Color.white);
				JLabel filler1 = new JLabel("I am currently 18 hours into this project");
				filler1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				filler1.setForeground(Color.black);
				text.add(filler1);
				JLabel corex1 = new JLabel("Corner-Edge Method: This method involves solving");
				JLabel corex2 = new JLabel("the 8 corners, followed by the 12 edges.");
				corex1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				corex2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				text.add(corex1);
				text.add(corex2);
				corex1.setForeground(Color.white);
				corex2.setForeground(Color.white);
				JLabel filler2 = new JLabel("Obama is not, in fact, a Kenyan Muslim Socialist.");
				filler2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				filler2.setForeground(Color.black);
				text.add(filler2);
				JLabel minex1 = new JLabel("Modified Roux: This method involves solving two");
				JLabel minex2 = new JLabel("1x2x3 blocks, followed by a modified algorithm");
				JLabel minex3 = new JLabel("(developed by me) that solves the top side and edges.");
				minex1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				minex2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				minex3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				text.add(minex1);
				text.add(minex2);
				text.add(minex3);
				minex1.setForeground(Color.white);
				minex2.setForeground(Color.white);
				minex3.setForeground(Color.white);
				JLabel filler3 = new JLabel("When the power of love overcomes the love of power, the world will know peace.");
				filler3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				filler3.setForeground(Color.black);
				text.add(filler3);
				JLabel notex1 = new JLabel("Note: No matter what view the cube is at,");
				JLabel notex2 = new JLabel("the turns will always start from the blue");
				JLabel notex3 = new JLabel("side to avoid disorientation.");
				notex1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				notex2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				notex3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
				text.add(notex1);
				text.add(notex2);
				text.add(notex3);
				notex1.setForeground(Color.white);
				notex2.setForeground(Color.white);
				notex3.setForeground(Color.white);
				helpArrangement.add(text, BorderLayout.CENTER);
				firstHelp = false;
			}
			helpView.setVisible(true);
		}
		
		else if(((JButton) arg0.getSource()).getText().equals("L"))
		{
			moveAid++;
			m1values[moveAid] = 1;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().L();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("L prime"))
		{
			moveAid++;
			m1values[moveAid] = 2;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().Lprime();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("R"))
		{
			moveAid++;
			m1values[moveAid] = 3;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().R();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("R prime"))
		{
			moveAid++;
			m1values[moveAid] = 4;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().Rprime();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("F"))
		{
			moveAid++;
			m1values[moveAid] = 5;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().F();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("F prime"))
		{
			moveAid++;
			m1values[moveAid] = 6;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().Fprime();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("B"))
		{
			moveAid++;
			m1values[moveAid] = 7;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().B();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("B prime"))
		{
			moveAid++;
			m1values[moveAid] = 8;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().Bprime();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("U"))
		{
			moveAid++;
			m1values[moveAid] = 9;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().U();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("U prime"))
		{
			moveAid++;
			m1values[moveAid] = 10;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().Uprime();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("D"))
		{
			moveAid++;
			m1values[moveAid] = 11;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().D();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("D prime"))
		{
			moveAid++;
			m1values[moveAid] = 12;
			m1list = m1list + "," + m1values[moveAid];
			new Moves().Dprime();
			drawAndButtons.add(new graphics());
			cubeSpace.repaint();
		}
		else if(((JButton) arg0.getSource()).getText().equals("Do it yourself"))
		{
			methodValue = 0;
			ltfil1.add(mL);
			ltfil1.add(mLp);
			ltfil1.add(mR);
			ltfil2.add(mRp);
			ltfil2.add(mF);
			ltfil2.add(mFp);
			rtfil1.add(mB);
			rtfil1.add(mBp);
			rtfil1.add(mU);
			rtfil2.add(mUp);
			rtfil2.add(mD);
			rtfil2.add(mDp);
			method1.setForeground(Color.black);
			method2.setForeground(Color.black);
			method3.setForeground(Color.black);
			doItYourself.setForeground(Color.red);
			arrangement.validate();
		}
	}
}
