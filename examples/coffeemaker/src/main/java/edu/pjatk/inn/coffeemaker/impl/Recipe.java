package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Class representing a recipe
 *
 * @author   Sarah & Mike
 */
public class Recipe implements Serializable {

    /*
     * Recipe name
     */
    private String name;
    /*
     * Recipe price
     */
    private int price;
    /*
     * Coffee amount in the recipe
     */
    private int amtCoffee;
    /*
     * Milk amount in the recipe
     */
    private int amtMilk;
    /*
     * Sugar amount in the recipe
     */
    private int amtSugar;
    /*
     * Chocolate amount in the recipe
     */
    private int amtChocolate;

    /**
     * Empty class constructor of the Recipe class.
     * All the fields are initialized with the default values.
     */
    
    public Recipe() {
    	this.name = "";
    	this.price = 0;
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }
    
    /**
   * Returns the currently set chocolate amount for the recipe
   *
   * @return Returns the amtChocolate
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}
    /**
   * Sets the recipe's chocolate amount
   *
	 * @param amtChocolate   The amount of chocolate to be set
	 */
    public void setAmtChocolate(int amtChocolate) {
		if (amtChocolate >= 0) {
			this.amtChocolate = amtChocolate;
		} 
	}
    /**
   * Returns the currently set coffee amount for the recipe
	 * @return   Returns the amtCoffee.
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}
    /**
   * Sets the recipe's coffee amount
	 * @param amtCoffee   The amount of coffee to be set
	 */
    public void setAmtCoffee(int amtCoffee) {
		if (amtCoffee >= 0) {
			this.amtCoffee = amtCoffee;
		} 
	}
    /**
   * Returns the currently set milk amount for the recipe
	 * @return   Returns the amtMilk.
	 */
    public int getAmtMilk() {
		return amtMilk;
	}
    /**
   * Sets the recipe's milk amount
	 * @param amtMilk   The amount of milk to be set
	 */
    public void setAmtMilk(int amtMilk) {
		if (amtMilk >= 0) {
			this.amtMilk = amtMilk;
		} 
	}
    /**
   * Returns the currently set sugar amount for the recipe
	 * @return   Returns the amtSugar.
	 */
    public int getAmtSugar() {
		return amtSugar;
	}
    /**
   * Sets the recipe's sugar amount
	 * @param amtSugar   The amount of sugar to be set
	 */
    public void setAmtSugar(int amtSugar) {
		if (amtSugar >= 0) {
			this.amtSugar = amtSugar;
		} 
	}
    /**
   * Returns the currently set recipe's name
	 * @return   Returns the currently set recipe's name
	 */
    public String getName() {
		return name;
	}
    /**
   * Sets the recipe's name
	 * @param name   The recipe name to be set
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}
    /**
   * Returns the currently set recipe's price
	 * @return   Returns the currently set recipe's price
	 */
    public int getPrice() {
		return price;
	}
    /**
   * Sets the recipe's price
	 * @param price   The recipe price to be set
	 */
    public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		} 
	} 

    /**
     * Checks whether two recipes are equal based on the recipes' names
     * @param r    Another recipe to check if it's equal to `this` recipe
     * @return     Returns boolean indicating if two recipes are equal or not
     */
    public boolean equals(Recipe r) {
        if((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }
    public String toString() {
    	return name;
    }


  /**
   * Creates a new recipe based on the context provided.
   * @param context containing information for the recipe creation.
   * @return returns new recipe if context contained required information.;
   * @throws ContextException if context did not contain sufficient information for the recipe creation.
   */
	static public Recipe getRecipe(Context context) throws ContextException {
		Recipe r = new Recipe();
		try {
			r.name = (String)context.getValue("key");
			r.price = (int)context.getValue("price");
			r.amtCoffee = (int)context.getValue("amtCoffee");
			r.amtMilk = (int)context.getValue("amtMilk");
			r.amtSugar = (int)context.getValue("amtSugar");
			r.amtChocolate = (int)context.getValue("amtChocolate");
		} catch (RemoteException e) {
			throw new ContextException(e);
		}
		return r;
	}

  /**
   * Creates a new Context based on the provided recipe instance.
   * @param recipe based on which the context will be created.
   * @return Context object based on the provided recipe instance. 
   * @throws ContextException if any of the `putValue` invocations fail.
   */

	static public Context getContext(Recipe recipe) throws ContextException {
		Context cxt = new ServiceContext();
		cxt.putValue("key", recipe.getName());
		cxt.putValue("price", recipe.getPrice());
		cxt.putValue("amtCoffee", recipe.getAmtCoffee());
		cxt.putValue("amtMilk", recipe.getAmtMilk());
		cxt.putValue("amtSugar", recipe.getAmtSugar());
		cxt.putValue("amtChocolate", recipe.getAmtChocolate());
		return cxt;
	}


}
