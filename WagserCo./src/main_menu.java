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

    public static person current_User;

    public static user current_user;

    public static main_menu run = new main_menu();

    public static void main(String[] args, person Current_User, user current_user){

        //System.out.println(args[0]);

        current_User = Current_User;

        current_user = current_user;

        run.main_frame(args[0]);

    }

    public JFrame main_Frame = new JFrame("Wagser Co.");

    public void main_frame(String user){

        main_Frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JMenuBar menu_bar = new JMenuBar();

        //------------------------------------------------------------------------------

        JMenu menu_File = new JMenu("File");

        JMenu menu_options = new JMenu("Options");

        JMenu menu_account = new JMenu("Account");

        //------------------------------------------------------------------------------

        JMenuItem menu_log_off = new JMenuItem("Log Off");

        JMenuItem menu_New = new JMenuItem("New");

        JMenuItem menu_help = new JMenuItem("Help");

        JMenuItem menu_create_new_account = new JMenuItem("Create new Account");

        JMenu menu_Edit_Information = new JMenu("Edit Account Info");

        JMenuItem menu_Edit_Name = new JMenuItem("Name");

        JMenuItem menu_Edit_DOB = new JMenuItem("Date of Birth");

        JMenuItem menu_Edit_Email = new JMenuItem("Email");

        //------------------------------------------------------------------------------

        menu_File.add(menu_New);

        //menu_Edit_Information.add(menu_Edit_Name);

        menu_Edit_Information.add(menu_Edit_DOB);

        menu_Edit_Information.add(menu_Edit_Email);

        menu_account.add(menu_Edit_Information);

        menu_account.addSeparator();

        menu_account.add(menu_log_off);

        //------------------------------------------------------------------------------

        BufferedReader reader = null;

        String[] files = new String[8];

        int counts = 0;

        try {

            File file3 = new File(System.getProperty("user.dir") + "/user/" + user + ".txt");

            reader = new BufferedReader(new FileReader(file3));

            String line;

            while ((line = reader.readLine()) != null) {

                files[counts] = line;

                counts++;

            }

        } catch (IOException f) {

            f.printStackTrace();

        } finally {
            try {
                reader.close();
            } catch (IOException f) {
                f.printStackTrace();
            }


        }

        String[] filesss = new String[counts];

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

        //------------------------------------------------------------------------------

        menu_options.addSeparator();
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

        menu_Edit_Name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                run.edit_Person_Info(1);

            }
        });

        menu_Edit_DOB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                run.edit_Person_Info(2);

            }
        });

        menu_Edit_Email.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                run.edit_Person_Info(3);

            }
        });

        //------------------------------------------------------------------------------

        menu_bar.add(menu_File);

        menu_bar.add(menu_account);

        menu_bar.add(menu_options);

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

        JFrame edit_Info = new JFrame("WagserCo.");
        edit_Info.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

        String[] files = new String[8];

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

        edit_Info.getContentPane().add(main_Panel);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 200);

        edit_Info.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Info.setResizable(false);
        edit_Info.setMinimumSize(frameSize);
        edit_Info.setVisible(true);
        edit_Info.pack();

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
                    bufferedWriter.flush();
                    bufferedWriter.write(Username);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        md.update(TextField_Password.getText().getBytes());
                        bufferedWriter.write(new String(new sun.misc.BASE64Encoder().encode(md.digest())));
                    } catch (NoSuchAlgorithmException f) {
                        System.out.println(f);
                    }
                    bufferedWriter.flush();


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

                edit_Info.dispose();

            }

        });

    }

    public void edit_Person_Info(int edit){

        String label1 = null;
        ActionListener action = null;

        if (edit == 1){

            //Name
            label1 = "Name";

        }

        if (edit == 2){

            //Date of Birth
            label1 = "Date of Birth";

        }

        if (edit == 3){

            //Email
            label1 = "Email";

        }


        JFrame edit_Info = new JFrame("WagserCo.");
        edit_Info.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        JPanel center = new JPanel(new BorderLayout());

        JPanel card_Title = new JPanel();
        JPanel card_Username = new JPanel(new BorderLayout());
        JPanel card_Button = new JPanel(new BorderLayout());


        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel("WagserCo.");
        JLabel label_Username = new JLabel(label1);

        JTextField TextField_Username = new JTextField();

        JButton Button_Create = new JButton("Edit Information");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_Username.setFont(new Font("Serif", Font.PLAIN, 20));

        Button_Create.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        card_Title.add(label_Title);

        card_Username.add(label_Username, BorderLayout.NORTH);
        card_Username.add(TextField_Username, BorderLayout.CENTER);

        center.add(card_Username, BorderLayout.NORTH);

        card_Button.add(Button_Create);

        main_Panel.add(card_Title, BorderLayout.NORTH);
        main_Panel.add(center, BorderLayout.CENTER);
        main_Panel.add(card_Button, BorderLayout.SOUTH);

        edit_Info.getContentPane().add(main_Panel);

        if (edit == 1){

            //Name
            action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    current_User.change_name(TextField_Username.getText());
                    current_User.write(current_User);

                }
            };

        }

        if (edit == 2){

            //Date of Birth
            action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    current_User.change_dob(TextField_Username.getText());
                    current_User.write(current_User);

                }
            };

        }

        if (edit == 3){

            //Email
            action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    current_User.change_email(TextField_Username.getText());
                    current_User.write(current_User);
                }
            };

        }

        Button_Create.addActionListener(action);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 150);

        edit_Info.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Info.setResizable(false);
        edit_Info.setMinimumSize(frameSize);
        edit_Info.setVisible(true);
        edit_Info.pack();


    }

}
