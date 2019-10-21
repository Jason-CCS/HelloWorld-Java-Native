package com.jason.app;

import com.newegg.ec.db.DBConnectionManager;
import com.newegg.ec.db.DBSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;

/**
 * Created by jc6t on 2015/4/20.
 */
public class HelloJDBC {
    private static Logger log = LogManager.getLogger(HelloJDBC.class);
    private static String sourceConfigPath="conf/dbselect-config.yaml";
    private static String userDir=System.getProperty("user.dir");
    public static void main(String[] args) throws SQLException {
        test();
    }

    public static void test() throws SQLException {
        String configPath=userDir+sourceConfigPath;
        log.info(configPath);
        DBConnectionManager dbMgr = null;
        try {
            dbMgr = DBConnectionManager.getInstance(new FileInputStream(configPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DBSelect dbSelect=new DBSelect(dbMgr);
        Connection conn=dbMgr.getDBConnection("test");
        PreparedStatement ps=conn.prepareStatement("insert into CodeCenter_ES.dbo.PseudoData2 ([id], [image]) values (?,?)");
        ps.setObject(1, new Random().nextInt(1000000));
        ps.setObject(2, "0x12341234".getBytes(), Types.VARBINARY);
        int output=ps.executeUpdate();
        log.info(output);
        ps.close();
        conn.close();
    }
}
