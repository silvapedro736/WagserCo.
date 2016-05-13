import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Driver;

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

        JMenu menu_edit = new JMenu("Edit");

        //------------------------------------------------------------------------------

        JMenuItem menu_log_off = new JMenuItem("Log Off");

        JMenuItem menu_New = new JMenuItem("New");

        JMenuItem menu_help = new JMenuItem("Help");

        JMenuItem menu_create_new_account = new JMenuItem("Create new Account");

        JMenu menu_Edit_Information = new JMenu("Edit Account Info");

        JMenuItem menu_Edit_Name = new JMenuItem("Name");

        JMenuItem menu_Edit_DOB = new JMenuItem("Date of Birth");

        JMenuItem menu_Edit_Email = new JMenuItem("Email");

        JMenuItem menu_New_Truck = new JMenuItem("New Truck");

        JMenuItem menu_New_Driver = new JMenuItem("New Driver");

        JMenuItem menu_Edit_Truck = new JMenuItem("Edit Truck");

        JMenuItem menu_Edit_Driver = new JMenuItem("Edit Driver");

        //------------------------------------------------------------------------------

        menu_File.add(menu_New);

        //menu_Edit_Information.add(menu_Edit_Name);

        menu_Edit_Information.add(menu_Edit_DOB);

        menu_Edit_Information.add(menu_Edit_Email);

        menu_account.add(menu_Edit_Information);

        menu_account.addSeparator();

        menu_account.add(menu_log_off);

        menu_edit.add(menu_New_Driver);

        menu_edit.add(menu_New_Truck);

        menu_edit.addSeparator();

        menu_edit.add(menu_Edit_Driver);

        menu_edit.add(menu_Edit_Truck);

        //------------------------------------------------------------------------------

        menu_bar.add(menu_File);

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

            menu_bar.add(menu_edit);

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

        menu_New_Truck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run.create_Truck();
            }
        });

        menu_Edit_Truck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run.edit_Truck();
            }
        });

        menu_New_Driver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                run.create_Driver();

            }
        });

        menu_Edit_Driver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                run.edit_Driver();

            }
        });

        //------------------------------------------------------------------------------

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
        Dimension frameSize = new Dimension(500, 170);

        edit_Info.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Info.setResizable(false);
        edit_Info.setMinimumSize(frameSize);
        edit_Info.setVisible(true);
        edit_Info.pack();


    }

    public void create_Truck(){

        JFrame new_Truck = new JFrame("WagserCo.");
        new_Truck.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new BorderLayout());
        JPanel south_Panel = new JPanel(new BorderLayout());

        JPanel center_Panel_North = new JPanel(new BorderLayout());
        JPanel center_Panel_Center = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title1 = new JLabel("WagserCo.");
        JLabel label_Brand = new JLabel("Brand");
        JLabel label_License_Plate = new JLabel("License Plate");

        JTextField textField_Brand = new JTextField();
        JTextField textField_License_Plate = new JTextField();

        JButton button_Create = new JButton("Create Truck");

        //------------------------------------------------------------------------------

        label_Title1.setFont(new Font("Serif", Font.PLAIN, 35));

        label_Brand.setFont(new Font("Serif", Font.PLAIN, 20));
        label_License_Plate.setFont(new Font("Serif", Font.PLAIN, 20));

        textField_Brand.setFont(new Font("Serif", Font.PLAIN, 20));
        textField_License_Plate.setFont(new Font("Serif", Font.PLAIN, 20));

        button_Create.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        north_Panel.add(label_Title1);

        center_Panel_North.add(label_Brand, BorderLayout.CENTER);
        center_Panel_North.add(textField_Brand, BorderLayout.SOUTH);

        center_Panel_Center.add(label_License_Plate, BorderLayout.CENTER);
        center_Panel_Center.add(textField_License_Plate, BorderLayout.SOUTH);

        south_Panel.add(button_Create, BorderLayout.CENTER);

        //------------------------------------------------------------------------------

        center_Panel.add(center_Panel_North, BorderLayout.NORTH);
        center_Panel.add(center_Panel_Center, BorderLayout.CENTER);

        main_Panel.add(north_Panel, BorderLayout.NORTH);
        main_Panel.add(center_Panel, BorderLayout.CENTER);
        main_Panel.add(south_Panel, BorderLayout.SOUTH);

        //------------------------------------------------------------------------------

        new_Truck.add(main_Panel);

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 200);

        new_Truck.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        new_Truck.setResizable(false);
        new_Truck.setMinimumSize(frameSize);
        new_Truck.setVisible(true);
        new_Truck.pack();

        button_Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                truck[] trucks = new truck[1];

                trucks[0] = new truck(textField_Brand.getText(), textField_License_Plate.getText());

                new_Truck.dispose();

            }
        });

    }

    public void edit_Truck(){

        String temp;
        String temp2;

        File folder = new File(System.getProperty("user.dir") + "/truck");
        File[] listOfFiles = folder.listFiles();

        final DefaultListModel truckList = new DefaultListModel();

        for (int i = 0; i < listOfFiles.length; i++){

            temp = listOfFiles[i].getName();
            temp2 = temp.replace(".txt", "");

            truckList.addElement(temp2);

        }

        //------------------------------------------------------------------------------

        JFrame edit_Truck = new JFrame("WagserCo.");
        edit_Truck.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        edit_Truck.getContentPane().add(main_Panel);

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new FlowLayout());
        JPanel south_Panel = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel("WagserCo.");
        JLabel label_Title1 = new JLabel("Edit Truck");

        JList list_Truck = new JList(truckList);

        JButton button_Edit = new JButton("Edit");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_Title1.setFont(new Font("Serif", Font.PLAIN, 25));

        list_Truck.setFont(new Font("Serif", Font.PLAIN, 17));

        button_Edit.setFont(new Font("Serif", Font.PLAIN, 25));

        list_Truck.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_Truck.setVisibleRowCount(5);
        list_Truck.setLayoutOrientation(JList.VERTICAL);
        list_Truck.setSelectedIndex(0);

        JScrollPane scroll = new JScrollPane(list_Truck);


        //------------------------------------------------------------------------------

        north_Panel.add(label_Title);
        //north_Panel.add(label_Title1, BorderLayout.SOUTH);

        center_Panel.add(scroll);
        center_Panel.add(button_Edit);
        center_Panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        //south_Panel.add(button_Edit);

        //------------------------------------------------------------------------------

        main_Panel.add(north_Panel, BorderLayout.NORTH);
        main_Panel.add(center_Panel, BorderLayout.CENTER);
        main_Panel.add(south_Panel, BorderLayout.SOUTH);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(200, 200);

        edit_Truck.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Truck.setResizable(false);
        edit_Truck.setMinimumSize(frameSize);
        edit_Truck.setVisible(true);
        edit_Truck.pack();

        button_Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int truck_LP_int = list_Truck.getSelectedIndex();
                File truck_file = listOfFiles[truck_LP_int];
                //String truck_file_name = truck_file.getName().replace(".txt", "");

                truck temp = new truck(truck_file);

                run.edit_Truck_step2(temp);

                edit_Truck.dispose();

            }
        });

    }

    public void edit_Truck_step2(truck edit_truck){

        //System.out.println(edit_truck.get_License_Plate());

        JFrame edit_Truck = new JFrame("WagserCo.");
        edit_Truck.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());
        edit_Truck.getContentPane().add(main_Panel);

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new BorderLayout());
        JPanel south_Panel = new JPanel();

        JPanel center_Panel_North = new JPanel();
        JPanel center_Panel_South = new JPanel(new BorderLayout());
        JPanel center_Panel_South_North = new JPanel(new BorderLayout());
        JPanel center_Panel_South_South = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel(edit_truck.get_License_Plate());
        JLabel label_show_brand = new JLabel(edit_truck.get_Brand());

        JLabel label_edit_Tailgate_License_Plate = new JLabel("Tailgate License Plate: ");
        JLabel label_edit_Tailgate_brand = new JLabel("Tailgate Brand: ");

        JTextField Textfield_Tailgate_License_Plate = new JTextField(edit_truck.get_Tailgate_License_Plate());
        JTextField Textfield_Tailgate_brand = new JTextField(edit_truck.get_Tailgate_Brand());

        JButton Button_edit = new JButton("Edit");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_show_brand.setFont(new Font("Serif", Font.PLAIN, 25));
        label_edit_Tailgate_License_Plate.setFont(new Font("Serif", Font.PLAIN, 20));
        label_edit_Tailgate_brand.setFont(new Font("Serif", Font.PLAIN, 20));

        Textfield_Tailgate_License_Plate.setFont(new Font("Serif", Font.PLAIN, 20));
        Textfield_Tailgate_brand.setFont(new Font("Serif", Font.PLAIN, 20));

        Button_edit.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        north_Panel.add(label_Title);

        center_Panel_North.add(label_show_brand);

        center_Panel_South_North.add(label_edit_Tailgate_License_Plate, BorderLayout.NORTH);
        center_Panel_South_North.add(Textfield_Tailgate_License_Plate, BorderLayout.CENTER);

        center_Panel_South_South.add(label_edit_Tailgate_brand, BorderLayout.NORTH);
        center_Panel_South_South.add(Textfield_Tailgate_brand, BorderLayout.CENTER);

        south_Panel.add(Button_edit);

        //------------------------------------------------------------------------------

        main_Panel.add(north_Panel, BorderLayout.NORTH);

        center_Panel.add(center_Panel_North, BorderLayout.NORTH);

        center_Panel_South.add(center_Panel_South_North, BorderLayout.NORTH);
        center_Panel_South.add(center_Panel_South_South, BorderLayout.CENTER);

        center_Panel.add(center_Panel_South, BorderLayout.CENTER);

        main_Panel.add(center_Panel, BorderLayout.CENTER);

        main_Panel.add(south_Panel, BorderLayout.SOUTH);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 200);

        edit_Truck.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Truck.setResizable(false);
        edit_Truck.setMinimumSize(frameSize);
        edit_Truck.setVisible(true);
        edit_Truck.pack();

        Button_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                edit_truck.change_tailgate_License_Plate(Textfield_Tailgate_License_Plate.getText());
                edit_truck.change_tailgate_Brand(Textfield_Tailgate_brand.getText());

                edit_truck.write();

            }
        });

    }

    public void create_Driver(){

        JFrame new_Driver = new JFrame("WagserCo.");
        new_Driver.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new BorderLayout());
        JPanel south_Panel = new JPanel(new BorderLayout());

        JPanel center_Panel_North = new JPanel(new BorderLayout());
        JPanel center_Panel_Center = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title1 = new JLabel("WagserCo.");
        JButton button_From_new = new JButton("Create New");
        JButton button_Import = new JButton("Import From User");

        //------------------------------------------------------------------------------

        label_Title1.setFont(new Font("Serif", Font.PLAIN, 35));

        button_From_new.setFont(new Font("Serif", Font.PLAIN, 25));
        button_Import.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        north_Panel.add(label_Title1);

        center_Panel_North.add(button_From_new, BorderLayout.CENTER);

        center_Panel_Center.add(button_Import, BorderLayout.CENTER);

        //------------------------------------------------------------------------------

        center_Panel.add(center_Panel_North, BorderLayout.NORTH);
        center_Panel.add(center_Panel_Center, BorderLayout.CENTER);

        main_Panel.add(north_Panel, BorderLayout.NORTH);
        main_Panel.add(center_Panel, BorderLayout.CENTER);

        //------------------------------------------------------------------------------

        new_Driver.add(main_Panel);

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(400, 100);

        new_Driver.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        new_Driver.setResizable(false);
        new_Driver.setMinimumSize(frameSize);
        new_Driver.setVisible(true);
        new_Driver.pack();

        button_From_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new_Driver.dispose();

                run.newPerson();

            }
        });

        button_Import.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new_Driver.dispose();

                run.newDriver();

            }
        });

    }

    public void newPerson(){

        //System.out.println("Testing New Person");

        JFrame first_Login = new JFrame("WagserCo.");
        first_Login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel main_Panel = new JPanel(new BorderLayout());

        JPanel center = new JPanel(new BorderLayout());

        JPanel card_Title = new JPanel();
        JPanel card_Name = new JPanel(new BorderLayout());
        JPanel card_DOB = new JPanel(new BorderLayout());
        JPanel card_Email = new JPanel(new BorderLayout());
        JPanel card_Button = new JPanel(new BorderLayout());


        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel("WagserCo.");
        JLabel label_Name = new JLabel("Name:");
        JLabel label_DOB = new JLabel("Date of Birth:");
        JLabel label_Email = new JLabel("Email:");

        JTextField TextField_Name = new JTextField();
        JTextField TextField_DOB = new JTextField();
        JTextField TextField_Email = new JTextField();

        JButton Button_Create = new JButton("Create");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_Name.setFont(new Font("Serif", Font.PLAIN, 20));
        label_DOB.setFont(new Font("Serif", Font.PLAIN, 20));
        label_Email.setFont(new Font("Serif", Font.PLAIN, 20));

        Button_Create.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        card_Title.add(label_Title);

        card_Name.add(label_Name, BorderLayout.NORTH);
        card_DOB.add(label_DOB, BorderLayout.NORTH);
        card_Email.add(label_Email, BorderLayout.NORTH);
        card_Name.add(TextField_Name, BorderLayout.CENTER);
        card_DOB.add(TextField_DOB, BorderLayout.CENTER);
        card_Email.add(TextField_Email, BorderLayout.CENTER);

        center.add(card_Name, BorderLayout.NORTH);
        center.add(card_DOB, BorderLayout.CENTER);
        center.add(card_Email, BorderLayout.SOUTH);

        card_Button.add(Button_Create);

        main_Panel.add(card_Title, BorderLayout.NORTH);
        main_Panel.add(center, BorderLayout.CENTER);
        main_Panel.add(card_Button, BorderLayout.SOUTH);

        first_Login.getContentPane().add(main_Panel);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 250);

        first_Login.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        first_Login.setResizable(false);
        first_Login.setMinimumSize(frameSize);
        first_Login.setVisible(true);
        first_Login.pack();

        Button_Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String file_User = TextField_Name + ".txt";

                File file2 = new File(System.getProperty("user.dir") + "/user/" + file_User);

                try {

                    FileWriter fileWriter =
                            new FileWriter(file2, true);

                    BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);


                    bufferedWriter.newLine();
                    bufferedWriter.write("Person File:");
                    bufferedWriter.newLine();
                    bufferedWriter.write(TextField_Name.getText() + ".txt");


                    bufferedWriter.close();
                } catch (IOException ex) {
                    System.out.println(
                            "Error writing to file '"
                                    + file_User + "'");

                }

                String[] files = new String[8];
                String file_Name = TextField_Name.getText() + ".txt";

                File file = new File(System.getProperty("user.dir") + "/person/" + file_Name);

                try {

                    FileWriter fileWriter2 =
                            new FileWriter(file);

                    BufferedWriter bufferedWriter2 =
                            new BufferedWriter(fileWriter2);

                    bufferedWriter2.write("Person Information:");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("-----------------------------");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("Name:");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(TextField_Name.getText());
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("Date of Birth:");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(TextField_DOB.getText());
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("Email:");
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(TextField_Email.getText());

                    bufferedWriter2.close();

                    first_Login.dispose();
                } catch (IOException ex) {


                }

                driver newDriver = new driver(file);

            }
        });
    }

    public void newDriver(){

        String temp;
        String temp2;

        File folder = new File(System.getProperty("user.dir") + "/person");
        File[] listOfFiles = folder.listFiles();

        final DefaultListModel truckList = new DefaultListModel();

        for (int i = 0; i < listOfFiles.length; i++){

            temp = listOfFiles[i].getName();
            temp2 = temp.replace(".txt", "");

            truckList.addElement(temp2);

        }

        //------------------------------------------------------------------------------

        JFrame edit_Truck = new JFrame("WagserCo.");
        edit_Truck.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        edit_Truck.getContentPane().add(main_Panel);

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new FlowLayout());
        JPanel south_Panel = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel("WagserCo.");
        JLabel label_Title1 = new JLabel("Create Driver From:");

        JList list_Truck = new JList(truckList);

        JButton button_Edit = new JButton("Create");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_Title1.setFont(new Font("Serif", Font.PLAIN, 25));

        list_Truck.setFont(new Font("Serif", Font.PLAIN, 17));

        button_Edit.setFont(new Font("Serif", Font.PLAIN, 25));

        list_Truck.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_Truck.setVisibleRowCount(5);
        list_Truck.setLayoutOrientation(JList.VERTICAL);
        list_Truck.setSelectedIndex(0);

        JScrollPane scroll = new JScrollPane(list_Truck);


        //------------------------------------------------------------------------------

        north_Panel.add(label_Title);
        //north_Panel.add(label_Title1, BorderLayout.SOUTH);

        center_Panel.add(scroll);
        center_Panel.add(button_Edit);
        center_Panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        //south_Panel.add(button_Edit);

        //------------------------------------------------------------------------------

        main_Panel.add(north_Panel, BorderLayout.NORTH);
        main_Panel.add(center_Panel, BorderLayout.CENTER);
        main_Panel.add(south_Panel, BorderLayout.SOUTH);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(200, 200);

        edit_Truck.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Truck.setResizable(false);
        edit_Truck.setMinimumSize(frameSize);
        edit_Truck.setVisible(true);
        edit_Truck.pack();

        button_Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int truck_LP_int = list_Truck.getSelectedIndex();
                File truck_file = listOfFiles[truck_LP_int];
                //String truck_file_name = truck_file.getName().replace(".txt", "");

                person temp = new person(truck_file);

                driver newDriver = new driver(temp);

                edit_Truck.dispose();

            }
        });

    }

    public void edit_Driver(){

        String temp;
        String temp2;

        File folder = new File(System.getProperty("user.dir") + "/driver");
        File[] listOfFiles = folder.listFiles();

        final DefaultListModel truckList = new DefaultListModel();

        for (int i = 0; i < listOfFiles.length; i++){

            temp = listOfFiles[i].getName();
            temp2 = temp.replace(".txt", "");

            truckList.addElement(temp2);

        }

        //------------------------------------------------------------------------------

        JFrame edit_Truck = new JFrame("WagserCo.");
        edit_Truck.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());

        edit_Truck.getContentPane().add(main_Panel);

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new FlowLayout());
        JPanel south_Panel = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel("WagserCo.");
        JLabel label_Title1 = new JLabel("Edit Driver");

        JList list_Truck = new JList(truckList);

        JButton button_Edit = new JButton("Edit");

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
        label_Title1.setFont(new Font("Serif", Font.PLAIN, 25));

        list_Truck.setFont(new Font("Serif", Font.PLAIN, 17));

        button_Edit.setFont(new Font("Serif", Font.PLAIN, 25));

        list_Truck.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_Truck.setVisibleRowCount(5);
        list_Truck.setLayoutOrientation(JList.VERTICAL);
        list_Truck.setSelectedIndex(0);

        JScrollPane scroll = new JScrollPane(list_Truck);


        //------------------------------------------------------------------------------

        north_Panel.add(label_Title);
        //north_Panel.add(label_Title1, BorderLayout.SOUTH);

        center_Panel.add(scroll);
        center_Panel.add(button_Edit);
        center_Panel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

        //south_Panel.add(button_Edit);

        //------------------------------------------------------------------------------

        main_Panel.add(north_Panel, BorderLayout.NORTH);
        main_Panel.add(center_Panel, BorderLayout.CENTER);
        main_Panel.add(south_Panel, BorderLayout.SOUTH);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(200, 200);

        edit_Truck.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Truck.setResizable(false);
        edit_Truck.setMinimumSize(frameSize);
        edit_Truck.setVisible(true);
        edit_Truck.pack();

        button_Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int truck_LP_int = list_Truck.getSelectedIndex();
                File truck_file = listOfFiles[truck_LP_int];
                //String truck_file_name = truck_file.getName().replace(".txt", "");

                driver temp = new driver(truck_file);

                run.edit_Driver_step2(temp);

                edit_Truck.dispose();

            }
        });

    }

    public void edit_Driver_step2(driver edit_driver){

        JFrame edit_Truck = new JFrame("WagserCo.");
        edit_Truck.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel main_Panel = new JPanel(new BorderLayout());
        edit_Truck.getContentPane().add(main_Panel);

        JPanel north_Panel = new JPanel();
        JPanel center_Panel = new JPanel(new BorderLayout());
        JPanel south_Panel = new JPanel();

        JPanel center_Panel_North = new JPanel();
        JPanel center_Panel_South = new JPanel(new BorderLayout());
        JPanel center_Panel_South_North = new JPanel(new BorderLayout());
        JPanel center_Panel_South_South = new JPanel(new BorderLayout());

        //------------------------------------------------------------------------------

        JLabel label_Title = new JLabel(edit_driver.get_Person_info().get_name());

        JLabel label_edit_Tailgate_License_Plate = new JLabel("Truck:");

        String temp3;
        String temp2;

        File folder = new File(System.getProperty("user.dir") + "/truck");
        File[] listOfFiles = folder.listFiles();

        final DefaultListModel truckList = new DefaultListModel();

        for (int i = 0; i < listOfFiles.length; i++){

            temp3 = listOfFiles[i].getName();
            temp2 = temp3.replace(".txt", "");

            truckList.addElement(temp2);

        }

        JList list_Truck = new JList(truckList);

        JButton Button_edit = new JButton("Edit");

        list_Truck.setFont(new Font("Serif", Font.PLAIN, 17));

        list_Truck.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_Truck.setVisibleRowCount(5);
        list_Truck.setLayoutOrientation(JList.VERTICAL);
        list_Truck.setSelectedIndex(0);

        JScrollPane scroll = new JScrollPane(list_Truck);

        //------------------------------------------------------------------------------

        label_Title.setFont(new Font("Serif", Font.PLAIN, 35));

        label_edit_Tailgate_License_Plate.setFont(new Font("Serif", Font.PLAIN, 20));

        Button_edit.setFont(new Font("Serif", Font.PLAIN, 25));

        //------------------------------------------------------------------------------

        north_Panel.add(label_Title);

        center_Panel_South_North.add(label_edit_Tailgate_License_Plate, BorderLayout.NORTH);
        center_Panel_South_North.add(scroll, BorderLayout.CENTER);

        south_Panel.add(Button_edit);

        //------------------------------------------------------------------------------

        main_Panel.add(north_Panel, BorderLayout.NORTH);

        center_Panel.add(center_Panel_North, BorderLayout.NORTH);

        center_Panel_South.add(center_Panel_South_North, BorderLayout.NORTH);
        center_Panel_South.add(center_Panel_South_South, BorderLayout.CENTER);

        center_Panel.add(center_Panel_South, BorderLayout.CENTER);

        main_Panel.add(center_Panel, BorderLayout.CENTER);

        main_Panel.add(south_Panel, BorderLayout.SOUTH);

        //------------------------------------------------------------------------------

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(500, 200);

        edit_Truck.setBounds(ss.width / 2 - frameSize.width / 2,
                ss.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);

        edit_Truck.setResizable(false);
        edit_Truck.setMinimumSize(frameSize);
        edit_Truck.setVisible(true);
        edit_Truck.pack();

        Button_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int truck_LP_int = list_Truck.getSelectedIndex();
                File truck_file = listOfFiles[truck_LP_int];
                //String truck_file_name = truck_file.getName().replace(".txt", "");

                System.out.println("works");

                truck temper = new truck(truck_file);

                //System.out.println(temper.get_License_Plate());

                edit_driver.change_Truck_Info(temper);

                edit_driver.write(edit_driver);

                edit_Truck.dispose();

            }
        });

    }

}