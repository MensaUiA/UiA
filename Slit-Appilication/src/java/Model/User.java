/**
 * Created by Basse.
 */
package Model;

import javafx.beans.property.*;

public class User {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }



    private StringProperty lastName = new SimpleStringProperty(this, "lastName", "");

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }




    private StringProperty status = new SimpleStringProperty(this, "status", "");

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

}
