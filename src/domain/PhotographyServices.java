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
public class PhotographyServices implements GenericEntity {
    private Long id;
    private String name;
    private double price;
    private String description;
    

    public PhotographyServices() {
    }

    public PhotographyServices(Long id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getTableName() {
        return "photographyservice";
    }

    @Override
    public String toString() {
        return "PhotographyServices:" + name;
    }
    

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
         List<GenericEntity> services = new ArrayList<>();
        while(rs.next()){
            PhotographyServices t = new PhotographyServices();
                    t.setId(rs.getLong("id"));
                    
                    
                    t.setName(rs.getString("name"));
                    t.setPrice(rs.getDouble("price"));
                    t.setDescription(rs.getString("description"));
                   
                    services.add(t);
        }
        return services;
    }

    @Override
    public String getJoinCondition() {
        return"";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
