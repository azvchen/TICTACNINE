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

	JButton a;
	JButton b;
	JButton c;
	JButton d;
	JButton e;
	JButton f;
	JButton g;
	JButton h;
	JButton i;
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
		a = new JButton("0");// creating instance of JButton
		a.setBounds(30, 100, 100, 100);// x axis, y axis, width, height
		b = new JButton("1");// creating instance of JButton
		b.setBounds(130, 100, 100, 100);// x axis, y axis, width, height
		c = new JButton("2");// creating instance of JButton
		c.setBounds(230, 100, 100, 100);// x axis, y axis, width, height
		d = new JButton("3");// creating instance of JButton
		d.setBounds(30, 200, 100, 100);// x axis, y axis, width, height
		e = new JButton("4");// creating instance of JButton
		e.setBounds(130, 200, 100, 100);// x axis, y axis, width, height
		f = new JButton("5");// creating instance of JButton
		f.setBounds(230, 200, 100, 100);// x axis, y axis, width, height
		g = new JButton("6");// creating instance of JButton
		g.setBounds(30, 300, 100, 100);// x axis, y axis, width, height
		h = new JButton("7");// creating instance of JButton
		h.setBounds(130, 300, 100, 100);// x axis, y axis, width, height
		i = new JButton("8");// creating instance of JButton
		i.setBounds(230, 300, 100, 100);// x axis, y axis, width, height
		restart = new JButton("Restart");// creating instance of JButton
		restart.setBounds(230, 400, 100, 30);// x axis, y axis, width, height

		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		i.addActionListener(this);
		restart.addActionListener(this);

		frame.add(a);// adding button in JFrame
		frame.add(b);// adding button in JFrame
		frame.add(c);// adding button in JFrame
		frame.add(d);// adding button in JFrame
		frame.add(e);// adding button in JFrame
		frame.add(f);// adding button in JFrame
		frame.add(g);// adding button in JFrame
		frame.add(h);// adding button in JFrame
		frame.add(i);// adding button in JFrame
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
