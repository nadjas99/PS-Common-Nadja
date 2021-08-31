/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nadja
 */
public class Client implements GenericEntity{
    
    
    private String name;
    private String surname;
    private String adress;
    private String email;
    private Long id;

    public Long getId() {
        return id;
    }
   
    

    public Client() {
    }
    

    public Client(Long id, String name, String surname, String adress, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.email = email;
    }

    @Override
    public String toString() {
        return  name + " " + surname ;
    }

   
    
   
    @Override
    public String getTableName() {
        return "client";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name,surname,adress,email";
    }

    @Override
    public String getInsertValues() {
         
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(name).append("', ")
                .append("'").append(surname).append("', ")
                .append("'").append(adress).append("', ")
                .append("'").append(email).append("' ");
                
        System.out.println(sb.toString());
        return sb.toString();
    
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> clients = new ArrayList<>();
        while(rs.next()){
           Client m = new Client();
           
          
                m.setEmail(rs.getString("email"));
                m.setId(rs.getLong("id"));
                m.setName(rs.getString("name"));
                m.setSurname(rs.getString("surname"));
                m.setAdress(rs.getString("adress"));
               
              
                
                clients.add(m);
        }
        return clients;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String getUpdateValues() {
            StringBuilder sb = new StringBuilder();
        
        sb.append("name=").append("'").append(name).append("', ")
            .append("surname=").append("'").append(surname).append("', ")
            .append("email=").append("'").append(email).append("', ")
                .append("adress=").append("'").append(adress).append("'")
                ;
        
        return sb.toString();
    }

    @Override
    public String getObjectCase() {
        return "id="+id;
    }

    @Override
    public String getSearchCase() {
      return "id="+id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
