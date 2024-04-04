package com.mycompany.parcial2;
import static spark.Spark.*;

import java.util.ArrayList;

public class MathService {
    
    public static void main( String[] args ){
        port(getPort());




        get("/linear", (req , res) -> 
        {
            res.type("application/json");
            int i = Integer.parseInt(req.queryParams("value"));
            String result = "Hola";
            return result;
        });

        get("/binaria", (req , res) -> 
        {
            res.type("application/json");
            int i = Integer.parseInt(req.queryParams("value"));
            String result = "Hola";
            return result;
        });




    }

    public static int blinear(){
        String[] list={"Hola","como"};
        String busqueda="Hola";
        int respuesta = 0;
        for (int i=0; i<=list.length;i++){
            if (list[i] == busqueda){
                respuesta = i;
            }
            else{
                respuesta = -1;
            }
        }
        return respuesta;
    }

    
    public static int bbinaria(){
        int[] list={1, 2, 3, 4};
        int busqueda = 3;
        int dividir = 0;
        while (list.length>0){
            dividir = list.length/2;
            if(list[dividir]==busqueda){
                return dividir;
            }
        
        }

        
        
        return -1;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
