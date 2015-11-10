import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GuiTicTac {
	
	public static void main(String[] args) {  
		JFrame frame=new JFrame();//creating instance of JFrame
		          
		JButton a=new JButton("a");//creating instance of JButton  
		a.setBounds(30,100,100, 100);//x axis, y axis, width, height  
		JButton b=new JButton("b");//creating instance of JButton  
		b.setBounds(130,100,100, 100);//x axis, y axis, width, height 
		JButton c=new JButton("c");//creating instance of JButton  
		c.setBounds(230,100,100, 100);//x axis, y axis, width, height 
		JButton d=new JButton("d");//creating instance of JButton  
		d.setBounds(30,200,100, 100);//x axis, y axis, width, height 
		JButton e=new JButton("e");//creating instance of JButton  
		e.setBounds(130,200,100, 100);//x axis, y axis, width, height 
		JButton f=new JButton("f");//creating instance of JButton  
		f.setBounds(230,200,100, 100);//x axis, y axis, width, height 
		JButton g=new JButton("g");//creating instance of JButton  
		g.setBounds(30,300,100, 100);//x axis, y axis, width, height 
		JButton h=new JButton("h");//creating instance of JButton  
		h.setBounds(130,300,100, 100);//x axis, y axis, width, height 
		JButton i=new JButton("i");//creating instance of JButton  
		i.setBounds(230,300,100, 100);//x axis, y axis, width, height 
		JButton restart=new JButton("Restart");//creating instance of JButton  
		restart.setBounds(230,400,100, 30);//x axis, y axis, width, height 
				          
		frame.add(a);//adding button in JFrame  
		frame.add(b);//adding button in JFrame  
		frame.add(c);//adding button in JFrame  
		frame.add(d);//adding button in JFrame  
		frame.add(e);//adding button in JFrame  
		frame.add(f);//adding button in JFrame  
		frame.add(g);//adding button in JFrame  
		frame.add(h);//adding button in JFrame  
		frame.add(i);//adding button in JFrame  
		frame.add(restart);//adding button in JFrame  
		          
		frame.setSize(400,500);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
		}  
	
	class HandleSubmitPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {/*
			System.out.println("i've beeen pressed!"); // to Console (not GUI)
			String name = nameTF.getText().trim();
			outputTF.setText("you clicked"); //shown on GUI (outputTF)
			frame.repaint();  //clears that text area, ready for new text
			*/
		}
	}
}
