/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author FON
 */
public enum Operation implements Serializable{
    LOGIN,
    GET_ALL_CLIENTS, GET_ALL_RESERVATIONS,GET_ALL_SERVICES,
    UPDATE_RESERVATION,ADD_NEW_CLIENT,
    DELETE_CLIENT,EDIT_CLIENT,EDIT_RESERVATION,LOGOUT,END,ADD_NEW_RESERVATION;
    
}
