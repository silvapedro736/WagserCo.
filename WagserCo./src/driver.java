/**
 * Created by pedrosilva on 4/25/16.
 */
public class driver {

    person person_info;
    truck truck_info;

    public driver(person person_info, truck truck_info){

        this.person_info = person_info;
        this.truck_info = truck_info;

    }

    public void change_Person_Info(person person_info){

        this.person_info = person_info;

    }

    public void change_Truck_Info(truck truck_info){

        this.truck_info = truck_info;

    }

    public person get_Person_info(){

        return this.person_info;

    }

    public truck get_Truck_info(){

        return truck_info;

    }

}
