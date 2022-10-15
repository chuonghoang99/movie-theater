package fa.appcode.common.response;

import java.io.Serializable;

public class GenericResponse implements Serializable {
    public String result;

    public  Integer statusCode;

    public GenericResponse() {
        super();
    }


    public GenericResponse(Integer statusCode){
        super();
        this.statusCode = statusCode;
    }

    public GenericResponse(String result, Integer statusCode) {
        super();
        this.result = result;
        this.statusCode = statusCode;
    }
}
