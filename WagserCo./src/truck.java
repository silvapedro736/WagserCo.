import java.io.*;

/**
 * Created by pedrosilva on 4/25/16.
 */
public class truck {

    String brand;
    String license_Plate;
    String tailgate_Brand;
    String tailgate_License_Plate;


    public truck(String brand, String license_Plate){

        this.brand = brand;
        this.license_Plate = license_Plate;

        this.tailgate_License_Plate = "null";
        this.tailgate_Brand = "null";

        String file_User = license_Plate + ".txt";

        File file2 = new File(System.getProperty("user.dir") + "/truck/" + file_User);

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

            bufferedWriter2.write("Truck Information:");
            bufferedWriter2.newLine();
            bufferedWriter2.write("-----------------------------");
            bufferedWriter2.newLine();
            bufferedWriter2.write("License Plate");
            bufferedWriter2.newLine();
            bufferedWriter2.write(license_Plate);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Brand");
            bufferedWriter2.newLine();
            bufferedWriter2.write(brand);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Tailgate License Plate");
            bufferedWriter2.newLine();
            bufferedWriter2.write(tailgate_License_Plate);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Tailgate Brand");
            bufferedWriter2.newLine();
            bufferedWriter2.write(tailgate_Brand);

            bufferedWriter2.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + file_User + "'");

        }

    }

    public truck(File truck_file){

        BufferedReader reader = null;

        String[] files = new String[10];

        try {

            File file = truck_file;

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

        this.brand = files[5];
        this.license_Plate = files[3];

        this.tailgate_License_Plate = files[7];
        this.tailgate_Brand = files[9];

    }

    public void change_Brand(String brand){

        this.brand = brand;

    }

    public void changed_License_Plate(String license_Plate){

        this.license_Plate = license_Plate;

    }

    public String get_Brand(){

        return this.brand;

    }

    public String get_License_Plate(){

        return this.license_Plate;

    }

    //------------------------------------------------------------------

    public void change_tailgate_Brand(String tailgate_Brand){

        this.tailgate_Brand = tailgate_Brand;

    }

    public void change_tailgate_License_Plate(String tailgate_License_Plate){

        this.tailgate_License_Plate = tailgate_License_Plate;

    }

    public String get_Tailgate_Brand(){

        return this.tailgate_Brand;

    }

    public String get_Tailgate_License_Plate(){

        return this.tailgate_License_Plate;

    }

    public void write(){

        String file_User = license_Plate + ".txt";

        File file2 = new File(System.getProperty("user.dir") + "/truck/" + file_User);

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

            bufferedWriter2.write("Truck Information:");
            bufferedWriter2.newLine();
            bufferedWriter2.write("-----------------------------");
            bufferedWriter2.newLine();
            bufferedWriter2.write("License Plate");
            bufferedWriter2.newLine();
            bufferedWriter2.write(license_Plate);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Brand");
            bufferedWriter2.newLine();
            bufferedWriter2.write(brand);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Tailgate License Plate");
            bufferedWriter2.newLine();
            bufferedWriter2.write(tailgate_License_Plate);
            bufferedWriter2.newLine();
            bufferedWriter2.write("Tailgate Brand");
            bufferedWriter2.newLine();
            bufferedWriter2.write(tailgate_Brand);

            bufferedWriter2.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + file_User + "'");

        }

    }

}
