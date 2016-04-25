/**
 * Created by pedrosilva on 4/25/16.
 */
public class truck {

    String brand;
    String license_Plate;

    public truck(String brand, String license_Plate){

        this.brand = brand;
        this.license_Plate = license_Plate;

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

}
