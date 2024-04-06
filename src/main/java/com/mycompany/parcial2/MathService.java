package com.mycompany.parcial2;
import static spark.Spark.*;

import java.util.ArrayList;

public class MathService {
    
    public static void main( String[] args ){
        port(getPort());




        get("/linear", (req , res) -> 
        {
            res.type("application/json");
            int n = Integer.parseInt(req.queryParams("value"));
            String listStr = req.queryParams("list");
            String[] listArray = listStr.split(",");
            int[] intList = new int[listArray.length];
            for (int i = 0; i < listArray.length; i++) {
                intList[i] = Integer.parseInt(listArray[i]);
            }
            int resp = linearSearch(intList, n);
            String result = String.format("{\"operation\":\"linearSearch\",\"inputlist\":\"%s\",\"value\":%d,\"output\":%d}", listStr, n, resp);
            return result;
        });

        get("/binaria", (req , res) -> 
        {
            res.type("application/json");
            int n = Integer.parseInt(req.queryParams("value"));
            String listStr = req.queryParams("list");
            String[] listStrArray = listStr.split(",");
            int[] list = new int[listStrArray.length];
            for (int i = 0; i < listStrArray.length; i++) {
                list[i] = Integer.parseInt(listStrArray[i]);
            }
            int resp = bbinaria(list, 0, list.length - 1, n);
            String respuesta = String.format("{\"operation\":\"BinarySearch\",\"inputlist\":\"%s\",\"value\":%d,\"output\":%d}", listStr, n, resp);
            return respuesta;

        });

    }


    public static int linearSearch(int[] list, int busqueda){
        for (int i = 0; i < list.length; i++){
            if (list[i] == busqueda){
                return i; 
            }
        }
        return -1; 
    }


    public static int bbinaria(int[] list, int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (list[mid] == x)
                return mid;

            if (list[mid] > x)
                return bbinaria(list, left, mid - 1, x);

            return bbinaria(list, mid + 1, right, x);
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
