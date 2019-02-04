/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

/**
 *
 * @author Administrator
 */
public class Account {
    public String user="";
    public String password="";

    public Account(String user,String password) {
        this.user=user;
        this.password=password;
    }
    public String toString(){
        return this.user+" + "+this.password;
    }
}
