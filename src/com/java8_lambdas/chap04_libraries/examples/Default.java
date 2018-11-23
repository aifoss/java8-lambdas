package com.java8_lambdas.chap04_libraries.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sofia on 12/24/16.
 */
public class Default {

    public interface Parent {
        void message(String body);

        default void welcome() {
            message("Parent: Hi!");
        }

        String getLastMessage();
    }

    public static class ParentImpl implements Parent {
        private String body;

        @Override
        public void message(String body) {
            this.body = body;
        }

        @Override
        public String getLastMessage() {
            return body;
        }
    }

    public static class OverridingParent extends ParentImpl {
        @Override
        public void welcome() {
            message("Class Parent: Hi!");
        }
    }

    public interface Child extends Parent {
        @Override
        default void welcome() {
            message("Child: Hi!");
        }
    }

    public static class ChildImpl extends ParentImpl implements Child {

    }

    public static class OverridingChild extends OverridingParent implements Child {

    }


    @Test
    public void parentDefaultUsed() {
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childOverridingDefault() {
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }

    @Test
    public void concreteBeatsDefault() {
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void concreteBeatsCloserDefault() {
        Child child = new OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }

}
