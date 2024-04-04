package com.mycompany.parcial2;
import static spark.Spark.*;

public class MathService {
    
    public static void main( String[] args ){
        port(getPort());
        get("/linear", (req , res) -> 
        {
            res.type("application/json");
            int i = Integer.parseInt(req.algo("value"));
            String result = "Hola";

        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
