package ulima.edu.pe.calculador.Remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ulima.edu.pe.calculador.Beans.NumReq;

/**
 * Created by Diego Torres on 24/10/2016.
 */

public interface CalculadorRemote {

    @POST("suma")
    Call<Float> suma(@Body NumReq req);

    @POST("resta")
    Call<Float> diferencia(@Body NumReq req );

    @POST("multi")
    Call<Float> multiplicacion(@Body NumReq req );

    @POST("divi")
    Call<Float> division(@Body NumReq req );


}
