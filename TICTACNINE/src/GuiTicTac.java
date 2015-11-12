import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiTicTac implements ItemListener, ActionListener {
	boolean[] empty = { true, true, true, true, true, true, true, true, true };
	// boolean[] circle = {true,true,true,true,true,true,true,true,true};
	boolean circle;
	JButton[] buttonArr = new JButton[9];
//
//	JButton a;
//	JButton b;
//	JButton c;
//	JButton d;
//	JButton e;
//	JButton f;
//	JButton g;
//	JButton h;
//	JButton i;
	JButton restart;

	Icon ic1 = new ImageIcon("ic1.jpg");
	Icon ic2 = new ImageIcon("ic2.jpg");

	public static void main(String[] args) {
		new GuiTicTac();

	}

	public GuiTicTac() {
		// we could do other non-GUI work here if needed
		initialize(); // our method to setup the GUI
	}

	private void initialize() {

		JFrame frame = new JFrame();// creating instance of JFrame
		// JCheckBox a = new JCheckBox();//creating instance of JButton
		for (int i=0;i<9; i++) {
			String s = Integer.toString(i);
			buttonArr[i]=new JButton(s);
			int a = 30+(i%3)*100;
			int b = 100+(i/3)*100;
			buttonArr[i].setBounds(a, b, 100, 100);
			buttonArr[i].addActionListener(this);
			frame.add(buttonArr[i]);
		}
		
		restart = new JButton("Restart");// creating instance of JButton
		restart.setBounds(230, 400, 100, 30);// x axis, y axis, width, height
		restart.addActionListener(this);
		frame.add(restart);// adding button in JFrame

		frame.setSize(400, 500);// 400 width and 500 height
		frame.setLayout(null);// using no layout managers
		frame.setVisible(true);// making the frame visible
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton but = (JButton) e.getSource();
		int i = Integer.parseInt(but.getText());

		if (empty[i]) {
			if (circle) {
				but.setIcon(ic1);
				circle = false;
			} else {
				but.setIcon(ic2);
				circle = true;
			}
		}
		empty[i] = false;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}
