package com.jason;

import com.jason.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className); // 產生Class instance
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotation in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name;
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1)
                    continue; // not a db table column
                if (anns[0] instanceof SQLInt) {
                    SQLInt sqlInt = (SQLInt) anns[0];
                    if (sqlInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sqlInt.name();
                    columnDefs.add(columnName + " INT" + getConstraints(sqlInt.constraints()));
                }
                if (anns[0] instanceof SQLVarchar) {
                    SQLVarchar sqlVarchar = (SQLVarchar) anns[0];
                    if (sqlVarchar.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sqlVarchar.name();
                    columnDefs.add(columnName + " VARCHAR(" + sqlVarchar.value() + ")" +
                            getConstraints(sqlVarchar.constraints()));
                }
                if(anns[0] instanceof SQLDate){
                    SQLDate sqlDate = (SQLDate) anns[0];
                    if (sqlDate.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sqlDate.name();
                    columnDefs.add(columnName + " DATE" + getConstraints(sqlDate.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + " (");
                for(String columnDef : columnDefs)
                    createCommand.append("\n"+columnDef+",");
                String tableCreate = createCommand.substring(0, createCommand.length()-1) + ")";
                System.out.println("Table Creation SQL for " + className + " is: \n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY KEY";
        if (con.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}
