import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldL1;
	private JTextField textFieldL2;
	private JTextField textFieldN1;
	private JTextField textFieldN2;
	private JTextField textFieldN3;
	private JTextField textFieldN4;
	private JTextField textFieldN5;
	private JTextField textFieldN6;
	private JButton button;
	private JLabel lblCheck;
	private JTable tableReference;
	private boolean enterPressed;
	private HKIDCheck HKIDChecker;
	
	private void performCheck() {
		if (correctFormat()) {
			//System.out.println("passed check!");
			//System.out.println("HKID: " + getHKID());
			lblCheck.setText(Character.toString(HKIDChecker.check(getHKID())));
			
		}
		else {
			//System.out.println("didn't pass check!");
			JOptionPane.showMessageDialog(this, "格式錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private String getHKID() {
		String HKID;
		
		HKID = textFieldL1.getText() + textFieldL2.getText() + textFieldN1.getText() + textFieldN2.getText() + 
				textFieldN3.getText() + textFieldN4.getText() + textFieldN5.getText() + textFieldN6.getText();
		
		HKID.trim();
		
		return HKID;
		
	}
	
	private boolean correctFormat() {
		boolean letterOk = false;
		
		textFieldL1.setText(textFieldL1.getText().trim());
		textFieldL2.setText(textFieldL2.getText().trim());
		
		try {
			if (textFieldL1.getText().equals(""))
				if (Character.isLetter(textFieldL2.getText().charAt(0)))
					letterOk = true;
				else letterOk = false;
			else if (textFieldL2.getText().equals(""))
				if (Character.isLetter(textFieldL1.getText().charAt(0)))
					letterOk = true;
				else letterOk = false;
			else {
				if (Character.isLetter(textFieldL1.getText().charAt(0)) &&
						Character.isLetter(textFieldL2.getText().charAt(0))
						)
					letterOk = true;
				else letterOk = false;
				
			}
				
			if (letterOk)
				if (
					Character.isDigit(textFieldN1.getText().charAt(0)) &&
					Character.isDigit(textFieldN2.getText().charAt(0)) &&
					Character.isDigit(textFieldN3.getText().charAt(0)) &&
					Character.isDigit(textFieldN4.getText().charAt(0)) &&
					Character.isDigit(textFieldN5.getText().charAt(0)) &&
					Character.isDigit(textFieldN6.getText().charAt(0))
					)
				return true;
				else return false;
			else return false;
		}
		catch (StringIndexOutOfBoundsException e) {
			//System.out.println("E catched");
			return false;
		}
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		HKIDChecker = new HKIDCheck();
		enterPressed = false;
		
		setResizable(false);
		setTitle("\u9999\u6E2F\u8EAB\u4EFD\u8B49\u865F\u78BC\u6AA2\u67E5\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldL1 = new JTextField();
		textFieldL1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("action performed!");
				performCheck();
				enterPressed = true;
			}
		});
		textFieldL1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				//System.out.println("Key Typed, Code: " + arg0.getKeyCode());
				if (!enterPressed) {
					textFieldL2.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
				
			}
		});
		
		
		textFieldL1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldL1.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldL1.setBounds(10, 57, 35, 32);
		contentPane.add(textFieldL1);
		textFieldL1.setColumns(10);
		
		textFieldL2 = new JTextField();
		textFieldL2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
				
			}
		});
		textFieldL2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					textFieldN1.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		textFieldL2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldL2.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldL2.setColumns(10);
		textFieldL2.setBounds(51, 57, 35, 32);
		contentPane.add(textFieldL2);
		
		textFieldN1 = new JTextField();
		textFieldN1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
			}
		});
		textFieldN1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					textFieldN2.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		textFieldN1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN1.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldN1.setColumns(10);
		textFieldN1.setBounds(119, 57, 35, 32);
		contentPane.add(textFieldN1);
		
		textFieldN2 = new JTextField();
		textFieldN2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
			}
		});
		textFieldN2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					textFieldN3.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		textFieldN2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN2.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldN2.setColumns(10);
		textFieldN2.setBounds(156, 57, 35, 32);
		contentPane.add(textFieldN2);
		
		textFieldN3 = new JTextField();
		textFieldN3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
			}
		});
		textFieldN3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					textFieldN4.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		textFieldN3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN3.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldN3.setColumns(10);
		textFieldN3.setBounds(193, 57, 35, 32);
		contentPane.add(textFieldN3);
		
		textFieldN4 = new JTextField();
		textFieldN4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
			}
		});
		textFieldN4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					textFieldN5.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		textFieldN4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN4.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldN4.setColumns(10);
		textFieldN4.setBounds(230, 57, 35, 32);
		contentPane.add(textFieldN4);
		
		textFieldN5 = new JTextField();
		textFieldN5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
			}
		});
		textFieldN5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					textFieldN6.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		textFieldN5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN5.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldN5.setColumns(10);
		textFieldN5.setBounds(267, 57, 35, 32);
		contentPane.add(textFieldN5);
		
		button = new JButton("\u6AA2\u67E5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("press");
				performCheck();
			}
		});
		textFieldN6 = new JTextField();
		textFieldN6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCheck();
				enterPressed = true;
			}
		});
		textFieldN6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!enterPressed) {
					button.requestFocus();
					lblCheck.setText("");
				}
				enterPressed = false;
			}
		});
		
		textFieldN6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN6.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldN6.setColumns(10);
		textFieldN6.setBounds(304, 57, 35, 32);
		contentPane.add(textFieldN6);
		
		
		button.setBounds(356, 126, 87, 28);
		contentPane.add(button);
		
		JLabel labelOpen = new JLabel("(");
		labelOpen.setFont(new Font("新細明體", Font.PLAIN, 18));
		labelOpen.setBounds(389, 57, 21, 32);
		contentPane.add(labelOpen);
		
		JLabel labelClose = new JLabel(")");
		labelClose.setFont(new Font("新細明體", Font.PLAIN, 18));
		labelClose.setBounds(455, 57, 21, 32);
		contentPane.add(labelClose);
		
		lblCheck = new JLabel(""); // label text constructor
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheck.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblCheck.setBounds(405, 58, 41, 28);
		contentPane.add(lblCheck);
		
		JLabel labelID = new JLabel("\u8EAB\u4EFD\u8B49\u865F\u78BC:");
		labelID.setFont(new Font("新細明體", Font.PLAIN, 16));
		labelID.setBounds(10, 21, 106, 23);
		contentPane.add(labelID);
		
		textFieldL1.setDocument(new LimitedLengthDocument(1));
		textFieldL2.setDocument(new LimitedLengthDocument(1));
		textFieldN1.setDocument(new LimitedLengthDocument(1));
		textFieldN2.setDocument(new LimitedLengthDocument(1));
		textFieldN3.setDocument(new LimitedLengthDocument(1));
		textFieldN4.setDocument(new LimitedLengthDocument(1));
		textFieldN5.setDocument(new LimitedLengthDocument(1));
		textFieldN6.setDocument(new LimitedLengthDocument(1));
		getRootPane().setDefaultButton(button);
		
		JLabel label = new JLabel("\u53C3\u8003\u8CC7\u6599:");
		label.setFont(new Font("新細明體", Font.PLAIN, 16));
		label.setBounds(10, 147, 106, 23);
		contentPane.add(label);
		
		tableReference = new JTable();
		tableReference.setRowSelectionAllowed(false);
		tableReference.setEnabled(false);
		tableReference.setModel(new DefaultTableModel(
			new Object[][] {
				{"***", "\u6301\u8B49\u4EBA\u5E74\u9F61\u70BA\u5341\u516B\u6B72\u6216\u4EE5\u4E0A\u53CA\u6709\u8CC7\u683C\u7533\u9818\u56DE\u6E2F\u8B49\u3002"},
				{"*", "\u6301\u8B49\u4EBA\u5E74\u9F61\u70BA\u5341\u4E00\u6B72\u81F3\u5341\u4E03\u6B72\u53CA\u6709\u8CC7\u683C\u7533\u9818\u56DE\u6E2F\u8B49\u3002"},
				{"A", "\u6301\u8B49\u4EBA\u64C1\u6709\u9999\u6E2F\u5C45\u7559\u6B0A\u3002"},
				{"C", "\u6301\u8B49\u4EBA\u767B\u8A18\u9818\u8B49\u6642\u5728\u9999\u6E2F\u7684\u5C45\u7559\u53D7\u5230\u5165\u5883\u4E8B\u52D9\u8655\u8655\u9577\u7684\u9650\u5236\u3002"},
				{"R", "\u6301\u8B49\u4EBA\u64C1\u6709\u9999\u6E2F\u5165\u5883\u6B0A\u3002"},
				{"U", "\u6301\u8B49\u4EBA\u767B\u8A18\u9818\u8B49\u6642\u5728\u9999\u6E2F\u7684\u5C45\u7559\u4E0D\u53D7\u5165\u5883\u4E8B\u52D9\u8655\u8655\u9577\u7684\u9650\u5236\u3002"},
				{"Z", "\u6301\u8B49\u4EBA\u5831\u7A31\u5728\u9999\u6E2F\u51FA\u751F\u3002"},
				{"X", "\u6301\u8B49\u4EBA\u5831\u7A31\u5728\u5167\u5730\u51FA\u751F\u3002"},
				{"W", "\u6301\u8B49\u4EBA\u5831\u7A31\u5728\u6FB3\u9580\u5730\u5340\u51FA\u751F\u3002"},
				{"O", "\u6301\u8B49\u4EBA\u5831\u7A31\u5728\u5176\u4ED6\u570B\u5BB6\u51FA\u751F\u3002"},
				{"B", "\u6301\u8B49\u4EBA\u6240\u5831\u7684\u51FA\u751F\u65E5\u671F\u6216\u5730\u9EDE\u81EA\u9996\u6B21\u767B\u8A18\u4EE5\u5F8C\uFF0C\u66FE\u52A0\u4EE5\u66F4\u6539\u3002"},
				{"N", "\u6301\u8B49\u4EBA\u6240\u5831\u7684\u59D3\u540D\u81EA\u9996\u6B21\u767B\u8A18\u4EE5\u5F8C\uFF0C\u66FE\u52A0\u4EE5\u66F4\u6539\u3002"},
			},
			new String[] {
				"\u7B26\u865F", "\u8A3B\u89E3"
			}
		));
		tableReference.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableReference.getColumnModel().getColumn(1).setPreferredWidth(489);
		tableReference.setFont(new Font("新細明體", Font.PLAIN, 12));
		tableReference.setBounds(10, 180, 530, 226);
		tableReference.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jp = new JScrollPane(tableReference);
		jp.setEnabled(false);
		jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		jp.setSize(530, 219);
		jp.setLocation(10, 180);
		contentPane.add(jp);
		
		JButton buttonClear = new JButton("\u6E05\u9664");
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldL1.setText("");
				textFieldL2.setText("");
				textFieldN1.setText("");
				textFieldN2.setText("");
				textFieldN3.setText("");
				textFieldN4.setText("");
				textFieldN5.setText("");
				textFieldN6.setText("");
				lblCheck.setText("");
			}
		});
		buttonClear.setBounds(453, 126, 87, 28);
		contentPane.add(buttonClear);
		
		
	}
}
