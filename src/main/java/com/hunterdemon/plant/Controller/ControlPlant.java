package com.hunterdemon.plant.Controller;


import com.hunterdemon.plant.model.UserInfor;
import com.hunterdemon.plant.model.reponsive.ReponsiveData;
import com.hunterdemon.plant.repository.UserReponstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ControlPlant {

    @Autowired
    UserReponstory userReponstory;

    @RequestMapping(value = "/registration",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object Registeation(@RequestParam("username") String username, @RequestParam("pass") String pass){
        UserInfor userInfor = new UserInfor(1,username,AcctionControl.getMD5(pass),"","",null,"","","");
        ReponsiveData reponsiveData = ReponsiveData.of();
        try {
            ArrayList<UserInfor> lis = userReponstory.GetUserByUsername(username);
            if(lis.size()>0){
                reponsiveData.setMessage("Tên đăng nhập đã tồn tại");
                reponsiveData.setError("1");
                reponsiveData.setResult(null);
            }else {
                userReponstory.save(userInfor);
                reponsiveData.setResult(userInfor);
                reponsiveData.setMessage("Thành công");
                reponsiveData.setError("0");
            }

            return reponsiveData;
        }catch (Exception e){
            reponsiveData.setMessage(e.getMessage());
            reponsiveData.setError("1");
            return  reponsiveData;
        }
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object GetUser(@RequestParam("username") String username, @RequestParam("pass") String pass){
        ReponsiveData reponsiveData = ReponsiveData.of();
        try {
            List<UserInfor> lis = userReponstory.CheckLogin(username,AcctionControl.getMD5(pass));
            if(lis.size()>0){
                reponsiveData.setResult(lis.get(0));
                reponsiveData.setMessage("Thành công");
                reponsiveData.setError("0");
                return reponsiveData;
            }else {
                reponsiveData.setResult(null);
                reponsiveData.setMessage("Tên tài khoản hoặc mật khẩu không chính xác");
                reponsiveData.setError("1");
                return reponsiveData;
            }

        }catch (Exception e){
            reponsiveData.setMessage(e.getMessage());
            reponsiveData.setError("1");
            return  reponsiveData;
        }

    }
    
    @RequestMapping(value = "/updateinfor",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object UpdateUser(@RequestBody UserInfor infor){
        ReponsiveData reponsiveData = ReponsiveData.of();
        try{
            userReponstory.UpdateInforUser(infor.getFirstname(),infor.getLastname(),infor.getBirthday(),infor.getSex(), infor.getAddress(),infor.getPhonenumber(),infor.getUsername());
            reponsiveData.setMessage("Thành công");
            reponsiveData.setError("0");
            reponsiveData.setResult(null);
            return reponsiveData;
        }catch (Exception e){
            reponsiveData.setMessage(e.getMessage());
            reponsiveData.setError("1");
            reponsiveData.setResult(null);
            return  reponsiveData;
        }

    }

}
