package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminHomePage extends JFrame implements ActionListener {
    JLabel backgroundLabel;
    Font f, f1, f2;

    public String admin_id2;
    int login__id;
    String username2;

    public AdminHomePage(String adminname, String admin_id, int login_id, String username) {
        super("admin home page");
        setLocation(0, 0);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        admin_id2 = admin_id;
        login__id = login_id;
        username2 = username;

        // Load and set the background image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/adminhome.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(
                Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height,
                Image.SCALE_SMOOTH);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundImage);
        backgroundLabel = new JLabel(backgroundScaledIcon);
        backgroundLabel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height);

        f = new Font("Lucida fax", Font.BOLD, 20);
        f1 = new Font("Gaudai", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic", Font.BOLD, 20);

        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Doctor");
        JMenuItem ment1 = new JMenuItem("Add Doctor");
        JMenuItem ment2 = new JMenuItem("View Doctor");

        JMenu men2 = new JMenu("Patient");
        JMenuItem ment3 = new JMenuItem("Add Patient");
        JMenuItem ment4 = new JMenuItem("View Patient");

        JMenu men3 = new JMenu("Receptionist");
        JMenuItem ment5 = new JMenuItem("Add Receptionist");
        JMenuItem ment6 = new JMenuItem("View Receptionist");

        JMenu men4 = new JMenu("Appointment");
        JMenuItem ment7 = new JMenuItem("Add Appointment");
        JMenuItem ment8 = new JMenuItem("View Appointment");

        JMenu men5 = new JMenu("Hi, Admin (" + adminname + ")");
        JMenuItem ment9 = new JMenuItem("My Profile");
        JMenuItem ment10 = new JMenuItem("Change Password");

        JMenu men8 = new JMenu("Exit");
        JMenuItem ment14 = new JMenuItem("Exit");

        men1.add(ment1);
        men1.add(ment2);
        men2.add(ment3);
        men2.add(ment4);
        men3.add(ment5);
        men3.add(ment6);
        men4.add(ment7);
        men4.add(ment8);
        men5.add(ment9);
        men5.add(ment10);
        men8.add(ment14);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men8);

        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men8.setFont(f);

        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment14.setFont(f1);

        m1.setBackground(Color.black);

        men1.setForeground(Color.gray);
        men2.setForeground(Color.gray);
        men3.setForeground(Color.gray);
        men4.setForeground(Color.gray);
        men5.setForeground(Color.gray);
        men8.setForeground(Color.red);

        ment1.setForeground(Color.yellow);
        ment3.setForeground(Color.yellow);
        ment5.setForeground(Color.yellow);
        ment7.setForeground(Color.yellow);
        ment9.setForeground(Color.yellow);
        ment14.setForeground(Color.red);

        ment1.setBackground(Color.black);
        ment3.setBackground(Color.black);
        ment5.setBackground(Color.black);
        ment7.setBackground(Color.black);
        ment9.setBackground(Color.black);
        ment14.setBackground(Color.red);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment14.addActionListener(this);

        setJMenuBar(m1);
        add(backgroundLabel);

        setLayout(new BorderLayout());

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String comnd = ae.getActionCommand();
        if (comnd.equals("Add Doctor")) {
            new Add_Doctor();
        } else if (comnd.equals("View Doctor")) {
            new View_Doctor(login__id).setVisible(true);
        } else if (comnd.equals("Add Patient")) {
            new Add_Patient();
        } else if (comnd.equals("View Patient")) {
            new View_Patient(username2, login__id).setVisible(true);
        } else if (comnd.equals("Add Receptionist")) {
            new Add_Receptionist();
        } else if (comnd.equals("View Receptionist")) {
            new View_Receptionist(login__id).setVisible(true);
        } else if (comnd.equals("Add Appointment")) {
            new Add_Appointment().setVisible(true);
        } else if (comnd.equals("View Appointment")) {
            new View_Appointment(username2, login__id).setVisible(true);
        } else if (comnd.equals("My Profile")) {
            new checkMyProfile(admin_id2, login__id);
        } else if (comnd.equals("Change Password")) {
            new ChangeMyPassword(admin_id2);
        } else if (comnd.equals("Exit")) {
            this.setVisible(false);
            new Index();
        }
    }

    //public static void main(String[] args) {
       // SwingUtilities.invokeLater(() -> new AdminHomePage("Admin", "admin123", 1, "admin"));
    //}
}
