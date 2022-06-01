package com.app.calculator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;


public class RectangleTest {
    
    @Test
    public void shouldReturnAreaWhenLengthAndBreadthAreGiven(){
        Rectangle rectangle = new Rectangle(10, 5);
        double resultantArea = rectangle.area();
        assertThat(resultantArea, is(closeTo(50, 0.1)));
    }

    @Test
    public void shouldReturnAreaWhenLengthAndBreadthWithDecimalsAreGiven(){
        Rectangle rectangle = new Rectangle(10.2, 5.5);
        double resultantArea = rectangle.area();
        assertThat(resultantArea, is(closeTo(56.1, 0.1)));
    }

}
