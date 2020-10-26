package com.hunterdemon.plant.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor(staticName = "of")
@Entity
@Table(name = "userinfor")
public class UserInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int ID;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String pass;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "address")
    private String address;

    @Column(name = "phonenumber")
    private String phonenumber;

    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public UserInfor(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public UserInfor(String username, String pass, String firstname, String lastname, Date birthday, String sex, String address, String phonenumber) {
        this.username = username;
        this.pass = pass;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public UserInfor(int ID, String username, String pass, String firstname, String lastname, Date birthday, String sex, String address, String phonenumber) {
        this.ID = ID;
        this.username = username;
        this.pass = pass;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "UserInfor{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
