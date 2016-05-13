import java.io.*;

/**
 * Created by pedrosilva on 4/25/16.
 */
public class driver {

    String person_info;
    String truck_info;

    public driver(person person_info) {

        this.person_info = person_info.get_name();

        String file_User = person_info.get_name() + ".txt";

        File file2 = new File(System.getProperty("user.dir") + "/driver/" + file_User);

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

            bufferedWriter2.write("Driver Information:");
            bufferedWriter2.newLine();
            bufferedWriter2.write("-----------------------------");
            bufferedWriter2.newLine();
            bufferedWriter2.write("Person Info");
            bufferedWriter2.newLine();
            bufferedWriter2.write(person_info.get_name() + ".txt");
            bufferedWriter2.newLine();
            bufferedWriter2.write("Truck Info");
            bufferedWriter2.newLine();
            bufferedWriter2.write("null");


            bufferedWriter2.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + file_User + "'");

        }

    }

    public driver(File Driver_Info){

        BufferedReader reader = null;

        String[] files = new String[6];

        try {

            File file = Driver_Info;

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

        this.person_info = files[3];

        this.truck_info = files[5];

    }

    public void change_Person_Info(person person_info){

        this.person_info = person_info.get_name();

    }

    public void change_Truck_Info(truck truck_info){

        this.truck_info = truck_info.license_Plate;

    }

    public person get_Person_info(){

        File person_Info = new File(System.getProperty("user.dir") + "/person/" + person_info );

        return new person(person_Info);

    }

    public truck get_Truck_info(){

        File file_TruckInfo = new File(System.getProperty("user.dir") + "/truck/" + truck_info + ".txt");

        return new truck(file_TruckInfo);

    }

    public void write(driver driver){

        String file_User = driver.get_Person_info().get_name() + ".txt";

        File file2 = new File(System.getProperty("user.dir") + "/driver/" + file_User);

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

            bufferedWriter2.write("Driver Information:");
            bufferedWriter2.newLine();
            bufferedWriter2.write("-----------------------------");
            bufferedWriter2.newLine();
            bufferedWriter2.write("Person Info");
            bufferedWriter2.newLine();
            bufferedWriter2.write(driver.get_Person_info().get_name() + ".txt");
            bufferedWriter2.newLine();
            bufferedWriter2.write("Truck Info");
            bufferedWriter2.newLine();
            bufferedWriter2.write(driver.get_Truck_info().get_License_Plate() + ".txt");


            bufferedWriter2.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + file_User + "'");

        }

    }

}
