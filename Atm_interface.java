import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Atm_interface {
	
    public static void main(String[] args)  {
        Page1 p = new Page1();
       
    }

}

//Welcome Page
class Page1 {
    JLabel l1,l2;
    JButton b1;
    JFrame f;
    JPanel p;

    Page1() {
        f = new JFrame("ATM INTERFACE");
      
        l1 = new JLabel("Welcome to ", SwingConstants.CENTER);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(new Font("Cambria", Font.BOLD, 50));
        l2 = new JLabel("ATM Interface", SwingConstants.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setFont(new Font("Cambria", Font.BOLD, 45));
        b1 = new JButton("Continue");
        b1.setBounds(250, 600, 200, 100);
        b1.setFont(new Font("Cambria", Font.BOLD, 25));
        b1.setBackground(Color.pink);
        f.setSize(400, 450);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        l1.setBounds(50, 270, 250, 30);
        l2.setBounds(40, 70, 100, 40);  
        b1.setBounds(100, 150, 70, 10);
        p = new JPanel();
        p.setBackground(Color.GRAY);
        p.add(l1);p.add(l2);
        p.add(b1);
        f.add(p);
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Page2 obj = new Page2();
                f.dispose();
            }

        });
    }

}

//Login Page
class Page2 {
  JFrame f2 = new JFrame("LOGIN FORM");
  JLabel label1, label2, label3;
  JTextField user;
  JPasswordField Pass;
  JButton b2, b3;
  JPanel p2;
  public static boolean onlyDigits(String str, int n) 
    {
        for (int i = 0; i < n; i++) { 
 
            if (str.charAt(i) < '0'
                || str.charAt(i) > '9') { 
                return false; 
            } 
        }    
	return true;}

  Page2() {

    f2.setSize(400, 450);
    f2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    f2.setLocationRelativeTo(null);

    label1 = new JLabel("Account Number", SwingConstants.CENTER);
    label1.setFont(new Font("Cambria", Font.BOLD, 40));
    
    label3 = new JLabel("< Enter 4 digit pin >", SwingConstants.CENTER);
    label3.setFont(new Font("Cambria", Font.BOLD, 32));

    label2 = new JLabel("Password", SwingConstants.CENTER);
    label2.setFont(new Font("Cambria", Font.BOLD, 40));
    label1.setBounds(40, 70, 90, 50);
    label2.setBounds(102, 50, 100, 50);
    label3.setBounds(102, 150, 100, 50);
    user = new JTextField(30);
    user.setBounds(40, 100, 120, 20);

    Pass = new JPasswordField(30);
    Pass.setBounds(40, 100, 160, 20);

    b2 = new JButton("Login");
    b2.setBounds(200, 400, 100, 50);
    b2.setFont(new Font("Cambria", Font.BOLD, 25));
    b2.setBackground(Color.pink);
    b3 = new JButton("Clear");
    b3.setBounds(200, 300, 100, 50);
    b3.setFont(new Font("Cambria", Font.BOLD, 25));
    b3.setBackground(Color.pink);

    p2 = new JPanel();
    p2.add(label1);
    p2.add(user);

    p2.add(label2);
    p2.add(Pass);
    p2.add(label3);
    p2.add(b2);
    p2.add(b3);
    p2.setBackground(Color.gray);
    f2.add(p2);
    f2.setVisible(true);
    b2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
		  
        String userValue = user.getText();
        int len = userValue.length();
        String userPass = String.valueOf(Pass.getPassword());
        int len2 = userPass.length();
        // if account details are valid then new page will be opened
        if (len <= 16 && len >= 8 && len2==4 &&onlyDigits(userPass,len2)==true && onlyDigits(user.getText(),len)==true) {
          Menu m = new Menu();
          m.setVisible(true);
          f2.dispose();
        }
        // error dialog box will be displayed
        else {

          JOptionPane.showMessageDialog(f2, "Invalid userId or password!",
              "ERROR", JOptionPane.ERROR_MESSAGE);
          f2.dispose();
        }
      }

    });
    b3.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        user.setText(null);
        Pass.setText(null);
      }

    });

  }
}


//Menu Page
class Menu extends JFrame {
    JLabel label1, label2, l1;
    JTextField user;
    JPasswordField Pass;
    JButton withdraw, deposit, sts, bal;
    JPanel p3;
    JFrame f3 = new JFrame("MENU");

    /**
     * 
     */
    Menu() {

        f3.setSize(400,450);
        f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f3.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        p3 = new JPanel();
        p3.setBackground(Color.gray);

        withdraw = new JButton(" >Withdraw ");
        withdraw.setFont(new Font("Cambria", Font.BOLD, 35));
        withdraw.setBounds(35,250,160,35);
        withdraw.setHorizontalAlignment(JLabel.CENTER);
        withdraw.setBackground(Color.pink);

        deposit = new JButton(" >Deposit ");
        deposit.setFont(new Font("Cambria", Font.BOLD, 35));
        deposit.setBounds(350,250,160,35);
        deposit.setBackground(Color.pink);

        sts = new JButton(" >Exit ");
        sts.setFont(new Font("Cambria", Font.BOLD, 35));
        sts.setBounds(35,350,160,35);
        sts.setHorizontalAlignment(JLabel.RIGHT);
        sts.setBackground(Color.pink);

        bal = new JButton(" >Balance enquiry ");
        bal.setFont(new Font("Cambria", Font.BOLD, 35));
        bal.setBounds(350,350,160,35);
        bal.setBackground(Color.pink);

        p3.add(withdraw);
        p3.add(deposit);
        p3.add(bal);
        p3.add(sts);

        f3.add(p3);
        f3.setVisible(true);

        withdraw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Page4 st = new Page4();
                st.setVisible(true);
                f3.dispose();
            }

        });

        deposit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Page5 dt = new Page5();
                dt.setVisible(true);
                f3.dispose();
            }

        });
        bal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Page6 bl = new Page6();
                bl.setVisible(true);
                f3.dispose();
            }

        });
       sts.addActionListener((event) -> System.exit(0));

    }
}

//Withdraw Page
class Page4 {
    JLabel enter;
    JTextField user2;

    JButton submit,exit;
    JPanel p4;
    JFrame f4 = new JFrame("WITHDRAW");

    Page4() {
        f4.setSize(400, 450);
        f4.setResizable(false);
        f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f4.setLocationRelativeTo(null);
        enter = new JLabel("Enter the withdraw Amount", SwingConstants.CENTER);
        enter.setFont(new Font("Cambria", Font.BOLD, 30));
        enter.setBounds(40, 70, 100, 10);
        submit = new JButton("Submit");
        submit.setFont(new Font("Cambria", Font.BOLD, 28));
        submit.setBackground(Color.pink);
        submit.setBounds(30, 350, 200, 30);
         exit = new JButton("Exit");
        exit.setFont(new Font("Cambria", Font.BOLD, 28));
        exit.setBounds(100, 300, 200, 10);
        exit.setBackground(Color.pink);
        user2 = new JTextField(28);
        user2.setBounds(40, 100, 120, 30);
        p4 = new JPanel();
        p4.setBackground(Color.gray);
        p4.add(enter);
        p4.add(user2);
        p4.add(submit);p4.add(exit);
        f4.add(p4);
        f4.setVisible(true);
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
    
                int mon=Integer.parseInt(user2.getText());
                if(mon<=2000){
                   Page6 p=new Page6();
                   int total=2000-mon;
                   p.my_update(String.valueOf(total));
                   p.setVisible(true);
                }
                else{
                    Pageft pf=new Pageft();
                    pf.setVisible(true);
                }
                

            }

        });
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               f4.dispose();
            }
            
        });

    }

    public void setVisible(boolean b) {
    }
}

//Deposit Page
class Page5 {
    JLabel enter;
    JTextField user2;

    JButton submit,exit;
    JPanel p5;
    JFrame f5 = new JFrame("DEPOSIT");

    Page5() {
        f5.setSize(400, 450);
        f5.setResizable(false);
        f5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f5.setLocationRelativeTo(null);
        enter = new JLabel("Enter the deposit amount", SwingConstants.CENTER);
        enter.setFont(new Font("Cambria", Font.BOLD, 30));
        enter.setBounds(40, 70, 100, 10);
        submit = new JButton("Submit");
        submit.setFont(new Font("Cambria", Font.BOLD, 28));
        submit.setBackground(Color.pink);
        submit.setBounds(50, 350, 200, 30);
        user2 = new JTextField(28);
        user2.setBounds(40, 100, 120, 30);
        exit = new JButton("Exit");
        exit.setFont(new Font("Cambria", Font.BOLD, 28));
        exit.setBounds(100, 300, 200, 10);
        exit.setBackground(Color.pink);
        p5 = new JPanel();
        p5.setBackground(Color.gray);
        p5.add(enter);
        p5.add(user2);
        p5.add(submit);p5.add(exit);
        f5.add(p5);
        f5.setVisible(true);
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f5.dispose();
                Page6 p2=new Page6();
                int amt=Integer.parseInt(user2.getText());
                int amt2=2000;int ttl=amt+amt2;
                p2.my_update(String.valueOf(ttl));
                p2.setVisible(true);
                

            }

        });
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               f5.dispose();
            }
            
        });

    }

    public void setVisible(boolean b) {
    }
}

//Balance Page
class Page6 {
    JLabel enq, sucss;
    JTextField balance;
    JPanel p6;
    JButton exit;
    JFrame f6 = new JFrame("Balance");
    String str = "2000";

    public void my_update(String str) {
        balance.setText(str);
    }

    Page6() {
        f6.setSize(400, 450);
        f6.setResizable(false);
        f6.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f6.setLocationRelativeTo(null);
        sucss = new JLabel("TRANSACTION SUCCESS.");
        sucss.setBounds(0, 30, 600, 40);
        sucss.setHorizontalAlignment(JLabel.CENTER);
        sucss.setFont(new Font("Cambria", Font.BOLD, 30));
        enq = new JLabel("Remaining Balance : ", SwingConstants.CENTER);
        enq.setFont(new Font("Cambria", Font.BOLD, 32));
        enq.setBounds(40, 70, 100, 10);

        balance = new JTextField();
        balance.setText(str);
        balance.setEditable(false);
        balance.setForeground(Color.black);
        balance.setBackground(Color.pink);
        balance.setBorder(null);
        balance.setFont(new Font("Cambria", Font.BOLD, 32));
        balance.setBounds(40, 100, 120, 10);

        exit = new JButton("Exit");
        exit.setFont(new Font("Cambria", Font.BOLD, 28));
        exit.setBounds(100, 300, 200, 10);
        exit.setBackground(Color.pink);

        p6 = new JPanel();p6.add(sucss);
        p6.setBackground(Color.gray);
        p6.add(enq);
        p6.add(balance);
        p6.add(exit);

        balance.setText(str);
        f6.add(p6);
        f6.setVisible(true);
        exit.addActionListener((event) -> System.exit(0));

    }

    public void setVisible(boolean b) {
    }

    public void dispose() {
    }
}

//Failed Transaction page
class Pageft extends JFrame {
    JLabel fail;
    JPanel pf;
    JButton exit;
    JFrame ff = new JFrame("Success");

    Pageft() {
        ff.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ff.setTitle("FAILURE");
        ff.setResizable(false);
        ff.setSize(500,500);
        ff.setLocationRelativeTo(null);
        fail = new JLabel("YOUR TRANSACTION HAS FAILED!!");
        fail.setBounds(0, 30, 600, 40);
        fail.setHorizontalAlignment(JLabel.CENTER);
        fail.setFont(new Font("Cambria", Font.BOLD, 30));
        exit = new JButton("Exit");
        exit.setFont(new Font("Cambria", Font.BOLD, 35));
        exit.setBounds(100, 800, 200, 10);
        exit.setBackground(Color.pink);
        pf = new JPanel();
        pf.setBackground(Color.gray);
        pf.add(fail);
        pf.add(exit);
        ff.add(pf);
        ff.setVisible(true);
        exit.addActionListener((event) -> System.exit(0));

    }
}
