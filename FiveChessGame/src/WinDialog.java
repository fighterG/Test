import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	boolean restartflag = false;
	

	public WinDialog(JFrame jframe, int userFlag) {
		// TODO Auto-generated constructor stub
		super(jframe, (userFlag == 1 ? "ºÚÆå" : "°×Æå") + "ÙøÀ²!!!", true);
		this.setLayout(new FlowLayout());
		JButton yesButton = new JButton("¼ÌÐø");
		JButton noButton = new JButton("È¡Ïû");
		JLabel tipLabel = new JLabel("¹§Ï² " + (userFlag == 1 ? "ºÚÆå" : "°×Æå")
				+ " Æì¿ªµÃÊ¤À²!!!");
		yesButton.addActionListener(this);
		yesButton.setActionCommand("Yes");
		noButton.addActionListener(this);
		noButton.setActionCommand("No");

		this.add(tipLabel);
		this.add(yesButton);
		this.add(noButton);

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocation(400, 350);
		this.setSize(180, 100);
		this.setResizable(false);
		this.setVisible(true);

	}

	public boolean getButtonPrassed() {

		return restartflag;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "Yes") {
			System.out.println("YesPrassDown");
			restartflag = true;
			this.dispose();
			this.toBack();

		} else {
			System.out.println("NoPrassDown");
			restartflag = false;
			this.dispose();
			this.toBack();
		}
	}
}

