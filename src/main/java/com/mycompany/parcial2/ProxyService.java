package com.mycompany.parcial2;

import static spark.Spark.*;

public class ProxyService {
    static String[] urluse = {"",""};
    static int service = 0;
    public static void main(String[] args){
        staticFiles("/public");
        urluse[0]=args[0];
        urluse[1]=args[1];
        port(getPort());
        get("/linear" , (req , res) -> {
            res.type("application/json");
            int n = Integer.parseInt(req.queryParams("value"));
            return HttpConnectionExample.Connection(urluse[whoservice()] + "/linear/values?" + n);
        //urluse[service]
        });

        get("/binaria" , (req , res) -> {
            res.type("application/json");
            int n = Integer.parseInt(req.queryParams("value"));
            return HttpConnectionExample.Connection(urluse[whoservice()] + "/linear/values?" + n);
        //urluse[service]
        });
        
    }

    private static int whoservice(){
        if (service == 0){
            service = 1;
        }
        else if (service == 1){
            service = 0;
        }
        return service;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4500;
    }
    
}
