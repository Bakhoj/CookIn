package data;

import com.facebook.Profile;

/**
 * Created by anders on 10-05-2016.
 */
public class Users {

    private String userID;
    private String firstName, lastName, fullName, facebookUri, profilPicUri;

    public Users(){
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getProfilPicUri() {
        return profilPicUri;
    }

    public void setProfilPicUri(String profilPicUri) {
        this.profilPicUri = profilPicUri;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFacebookUri() {
        return facebookUri;
    }

    public void setFacebookUri(String facebookUri) {
        this.facebookUri = facebookUri;
    }
}
