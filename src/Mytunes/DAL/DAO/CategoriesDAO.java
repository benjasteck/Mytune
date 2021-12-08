package Mytunes.DAL.DAO;

import Mytunes.DAL.database.DbConnector;

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

    public int getCategoryById(int categoryId) throws SQLException {
    //todo get a category by using id and return that.
    return 1;
    }


}
