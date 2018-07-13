

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AboutDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	boolean restartflag = false;

	public AboutDialog(JFrame jframe) {
		// TODO Auto-generated constructor stub
		super(jframe, "关于", true);
		this.setLayout(new GridLayout(4,1));
		JButton closeButton = new JButton("关闭");
		JLabel label1 = new JLabel("单机版五子棋v1.0");
		JLabel label2=new JLabel("Made by MYlitBoY");
		JLabel label3=new JLabel("Made:2010.6.7-6.8,6.23-6.25");
		closeButton.addActionListener(this);
		closeButton.setActionCommand("Close");
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(closeButton);

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocation(400, 350);
		this.setSize(260, 300);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);

	}

	public boolean getButtonPrassed() {

		return restartflag;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "Close") {
			this.dispose();
			this.toBack();
		} 
	}
}

