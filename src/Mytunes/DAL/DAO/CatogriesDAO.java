package Mytunes.DAL.DAO;

import Mytunes.BE.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatogriesDAO {
    List<Category> allCategoryList = new ArrayList<>();

    public List<Category> setAllCategoryList() {
        allCategoryList.addAll(Arrays.asList(Category.values()));
        return allCategoryList;
    }


}
