package com.jason.app;

import java.util.*;

/**
 * Created by jc6t on 2015/8/14.
 */
public class ExtendsAndSuper {
    public static void main(String[] args) {
        List<? super MidClass> list = new ArrayList<TopClass>();
//        List<? extends MidClass> list2= new ArrayList<TopClass>(); // this one is wrong

        ArrayList<? extends MidClass> list3 = new ArrayList<MidClass>();

        Collections.sort(list3, new Comparator<TopClass>() {
            public int compare(TopClass o1, TopClass o2) {
                return 0;
            }
        });

        List<? super BtmClass> list4 = new ArrayList<Interface>();

        Map<?,?> map=new HashMap<String, String>();

    }

    interface Interface {
        void foo();

        void bar();
    }

    static class TopClass {

        @Override
        public String toString() {
            return String.format("getName() = %s, getCanonicalName = %s, getSimpleName() = %s",
                    this.getClass().getName(), this.getClass().getCanonicalName(), this.getClass().getSimpleName());
        }
    }

    static class MidClass extends TopClass {

    }

    static class BtmClass extends MidClass implements Interface {

        public void foo() {
            System.out.println("foo");
        }

        public void bar() {
            System.out.println("bar");
        }
    }
}
