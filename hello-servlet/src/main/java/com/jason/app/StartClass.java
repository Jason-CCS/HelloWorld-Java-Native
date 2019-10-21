package com.jason.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by jc6t on 2015/3/11.
 */
public class StartClass {
    public static void main(String[] args) throws Exception {
        StartClass startClass = new StartClass();
        startClass.initEmbeddedJettyTest();
    }
    private void initEmbeddedJetty() throws Exception {
        final int port=7777;
        String userDir=System.getProperty("user.dir");

        Server server = new Server(port);


        ProtectionDomain domain = this.getClass().getProtectionDomain();
        URL warLocation = domain.getCodeSource().getLocation();
        String warPath=warLocation.getPath();
        warPath=warLocation.toExternalForm();
        warPath=warLocation.toString();
        warPath=warLocation.toURI().toString();

        /**
         * set WebAppContext
         */
        WebAppContext webapp = new WebAppContext();
//        webapp.setContextPath("/");
        File warFile=new File(userDir+"/try_servlet.war");
//        webapp.setWar(warFile.getAbsolutePath());
//        webapp.setDescriptor("D:\\Projects\\LogXUI\\ESQueryReportWeb\\src\\main\\webapp\\WEB-INF\\web.xml");
//        webapp.setDescriptor("D:\\0_projects\\customer-profile\\write-service\\src\\main\\webapp\\WEB-INF\\web.xml");
//        webapp.setResourceBase("D:\\Projects\\LogXUI\\ESQueryReportWeb\\src\\main\\webapp");
//        webapp.setServer(server);
        webapp.setWar(warLocation.toExternalForm());

        server.setHandler(webapp);
        server.start();
        server.join();
    }

    private void initEmbeddedJettyTest() throws Exception {
        /**
         * set WebAppContext
         */
        WebAppContext webapp = new WebAppContext();
//        webapp.setDescriptor("D:\\Projects\\try-world\\try-servlet\\src\\main\\webapp\\WEB-INF\\web.xml");
        webapp.setResourceBase("D:\\Projects\\try-world\\try-servlet\\src\\main\\webapp");
//        webapp.setServer(server);

        final int port=7777;
        Server server = new Server(port);
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}
