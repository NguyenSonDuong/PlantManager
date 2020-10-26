package com.hunterdemon.plant.detail;

import com.hunterdemon.plant.model.UserInfor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserDatail implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int ID;

    private String username;

    private String pass;

    private String firstname;

    private String lastname;

    private Date birthday;

    private String sex;

    private String address;

    private String phonenumber;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDatail(int ID, String username, String pass, String firstname, String lastname, Date birthday, String sex, String address, String phonenumber,
                      Collection<? extends GrantedAuthority> authorities) {
        this.ID = ID;
        this.username = username;
        this.pass = pass;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phonenumber = phonenumber;
        this.authorities = authorities;
    }

    public UserDatail() {
    }

    public static UserDatail build(UserInfor account) {
        List<GrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new UserDatail(
                account.getID(),
                account.getUsername(),
                account.getPass(),
                account.getFirstname(),
                account.getLastname(),
                account.getBirthday(),
                account.getSex(),
                account.getAddress(),
                account.getPhonenumber(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public int getID() {
        return ID;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    public void removePassword(){
        this.pass = null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
