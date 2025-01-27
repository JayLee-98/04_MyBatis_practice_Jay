package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService = new CategoryService();
    private final CategoryPrint categoryPrint = new CategoryPrint();

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("select");
        }
    }

    public void registNewCategory(CategoryDTO category) {

        categoryService.registNewCategory(category);

        if(category != null) {
            categoryPrint.printSuccessMessage("register");
        } else {
            categoryPrint.printErrorMessage("register");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {

        categoryService.modifyCategoryName(category);

        if(categoryService.modifyCategoryName(category)) {
            categoryPrint.printSuccessMessage("modify");
        } else {
            categoryPrint.printErrorMessage("modify");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        if(categoryService.deleteCategory(parameter)) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
