import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pedrosilva on 4/18/16.
 */
public class initializer {

    public static initializer run = new initializer();

    public static void main(String args[]) {

        run.init_properties();

    }

    public void init_properties() {


        String file_Name = "info_logs.txt";

        String thisline = null;

        try {

            FileReader fileReader =
                    new FileReader(file_Name);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);


            //System.out.println(line);

            //------------------------------------------------------------------------------

            JFrame Login = new JFrame("WagserCo.");

            Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
            JPasswordField PasswordField_Password = new JPasswordField();

            JButton Button_Login = new JButton("Login");

            //------------------------------------------------------------------------------

            label_Title.setFont(new Font("Serif", Font.PLAIN, 35));
            label_Username.setFont(new Font("Serif", Font.PLAIN, 20));
            label_Password.setFont(new Font("Serif", Font.PLAIN, 20));

            Button_Login.setFont(new Font("Serif", Font.PLAIN, 25));

            //------------------------------------------------------------------------------

            card_Title.add(label_Title);

            card_Username.add(label_Username, BorderLayout.NORTH);
            card_Password.add(label_Password, BorderLayout.NORTH);
            card_Username.add(TextField_Username, BorderLayout.CENTER);
            card_Password.add(PasswordField_Password, BorderLayout.CENTER);

            center.add(card_Username, BorderLayout.NORTH);
            center.add(card_Password, BorderLayout.CENTER);

            card_Button.add(Button_Login);

            main_Panel.add(card_Title, BorderLayout.NORTH);
            main_Panel.add(center, BorderLayout.CENTER);
            main_Panel.add(card_Button, BorderLayout.SOUTH);

            Login.getContentPane().add(main_Panel);

            //------------------------------------------------------------------------------

            Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = new Dimension(500, 200);

            Login.setBounds(ss.width / 2 - frameSize.width / 2,
                    ss.height / 2 - frameSize.height / 2,
                    frameSize.width, frameSize.height);

            Login.setResizable(false);
            Login.setMinimumSize(frameSize);
            Login.setVisible(true);
            Login.pack();

            //------------------------------------------------------------------------------

            String[] file = new String[2];
            final int[] num = {0};

            Button_Login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String pass = null;
                    try {
                        String passer = new String(PasswordField_Password.getPassword());
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        md.update(passer.getBytes());
                        pass = new String(new sun.misc.BASE64Encoder().encode(md.digest()));
                    } catch (NoSuchAlgorithmException f) {
                        System.out.println(f);
                    }

                    run.login(TextField_Username.getText(), pass, Login);

                }
            });


            bufferedReader.close();

        } catch (FileNotFoundException ex) {

            properties_make();

        } catch (IOException e) {

            System.out.println(
                    "Error reading file '"
                            + file_Name + "'");

        }

    }

    public void properties_make() {

        /**

        main_menu main_m = new main_menu();

        File dir = new File("user");
        dir.mkdir();

        main_m.create_Account();

         */

        File dir = new File("user");
        dir.mkdir();

        File dirs = new File("person");
        dirs.mkdir();

        String file_Name = "info_logs.txt";

        File file = new File(System.getProperty("user.dir") + file_Name);


        //------------------------------------------------------------------------------


        try {

            file.createNewFile();

        } catch (IOException e) {

            e.printStackTrace();

        }

        //------------------------------------------------------------------------------

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
                            new FileWriter(file_Name);

                    BufferedWriter bufferedWriter =
                            new BufferedWriter(fileWriter);

                    bufferedWriter.write("Login Information:");
                    bufferedWriter.newLine();
                    bufferedWriter.write("-----------------------------");
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
                    bufferedWriter2.write("true");

                    bufferedWriter2.close();
                } catch (IOException ex) {
                    System.out.println(
                            "Error writing to file '"
                                    + file_User + "'");

                }

                //------------------------------------------------------------

                make_Properties.dispose();

            }

        });


    }

    public Boolean check_first = true;

    public void login(String user, String pass, JFrame a) {

        boolean bool_Admin = false;

        BufferedReader reader = null;

        int count = 0;


        try {

            File file = new File("info_logs.txt");

            reader = new BufferedReader(new FileReader(file));

            String line;



            while ((line = reader.readLine()) != null) {

                count++;

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

        String[] files = new String[count];

        try {

            File file = new File("info_logs.txt");

            reader = new BufferedReader(new FileReader(file));

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

        for (int i = 0; i < count; i++){

            if (files[i].equals(user)){




                if (i == (count-1)){



                } else if (files[i+1].equals(pass)){

                    String file_Name = user + ".txt";

                    File file = new File(System.getProperty("user.dir") + "/person/" + file_Name);

                    BufferedReader reader2 = null;

                    int count2 = 0;

                    String[] file_user_info = new String[8];

                    try {

                        File file3 = new File(System.getProperty("user.dir") + "/user/" + user + ".txt");

                        reader2 = new BufferedReader(new FileReader(file3));

                        String line;

                        while ((line = reader2.readLine()) != null) {

                            file_user_info[count2] = line;
                            count2++;

                        }

                    } catch (IOException f) {

                        f.printStackTrace();

                    } finally {
                        try {
                            reader2.close();
                        } catch (IOException f) {
                            f.printStackTrace();
                        }


                    }

                    //work HERE!

                    if (count2 < 7) {

                        check_first = false;
                        a.dispose();
                        run.first_login(user, pass);
                        //while(!check_first){}

                    } else {

                        BufferedReader reader3 = null;

                        String[] files2 = new String[8];

                        try {

                            File file2 = new File(System.getProperty("user.dir") + "/person/" + file_user_info[6]);

                            reader3 = new BufferedReader(new FileReader(file2));

                            String line;

                            int count3 = 0;

                            while ((line = reader3.readLine()) != null) {

                                files2[count3] = line;

                                count3++;

                            }

                        } catch (IOException f) {

                            f.printStackTrace();

                        }

                        finally {

                            try {

                                reader3.close();

                            } catch (IOException f) {

                                f.printStackTrace();

                            }

                        }

                        if (file_user_info[4].equals("true")){

                            bool_Admin = true;

                        }

                        person current_Person = new person(files2[3], files2[5]);

                        current_Person.change_email(files2[7]);

                        user current_User = new user(user, pass, bool_Admin, current_Person);

                        String[] args = new String[1];
                        args[0] = user;
                        main_menu.main(args, current_Person, current_User);
                        a.dispose();

                    }

                }

            }

        }



    }

    public void first_login(String user, String pass){

        final boolean[] bool_Admin = {false};

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

        JButton Button_Create = new JButton("Login");

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

        Button_Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String file_User = user + ".txt";

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
                } catch (IOException ex) {
                    System.out.println(
                            "Error writing to file '"
                                    + file + "'");

                }

                BufferedReader reader = null;

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

                BufferedReader readerss = null;

                BufferedReader reader2 = null;

                int count = 0;


                try {

                    File file_user_info = new File(System.getProperty("user.dir") + "/user/"+ user +".txt");

                    reader2 = new BufferedReader(new FileReader(file_user_info));

                    String line;



                    while ((line = reader2.readLine()) != null) {

                        count++;

                    }

                } catch (IOException h) {

                    h.printStackTrace();

                } finally {
                    try {
                        reader2.close();
                    } catch (IOException h) {
                        h.printStackTrace();
                    }


                }

                try {

                    File file_user_info = new File(System.getProperty("user.dir") + "/user/"+ user +".txt");

                    readerss = new BufferedReader(new FileReader(file_user_info));

                    String line;



                    int f = 0;

                    while ((line = readerss.readLine()) != null) {

                        filesss[f] = line;

                        f++;

                    }

                } catch (IOException g) {

                    g.printStackTrace();

                } finally {
                    try {
                        readerss.close();
                    } catch (IOException g) {
                        g.printStackTrace();
                    }


                }

                if (files[4].equals("true")){

                    bool_Admin[0] = true;

                }

                person current_Person = new person(files[3], files[5]);

                current_Person.change_email(files[7]);

                String[] args = new String[1];
                args[0] = user;

                user current_User = new user(user, pass, bool_Admin[0], current_Person);

                main_menu.main(args, current_Person, current_User);

                first_Login.dispose();

            }
        });

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

    }

}


