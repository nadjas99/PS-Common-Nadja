/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nadja
 */
public class Reservation implements GenericEntity{
    
    private Long id;
    private Date date;
    private String place;
    private double cost;
    //dodaj objekat paketa usluge kad napravis
    //i stavku rezervacije
    private List<ReservationDetail> reservationDetails;
    private Client client;
    private Photographer photographer;

    public Reservation() {
        reservationDetails=new ArrayList<>();
    }
    

    public Reservation(Long id, Date date, String place, double cost, List<ReservationDetail> reservationDetails, Client client, Photographer photographer) {
        this.id = id;
        this.date = date;
        this.place = place;
        this.cost = cost;
        this.reservationDetails = reservationDetails;
        this.client = client;
        this.photographer = photographer;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<ReservationDetail> getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(List<ReservationDetail> reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    @Override
    public String getTableName() {
        return "reservation";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,idClient,idPhotographer,date,cost,place";
    }

    @Override
    public String getInsertValues() {
           StringBuilder sb = new StringBuilder();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        

     
                 sb.append(id).append(",")
                .append(client.getId()).append(",")
                .append(photographer.getId()).append(",'")
                .append(date1).append("',")
                .append(cost).append(",'")
                .append(place).append("'");
        return sb.toString();
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> reservations = new ArrayList<>();
        while(rs.next()){
             Reservation r = new Reservation();
                r.setId(rs.getLong("id"));
                r.setDate(rs.getDate("date"));
                r.setCost(rs.getDouble("cost"));
                Photographer ph=new Photographer();
                ph.setId(rs.getLong("idPhotographer"));
                Client c=new Client();
                c.setId(rs.getLong("idClient"));
                r.setClient(c);
                r.setPhotographer(ph);
                r.setPlace(rs.getString("place"));
                reservations.add(r);
        }
        return reservations;
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String getUpdateValues() {
        StringBuilder sb = new StringBuilder();
       
        java.sql.Date date1 = new java.sql.Date(date.getTime());
      
       
        sb.append("place=").append("'").append(place).append("', ")
                .append("cost=").append(cost).append(", ")
                 .append("date=").append(date1);
        
        return sb.toString();
    }

    @Override
    public String getObjectCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }

    @Override
    public String toString() {
        return "Reservation{" + "date=" + date + '}';
    }
    
    

   

}
