package com.jason.app.client_server_simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by user on 2016/2/20.
 * To determine the load that a group of servers on my laptop can handle.
 * Server numbers is four at beginning.
 */
public class ClientServerSimulation {
    public static long start = System.currentTimeMillis();

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        RequestQueue rq = new RequestQueue();
        List<Server> serverList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            serverList.add(new Server(rq, es));
        }
        ServerMonitor sm = new ServerMonitor(es, serverList, rq);

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(sm, 0, 100, TimeUnit.MILLISECONDS);

        for (Server s : serverList) {
            es.execute(s);
        }
        RequestGenerator requestGenerator = new RequestGenerator(rq);
        es.execute(requestGenerator);
    }
}

class Server implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private RequestQueue rq;
    private ExecutorService es;
    private boolean serving = true;
    private int servedReqNum = 0;
    private boolean alive = true;

    public Server(RequestQueue rq, ExecutorService es) {
        this.rq = rq;
        this.es = es;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Request r = rq.take();
                if (System.currentTimeMillis() - r.getTriggerTime() > 5000) {
                    System.out.println("The request has waited for more than 5 seconds.");
                    System.out.println("Simulation is closing now.");
                    es.shutdownNow();
                } else {
                    synchronized (this) {
                        serving = false;
                    }
                    TimeUnit.MILLISECONDS.sleep(r.getRequestTime());
                    this.servedReqNum++;
                    synchronized (this) {
                        serving = true;
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        } finally {
            synchronized (this){
                serving = false;
                alive = false;
            }
            System.out.println("===== set alive = faluse on " + this + "=====");
        }
        System.out.println(this + "terminated");
    }

    public boolean isAlive() {
        return alive;
    }

    public int getServedReqNum() {
        return servedReqNum;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                '}';
    }

    public boolean isServing() {
        return serving;
    }
}

class ServerMonitor implements Runnable {
    private ExecutorService es;
    private List<Server> serverList;
    private RequestQueue rq;

    public ServerMonitor(ExecutorService es, List<Server> serverList, RequestQueue rq) {
        this.es = es;
        this.serverList = serverList;
        this.rq = rq;
    }

    @Override
    public void run() {
        System.out.println("ServerMonitor is monitoring now.");
        int busyServerNum = 0;
        int terminatedServerNum = 0;

        for (Server s : serverList) {
            // check if all servers are busy.
            if (!s.isServing()) {
                busyServerNum++;
                if (busyServerNum == this.serverList.size()) {
                    System.out.println("======servers are not enough=====");
                    Server newServer = new Server(this.rq, this.es);
                    this.serverList.add(newServer);
                    if (!es.isShutdown()) {
                        es.execute(newServer);
                        System.out.println("===== added one more server =====");
                    }
                }
            }
            System.out.println("===== finished check server's serving status=====");
            // check if all servers are alive.
            if (!s.isAlive()) {
                System.out.println(" 11111 ");
                terminatedServerNum++;
                if (terminatedServerNum == this.serverList.size()) {
                    System.out.println(" 22222 ");
                    long end = System.currentTimeMillis();
                    System.out.println("all servers are terminated.");
                    System.out.println("There are " + serverList.size() + " servers.");
                    int totalServedReqNum = 0;
                    for (Server s2 : serverList) {
                        totalServedReqNum += s2.getServedReqNum();
                    }
                    System.out.println("======total served request is " + totalServedReqNum + ".======");
                    long period = end - ClientServerSimulation.start;
                    System.out.println("=====the load is " + totalServedReqNum / period / 1000 + " requests per seconds.=====");
                    System.out.println("System exit");
                    System.exit(0);
                }
            }
        }
        System.out.println("ServerMonitor finished.");
    }
}

class Request {
    private final int requestTime;
    private final long triggerTime;

    public Request(int requestTime) {
        this.requestTime = requestTime;
        this.triggerTime = System.currentTimeMillis();
    }

    public int getRequestTime() {
        return requestTime;
    }

    public long getTriggerTime() {
        return triggerTime;
    }

    @Override
    public String toString() {
        return "[" +
                "requestTime=" + requestTime +
                ']';
    }
}

class RequestQueue extends LinkedBlockingQueue<Request> {

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuffer result = new StringBuffer();
        for (Request r : this) {
            result.append(r);
        }
        return result.toString();
    }
}

class RequestGenerator implements Runnable {
    private RequestQueue requestQueue;
    private static Random rand = new Random(47);

    public RequestGenerator(RequestQueue rq) {
        this.requestQueue = rq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(100));
                requestQueue.put(new Request(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("RequestGenerator interrupted");
        }
        System.out.println("RequestGenerator terminating");
    }
}