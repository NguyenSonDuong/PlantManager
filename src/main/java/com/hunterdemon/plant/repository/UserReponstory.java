package com.hunterdemon.plant.repository;

import com.hunterdemon.plant.model.UserInfor;
import com.hunterdemon.plant.model.reponsive.ReponsiveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface UserReponstory extends JpaRepository<UserInfor, Integer> {

    @Query(value = "SELECT * FROM userinfor  WHERE username = ?1 AND pass = ?2", nativeQuery = true)
    public ArrayList<UserInfor> CheckLogin(String username, String pass);

    @Modifying
    @Query(value = "UPDATE userinfor SET firstname = ?1, lastname = ?2, birthday = ?3, sex = ?4, address = ?5, phonenumber = ?6 WHERE username = ?7",nativeQuery = true)
    public ReponsiveData UpdateInforUser(String firstname, String lastname, Date birthday, String sex, String address, String phonenumber, String username);

    @Query(value = "SELECT * FROM userinfor  WHERE username = ?1", nativeQuery = true)
    public ArrayList<UserInfor> GetUserByUsername(String username);

    @Query(value = "SELECT * FROM userinfor  WHERE phonenumber = ?1", nativeQuery = true)
    public ArrayList<UserInfor> GetUserByPhoneNumber(String phonenumber);

    @Query(value = "SELECT * FROM userinfor  WHERE firstname = ?1", nativeQuery = true)
    public ArrayList<UserInfor> GetUserByFirstName(String firstname);

    @Query(value = "SELECT * FROM userinfor  WHERE lasttname = ?1", nativeQuery = true)
    public ArrayList<UserInfor> GetUserByLastName(String lasttname);

    @Query(value = "SELECT * FROM userinfor  WHERE sex = ?1", nativeQuery = true)
    public ArrayList<UserInfor> GetUserBySex(String sex);


}
