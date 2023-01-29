package edu.pjatk.inn.coffeemaker;

import sorcer.service.Context;

public interface NewCoffeeService{
    public Context addRecipe(Context context) throws Exception;
    public Context editRecipe(Context context) throws Exception;
    public Context deleteRecipe(Context context) throws Exception;
}