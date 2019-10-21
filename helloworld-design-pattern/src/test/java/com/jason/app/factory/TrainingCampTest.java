package com.jason.app.factory;

import com.jason.app.factory.simple.Adventurer;
import com.jason.app.factory.simple.Archer;
import com.jason.app.factory.simple.Knight;
import com.jason.app.factory.simple.TrainingCamp;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by jasonchang on 2017/4/20.
 */
public class TrainingCampTest extends TestCase {
    public void test(){
        Adventurer a1 = TrainingCamp.trainAdventurer("archer");
        Adventurer a2 = TrainingCamp.trainAdventurer("knight");
        Assert.assertEquals(a1.getType(), Archer.class.getSimpleName());
        Assert.assertEquals(a2.getType(), Knight.class.getSimpleName());
    }
}