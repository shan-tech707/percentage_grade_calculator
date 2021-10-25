import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PercentageGradeCalculator extends JFrame{
    JLabel lbl_Obtained_Marks,lbl_Total_Marks,lbl_Output;
    JTextField txt_Obtained_Marks,txt_Total_Marks;
    JRadioButton r_Button_Percentage,r_Button_Grade;
    JButton btn_Calculate;
    PercentageGradeCalculator(){
        setTitle("Calculator");
        lbl_Obtained_Marks=new JLabel("Enter the Obtained Marks: ");
        lbl_Total_Marks=new JLabel("Enter the Total Marks: ");
        lbl_Output=new JLabel();
        txt_Obtained_Marks=new JTextField(15);
        txt_Total_Marks=new JTextField(15);
        r_Button_Percentage=new JRadioButton("Calculate Percentage",true);
        r_Button_Grade=new JRadioButton("Calculate Grade");
        ButtonGroup btn_group=new ButtonGroup();
        btn_group.add(r_Button_Percentage);
        btn_group.add(r_Button_Grade);
        btn_Calculate=new JButton("Calculate");
        GridBagLayout lay_out=new GridBagLayout();
        Container container=getContentPane();
        container.setLayout(lay_out);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets=new Insets(10,5,10,5);
        gbc.gridx=0;
        gbc.gridy=0;
        add(lbl_Obtained_Marks,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        add(txt_Obtained_Marks,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        add(lbl_Total_Marks,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        add(txt_Total_Marks,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        add(r_Button_Percentage,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        add(r_Button_Grade,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        add(btn_Calculate,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=2;
        add(lbl_Output,gbc);
        pack();
        setVisible(true);
        btn_Calculate.addActionListener(new InnerClass());

    }
    private  class InnerClass implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            int obt_Marks=Integer.parseInt(txt_Obtained_Marks.getText());
            int total_Marks=Integer.parseInt(txt_Total_Marks.getText());
            int percentage=(obt_Marks*100)/total_Marks;
            if(r_Button_Percentage.isSelected()){
                lbl_Output.setText("Percentage is = "+ percentage+"%");
                pack();
            }
            else{
                if(percentage >= 70){
                    lbl_Output.setText("Grade is A");
                    pack();
                }else if(percentage >= 60){
                    lbl_Output.setText("Grade is B");
                    pack();
                }else if(percentage >= 50){
                    lbl_Output.setText("Grade is C");
                    pack();
                }else if(percentage >= 40){
                    lbl_Output.setText("Grade is D");
                    pack();
                }else{
                    lbl_Output.setText("Grade is F");
                    pack();
                }
            }
        }
    }

    public static void main(String[] args) {
        new PercentageGradeCalculator();
    }

}