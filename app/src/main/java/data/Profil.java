package data;

/**
 * Created by anders on 13-03-2016.
 */
public class Profil {

    public int profilId;            //Identification of the profil

    public String firstName;        //First name of the Profil
    public String lastName;         //Last name of the Profil
    public String email;            //E-mail of the Profil
    public String address;          //Full address of the Profil
    public String country;          //The Country of the Profil
    public String picURL;           //URL for the profilpicture

    public int arealCode;           //Arealcode, for now postalcode, might be something different later on
  //  public short specialFood;       //Special foods for this profil, 0 = omni, 1 = vegetar, 2 = veganer

    public Profil(){
        String firstName = "Anders";
        String lastName = "Larsen";
    }

    public Profil(int profilId, String firstName, String lastName, String email, String address, String country, String picURL, int arealCode, short specialFood){
        this.profilId = profilId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.country = country;
        this.picURL = picURL;
        this.arealCode = arealCode;
    //    this.specialFood = specialFood;
    }
}
