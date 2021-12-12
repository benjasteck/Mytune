package Mytunes.DAL.DAO;

import Mytunes.BLL.old.CategoryBLL;
import Mytunes.DAL.database.DbConnector;

import java.sql.*;

public class CategoriesDAO {
    DbConnector databaseConnector;

    public CategoriesDAO() {
        databaseConnector = new DbConnector();
    }


    public int createNewCategory(String category) throws SQLException {
        String sql = "SELECT * FROM categories WHERE Category = ?";
        int categoryid = 0;
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                categoryid = resultSet.getInt("Id");
                return categoryid;
            }
            String sql1 = "INSERT INTO categories VALUES(?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement1.setString(1, category);
            preparedStatement1.executeUpdate();
            ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
            while (resultSet1.next()) {
                categoryid = resultSet1.getInt(1);
            }

        }
        return categoryid;
    }

    public void deleteCategory(int id) throws SQLException {
        String sql = "DELETE FROM categories WHERE categoryid = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }

    }

    public CategoryBLL getCategoryById(int categoryId) throws SQLException {
        //todo get a category by using id and return that.
        String sql = "SELECT FROM category WHERE categoryid=?";
        CategoryBLL category = null;
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int categoryid = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                category = new CategoryBLL(id, categoryid, name);
            }

        }
        return category;
    }

    public void updateCategory(int id, String name) throws SQLException {
        String sql = "UPDATE categories SET Category=? WHERE id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        }
    }


}
