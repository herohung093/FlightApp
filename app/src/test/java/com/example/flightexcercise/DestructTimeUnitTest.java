package com.example.flightexcercise;

import static org.junit.Assert.assertEquals;

import com.example.flightexcercise.util.DestructTime;
import org.junit.Test;
/**
 * Unit tests for DestructTime logic.
 * */
public class DestructTimeUnitTest {
    @Test
    public void destructTime_getDate(){
        assertEquals(DestructTime.getDate("2019-11-15T08:44:00.000"),"Fri, 15 Nov");
    }
    @Test
    public void destructTime_getDate_nullInput(){
        assertEquals(DestructTime.getDate(null),"N/A");
    }
    @Test
    public void destrictTime_getTime(){
        assertEquals(DestructTime.getTime("2019-12-03T05:25:00.000"),"05:25 AM");
    }
}
