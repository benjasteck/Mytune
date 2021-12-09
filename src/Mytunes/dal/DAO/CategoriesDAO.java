package Mytunes.dal.DAO;

import Mytunes.dal.database.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesDAO {
    DbConnector databaseConnector;

    public CategoriesDAO() {
        databaseConnector = new DbConnector();
    }


    public int createNewCategory(String category) throws SQLException {
    //todo check for a given category and return id of that if it exists, if not create a new id and return it
    return 1;
    }

    public void deleteCategory(int id) throws SQLException {
    //todo delete category from sql coloumn
    }

    public Mytunes.BLL.CategoryBLL getCategoryById(int categoryId) throws SQLException {
    //todo get a category by using id and return that.
        //todo get the artist that matches the id and return the artist
        String sql = "SELECT FROM category WHERE Id=?";
        Mytunes.BLL.CategoryBLL category = null;
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int categoryid = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                category = new Mytunes.BLL.CategoryBLL(id, categoryid, name);
            }

        }
    return category;
    }


}
