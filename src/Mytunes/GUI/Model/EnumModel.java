package Mytunes.GUI.Model;

import Mytunes.BE.Category;
import Mytunes.BLL.IBLLManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class EnumModel {

    ObservableList<Category> categoryObservableList;


    public EnumModel(){
        categoryObservableList = FXCollections.observableArrayList();
        categoryObservableList.addAll(Arrays.asList(Category.values()));
    }

    public ObservableList<Category> getCategoryObservableList(){
        return this.categoryObservableList;
    }

}
