package database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
/**
 *
 * @author Myles
 */
public abstract class DBConnectionFactory {
    
    String url = "jdbc:mysql://localhost:3306/dar-amis";
    String username = "root";
    String password = "p@ssword";

    /**
     *
     * @return
     */
    public static DBConnectionFactory getInstance() {
        return new DBConnectionFactoryImpl();
    }

    /**
     *
     * @return
     */
    public abstract Connection getConnection();
}

