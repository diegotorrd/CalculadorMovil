package ulima.edu.pe.calculador.Principal;

import android.util.Log;
import android.widget.Switch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ulima.edu.pe.calculador.Beans.NumReq;
import ulima.edu.pe.calculador.Remote.CalculadorRemote;

/**
 * Created by w3224 on 18/10/2016.
 */
public class PrincipalPresenterImp implements PrincipalPresenter{
    private PrincipalView mView;

    public PrincipalPresenterImp(PrincipalView mView) {
        this.mView = mView;
    }

    @Override
    public void calcular(NumReq req, String operacion) {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://ws-software1.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CalculadorRemote service = retrofit.create(CalculadorRemote.class);
        switch (operacion){
            case "sum":
                service.suma(req).enqueue(new Callback<Float>() {
                    @Override
                    public void onResponse(Call<Float> call, Response<Float> response) {
                        mView.mostrarResultado(response.body());
                    }

                    @Override
                    public void onFailure(Call<Float> call, Throwable t) {
                        Log.e("Calculador", t.getMessage());
                    }
                });
                break;
            case "dif":
                service.diferencia(req).enqueue(new Callback<Float>() {
                    @Override
                    public void onResponse(Call<Float> call, Response<Float> response) {
                        mView.mostrarResultado(response.body());
                    }

                    @Override
                    public void onFailure(Call<Float> call, Throwable throwable) {
                        Log.e("Calculador", throwable.getMessage());
                    }
                });
                break;
            case "mul":
                service.multiplicacion(req).enqueue(new Callback<Float>() {
                    @Override
                    public void onResponse(Call<Float> call, Response<Float> response) {
                        mView.mostrarResultado(response.body());
                    }

                    @Override
                    public void onFailure(Call<Float> call, Throwable throwable) {
                        Log.e("Calculador", throwable.getMessage());
                    }
                });
                break;
            case "div":
                service.division(req).enqueue(new Callback<Float>() {
                    @Override
                    public void onResponse(Call<Float> call, Response<Float> response) {
                        mView.mostrarResultado(response.body());
                    }

                    @Override
                    public void onFailure(Call<Float> call, Throwable throwable) {
                        Log.e("Calculador", throwable.getMessage());
                    }
                });
                break;
        }

    }
}
