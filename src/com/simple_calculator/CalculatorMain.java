package com.simple_calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CalculatorMain extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputField;
	private JButton button3;
	private JButton button4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorMain frame = new CalculatorMain();
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
	public CalculatorMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputField = new JTextField();
		inputField.setEditable(false);
		inputField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		inputField.setBounds(28, 57, 254, 40);
		inputField.addKeyListener(this);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		JButton clearButton = new JButton("C");
		clearButton.setFont(new Font("Arial Black", Font.PLAIN, 10));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.clear(inputField.getText()));
				inputField.requestFocusInWindow(); //sends focus back to input field
			}
		});
		clearButton.setBounds(292, 59, 40, 40);
		contentPane.add(clearButton);
		
		
		JButton button1 = new JButton("1");
		button1.setFont(new Font("Arial Black", Font.BOLD, 20));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"1");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button1.setBounds(28, 118, 50, 50);
		contentPane.add(button1);
		
		JButton button2 = new JButton("2");
		button2.setFont(new Font("Arial Black", Font.BOLD, 20));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"2");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button2.setBounds(92, 118, 50, 50);
		contentPane.add(button2);
		
		button3 = new JButton("3");
		button3.setFont(new Font("Arial Black", Font.BOLD, 20));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"3");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button3.setBounds(159, 118, 50, 50);
		contentPane.add(button3);
		
		
		button4 = new JButton("4");
		button4.setFont(new Font("Arial Black", Font.BOLD, 20));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"4");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button4.setBounds(28, 185, 50, 50);
		contentPane.add(button4);
		
		JButton button5 = new JButton("5");
		button5.setFont(new Font("Arial Black", Font.BOLD, 20));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"5");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button5.setBounds(92, 185, 50, 50);
		contentPane.add(button5);
		
		JButton button6 = new JButton("6");
		button6.setFont(new Font("Arial Black", Font.BOLD, 20));
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"6");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button6.setBounds(159, 185, 50, 50);
		contentPane.add(button6);
		
		JButton button7 = new JButton("7");
		button7.setFont(new Font("Arial Black", Font.BOLD, 20));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"7");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button7.setBounds(28, 244, 50, 50);
		contentPane.add(button7);
		
		JButton button8 = new JButton("8");
		button8.setFont(new Font("Arial Black", Font.BOLD, 20));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"8");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button8.setBounds(92, 244, 50, 50);
		contentPane.add(button8);
		
		JButton button9 = new JButton("9");
		button9.setFont(new Font("Arial Black", Font.BOLD, 20));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"9");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button9.setBounds(159, 244, 50, 50);
		contentPane.add(button9);
		
		JButton pointButton = new JButton(".");
		pointButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		pointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.addDot(inputField.getText()));
				inputField.requestFocusInWindow();
			}
		});
		pointButton.setBounds(28, 304, 50, 50);
		contentPane.add(pointButton);
		
		
		JButton button0 = new JButton("0");
		button0.setFont(new Font("Arial Black", Font.BOLD, 20));
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(inputField.getText()+"0");
				Operations.setIsOpValid();
				inputField.requestFocusInWindow();
			}
		});
		button0.setBounds(92, 304, 50, 50);
		contentPane.add(button0);
		
		JButton subButton = new JButton("-");
		subButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.addSubSign(inputField.getText()));
				inputField.requestFocusInWindow();
			}
		});
		subButton.setBounds(159, 304, 50, 50);
		contentPane.add(subButton);
		
		

		JButton addButton = new JButton("+");
		addButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.addAddSign(inputField.getText()));
				inputField.requestFocusInWindow();
			}
		});
		addButton.setBounds(232, 120, 50, 50);
		contentPane.add(addButton);
		
		JButton mulButton = new JButton("X");
		mulButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		mulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.addMulSign(inputField.getText()));
				inputField.requestFocusInWindow();
			}
		});
		mulButton.setBounds(232, 185, 50, 50);
		contentPane.add(mulButton);
		
		JButton divButton = new JButton("/");
		divButton.setFont(new Font("Arial Black", Font.BOLD, 25));
		divButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.addDivSign(inputField.getText()));
				inputField.requestFocusInWindow();
			}
		});
		divButton.setBounds(232, 242, 50, 50);
		contentPane.add(divButton);
		
		JButton equalsButton = new JButton("=");
		equalsButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText(Operations.findResult(inputField.getText()));
				inputField.requestFocusInWindow();
			}
		});
		equalsButton.setBounds(232, 304, 50, 50);
		contentPane.add(equalsButton);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case '0':
			inputField.setText(inputField.getText()+"0");
			Operations.setIsOpValid();
			break;
		case '1':
			inputField.setText(inputField.getText()+"1");
			Operations.setIsOpValid();
			break;
		case '2':
			inputField.setText(inputField.getText()+"2");
			Operations.setIsOpValid();
			break;
		case '3':
			inputField.setText(inputField.getText()+"3");
			Operations.setIsOpValid();
			break;
		case '4':
			inputField.setText(inputField.getText()+"4");
			Operations.setIsOpValid();
			break;
		case '5':
			inputField.setText(inputField.getText()+"5");
			Operations.setIsOpValid();
			break;
		case '6':
			inputField.setText(inputField.getText()+"6");
			Operations.setIsOpValid();
			break;
		case '7':
			inputField.setText(inputField.getText()+"7");
			Operations.setIsOpValid();
			break;
		case '8':
			inputField.setText(inputField.getText()+"8");
			Operations.setIsOpValid();
			break;
		case '9':
			inputField.setText(inputField.getText()+"9");
			Operations.setIsOpValid();
			break;
		case '.':
			inputField.setText(Operations.addDot(inputField.getText()));
			break;
		case '-':
			inputField.setText(Operations.addSubSign(inputField.getText()));
			break;
		case '+':
			inputField.setText(Operations.addAddSign(inputField.getText()));
			break;
		case '*':
		case 'x':
		case 'X':
			inputField.setText(Operations.addMulSign(inputField.getText()));
			break;
		case '/':
			inputField.setText(Operations.addDivSign(inputField.getText()));
			break;
		case '=':
		case '\n':
			inputField.setText(Operations.findResult(inputField.getText()));
			break;
		case '\b':
			inputField.setText(Operations.clear(inputField.getText()));
		    break;
		default:
			System.out.println("Entered character is " + e.getKeyChar());
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 127)
			inputField.setText(Operations.clear(inputField.getText()));
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
