


/**
 *     五子棋游戏.FiveChessGame
 *     思路：
 *     1。用按钮做棋子，用图片填充每个按钮。
 *     2。棋盘为24*24的
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
 * 五子棋FiveChessGame类，继承了JFrame，并且添加了时间监听
 * 
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 */
public class FiveChessMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * 五子棋棋盘的长宽:chessLineCount
	 * 
	 * @serial
	 */
	static int chessLineCount = 20;

	/**
	 * 五子棋的棋子chess，用JButton表示
	 * 
	 * @serial
	 */
	private JButton chess[][] = new JButton[chessLineCount][chessLineCount];

	/**
	 * 和五子棋棋子chess对应的棋子标识，用于标记棋子的状态。 1表示黑棋,-1表示白棋,默认0表示无棋子
	 * 
	 * @serial
	 * @see #chess
	 */
	int chessInt[][] = new int[chessLineCount][chessLineCount];

	/**
	 * 用户标识 1表示黑棋,-1表示白棋,10表示电脑
	 */
	int userFlag = 1;

	/**
	 * true表示人，false表示电脑
	 */
	boolean userType = true;// ture Man false PC

	/**
	 * 棋子的图片保存的位置direction
	 * 
	 * @serial
	 */
	// home/tarena/You.me/HomeWork/Others/bin/FiveChessGame/FiveChessIcons
	String direction = "./FiveChess/FiveChessGame/FiveChessIcons/";

	/**
	 * 初始状态下棋子的图片:beginIcon
	 * 
	 * @serial
	 * @see javax.swing.ImageIcon
	 */
	ImageIcon beginIcon = new ImageIcon(direction + "qz.jpg");

	/**
	 * 白棋的图片：whiteIcon
	 * 
	 * @serial
	 * @see javax.swing.ImageIcon
	 */
	ImageIcon whiteIcon = new ImageIcon(direction + "bz.jpg");

	/**
	 * 黑棋的图片：blackIcon
	 * 
	 * @see javax.swing.ImageIcon
	 */
	ImageIcon blackIcon = new ImageIcon(direction + "hz.jpg");

	/**
	 * 用于标识是白棋还是黑棋玩家。1：代表黑棋，-1：代表白棋
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
	 * 用于存放棋子的JPanel:chessPanel
	 * 
	 * @see javax.swing.JPanel
	 */
	JPanel chessPanel = new JPanel();

	/**
	 * FiveChessGame类的构造方法。主要设置JFrame的相关属性。
	 * 
	 * @see javax.swing.JFrame
	 * @see #initChess
	 * @see #initChessInt
	 * @see #addChessIntoPanel
	 */
	public FiveChessMain() {
		setMenu();
		/* 调用初始化棋子方法:initChess(JButton[][]) */
		initChess(chess);
		/* 调用初始化棋子图标的方法setChessIcon(JButton[][]) */
		setChessIcon(chess);
		/* 调用初始化棋子标签数组的方法:initChessInt(int[][]) */
		chessInt = initChessInt(chessInt);
		/* 调用向panel中添加棋子的方法:addChessIntoPanel(chess,chessPanel) */
		addChessIntoPanel(chess, chessPanel);
		/* 向JFrame中添加存放棋子的JPanel：chessPanel */
		this.add(chessPanel);
		this.setTitle("单机版五子棋.0623");
		this.setResizable(false);
		this.setLocation(300, 130);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * 设置JFrame的菜单栏:setMenu()
	 * 
	 * @see java.awt.MenuBar
	 * @see java.awt.Menu
	 * @see java.awt.MenuItem
	 */
	public void setMenu() {
		/* 主菜单mainMenuBar */
		JMenuBar mainMenuBar = new JMenuBar();
		String[][] menuStrs = { { "游戏", "开始", "PlayWithPC", "", "退出" },
				{ "帮助", "关于" }, };
		String[][] menuCommands = {
				{ "游戏", "Begin", "PlayWithPC", "", "Exit" }, { "帮助", "About" } };

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
	 * 棋盘初始化方法initChess(JButton[][] chess),设置棋子的相关属性，图标、大小、事件等。
	 * 
	 * @see javax.swing.JButton
	 * @param chess
	 *            棋子数组JButton[][]，用于保存棋子
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
	 * 设置棋盘的初始棋子的图标setChessIcon
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
	 * 点击棋子时设置棋子的图标setOnChessIcon
	 * 根据判断该位置的棋子是否有棋子，和棋子颜色设置棋子图标
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
	 * 测试棋子的方法showChess。用于将chessInt数组内容打印到控制台，以便观看。
	 * 
	 * @see #chessInt
	 * @param chessInt
	 *            棋子标签数组int[][] ，用于保存棋子状态
	 */
	public static void showChess(int[][] chessInt) {
		for (int i = 0; i < chessInt.length; i++) {
			for (int j = 0; j < chessInt[i].length; j++)
				System.out.print("   " + chessInt[i][j]);
			System.out.println();
		}
	}

	/**
	 * 将棋子放入panel中addChessIntoPanel(JButton[][] buttons,JPanel panel)
	 * 把panel设置为网格布局，然后向里面添加棋子JButton:chess
	 * 
	 * @see javax.swing.JButton
	 * @see javax.swing.JPanel
	 * @see java.awt.GridLayout
	 * @param buttons
	 *            棋子数组JButton[][]，用于添加到panel中
	 * @param panel
	 *            用于存放棋子的JPanel
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
	 * 棋子标签数组chessInt的初始化initChessInt(int[][] array) 将所有元素赋值为0
	 * 
	 * @param array
	 *            用于表示chessInt
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
	 * 响应按钮的事件actionPerformed(ActionEvent e)
	 * 根据点击的按钮，获取其ActionCommand，然后找到对应的棋子chess[x][y]，并作出相应的响应事件。
	 * 判断棋子是否嬴了，并给出相应的操作。嬴了调用getWinDialog()弹出提示栏
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
					/* 人机对战时调用获取计算机生成的棋子位置。 */
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
	 * getWinDialog()方法。 调用WinDialog类的实例变量，完成玩家嬴棋后的继续或取消操作。
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
	 * 重新开始游戏beginGame()
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

	/**下棋方法。当该位置放下棋子后能成五个，那么判断该方赢啦。*/
	public void putOnChess(Point p) {
		int x = p.x;
		int y = p.y;
		int temp = 0;
		chessInt[x][y] = userFlag;
		setOnChessIcon(x, y, userFlag);
		chess[x][y].removeActionListener(this);
		/* 判断纵向的，y不变 */
		for (int i = x - 4; i < x + 1; i++) {
			temp = chessInt[i][y] + chessInt[i + 1][y] + chessInt[i + 2][y]
					+ chessInt[i + 3][y] + chessInt[i + 4][y];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
		/* 判断横向的，x不变 */
		for (int i = y - 4; i < y + 1; i++) {
			temp = chessInt[x][i] + chessInt[x][i + 1] + chessInt[x][i + 2]
					+ chessInt[x][i + 3] + chessInt[x][i + 4];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
		/* 判断斜下的，x和y同加减 */
		for (int i = -4; i < 1; i++) {
			temp = chessInt[x + i][y + i] + chessInt[x + i + 1][y + i + 1]
					+ chessInt[x + i + 2][y + i + 2]
					+ chessInt[x + i + 3][y + i + 3]
					+ chessInt[x + i + 4][y + i + 4];
			if (temp == userFlag * 5) {
				getWinDialog();
			}
		}
		/* 判断斜上的，x加，y减 */
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
	 * 人机对战时生成棋子的位置。
	 * 思路：通过循环判断空白位置的四个方向的白棋和黑棋数量。电脑的优先。
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
