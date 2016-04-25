import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pedrosilva on 4/20/16.
 */
public class main_menu {

    public static main_menu run = new main_menu();

    public static void main(String[] args){

        //System.out.println(args[0]);
        run.main_frame(args[0]);

    }

    public JFrame main_Frame = new JFrame("Wagser Co.");

    public void main_frame(String user){

        main_Frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JMenuBar menu_bar = new JMenuBar();

        JMenu menu_File = new JMenu("File");

        JMenu menu_options = new JMenu("Options");

        JMenu menu_account = new JMenu("Account");

        JMenuItem menu_log_off = new JMenuItem("Log Off");

        JMenuItem menu_New = new JMenuItem("New");

        JMenuItem menu_help = new JMenuItem("Help");

        JMenuItem menu_create_new_account = new JMenuItem("Create new Account");

        menu_account.add(menu_log_off);

        menu_File.add(menu_New);

        BufferedReader reader = null;

        String[] files = new String[5];

        try {

            File file_user_info = new File(System.getProperty("user.dir") + "/user/"+ user +".txt");

            reader = new BufferedReader(new FileReader(file_user_info));

            String line;



            int i = 0;

            while ((line = reader.readLine()) != null) {

                files[i] = line;

                i++;

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        if (files[4].equals("true")){

            menu_options.add(menu_create_new_account);

        }

        menu_options.add(menu_help);

        //------------------------------------------------------------------------------

        menu_create_new_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println("Create account working");

                run.create_Account(user);

            }
        });

        menu_log_off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_Frame.dispose();
                main_Class run_main = new main_Class();

                String[] args = new String[0];

                run_main.main(args);
            }
        });

        menu_New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new_file run_new_file = new new_file();

                String[] args = new String[0];

                run_new_file.main(args);


            }
        });

        //------------------------------------------------------------------------------

        menu_bar.add(menu_File);

        menu_bar.add(menu_options);

        menu_bar.add(menu_account);

        //------------------------------------------------------------------------------

        main_Frame.setJMenuBar(menu_bar);

        main_Frame.add(main_Panel);

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(600, 600);

        main_Frame.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        main_Frame.setResizable(false);
        main_Frame.setMinimumSize(frameSize);
        main_Frame.setVisible(true);
        main_Frame.pack();

    }

    public void create_Account(String user){

        String file_Name = "info_logs.txt";

        File file = new File(System.getProperty("user.dir") + file_Name);

        JFrame make_Properties = new JFrame("WagserCo.");
        make_Properties.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        JPanel center = new JPanel(new BorderLayout());

        JPanel card_Title = new JPanel();
        JPanel card_Username = new JPanel(new BorderLayout());
        JPanel card_Password = new JPanel(new BorderLayout());
        JPanel card_Button = new JPanel(new BorderLayout());


        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel("WagserCo.");
        JLabel label_Username = new JLabel("Username:");
        JLabel label_Password = new JLabel("Password:");

        JTextField TextField_Username = new JTextField();
        JTextField TextField_Password = new JTextField();

        JButton Button_Create = new JButton("Create Account");

        JRadioButton RB_admin = new JRadioButton("Admin");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_Username.setFont(new Font("Serif", Font.PLAIN, 20));
        label_Password.setFont(new Font("Serif", Font.PLAIN, 20));

        Button_Create.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        card_Title.add(label_Title);

        card_Username.add(label_Username, BorderLayout.NORTH);
        card_Password.add(label_Password, BorderLayout.NORTH);
        card_Username.add(TextField_Username, BorderLayout.CENTER);
        card_Password.add(TextField_Password, BorderLayout.CENTER);

        //------------------------------------------------------------------------------

        BufferedReader reader = null;

        String[] files = new String[5];

        try {

            File file_user_info = new File(System.getProperty("user.dir") + "/user/"+ user +".txt");

            reader = new BufferedReader(new FileReader(file_user_info));

            String line;



            int i = 0;

            while ((line = reader.readLine()) != null) {

                files[i] = line;

                i++;

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        if (files[4].equals("true")){

            card_Password.add(RB_admin, BorderLayout.SOUTH);

        }

        //------------------------------------------------------------------------------

        center.add(card_Username, BorderLayout.NORTH);
        center.add(card_Password, BorderLayout.CENTER);

        card_Button.add(Button_Create);

        main_Panel.add(card_Title, BorderLayout.NORTH);
        main_Panel.add(center, BorderLayout.CENTER);
        main_Panel.add(card_Button, BorderLayout.SOUTH);

        make_Properties.getContentPane().add(main_Panel);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 200);

        make_Properties.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        make_Properties.setResizable(false);
        make_Properties.setMinimumSize(frameSize);
        make_Properties.setVisible(true);
        make_Properties.pack();

        //------------------------------------------------------------------------------

        Button_Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Username = TextField_Username.getText();

                try {

                    FileWriter fileWriter =
                            new FileWriter(file_Name, true);

                    BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);


                    bufferedWriter.newLine();
                    bufferedWriter.write(Username);
                    bufferedWriter.newLine();
                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        md.update(TextField_Password.getText().getBytes());
                        bufferedWriter.write(new String(new sun.misc.BASE64Encoder().encode(md.digest())));
                    } catch (NoSuchAlgorithmException f) {
                        System.out.println(f);
                    }

                    bufferedWriter.close();
                } catch (IOException ex) {
                    System.out.println(
                            "Error writing to file '"
                                    + file_Name + "'");

                }

                String admin_bool = "false";

                Boolean admin = new Boolean(RB_admin.isSelected());

                if (admin){

                    admin_bool = "true";

                }

                String file_User = Username + ".txt";

                File file2 = new File(System.getProperty("user.dir") + "/user/" + file_User);

                try {

                    file2.createNewFile();

                } catch (IOException f) {

                    f.printStackTrace();

                }

                try {

                    FileWriter fileWriter2 =
                            new FileWriter(file2);

                    BufferedWriter bufferedWriter2 =
                            new BufferedWriter(fileWriter2);

                    bufferedWriter2.write("User Information:");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("-----------------------------");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(Username);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("Admin: ");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(admin_bool);

                    bufferedWriter2.close();
                } catch (IOException ex) {
                    System.out.println(
                            "Error writing to file '"
                                    + file_User + "'");

                }

                make_Properties.dispose();

            }

        });

    }

}
