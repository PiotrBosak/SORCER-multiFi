package edu.pjatk.inn.coffeemaker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.*;

import static org.junit.Assert.*;
import static sorcer.co.operator.*;
import static sorcer.ent.operator.*;
import static sorcer.eo.operator.alt;
import static sorcer.eo.operator.args;
import static sorcer.eo.operator.opt;
import static sorcer.eo.operator.result;
import static sorcer.eo.operator.*;
import static sorcer.mo.operator.add;
import static sorcer.mo.operator.model;
import static sorcer.mo.operator.result;
import static sorcer.mo.operator.value;
import static sorcer.so.operator.*;

@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class CoffeeMakerv2Test {
    private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerv2Test.class);


    @Test
    public void orderCoffee() throws Exception {
        Routine addLatte = null; //todo
        Routine makeCoffee  = null;//todo

        Block orderCoffee = block("orderCoffee", addLatte, makeCoffee,context(ent("drinkerBalance", 150)));
        Context result = context(exert(orderCoffee));
        assertEquals(value(result, "drinkerBalance"), 50.00);
    }
}