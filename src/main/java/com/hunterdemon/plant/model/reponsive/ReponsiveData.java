package com.hunterdemon.plant.model.reponsive;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
public class ReponsiveData {

    private String message;
    private String error;
    private Object result;


}
