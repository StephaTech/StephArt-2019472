/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The model is the DB connection and has been sourced from Amilcar Aponte
 * Availability: on moodle GUi subject
 */
public class LoginModel {
    //my own connection from the database
    String dbServer = "jdbc:mysql://database-1.cptrcvahtkfl.eu-west-1.rds.amazonaws.com:3306/stephany_2019472";
    String user = "stephany_2019472";
    String password = "Java2020Ste";
    Connection conn = null;
    Statement stmt = null;
    Statement stmta = null;

    
    // Constructor. This guy is starting the DB connection and 
    // putting everything in the variables declared above
    public LoginModel(){
        
        try{
            // Get a connection to the database
            Class.forName("com.mysql.jdbc.Driver");//accepts a class name as a String parameter and loads it into the memory
            conn = DriverManager.getConnection(dbServer,user,password) ;
            

            // Get a statement from the connection
            stmt = conn.createStatement() ;

        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions, if something goes wrong will be print a message
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
    }
    
    // This method is only in charge of asking the DB if a user exists
    // Notice that it is using the variables initialised by the constructor
    public boolean login(User userLogged){
        
        // Variable to define if the login is successful
        boolean login = false;
        try{
            // Building the query according to my table on the database
            String query = "SELECT * FROM Customer WHERE username = '" + userLogged.getUn() + "' AND password = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query) ;
            


            // If there is an entry in the database that satisfies
            // the username and password, then the login is successful
            // otherwise it fails
            login = rs.next();
            


            // Close the result set, statement and the connection
            rs.close() ;
            


            // Calling the method in charge of closing the connections
            closings();
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }

        // Retuning the login status
        return login;
        
        //As my database has two tables and not only one call "user" I had to to create another query for to login as Admin (NOT WORKING)
        else {
            // Building the query
            String query = "SELECT * FROM Administrator WHERE username = '" + userLogged.getUn() + "' AND password = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query) ;
            


            // If there is an entry in the database that satisfies
            // the username and password, then the login is successful
            // otherwise it fails
            login = rs.next();
            


            // Close the result set, statement and the connection
            rs.close() ;
            


            // Calling the method in charge of closing the connections
            closings();
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }

        // Retuning the login status
        return login;
    
    }
        
    // This method is only in charge of saving a new user into the the DB
    public void register(User userLogged){
        
        try{
            // Building the query 
            String query = "INSERT INTO Customer (username, password) VALUES ('"+userLogged.getUn()+"', '"+userLogged.getPw()+"');";

            // Execute the query
            stmt.execute(query) ;

            // Calling the method in charge of closing the connections
            closings();
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }


    }
    
    // Separeating closing statements for better code structure
    private void closings(){
        try {            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
