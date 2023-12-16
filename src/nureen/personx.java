package nureen;

import java.util.*;

public class personx {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String username;
    private int password;
    String firstname;
    String lastname;
    private String email;
    static int basic_counter, standard_counter, premium_counter;


    personx(int id, String username, int password, String firstname, String lastname, String email) {
         this.id=id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    personx( String username, int password, String firstname, String lastname, String email) {

        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }}