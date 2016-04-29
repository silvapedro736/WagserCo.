import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pedrosilva on 4/25/16.
 */
public class person {

    String name;
    String dob;

    String email;

    public person(String name, String dob){

        this.name = name;
        this.dob = dob;

    }

    public void change_name(String name){

        this.name = name;

    }

    public void change_dob(String dob){

        this.dob = dob;

    }

    public String get_name(){

        return this.name;

    }

    public String get_Dob(){

        return this.dob;

    }

    //------------------------------------------------------------

    public void change_email(String email){

        this.email = email;

    }

    public String get_email(){

        return this.email;

    }

    public void write(person person){

        String write_Name = person.get_name();
        String write_DOB = person.get_Dob();
        String write_Email = person.get_email();

        String file_Name = person.get_name() + ".txt";

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
            bufferedWriter2.write(write_Name);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Date of Birth:");
            bufferedWriter2.newLine();
            bufferedWriter2.write(write_DOB);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Email:");
            bufferedWriter2.newLine();
            bufferedWriter2.write(write_Email);

            bufferedWriter2.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + file + "'");

        }

    }

}
