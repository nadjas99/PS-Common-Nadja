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
public class Photographer implements GenericEntity{

    public Long getId() {
        return id;
    }
    
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    

    public Photographer(String name, String surname, String username, String password,Long id) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public Photographer() {
    }

    @Override
    public String getTableName() {
        return "photographer";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getObjectCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Photographer{" + "name=" + name + ", surname=" + surname + '}';
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
      @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> photographers = new ArrayList<>();
        while(rs.next()){
            Photographer leader = new Photographer();
            leader.setId(rs.getLong("id"));
            leader.setUsername(rs.getString("username"));
            leader.setSurname(rs.getString("surname"));
            leader.setPassword(rs.getString("password"));
            leader.setName(rs.getString("name"));
            photographers.add(leader);
        }
        
        return photographers;
    }
    
    
    
}
