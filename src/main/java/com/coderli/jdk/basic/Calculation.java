package com.coderli.jdk.basic;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Calculation {
	//数字键
	 JButton btu1=new JButton("1");
	 JButton btu2=new JButton("2");
	 JButton btu3=new JButton("3");
	 JButton btu4=new JButton("4");
	 JButton btu5=new JButton("5");
	 JButton btu6=new JButton("6");
	 JButton btu7=new JButton("7");
	 JButton btu8=new JButton("8");
	 JButton btu9=new JButton("9");
	 JButton btu10=new JButton("0");
	//操作键
	 
	 JButton btu11=new JButton("+");
	 JButton btu12=new JButton("-");
	 JButton btu13=new JButton("*");
	 JButton btu14=new JButton("/");
	 JButton btu15=new JButton("=");
	 JButton btu16=new JButton("后退");
	 JButton btu17=new JButton(".");
	
	JFrame jf=new JFrame("计算器");
	JLabel jl1=new JLabel("输入:");
	JLabel jl2=new JLabel("结果:");
	JTextField jt1=new JTextField(20);	 
	JTextField jt2=new JTextField(20);
	
	JPanel jp=new JPanel();
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jpx=new JPanel();
	 
	double x,y;         //x和y都是运算数  
	String z;
	Boolean start=true;//默认开始为真
	int count=0;//默认小数点出现的次数为0
	double firstNum;//接收输入符号键之前的数值
	double lastNum;//接收输入符号键之后的数值
	double result=0;//接收结果
	
	public Calculation() {
		
		jt1.setHorizontalAlignment(JTextField.RIGHT);
		jt2.setHorizontalAlignment(JTextField.RIGHT);
		jt1.setEditable(false);
		jt2.setEditable(false);
		jp1.add(jl1);			
		jp1.add(jt1);
			jpx.add(jl2);			
			jpx.add(jt2);
			
			jp.add(jp1);
			jp.add(jpx);
			
			jp2.add(btu1);
			jp2.add(btu2);
			jp2.add(btu3);
			jp2.add(btu11);
			jp2.add(btu4);
			jp2.add(btu5);
			jp2.add(btu6);
			jp2.add(btu12);
			jp2.add(btu7);			
			jp2.add(btu8);
			jp2.add(btu9);
			jp2.add(btu13);
			jp2.add(btu17);
			jp2.add(btu10);	
			jp2.add(btu15);						
			jp2.add(btu14);
			jp2.add(btu16);	
			
			jf.add(jp);
			jf.add(jp2,new BorderLayout().SOUTH);
			
			jf.setBounds(400, 200, 300, 260);
			jf.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);	
				}
			});			
			jp2.setLayout(new GridLayout(5, 4));
			
			jf.setVisible(true);
			//功能键监听
			btu11.addActionListener(new FunctionListener());//"."
			btu12.addActionListener(new FunctionListener());//"+"
			btu13.addActionListener(new FunctionListener());//"-"
			btu14.addActionListener(new FunctionListener());//"*"
			btu15.addActionListener(new FunctionListener());//"/"
			btu16.addActionListener(new FunctionListener());//"="
			btu17.addActionListener(new FunctionListener());//"&后退"
			//数字键监听
			btu1.addActionListener(new CharListener());
			btu2.addActionListener(new CharListener());
			btu3.addActionListener(new CharListener());
			btu4.addActionListener(new CharListener());
			btu5.addActionListener(new CharListener());
			btu6.addActionListener(new CharListener());
			btu7.addActionListener(new CharListener());
			btu8.addActionListener(new CharListener());
			btu9.addActionListener(new CharListener());	
			btu10.addActionListener(new CharListener());

		}
	
			
	
    class FunctionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		   String input=e.getActionCommand();
//		   jt1.setText(jt1.getText()+input);
		   if(input.equals(".")){
		   		if(count==0){
		   			jt1.setText(jt1.getText()+input);
		   		}else{
		   			jt1.setText(jt1.getText()+"");
		   		}
		   	count++;
		   	}
	//点的检验	   
//		   if(!input.equals(".")){
//			   jt1.setText(jt1.getText()+input);
//		   	}		   
		   if(input.equals("后退")){
			   if(jt1.getText().length()>1){
				   jt1.setText(jt1.getText().substring(0,jt1.getText().length()-1));//后退一位
			   }else{
				   jt1.setText("0");
			   }
		   }
//		   没有接收到符号键之前的输入数值，怎么才能接收符号键之间的数值呢
		   //设置一个变量接收前面输入的数值
		   	if(input.equals("+")){
		   		firstNum=Double.parseDouble(jt1.getText());
//		   		jt1.setText(jt1.getText()+input);
		   		start=true;
		   		lastNum=Double.parseDouble(jt1.getText());
		   		result=firstNum+lastNum;
		   	}
		   	if(input.equals("-")){
		   		firstNum=Double.parseDouble(jt1.getText());
//		   		jt1.setText(jt1.getText()+input);
		   		start=true;
		   		lastNum=Double.parseDouble(jt1.getText());
		   		result=firstNum-lastNum;
		   		
		   	}
		   	if(input.equals("*")){
		   		firstNum=Double.parseDouble(jt1.getText());
//		   		jt1.setText(jt1.getText()+input);
		   		start=true;
		   		lastNum=Double.parseDouble(jt1.getText());
		   		result=firstNum*lastNum;
		   		
		   	}
		   	if(input.equals("/")){
		   		firstNum=Double.parseDouble(jt1.getText());
//		   		jt1.setText(jt1.getText()+input);
		   		start=true;
		   		lastNum=Double.parseDouble(jt1.getText());
		   		result=firstNum/lastNum;
		   		
		   	}
		   	if(input.equals("=")){
		   		jt2.setText(result+"");
		   	}
		}
		}
    
    class CharListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String input=e.getActionCommand();
			if(jt1.getText().equals("0")){
				start=true;
			}
			if(start){//为什么这里变成start=true会得到想要的结果呢
				count=0;
				jt1.setText("");
				start=false;
			}		
			jt1.setText(jt1.getText()+input);
		 }	
		}
		
	public static void main(String[] args) {	
			new Calculation(); 
}
}
