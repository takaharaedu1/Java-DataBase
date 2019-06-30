package jp.ne.tin.calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EntryPoint extends JFrame {

	/** バージョン表記 */
	private static final long serialVersionUID = 1L;

	// =============== Fields =====================

	private JPanel contentPane;
	private JTextField textField;
	private JButton button_0;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_AC;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;

	// aは最初のに入力した数
	// bは次に入力した数
	// 明示的に修飾詞(private)を付加しましょう。
	private int a, b, c, x; // これはリテラル
	private String d; // Java特有ですが文字列はリテラルではなくクラス（特殊クラス）です。

	// private final JButton btnNewButton_2 = new JButton("New button");
	// 未使用なのでコメントアウトしました。

	
	// ================== Constructs =====================

	/**
	 * コンストラクタ
	 */
	public EntryPoint() {

		setTitle("culculation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 6, 7));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][]", "[][][][][][]"));

		textField = new JTextField();
		contentPane.add(textField, "cell 0 0 3 1,width :500:");
		textField.setColumns(40);

		// ボタンの配置及び入力設定
		createButtons();
	}


	// ================== Methods ================================
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					EntryPoint frame = new EntryPoint();
					frame.setVisible(true);

				} catch (Exception e) {

					// このTry-Catchこそが次回に習得する例外処理です。
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ボタンを作成し配置します。
	 * 
	 * 共通化するための関数化ではありませんが役割を独立させるためにメソッド化する方法もあります。
	 */
	private void createButtons() {
		
		button_0 = new JButton("0");
		contentPane.add(button_0, "cell 0 4");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0" + textField.getText());
			}
		});

		button_1 = new JButton("1");
		contentPane.add(button_1, "cell 0 3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("1" + textField.getText());
			}
		});

		button_2 = new JButton("2");
		contentPane.add(button_2, "cell 1 3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("2" + textField.getText());
			}
		});

		button_3 = new JButton("3");
		contentPane.add(button_3, "cell 2 3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("3" + textField.getText());
			}
		});

		button_4 = new JButton("4");
		contentPane.add(button_4, "cell 0 2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("4" + textField.getText());
			}
		});

		button_5 = new JButton("5");
		contentPane.add(button_5, "cell 1 2");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("5" + textField.getText());
			}
		});

		button_6 = new JButton("6");
		contentPane.add(button_6, "cell 2 2");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("6" + textField.getText());
			}
		});

		button_7 = new JButton("7");
		contentPane.add(button_7, "cell 0 1");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("7" + textField.getText());
			}
		});

		button_8 = new JButton("8");
		contentPane.add(button_8, "cell 1 1,width :30:");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("8" + textField.getText());
			}
		});

		button_9 = new JButton("9");
		contentPane.add(button_9, "cell 2 1,width :30:");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("9" + textField.getText());
			}
		});

		button_10 = new JButton("-");
		contentPane.add(button_10, "cell 3 3");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 入力した値をint型に変換後aに代入
				a = Integer.parseInt(textField.getText());
				// のちのswitch使用時に利用
				x = 1;
				// textField内をなにも書かれていない状態にする
				textField.setText("");
			}
		});

		button_11 = new JButton("+");
		contentPane.add(button_11, "cell 3 4");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					a = Integer.parseInt(textField.getText());
					x = 2;
					textField.setText("");
				} catch (Exception e2) {
					
					e2.printStackTrace();
					textField.setText("not integer.");
				}
				
			}
		});

		button_12 = new JButton("*");
		contentPane.add(button_12, "cell 3 1");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(textField.getText());
				x = 3;
				textField.setText("");
			}
		});

		button_13 = new JButton("/");
		contentPane.add(button_13, "cell 3 2");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(textField.getText());
				x = 4;
				textField.setText("");

			}
		});

		button_14 = new JButton("=");
		contentPane.add(button_14, "cell 3 5");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 次に入力した値をint型に変換後bに代入
				b = Integer.parseInt(textField.getText());
				// 先ほど決めたxの値をもとに計算方法を決める
				switch (x) {
				case 1:
					c = a - b;
					break;
				case 2:
					c = a + b;
					break;
				case 3:
					c = a * b;
					break;
				case 4:
					c = a / b;
					break;
				}
				// 計算結果をString型に戻す
				d = String.valueOf(c);
				textField.setText(d);
			}
		});

		button_AC = new JButton("AC");
		contentPane.add(button_AC, "cell 3 0");
		button_AC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 値が全てリセットされるようになる
				a = 0;
				b = 0;
				textField.setText("");
			}
		});
	}
	
}
