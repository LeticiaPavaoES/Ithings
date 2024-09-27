package br.com.ithings.dto; /*dto-> data transfer object, ela serve para transferir dados de uma camada para a outra */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDto {

    private long id;
    private String name;
    private String state;

    public String getFullName(){
        return name + "/" + state;
    }

}