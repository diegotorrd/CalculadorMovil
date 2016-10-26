package ulima.edu.pe.calculador.Remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ulima.edu.pe.calculador.Beans.NumReq;

/**
 * Created by Diego Torres on 24/10/2016.
 */

public interface CalculadorRemote {

    @GET("suma")
    Call<Float> suma(@Body NumReq req);

    @GET("resta")
    Call<Float> diferencia(@Body NumReq req );

    @GET("multi")
    Call<Float> multiplicacion(@Body NumReq req );

    @GET("divi")
    Call<Float> division(@Body NumReq req );


}
