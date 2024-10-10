package com.example.calculadora_c;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bac, bc, btnraiz, btnmas, btnres, btnentre, btnmul, bequal, btnpunto, btnparent,
            btnparent2, btnsin, btncos, btntan, btnx2, bpi, btnxl, btnlog, btnln, btnx3;
    TextView tvuno, tvdos;

    String pi = "3.14159265";  // Valor de pi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        // Inicializar botones
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bac = findViewById(R.id.btnac);
        bc = findViewById(R.id.btnc);
        btnraiz = findViewById(R.id.btnraiz);
        btnmas = findViewById(R.id.btnmas);
        btnres = findViewById(R.id.btnres);
        btnentre = findViewById(R.id.btnentre);
        btnmul = findViewById(R.id.btnmul);
        bequal = findViewById(R.id.bequal);
        btnpunto = findViewById(R.id.btnpunto);
        btnparent = findViewById(R.id.btnparent);
        btnparent2 = findViewById(R.id.btnparent2);
        btnsin = findViewById(R.id.btnsin);
        btncos = findViewById(R.id.btncos);
        btntan = findViewById(R.id.btntan);
        btnx2 = findViewById(R.id.btnx2);
        bpi = findViewById(R.id.bpi);
        btnxl = findViewById(R.id.btnxl);
        btnlog = findViewById(R.id.btnlog);
        btnln = findViewById(R.id.btnln);
        btnx3 = findViewById(R.id.btnx3);

        tvuno = findViewById(R.id.tvuno);
        tvdos = findViewById(R.id.tvdos);

        // Listener para los números
        b1.setOnClickListener(v -> updateInput(b1));
        b2.setOnClickListener(v -> updateInput(b2));
        b3.setOnClickListener(v -> updateInput(b3));
        b4.setOnClickListener(v -> updateInput(b4));
        b5.setOnClickListener(v -> updateInput(b5));
        b6.setOnClickListener(v -> updateInput(b6));
        b7.setOnClickListener(v -> updateInput(b7));
        b8.setOnClickListener(v -> updateInput(b8));
        b9.setOnClickListener(v -> updateInput(b9));
        b0.setOnClickListener(v -> updateInput(b0));

        // Listener para punto
        btnpunto.setOnClickListener(v -> {
            String res = tvdos.getText().toString();
            if (!res.contains(".")) {
                tvdos.setText(res + ".");
            }
        });

        // Operaciones básicas
        btnmas.setOnClickListener(v -> updateInput(btnmas));
        btnres.setOnClickListener(v -> updateInput(btnres));
        btnentre.setOnClickListener(v -> updateInput(btnentre));
        btnmul.setOnClickListener(v -> updateInput(btnmul));

        // Funciones avanzadas
        btnraiz.setOnClickListener(v -> updateInput("√"));
        btnsin.setOnClickListener(v -> updateInput("sin("));
        btncos.setOnClickListener(v -> updateInput("cos("));
        btntan.setOnClickListener(v -> updateInput("tan("));
        btnx2.setOnClickListener(v -> calculateSquare());
        btnx3.setOnClickListener(v -> updateInput("^(-1)"));
        btnlog.setOnClickListener(v -> updateInput("log("));
        btnln.setOnClickListener(v -> updateInput("ln("));

        // Función de factorial
        btnxl.setOnClickListener(v -> calculateFactorial());

        // Valor de Pi
        bpi.setOnClickListener(v -> updateInput(pi));

        // Igual
        bequal.setOnClickListener(v -> calculateResult());

        // Borrar todo
        bac.setOnClickListener(v -> {
            tvuno.setText("");
            tvdos.setText("");
        });

        // Borrar último dígito
        bc.setOnClickListener(v -> {
            String res = tvdos.getText().toString();
            if (!res.equals("")) {
                tvdos.setText(res.substring(0, res.length() - 1));
            }
        });

        // Paréntesis
        btnparent.setOnClickListener(v -> updateInput("("));
        btnparent2.setOnClickListener(v -> updateInput(")"));
    }

    // Actualiza el input con el texto del botón
    private void updateInput(Button button) {
        String res = tvdos.getText().toString();
        tvdos.setText(res + button.getText().toString());
    }

    // Actualiza el input con un String
    private void updateInput(String text) {
        String res = tvdos.getText().toString();
        tvdos.setText(res + text);
    }

    // Calcula la raíz cuadrada
    private void calculateSquareRoot() {
        String res = tvdos.getText().toString();
        try {
            double number = Double.parseDouble(res);
            double result = Math.sqrt(Double.parseDouble(res));
            tvdos.setText(String.valueOf(result));
            tvuno.setText("√" + number);
        } catch (NumberFormatException e) {
            tvdos.setText("Error");
        }
    }

    // Calcula el cuadrado de un número
    private void calculateSquare() {
        String res = tvdos.getText().toString();
        try {
            double number = Double.parseDouble(res);
            double square = number * number;
            tvdos.setText(String.valueOf(square));
            tvuno.setText(number + "^2");
        } catch (NumberFormatException e) {
            tvdos.setText("Error");
        }
    }

    // Calcula el factorial de un número
    private void calculateFactorial() {
        String res = tvdos.getText().toString();
        try {
            int number = Integer.parseInt(res);
            int fact = factorial(number);
            tvdos.setText(String.valueOf(fact));
            tvuno.setText(number + "!");
        } catch (NumberFormatException e) {
            tvdos.setText("Error");
        }
    }

    // Función factorial recursiva
    private int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    // Evalúa la expresión y calcula el resultado
    private void calculateResult() {
        String res = tvdos.getText().toString();
        try {
            String replacedString = res.replace("÷", "/")
                    .replace("x", "*")
                    .replace("√", "sqrt");
            double result = eval(replacedString);
            tvdos.setText(String.valueOf(result));
            tvuno.setText(res);
        } catch (Exception e) {
            tvdos.setText("Error");
        }
    }


    // Evalúa una expresión matemática
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // suma
                    else if (eat('-')) x -= parseTerm(); // resta
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplicación
                    else if (eat('/')) x /= parseFactor(); // división
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unario positivo
                if (eat('-')) return -parseFactor(); // unario negativo

                double x;
                int startPos = this.pos;
                if (eat('(')) { // paréntesis
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // números
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // funciones
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);  // Raíz cuadrada
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // potenciación

                return x;
            }


        }.parse();
    }
}
