import java.awt.Graphics;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





public class PaintFrame extends JFrame {

	private Account account;
	private EntityManagment em;
	
	private int whichShape=0;
	private int whichColor=1;
	private static int maxCount=100;
	/**
	 * Launch the application.
	 */

	public PaintFrame(Account account) {
		
		this.account=account;
		 Panel p = new Panel();
		 getContentPane().add(p);
		 getContentPane().setLayout(null);
		 
		 em=new EntityManagment();
		    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		p.addMouseListener(new MouseAdapter() {
			
	
		});
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setLayout(null);
		
		JRadioButton rb3 = new JRadioButton("\u0645\u0634\u06A9\u06CC");
		rb3.setSelected(true);
		rb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whichColor=1;
			}
			
		});
		rb3.setBounds(345, 162, 109, 23);
		 getContentPane().add(rb3);
		 
			JRadioButton rb2 = new JRadioButton("\u0642\u0631\u0645\u0632");
			rb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					whichColor=2;
				}
			});
			rb2.setBounds(345, 179, 65, 23);
			 getContentPane().add(rb2);
			 
				JRadioButton rb1 = new JRadioButton("\u0622\u0628\u06CC");
				rb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						whichColor=3;
					}
				});
				rb1.setBounds(345, 197, 65, 23);
				 getContentPane().add(rb1);
		 
		JRadioButton rb0 = new JRadioButton("\u0633\u0628\u0632");
		rb0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whichColor=4;
			}
		});
		rb0.setBounds(347, 216, 65, 23);
		 getContentPane().add(rb0);
		

		

		
		JButton btnLinre = new JButton("\u062E\u0637");
		btnLinre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				whichShape=1;
			}
		});
		btnLinre.setBounds(319, 28, 89, 23);
		 getContentPane().add(btnLinre);
		
		JButton btnCircle = new JButton("\u062F\u0627\u06CC\u0631\u0647");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whichShape=2;
			}
		});
		btnCircle.setBounds(319, 65, 89, 23);
		 getContentPane().add(btnCircle);
		
		JButton button = new JButton("\u0645\u0633\u062A\u0637\u06CC\u0644");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whichShape=3;
			}
		});
		button.setBounds(319, 101, 89, 23);
		 getContentPane().add(button);
		
		JLabel label = new JLabel("\u0627\u0646\u062A\u062E\u0627\u0628 \u0631\u0646\u06AF");
		label.setBounds(348, 135, 60, 20);
		getContentPane().add(label);
		
	
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb0);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		JButton button_1 = new JButton("\u062E\u0631\u0648\u062C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.saveAccount(account);
				LoginFrame lf=new LoginFrame();
				lf.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(323, 239, 89, 23);
		 getContentPane().add(button_1);
	}
	
	private class Panel extends JPanel
	{   
		
		
	    public Panel()
	   {   
	       setBounds(20,20,270,230);
	        setBackground(Color.white);
	        MouseHandler handler = new MouseHandler();
	        this.addMouseMotionListener(handler);
	        this.addMouseListener(handler);
	    }
	    @Override
	    protected void paintComponent(Graphics g) 
	    {
	        // TODO Auto-generated method stub
	        super.paintComponent(g);
	       int count=account.getLineCount();
	       Line[] lines=account.getLines();
	        for(int i = 0;i <count;i++)
	        {   
	            if(lines[i].getColor()==1)g.setColor(Color.black);
	            if(lines[i].getColor()==2)g.setColor(Color.red);
	            if(lines[i].getColor()==3)g.setColor(Color.blue);
	            if(lines[i].getColor()==4)g.setColor(Color.green);
	           
	           g.drawLine(lines[i].getBegine().x, lines[i].getBegine().y, lines[i].getEnd().x, lines[i].getEnd().y);
	        }  
	        count = account.getRectangleCount();
	        Rectangle[] rectangles=account.getRectangles();
	        for(int i = 0;i <count;i++)
	        {   
	        	 if(rectangles[i].getColor()==1)g.setColor(Color.black);
		            if(rectangles[i].getColor()==2)g.setColor(Color.red);
		            if(rectangles[i].getColor()==3)g.setColor(Color.blue);
		            if(rectangles[i].getColor()==4)g.setColor(Color.green);
	            g.drawRect(rectangles[i].getBegine().x, rectangles[i].getBegine().y, rectangles[i].getEnd().x-rectangles[i].getBegine().x, rectangles[i].getEnd().y-rectangles[i].getBegine().y);
	        }
	        count=account.getCircleCount();
	        Circle[] circles=account.getCircles();
	        for(int i = 0;i <count;i++)
	        {   
	        	 if(circles[i].getColor()==1)g.setColor(Color.black);
		            if(circles[i].getColor()==2)g.setColor(Color.red);
		            if(circles[i].getColor()==3)g.setColor(Color.blue);
		            if(circles[i].getColor()==4)g.setColor(Color.green);
	            g.drawArc(circles[i].getBegine().x, circles[i].getBegine().y, circles[i].getEnd().x-circles[i].getBegine().x, circles[i].getEnd().y-circles[i].getBegine().y,0,360);
	        }

	    }



	private class MouseHandler extends MouseAdapter
	{  
	    @Override
	    public void mouseDragged(MouseEvent e) 
	    {
	    	int count;
	        // TODO Auto-generated method stub
	    	if(whichShape==1)
	    	{
	    	    count=account.getLineCount();
	    		account.getLines()[count-1].setEnd(e.getPoint());
	    		account.getLines()[count-1].setColor(whichColor);
	    	} 
	    	if(whichShape==2)
	    	{
	    		count=account.getCircleCount();
	    		account.getCircles()[count-1].setEnd(e.getPoint());
	    		account.getCircles()[count-1].setColor(whichColor);
	    	}
	    	if(whichShape==3)
	    	{
	    		count=account.getRectangleCount();
	    		account.getRectangles()[count-1].setEnd(e.getPoint());
	    		account.getRectangles()[count-1].setColor(whichColor);
	    	}

	           repaint();
	           


	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
	        // TODO Auto-generated method stub
	        super.mousePressed(e);
	        
	        if(whichShape==1 && account.getLineCount() < maxCount)
	        {
	        	Line line=new Line();
	            line.setBegine(e.getPoint());
	            line.setEnd(e.getPoint());
	            account.addLine(line); 
	           
	        }
	        
	        if(whichShape==2 && account.getCircleCount() < maxCount)
	        {
	        	Circle circle=new Circle();
	        	circle.setBegine(e.getPoint());
	        	circle.setEnd(e.getPoint());
	        	account.addCircle(circle); 
	         
	        }
	        
	        if(whichShape==3 && account.getRectangleCount() < maxCount)
	        {
	        	Rectangle rectangle=new Rectangle();
	        	rectangle.setBegine(e.getPoint());
	        	rectangle.setEnd(e.getPoint());
	        	account.addRectangle(rectangle);
	           
	        }
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
	        // TODO Auto-generated method stub
	        super.mouseReleased(e);
	        /*pointends[pointCount]=e.getPoint();
	        repaint();
	        pointCount++;
	    */
	    }

	    }
	
	
	}}
