package ulima.edu.pe.calculador.Principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ulima.edu.pe.calculador.Beans.NumReq;
import ulima.edu.pe.calculador.R;

public class PrincipalActivity extends AppCompatActivity implements PrincipalView{

    private PrincipalPresenter mPresenter;
    private Button btn_calcular;
    private static String[] spinnerData = {"Suma","Diferencia","Multiplicación","División"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        Spinner s = (Spinner) findViewById(R.id.spi_operaciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item, spinnerData);
        s.setAdapter(adapter);

        setPresenter(new PrincipalPresenterImp(this));
        final EditText num1 = (EditText) findViewById(R.id.numero1);
        final EditText num2 = (EditText) findViewById(R.id.numero2);
        final Spinner combo = (Spinner) findViewById(R.id.spi_operaciones);



        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumReq req = new NumReq(Float.parseFloat(num1.getText().toString()),Float.parseFloat(num2.getText().toString()));
                String op = "";
                switch (combo.getSelectedItem().toString()){
                    case "Suma":
                        op="sum";
                        break;
                    case "Diferencia":
                        op="dif";
                        break;
                    case  "Multiplicación":
                        op="mul";
                        break;
                    case "División":
                        op="div";
                        break;
                }
                mPresenter.calcular(req, op);
            }
        });

    }



    @Override
    public void setPresenter(PrincipalPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarResultado(float res) {
        EditText resultado = (EditText) findViewById(R.id.resultado);

        resultado.setText(String.valueOf(res));
    }
}
