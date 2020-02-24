package tech.andrav.framework.demo.test;

import tech.andrav.framework.annotation.After;
import tech.andrav.framework.annotation.Before;
import tech.andrav.framework.annotation.Test;
import tech.andrav.framework.demo.src.MyClassTwo;

import static com.google.common.truth.Truth.assertThat;

public class MyClassTwoTest {

    private MyClassTwo obj;

    public MyClassTwoTest() {
    }

    @Before
    public void setUp() {
        obj = new MyClassTwo();
    }

    @Test
    public void Test1() {
        assertThat(obj.sum(10,2)).isEqualTo(13);
    }

    @Test
    public void Test2() {
        assertThat(obj.sum(10,2)).isEqualTo(12);
    }

    @Test
    public void Test3() {
        assertThat(obj.sum(1,2)).isNotEqualTo(0);
    }

    @After
    public void tearDown() {

    }
}

