/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.mvc.controller;

import supermarket.mvc.model.ItemModel;
import supermarket.mvc.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class ItemController {
    public String saveItem(ItemModel item) throws SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        
        String query ="INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1, item.getItemCode());
        preparedStatement.setString(2, item.getItemDesc());
        preparedStatement.setString(3, item.getPackSize());
        preparedStatement.setDouble(4, item.getUnitPrice());
        preparedStatement.setInt(5, item.getQtyOnHand());
        
        if(preparedStatement.executeUpdate()>0){
            return "Success";
        }else{
            return "Fail";
        }
    }
    
        public ArrayList<ItemModel> getAllItems() throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(query);
        
        ArrayList<ItemModel> itemModels = new ArrayList<>();
        
        ResultSet rst = statement.executeQuery();
        while (rst.next()) {            
            ItemModel im = new ItemModel(
                    rst.getString(1),
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getDouble(4), 
                    rst.getInt(5));
            
            itemModels.add(im);
        }
        
        return itemModels;
    }
}
