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
        make_Properties.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

                make_Properties.dispose();

            }

        });


    }

    public void login(String user, String pass, JFrame a) {

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

                    String[] args = new String[1];
                    args[0] = user;
                    main_menu.main(args);
                    a.dispose();


                }

            }

        }



    }
}


