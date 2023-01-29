package edu.pjatk.inn.coffeemaker;

import sorcer.service.Context;

public interface NewMachineService{
    public Context getRecipe(Context context) throws Exception;
    public Context checkInventory(Context context) throws Exception;
}