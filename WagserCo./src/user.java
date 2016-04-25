import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pedrosilva on 4/25/16.
 */
public class user {

    String username;
    String password;
    Boolean admin;
    person person_info;

    public user(String username, String password, Boolean admin, person person_info){

        String pass = null;
        try {
            String passer = new String(password);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passer.getBytes());
            pass = new String(new sun.misc.BASE64Encoder().encode(md.digest()));
        } catch (NoSuchAlgorithmException f) {
            System.out.println(f);
        }

        this.username = username;
        this.password = pass;
        this.admin = admin;
        this.person_info = person_info;

    }

    public void change_username(String username){

        this.username = username;

    }

    public void change_password(String password){

        String pass = null;
        try {
            String passer = new String(password);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passer.getBytes());
            pass = new String(new sun.misc.BASE64Encoder().encode(md.digest()));
        } catch (NoSuchAlgorithmException f) {
            System.out.println(f);
        }

        this.password = pass;


    }

    public void change_admin(Boolean admin){

        this.admin = admin;

    }

    public void change_person_info(person person_info){

        this.person_info = person_info;

    }

    public String get_Username(){

        return this.username;

    }

    public Boolean get_admin(){

        return this.admin;

    }

    public person get_Person_info(){

        return this.person_info;

    }

}
