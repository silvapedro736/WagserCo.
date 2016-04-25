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

}
