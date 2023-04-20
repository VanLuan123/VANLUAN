package ThucHanh2;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ThucHanh2 {
 
	public ThucHanh2() {
		
	}
    private static double firstNumber=0;
    private static double memory=0;
    private static String operation;
    private static boolean isSecondNumber;
	private static final Logger LOGGER = LogManager.getLogger(ThucHanh2.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Tạo frame
		 	Frame frame = new Frame("Calculator");
		    frame.setSize   ( 400, 600 );
		    frame.setVisible( true );
		    frame.addWindowListener(new WindowColoser());
		    //Tạo panel p để chứa toàn bộ các item
		    Panel p = new Panel();
		    frame.add(p);
		    //Tạo thanh menu
		    MenuBar mb=new MenuBar();  
	        Menu menuView=new Menu("View");
	        Menu menuEdit=new Menu("Edit");  
	        Menu menuHelp=new Menu("Help");
	        mb.add(menuView);
	        mb.add(menuEdit);
	        mb.add(menuHelp);
	        frame.setMenuBar(mb);
	        //Tạo panel p5 chứa textfield và các button, p5 sẽ gồm 2 GridBagConstraint
		    Panel p5= new Panel(new GridBagLayout());
		    //GridBagConstraints gcbTextField dùng để chứa và điều chỉnh vị trí của textfield
		    GridBagConstraints gbcTextField = new GridBagConstraints();
		    gbcTextField.insets = new Insets(5, 5, 5, 5); 
		    TextField textField = new TextField();
		    Font font = new Font("Arial", Font.PLAIN, 30);
		    textField.setFont(font);
		    // Cấu hình thuộc tính đối tượng GridBagConstraints
		    gbcTextField.gridx = 0;
		    gbcTextField.gridy = 0;
		    gbcTextField.gridwidth = 8; // Thiết lập giá trị gridwidth là 4 để xuất hiện TextField trên toàn bộ đường ngang của các nút
		    gbcTextField.ipadx = 270; // Thiết lập giá trị ipadx để phóng to chiều rộng của TextField
		    gbcTextField.ipady = 20;

		    // Thêm TextField vào Panel
		    p5.add(textField, gbcTextField);
		  //GridBagConstraints gcbdùng để chứa và điều chỉnh vị trí của các button
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.insets = new Insets(5, 5, 5, 5); 
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.ipadx = 20; // Thiết lập giá trị ipadx để phóng to chiều rộng của nút
	        gbc.ipady = 20;
	        
	        Button buttonMC = new Button("MC");
	        p5.add(buttonMC, gbc);
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        Button buttonMR = new Button("MR");
	        p5.add(buttonMR, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 2;
	        gbc.gridy = 1;
	        Button buttonMS = new Button("MS");
	        p5.add(buttonMS, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 3;
	        gbc.gridy = 1;
	        Button buttonMAdd = new Button("M+");
	        p5.add(buttonMAdd, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 4;
	        gbc.gridy = 1;
	        Button buttonMSub = new Button("M-");
	        p5.add(buttonMSub, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        Button  buttonBackspace = new Button("<--");
	        p5.add( buttonBackspace, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        Button buttonCE = new Button("CE");
	        p5.add(buttonCE, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 2;
	        gbc.gridy = 2;
	        Button buttonC = new Button("C");
	        p5.add(buttonC, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 3;
	        gbc.gridy = 2;
	        Button buttonNegation = new Button("±");
	        p5.add(buttonNegation, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 4;
	        gbc.gridy = 2;
	        Button buttonSqrt = new Button("√");
	        p5.add(buttonSqrt, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        Button button7 = new Button("7");
	        p5.add(button7, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        Button button8 = new Button("8");
	        p5.add(button8, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 2;
	        gbc.gridy = 3;
	        Button button9 = new Button("9");
	        p5.add(button9, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 3;
	        gbc.gridy = 3;
	        Button buttonDivide = new Button("/");
	        p5.add(buttonDivide, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 4;
	        gbc.gridy = 3;
	        Button buttonPercent = new Button("%");
	        p5.add(buttonPercent, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 4;
	        Button button4 = new Button("4");
	        p5.add(button4, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        Button button5 = new Button("5");
	        p5.add(button5, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 2;
	        gbc.gridy = 4;
	        Button button6 = new Button("6");
	        p5.add(button6, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 3;
	        gbc.gridy = 4;
	        Button buttonMultiply = new Button("6");
	        p5.add(buttonMultiply, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 4;
	        gbc.gridy = 4;
	        Button buttonInverse = new Button("1/x");
	        p5.add(buttonInverse, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 5;
	        Button button1 = new Button("1");
	        p5.add(button1, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 1;
	        gbc.gridy = 5;
	        Button button2 = new Button("2");
	        p5.add(button2, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 2;
	        gbc.gridy = 5;
	        Button button3 = new Button("3");
	        p5.add(button3, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 3;
	        gbc.gridy = 5;
	        Button buttonSub = new Button("-");
	        p5.add(buttonSub, gbc);
	        //tạo button = có chiều cao bằng 2 button khác
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 4;
	        gbc.gridy = 5;
	        gbc.gridheight = 2;
	        gbc.ipady = 72;
	        Button buttonEqual = new Button("=");
	        p5.add(buttonEqual, gbc);
	        //tạo button 0 có chiều ngang bằng 2 button khác
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 6;
	        gbc.gridwidth = 2;
	        gbc.ipady = 20;
	        Button button0 = new Button("0");
	        p5.add(button0, gbc);
	        
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 2;
	        gbc.gridy = 6;
	        gbc.gridwidth = 1;
	        Button buttonAdd = new Button("+");
	        p5.add(buttonAdd, gbc);
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 3;
	        gbc.gridy = 6;
	        Button buttonDot = new Button(".");
	        p5.add(buttonDot, gbc);
	        p.add(p5);
		    frame.pack();
	        frame.setVisible(true);
	        LOGGER.info("Code giao dien" );
	        LOGGER.info("Code sửa lại giao diện: xong");
	        LOGGER.info("Xử lý các nút bấm: 0->9");
	        LOGGER.info("Xử lý các nút bấm khác");
	        //sử lý sự kiện các nút bấm từ 0 đến 9
	        button0.addActionListener(e -> {
	            textField.setText(textField.getText() + "0");
	        });
	        button1.addActionListener(e -> {
	            textField.setText(textField.getText() + "1");
	        });
	        button2.addActionListener(e -> {
	            textField.setText(textField.getText() + "2");
	        });
	        button3.addActionListener(e -> {
	            textField.setText(textField.getText() + "3");
	        });
	        button4.addActionListener(e -> {
	            textField.setText(textField.getText() + "4");
	        });
	        button5.addActionListener(e -> {
	            textField.setText(textField.getText() + "5");
	        });
	        button6.addActionListener(e -> {
	            textField.setText(textField.getText() + "6");
	        });
	        button7.addActionListener(e -> {
	            textField.setText(textField.getText() + "7");
	        });
	        button8.addActionListener(e -> {
	            textField.setText(textField.getText() + "8");
	        });
	        button9.addActionListener(e -> {
	            textField.setText(textField.getText() + "9");
	        });
	        //xử lý sự kiện khi bấm vào nút +
	        buttonAdd.addActionListener(e -> {
	            firstNumber = Double.parseDouble(textField.getText());
	            operation = "+";
	            textField.setText("");
	            isSecondNumber = true;
	        });
	      //xử lý sự kiện khi bấm vào nút -
	        buttonSub.addActionListener(e -> {
	            firstNumber = Double.parseDouble(textField.getText());
	            operation = "-";
	            textField.setText("");
	            isSecondNumber = true;
	        });
	        //Xử lý sự kiện khi bấm vào nút *
	        buttonMultiply.addActionListener(e -> {
	            firstNumber = Double.parseDouble(textField.getText());
	            operation = "*";
	            textField.setText("");
	            isSecondNumber = true;
	        });
	        //Xử lý sự kiện khi bấm vào nút /
	        buttonDivide.addActionListener(e -> {
	            firstNumber = Double.parseDouble(textField.getText());
	            operation = "/";
	            textField.setText("");
	            isSecondNumber = true;
	        });
	        //Xử lý sự kiện khi bấm vào nút %
	        buttonPercent.addActionListener(e -> {
	            double secondNumber = Double.parseDouble(textField.getText());
	            double result = firstNumber * secondNumber / 100.0;
	            textField.setText(Double.toString(result));
	        });
	        //Xử lý sự kiện khi bấm vào nút =
	        buttonEqual.addActionListener(e -> {
	            double secondNumber = Double.parseDouble(textField.getText());
	            double result = 0;
	            switch (operation) {
	                case "+":
	                    result = firstNumber + secondNumber;
	                    break;
	                case "-":
	                    result = firstNumber - secondNumber;
	                    break;
	                case "*":
	                    result = firstNumber * secondNumber;
	                    break;
	                case "/":
	                    result = firstNumber / secondNumber;
	                    break;
	            }
	            textField.setText(Double.toString(result));
	            isSecondNumber = false;
	        });
	      //Xử lý sự kiện khi bấm vào nút M+
	        buttonMAdd.addActionListener(e -> {
	            double number = Double.parseDouble(textField.getText());
	            memory += number;
	        });
	      //Xử lý sự kiện khi bấm vào nút M-
	        buttonMSub.addActionListener(e -> {
	            double number = Double.parseDouble(textField.getText());
	            memory -= number;
	        });
	      //Xử lý sự kiện khi bấm vào nút MC
	        buttonMC.addActionListener(e -> {
	            memory = 0;
	        });
	      //Xử lý sự kiện khi bấm vào nút MR
	        buttonMR.addActionListener(e -> {
	            textField.setText(Double.toString(memory));
	        });
	      //Xử lý sự kiện khi bấm vào nút CE
	        buttonCE.addActionListener(e -> {
	            textField.setText("");
	            isSecondNumber = false;
	        });
	      //Xử lý sự kiện khi bấm vào nút C
	        buttonC.addActionListener(e -> {
	            textField.setText("");
	            firstNumber = 0;
	            operation = "";
	            isSecondNumber = false;
	            memory = 0;
	        });
		      //Xử lý sự kiện khi bấm vào nút V
	        buttonSqrt.addActionListener(e -> {
	            double number = Double.parseDouble(textField.getText());
	            double result = Math.sqrt(number);
	            textField.setText(Double.toString(result));
	        });
	      //Xử lý sự kiện khi bấm vào nút 1/x
	        buttonInverse.addActionListener(e -> {
	            double number = Double.parseDouble(textField.getText());
	            double result = 1.0 / number;
	            textField.setText(Double.toString(result));
	        });
	      //Xử lý sự kiện khi bấm vào nút .
	        buttonDot.addActionListener(e -> {
	            String text = textField.getText();
	            if (!text.contains(".")) {
	                textField.setText(text + ".");
	            }
	        });
	     // Xử lý sự kiện cho nút <--
	        buttonBackspace.addActionListener(e -> {
	            String text = textField.getText();
	            if (text.length() > 0) {
	                textField.setText(text.substring(0, text.length() - 1));
	            }
	        });
	        //Xử lý sự kiện cho nút ±
	        buttonNegation.addActionListener(e -> {
	            String text = textField.getText();
	            if (text.length() > 0 && !text.equals("0")) {
	                double number = Double.parseDouble(text);
	                number *= -1;
	                textField.setText(Double.toString(number));
	            }
	        });

	}
	public static class WindowColoser implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	}
