package edu.pjatk.inn.coffeemaker;

import sorcer.service.Context;

public interface AppService{
    public Context makeBeverage(Context context) throws Exception;
    public Context chooseBeverage(Context context) throws Exception;
}