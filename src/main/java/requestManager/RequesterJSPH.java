package requestManager;

import static services.BaseClass.*;
import static services.ResponseUtils.RespOut;

public class RequesterJSPH{

    public static void main(String[] args) {
        // для запуска в idea
        // setJsonDataPath("путь_к_json");
         RespOut(postRequest("/posts"));
         RespOut(getRequest("/posts/2"));
/*
        //для запуска из консоли
        if(args[0].equalsIgnoreCase("get"))
            RespOut(getRequest(args[1]));
        else RespOut(postRequest(args[1]));
*/
    }
}
