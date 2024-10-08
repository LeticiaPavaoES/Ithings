package br.com.ithings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private long id;
    private String fullName;
    private String gender;
    private Date birthDate;
    private CityDto city;

    public String getFullName(){
        return fullName + "/" + gender;
    }
}
