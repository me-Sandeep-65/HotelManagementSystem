package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    static JLabel l1;
    static JButton b1;
    static Dimension frameSize;
    static JLabel lid;
    
    public HotelManagementSystem() {
        super("planSpot");
        
        setSize(1366,830);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setContentPane(300,300,1366,390);   frame size
//        setLayout(null);
//        setLocation(100,100);    
            
        frameSize = getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - frameSize.width) >> 1, (screenSize.height - frameSize.height) >> 1);

        l1 = new JLabel("");
        b1 = new JButton("Next");
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);			
        
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(screenSize.width+20, screenSize.height+20,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
            
        lid=new JLabel("DATABASE MANAGEMENT SYSTEMS PROJECT");
//        lid.setBounds(30,300,1500,100);
//        lid.setFont(new Font("serif",Font.BOLD ,40));
        lid.setForeground(Color.white);
        l1.add(lid);
       
//        b1.setBounds(frameSize.width-frameSize.width/5,frameSize.height-frameSize.height/5,150,50);
//        l1.setBounds(frameSize.width >>1, frameSize.height >>1, frameSize.width, frameSize.height);
        
        l1.add(b1);
        add(l1);
        b1.addActionListener(this);
        setVisible(true);
    }
       
        @Override
        public void actionPerformed(ActionEvent ae){
            new Login().setVisible(true); 
            dispose();
        }
        
        public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);
       
        window.addComponentListener(new ComponentListener(){
            @Override
            public void componentHidden(ComponentEvent e){}
            @Override
            public void componentShown(ComponentEvent e){}
            @Override
            public void componentMoved(ComponentEvent e){}
            @Override
            public void componentResized(ComponentEvent e){
                b1.setBounds((e.getComponent().getSize().width)-(e.getComponent().getSize().width/5),(e.getComponent().getSize().height)-(e.getComponent().getSize().height/5),e.getComponent().getSize().width/10,e.getComponent().getSize().height/18 );
                l1.setBounds(0, 0, e.getComponent().getSize().width, e.getComponent().getSize().height); 
                lid.setBounds(e.getComponent().getSize().width/50, e.getComponent().getSize().height/3, e.getComponent().getSize().width, e.getComponent().getSize().height/10);
                lid.setFont(new Font("serif",Font.BOLD ,e.getComponent().getSize().height/25));
            }
        });
    }   
}