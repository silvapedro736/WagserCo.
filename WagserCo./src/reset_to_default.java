/**
 * Created by pedrosilva on 5/2/16.
 */

import java.io.File;

public class reset_to_default {

    public static void main(String[] args){

        try{

            File file = new File(System.getProperty("user.dir")  + "/info_logs.txt");
            File file2 = new File(System.getProperty("user.dir") + "/user");
            File file3 = new File(System.getProperty("user.dir") + "/person");
            File file4 = new File(System.getProperty("user.dir") + "/report");
            File file5 = new File(System.getProperty("user.dir") + "/driver");
            File file6 = new File(System.getProperty("user.dir") + "/truck");


            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

            if(file2.delete()){
                System.out.println(file2.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

            if(file3.delete()){
                System.out.println(file3.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

            if(file4.delete()){
                System.out.println(file4.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

            if(file5.delete()){
                System.out.println(file5.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

            if(file6.delete()){
                System.out.println(file6.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
