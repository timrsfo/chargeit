package com.timr.chargeit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CharCountTest {
    
    
    @DataProvider
    public Object[][] TestData() {
        return new Object[][] { 
            {"1", "11"},
            {"111", "31"},
            {"12", "1112"},
            {"113444451788", "21134415111728"},
            {"13445178", "11132415111718"},
            {"A1bb22eeeccZZ1", "1A112b223e2c2Z11"}
        };
    }
    
    @Test(dataProvider = "TestData")
    public void testCharCount(String in, String expected){
        
        assertThat(CharCount.getCountStrBuilder(in),
                is(equalTo(expected))); 
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullInputException(){
        String in = null;
        CharCount.getCountStrBuilder(in);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyStringException(){
        String in = "";
        CharCount.getCountStrBuilder(in);
    }
    

}
