package tech.andrav.framework.demo.test;

import tech.andrav.framework.annotation.After;
import tech.andrav.framework.annotation.Before;
import tech.andrav.framework.annotation.Test;
import tech.andrav.framework.demo.src.MyClassOne;

import static com.google.common.truth.Truth.assertThat;

public class MyClassOneTest {

    private MyClassOne obj;

    public MyClassOneTest() {
    }

    @Before
    public void setUp() {
        obj = new MyClassOne();
    }

    @Test
    public void Test1() {
        String str = "Hello";
        assertThat(obj.echo(str)).startsWith("He");
    }

    @Test
    public void Test2() {
        String str = "Hello";
        assertThat(obj.echo(str)).startsWith("el");
    }

    @Test
    public void Test3() {
        assertThat(obj.echo(null)).isNull();
    }

    @After
    public void tearDown() {

    }
}
