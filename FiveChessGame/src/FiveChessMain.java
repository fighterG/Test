


/**
 *     ��������Ϸ.FiveChessGame
 *     ˼·��
 *     1���ð�ť�����ӣ���ͼƬ���ÿ����ť��
 *     2������Ϊ24*24��
 * @see java.awt.event.ActionEvent;
 * @see java.awt.event.ActionListener;
 * @see java.awt.*;
 * @see javax.swing.*;
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

/**
 * ������FiveChessGame�࣬�̳���JFrame�����������ʱ�����
 * 
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 */
public class FiveChessMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * ���������̵ĳ���:chessLineCount
	 * 
	 * @serial
	 */
	static int chessLineCount = 20;

	/**
	 * �����������chess����JButton��ʾ
	 * 
	 * @serial
	 */
	private JButton chess[][] = new JButton[chessLineCount][chessLineCount];

	/**
	 * ������������chess��Ӧ�����ӱ�ʶ�����ڱ�����ӵ�״̬�� 1��ʾ����,-1��ʾ����,Ĭ��0��ʾ������
	 * 
	 * @serial
	 * @see #chess
	 */
	int chessInt[][] = new int[chessLineCount][chessLineCount];

	/**
	 * �û���ʶ 1��ʾ����,-1��ʾ����,10��ʾ����
	 */
	int userFlag = 1;

	/**
	 * true��ʾ�ˣ�false��ʾ����
	 */
	boolean userType = true;// ture Man false PC

	/**
	 * ���ӵ�ͼƬ�����λ��direction
	 * 
	 * @serial
	 */
	// home/tarena/You.me/HomeWork/Others/bin/FiveChessGame/FiveChessIcons
	String direction = "./FiveChess/FiveChessGame/FiveChessIcons/";

	/**
	 * ��ʼ״̬�����ӵ�ͼƬ:beginIcon
	 * 
	 * @serial
	 * @see javax.swing.ImageIcon
	 */
	ImageIcon beginIcon = new ImageIcon(direction + "qz.jpg");

	/**
	 * �����ͼƬ��whiteIcon
	 * 
	 * @serial
	 * @see javax.swing.ImageIcon
	 */
	ImageIcon whiteIcon = new ImageIcon(direction + "bz.jpg");

	/**
	 * �����ͼƬ��blackIcon
	 * 
	 * @see javax.swing.ImageIcon
	 */
	ImageIcon blackIcon = new ImageIcon(direction + "hz.jpg");

	/**
	 * ���ڱ�ʶ�ǰ��廹�Ǻ�����ҡ�1��������壬-1���������
	 * 
	 * @serial
	 */
	ImageIcon rightIcon = new ImageIcon(direction + "right.jpg");

	ImageIcon rightWhiteIcon = new ImageIcon(direction + "rightWhite.jpg");

	ImageIcon rightBlackIcon = new ImageIcon(direction + "rightBlack.jpg");

	ImageIcon leftIcon = new ImageIcon(direction + "left.jpg");

	ImageIcon leftBlackIcon = new ImageIcon(direction + "leftBlack.jpg");

	ImageIcon leftWhiteIcon = new ImageIcon(direction + "leftWhite.jpg");

	ImageIcon upIcon = new ImageIcon(direction + "up.jpg");

	ImageIcon upBlackIcon = new ImageIcon(direction + "upBlack.jpg");

	ImageIcon upWhiteIcon = new ImageIcon(direction + "upWhite.jpg");

	ImageIcon downIcon = new ImageIcon(direction + "down.jpg");

	ImageIcon downBlackIcon = new ImageIcon(direction + "downBlack.jpg");

	ImageIcon downWhiteIcon = new ImageIcon(direction + "downWhite.jpg");

	ImageIcon upRightIcon = new ImageIcon(direction + "upRight.jpg");

	ImageIcon upRightBlackIcon = new ImageIcon(direction + "upRightBlack.jpg");

	ImageIcon upRightWhiteIcon = new ImageIcon(direction + "upRightWhite.jpg");

	ImageIcon upLeftIcon = new ImageIcon(direction + "upLeft.jpg");

	ImageIcon upLeftBlackIcon = new ImageIcon(direction + "upLeftBlack.jpg");

	ImageIcon upLeftWhiteIcon = new ImageIcon(direction + "upLeftWhite.jpg");

	ImageIcon downRightIcon = new ImageIcon(direction + "downRight.jpg");

	ImageIcon downRightBlackIcon = new ImageIcon(direction
			+ "downRightBlack.jpg");

	ImageIcon downRightWhiteIcon = new ImageIcon(direction
			+ "downRightWhite.jpg");

	ImageIcon downLeftIcon = new ImageIcon(direction + "downLeft.jpg");

	ImageIcon downLeftBlackIcon = new ImageIcon(direction + "downLeftBlack.jpg");

	ImageIcon downLeftWhiteIcon = new ImageIcon(direction + "downLeftWhite.jpg");

	/**
	 * ���ڴ�����ӵ�JPanel:chessPanel
	 * 
	 * @see javax.swing.JPanel
	 */
	JPanel chessPanel = new JPanel();

	/**
	 * FiveChessGame��Ĺ��췽������Ҫ����JFrame��������ԡ�
	 * 
	 * @see javax.swing.JFrame
	 * @see #initChess
	 * @see #initChessInt
	 * @see #addChessIntoPanel
	 */
	public FiveChessMain() {
		setMenu();
		/* ���ó�ʼ�����ӷ���:initChess(JButton[][]) */
		initChess(chess);
		/* ���ó�ʼ������ͼ��ķ���setChessIcon(JButton[][]) */
		setChessIcon(chess);
		/* ���ó�ʼ�����ӱ�ǩ����ķ���:initChessInt(int[][]) */
		chessInt = initChessInt(chessInt);
		/* ������panel��������ӵķ���:addChessIntoPanel(chess,chessPanel) */
		addChessIntoPanel(chess, chessPanel);
		/* ��JFrame����Ӵ�����ӵ�JPanel��chessPanel */
		this.add(chessPanel);
		this.setTitle("������������.0623");
		this.setResizable(false);
		this.setLocation(300, 130);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * ����JFrame�Ĳ˵���:setMenu()
	 * 
	 * @see java.awt.MenuBar
	 * @see java.awt.Menu
	 * @see java.awt.MenuItem
	 */
	public void setMenu() {
		/* ���˵�mainMenuBar */
		JMenuBar mainMenuBar = new JMenuBar();
		String[][] menuStrs = { { "��Ϸ", "��ʼ", "PlayWithPC", "", "�˳�" },
				{ "����", "����" }, };
		String[][] menuCommands = {
				{ "��Ϸ", "Begin", "PlayWithPC", "", "Exit" }, { "����", "About" } };

		for (int i = 0; i < menuStrs.length; i++) {
			JMenu menu = new JMenu(menuStrs[i][0]);
			mainMenuBar.add(menu);
			for (int j = 1; j < menuStrs[i].length; j++) {
				if ("".equals(menuStrs[i][j]))
					menu.addSeparator();
				else {
					JMenuItem menuItem = new JMenuItem(menuStrs[i][j]);
					menuItem.addActionListener(this);
					menuItem.setActionCommand(menuCommands[i][j]);
					menu.add(menuItem);
				}
			}
		}
		this.setJMenuBar(mainMenuBar);
	}

	/**
	 * ���̳�ʼ������initChess(JButton[][] chess),�������ӵ�������ԣ�ͼ�ꡢ��С���¼��ȡ�
	 * 
	 * @see javax.swing.JButton
	 * @param chess
	 *            ��������JButton[][]�����ڱ�������
	 */
	public void initChess(JButton[][] chess) {

		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {
				chess[i][j] = new JButton();
				chess[i][j].setBounds(0, 0, 0, 0);
				chess[i][j].setBorderPainted(false);
				chess[i][j].setPreferredSize(new java.awt.Dimension(32, 32));
				chess[i][j].addActionListener(this);
			}
		}
	}

	/**
	 * �������̵ĳ�ʼ���ӵ�ͼ��setChessIcon
	 */
	public void setChessIcon(JButton[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {
				if (i == 4 && j == 4)
					chess[i][j].setIcon(upLeftIcon);
				else if (i == 4 && j == chess[i].length - 4 - 1)
					chess[i][j].setIcon(upRightIcon);
				else if (i == chess.length - 4 - 1 && j == 4)
					chess[i][j].setIcon(downLeftIcon);
				else if (i == chess.length - 4 - 1
						&& j == chess[i].length - 4 - 1)
					chess[i][j].setIcon(downRightIcon);
				else if (i == 4)
					chess[i][j].setIcon(upIcon);
				else if (j == 4)
					chess[i][j].setIcon(leftIcon);
				else if (j == chess[i].length - 4 - 1)
					chess[i][j].setIcon(rightIcon);
				else if (i == chess.length - 4 - 1)
					chess[i][j].setIcon(downIcon);
				else
					chess[i][j].setIcon(beginIcon);
			}
		}
	}

	/**
	 * �������ʱ�������ӵ�ͼ��setOnChessIcon
	 * �����жϸ�λ�õ������Ƿ������ӣ���������ɫ��������ͼ��
	 */
	public void setOnChessIcon(int i, int j, int userFlag) {
		if (i == 4 && j == 4)
			chess[i][j].setIcon(userFlag == 1 ? upLeftBlackIcon
					: upLeftWhiteIcon);
		else if (i == 4 && j == chess[i].length - 4 - 1)
			chess[i][j].setIcon(userFlag == 1 ? upRightBlackIcon
					: upRightWhiteIcon);
		else if (i == chess.length - 4 - 1 && j == 4)
			chess[i][j].setIcon(userFlag == 1 ? downLeftBlackIcon
					: downLeftWhiteIcon);
		else if (i == chess.length - 4 - 1 && j == chess[i].length - 4 - 1)
			chess[i][j].setIcon(userFlag == 1 ? downRightBlackIcon
					: downRightWhiteIcon);
		else if (i == 4)
			chess[i][j].setIcon(userFlag == 1 ? upBlackIcon : upWhiteIcon);
		else if (j == 4)
			chess[i][j].setIcon(userFlag == 1 ? leftBlackIcon : leftWhiteIcon);
		else if (j == chess[i].length - 4 - 1)
			chess[i][j]
					.setIcon(userFlag == 1 ? rightBlackIcon : rightWhiteIcon);
		else if (i == chess.length - 4 - 1)
			chess[i][j].setIcon(userFlag == 1 ? downBlackIcon : downWhiteIcon);
		else
			chess[i][j].setIcon(userFlag == 1 ? blackIcon : whiteIcon);
	}

	/**
	 * �������ӵķ���showChess�����ڽ�chessInt�������ݴ�ӡ������̨���Ա�ۿ���
	 * 
	 * @see #chessInt
	 * @param chessInt
	 *            ���ӱ�ǩ����int[][] �����ڱ�������״̬
	 */
	public static void showChess(int[][] chessInt) {
		for (int i = 0; i < chessInt.length; i++) {
			for (int j = 0; j < chessInt[i].length; j++)
				System.out.print("   " + chessInt[i][j]);
			System.out.println();
		}
	}

	/**
	 * �����ӷ���panel��addChessIntoPanel(JButton[][] buttons,JPanel panel)
	 * ��panel����Ϊ���񲼾֣�Ȼ���������������JButton:chess
	 * 
	 * @see javax.swing.JButton
	 * @see javax.swing.JPanel
	 * @see java.awt.GridLayout
	 * @param buttons
	 *            ��������JButton[][]��������ӵ�panel��
	 * @param panel
	 *            ���ڴ�����ӵ�JPanel
	 */
	public static void addChessIntoPanel(JButton[][] buttons, JPanel panel) {
		panel.setLayout(new GridLayout(chessLineCount-8, chessLineCount-8));
		int numbers = 0;
		for (int i = 4; i < buttons.length - 4; i++) {
			for (int j = 4; j < buttons[i].length - 4; j++) {
				buttons[i][j].setActionCommand("" + (numbers++));
				panel.add(buttons[i][j]);
			}
		}
		panel.setPreferredSize(new java.awt.Dimension(32*(chessLineCount-8),32*(chessLineCount-8)));
	}

	/**
	 * ���ӱ�ǩ����chessInt�ĳ�ʼ��initChessInt(int[][] array) ������Ԫ�ظ�ֵΪ0
	 * 
	 * @param array
	 *            ���ڱ�ʾchessInt
	 */
	public static int[][] initChessInt(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = 0;
			}
		}
		return array;
	}

	/**
	 * ��Ӧ��ť���¼�actionPerformed(ActionEvent e)
	 * ���ݵ���İ�ť����ȡ��ActionCommand��Ȼ���ҵ���Ӧ������chess[x][y]����������Ӧ����Ӧ�¼���
	 * �ж������Ƿ����ˣ���������Ӧ�Ĳ��������˵���getWinDialog()������ʾ��
	 * 
	 * @see java.awt.event.ActionEvent
	 * @see java.awt.event.ActionListener
	 * @see #getWinDialog
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("Begin")) {
			userType = true;
			userFlag = 1;
			beginGame();
		} else if (e.getActionCommand().equals("PlayWithPC")) {
			userType = false;
			beginGame();
			userFlag = 1;
		} else if (e.getActionCommand().equals("About")) {
			new AboutDialog(this);
		} else {
			while (true) {
				int commandNumber = 0;
				int x = 0;
				int y = 0;
				if (userFlag == 1 || userFlag == -1) {
					commandNumber = Integer.parseInt(e.getActionCommand());
					x = commandNumber /(chessLineCount-8) + 4;
					y = commandNumber % (chessLineCount-8) + 4;
				} else {
					/* �˻���սʱ���û�ȡ��������ɵ�����λ�á� */
					Point p = this.getComputerPoint();
					x = p.x;
					y = p.y;
				}
				Point tp = new Point(x, y);
				putOnChess(tp);
				if (userType) {
					userFlag *= -1;
					break;
				} else {
					if (userFlag == 1) {
						userFlag = 10;
						continue;
					}
					else
						userFlag = 1;
					break;
				}
			}
		}
	}

	/**
	 * getWinDialog()������ ����WinDialog���ʵ�������������������ļ�����ȡ��������
	 * 
	 * @see WinDialog
	 */
	public void getWinDialog() {
		WinDialog win = new WinDialog(this, userFlag);
		if (win.getButtonPrassed()) {
			beginGame();
		} else {
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess[i].length; j++)
					chess[i][j].removeActionListener(this);
			}
		}

	}

	/**
	 * ���¿�ʼ��ϷbeginGame()
	 */
	public void beginGame() {
		for (int i = 0; i < chessInt.length; i++) {
			for (int j = 0; j < chessInt[i].length; j++) {
				chessInt[i][j] = 0;
			}
		}
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++)
				chess[i][j].removeActionListener(this);
		}
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {
				// chess[i][j].setIcon(beginIcon);
				chess[i][j].addActionListener(this);
			}
		}
		setChessIcon(chess);
	}

	/**���巽��������λ�÷������Ӻ��ܳ��������ô�жϸ÷�Ӯ����*/
	public void putOnChess(Point p) {
		int x = p.x;
		int y = p.y;
		int temp = 0;
		chessInt[x][y] = userFlag;
		setOnChessIcon(x, y, userFlag);
		chess[x][y].removeActionListener(this);
		/* �ж�����ģ�y���� */
		for (int i = x - 4; i < x + 1; i++) {
			temp = chessInt[i][y] + chessInt[i + 1][y] + chessInt[i + 2][y]
					+ chessInt[i + 3][y] + chessInt[i + 4][y];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
		/* �жϺ���ģ�x���� */
		for (int i = y - 4; i < y + 1; i++) {
			temp = chessInt[x][i] + chessInt[x][i + 1] + chessInt[x][i + 2]
					+ chessInt[x][i + 3] + chessInt[x][i + 4];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
		/* �ж�б�µģ�x��yͬ�Ӽ� */
		for (int i = -4; i < 1; i++) {
			temp = chessInt[x + i][y + i] + chessInt[x + i + 1][y + i + 1]
					+ chessInt[x + i + 2][y + i + 2]
					+ chessInt[x + i + 3][y + i + 3]
					+ chessInt[x + i + 4][y + i + 4];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
		/* �ж�б�ϵģ�x�ӣ�y�� */
		for (int i = -4; i < 1; i++) {
			temp = chessInt[x + i][y - i] + chessInt[x + i + 1][y - i - 1]
					+ chessInt[x + i + 2][y - i - 2]
					+ chessInt[x + i + 3][y - i - 3]
					+ chessInt[x + i + 4][y - i - 4];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
	}

	/**
	 * �˻���սʱ�������ӵ�λ�á�
	 * ˼·��ͨ��ѭ���жϿհ�λ�õ��ĸ�����İ���ͺ������������Ե����ȡ�
	 */
	public Point getComputerPoint() {
		List<Point> blankChess = new ArrayList<Point>();
		for (int i = 4; i < chessInt.length - 4; i++) {
			for (int j = 4; j < chessInt[i].length - 4; j++) {
				if (chessInt[i][j] == 0) {
					blankChess.add(new Point(i, j));
				}
			}
		}
		/**/
		List<Set<Point>> compChessList = new ArrayList<Set<Point>>();
		for (int k = 0; k < 7; k++) {
			Set<Point> hs = new HashSet<Point>();
			compChessList.add(hs);
		}

		List<Set<Point>> peopChessList = new ArrayList<Set<Point>>();
		for (int k = 0; k < 7; k++) {
			Set<Point> hs = new HashSet<Point>();
			peopChessList.add(hs);
		}
		out: for (Point tp : blankChess) {
			int x = tp.x;
			int y = tp.y;
			int temp = 0;
			int[][] xs = { { x - 4, x + 1 }, { y - 4, y + 1 }, { -4, 1 },
					{ -4, 1 } };
			for (int post = 0; post < 4; post++) {
				for (int i = xs[post][0]; i < xs[post][1]; i++) {
					if (post == 0)
						temp = chessInt[i][y] + chessInt[i + 1][y]
								+ chessInt[i + 2][y] + chessInt[i + 3][y]
								+ chessInt[i + 4][y];
					else if (post == 1)
						temp = chessInt[x][i] + chessInt[x][i + 1]
								+ chessInt[x][i + 2] + chessInt[x][i + 3]
								+ chessInt[x][i + 4];
					else if (post == 2)
						temp = chessInt[x + i][y + i]
								+ chessInt[x + i + 1][y + i + 1]
								+ chessInt[x + i + 2][y + i + 2]
								+ chessInt[x + i + 3][y + i + 3]
								+ chessInt[x + i + 4][y + i + 4];
					else if (post == 3)
						temp = chessInt[x + i][y - i]
								+ chessInt[x + i + 1][y - i - 1]
								+ chessInt[x + i + 2][y - i - 2]
								+ chessInt[x + i + 3][y - i - 3]
								+ chessInt[x + i + 4][y - i - 4];
					if (temp == 40) {
						compChessList.get(0).add(new Point(x, y));
						break out;
					} else if (temp == 4) {
						peopChessList.get(0).add(new Point(x, y));
					} else if (temp >= 30 || temp == 3) {
						boolean compFlag = true;
						if (temp == 3)
							compFlag = false;
						int temp3 = 0;
						int t = 0;
						for (t = xs[post][0] + 1; t < xs[post][1]; t++) {
							if (post == 0)
								temp3 = chessInt[t][y] + chessInt[t + 1][y]
										+ chessInt[t + 2][y]
										+ chessInt[t + 3][y];
							else if (post == 1)
								temp3 = chessInt[x][t] + chessInt[x][t + 1]
										+ chessInt[x][t + 2]
										+ chessInt[x][t + 3];
							else if (post == 2)
								temp3 = chessInt[x + t][y + t]
										+ chessInt[x + t + 1][y + t + 1]
										+ chessInt[x + t + 2][y + t + 2]
										+ chessInt[x + t + 3][y + t + 3];
							else if (post == 3)
								temp3 = chessInt[x + t][y - t]
										+ chessInt[x + t + 1][y - t - 1]
										+ chessInt[x + t + 2][y - t - 2]
										+ chessInt[x + t + 3][y - t - 3];

							if (compFlag) {
								if (temp3 >= 30) {
									compChessList.get(1).add(new Point(x, y));
									break;
								}
							} else {
								if (temp3 == 3) {
									peopChessList.get(1).add(new Point(x, y));
									break;
								}
							}
						}
						if (t == xs[post][1] - 1) {
							if (compFlag)
								compChessList.get(2).add(new Point(x, y));
							else
								peopChessList.get(2).add(new Point(x, y));
						}
					} else if (temp >= 20 || temp == 2) {
						boolean compFlag = true;
						if (temp == 2)
							compFlag = false;
						int temp2 = 0;
						int t = 0;
						for (t = xs[post][0] + 2; t < xs[post][1]; t++) {
							if (post == 0)
								temp2 = chessInt[t][y] + chessInt[t + 1][y]
										+ chessInt[t + 2][y];
							else if (post == 1)
								temp2 = chessInt[x][t] + chessInt[x][t + 1]
										+ chessInt[x][t + 2];
							else if (post == 2)
								temp2 = chessInt[x + t][y + t]
										+ chessInt[x + t + 1][y + t + 1]
										+ chessInt[x + t + 2][y + t + 2];
							else if (post == 3)
								temp2 = chessInt[x + t][y - t]
										+ chessInt[x + t + 1][y - t - 1]
										+ chessInt[x + t + 2][y - t - 2];
							if (compFlag) {
								if (temp2 >= 20) {
									compChessList.get(3).add(new Point(x, y));
									break;
								}
							} else {
								if (temp2 == 2) {
									peopChessList.get(3).add(new Point(x, y));
									break;
								}
							}
						}
						if (t == xs[post][1] - 1) {
							if (compFlag)
								compChessList.get(4).add(new Point(x, y));
							else
								peopChessList.get(4).add(new Point(x, y));
						}
					} else if (temp >= 10 || temp == 1) {
						boolean compFlag = true;
						if (temp == 1)
							compFlag = false;
						int temp1 = 0;
						int t = 0;

						for (t = xs[post][0] + 3; t < xs[post][1]; t++) {
							if (post == 0)
								temp1 = chessInt[t][y] + chessInt[t + 1][y];
							else if (post == 1)
								temp1 = chessInt[x][t] + chessInt[x][t + 1];
							else if (post == 2)
								temp1 = chessInt[x + t][y + t]
										+ chessInt[x + t + 1][y + t + 1];
							else if (post == 3)
								temp1 = chessInt[x + t][y - t]
										+ chessInt[x + t + 1][y - t - 1];
							if (compFlag) {
								if (temp1 >= 10) {
									compChessList.get(5).add(new Point(x, y));
									break;
								}
							} else {
								if (temp1 == 1) {
									peopChessList.get(5).add(new Point(x, y));
									break;
								}
							}
						}
						if (t == xs[post][1] - 1)
							if (compFlag)
								compChessList.get(6).add(new Point(x, y));
							else
								peopChessList.get(6).add(new Point(x, y));
					}
				}
			}
		}

		List<Set<Point>> chessLists = new ArrayList<Set<Point>>();

		for (int i = 0; i < 7; i++) {
			chessLists.add(compChessList.get(i));
			chessLists.add(peopChessList.get(i));
		}

		for (int ti = 0; ti < chessLists.size(); ti++) {
			if (chessLists.get(ti).size() != 0) {
				for (Point tps : chessLists.get(ti)) {
					return tps;
				}
			}
		}
		return new Point(chessInt.length / 2, chessInt.length / 2);
	}

	public static void main(String[] args) {
		new FiveChessMain();
	}

}
