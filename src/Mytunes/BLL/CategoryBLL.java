package Mytunes.BLL;

import Mytunes.DAL.Interfaces.ICategories;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import jdk.jfr.Category;

import java.sql.SQLException;

public class CategoryBLL implements ICategories {

    public CategoryBLL(int id, int categoryid, String name) {
    }

    @Override
    public int createNewCategory(String name) throws SQLException {
        return 0;
    }

    @Override
    public void deleteCategory(int id) throws SQLServerException, SQLException {

    }

    @Override
    public int categoryOccurrences(int categoryId) throws SQLException {
        return 0;
    }

    @Override
    public Category getCategoryById(int categoryId) throws SQLException {
        return null;
    }

    @Override
    public void updateCategory(int id, String name) throws SQLException {

    }
}
