package ulima.edu.pe.calculador.Beans;

/**
 * Created by Diego Torres on 25/10/2016.
 */

public class NumReq {
    private  Float num1,num2;

    public NumReq(Float num1, Float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Float getNum1() {
        return num1;
    }

    public void setNum1(Float num1) {
        this.num1 = num1;
    }

    public Float getNum2() {
        return num2;
    }

    public void setNum2(Float num2) {
        this.num2 = num2;
    }
}
