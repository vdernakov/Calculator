package com.example.vlad.fcalculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String EXPRESSION_TAG = "expression";
    private static final String INPUT_TAG = "input";


    ViewPager viewPager;

    EditText expression;
    TextView input;

    Button leftBracketButton;
    Button rightBracketButton;
    Button delButton;
    Button clearBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        input = (TextView) findViewById(R.id.input);
        input.setText("");
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Calculator.isCalculated()) {
                    appendExpression(getInput());
                    String expression = getExpression();
                    appendExpression("=");
                    String result = Calculator.calculate(expression);
                    setInput(result);
                }
            }
        });

        expression = (EditText) findViewById(R.id.expression);
        expression.setText("");
        expression.setEnabled(false);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            String expression = savedInstanceState.getString(EXPRESSION_TAG);
            setExpression(expression);
            String input = savedInstanceState.getString(INPUT_TAG);
            setInput(input);
        }

        leftBracketButton = (Button) findViewById(R.id.left_bracket_btn);
        leftBracketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBracket("(");
            }
        });
        rightBracketButton = (Button) findViewById(R.id.right_bracket_btn);
        rightBracketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBracket(")");
            }
        });

        delButton = (Button) findViewById(R.id.del_btn);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = getInput();
                String newInput;
                if (currentInput.length() <= 1) {
                    newInput = "";
                } else {
                    newInput = currentInput.substring(0, currentInput.length() - 1);
                }
                setInput(newInput);
            }
        });
        clearBtn = (Button) findViewById(R.id.clear_btn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInput("");
                setExpression("");
                Calculator.resetCalculated();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return EngineeringOperationsFragment.newInstance();
                }
                return SimpleOperationsFragment.newInstance();
            }
            @Override
            public int getCount() {
                return 2;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(EXPRESSION_TAG, getExpression());
        outState.putString(INPUT_TAG, getInput());
        super.onSaveInstanceState(outState);
    }

    public String getInput() {
        return input.getText().toString();
    }

    public void setInput(String text) {
        if (text.length() >= 12) {
            text = String.format("%.12s", Float.valueOf(text));
        }
        input.setText(text);
    }

    public String getExpression() {
        return expression.getText().toString();
    }

    public void setExpression(String text) {
        expression.setText(text);
    }

    public void appendInput(String str) {
        if (getInput().equals("Error")) return;
        if (Calculator.isCalculated()) {
            setExpression("");
            setInput(str);
            Calculator.resetCalculated();
            return;
        }
        String currentInput = getInput();
        String newInput;
        // limit 12 symbols
        if (currentInput.length() >= 11) {
            return;
        }
        // delete the first 0
        if (currentInput.equals("0") && !str.equals(".")) {
            newInput = str;
            setInput(newInput);
            return;
        }
        // forbid two . (dots)
        if (currentInput.indexOf(".") >= 0 && str.equals(".")) {
            return;
        }

        newInput = currentInput + str;
        setInput(newInput);
    }

    public void appendExpression(String str) {
        if (getInput().equals("Error")) return;
        String currentExpression = getExpression();
        String newExpression = currentExpression + str;
        setExpression(newExpression);
    }

    public void changeSign() {
        if (getInput().equals("Error")) return;
        String currentInput = getInput();
        String newInput;
        if (currentInput.indexOf("-") == 0) {
            newInput = currentInput.substring(1);
        } else {
            newInput = "-" + currentInput;
        }
        setInput(newInput);
    }

    public void addSimpleOperation(String str) {
        if (getInput().equals("Error")) return;
        if (Calculator.isCalculated()) {
            setExpression(getInput());
            Calculator.resetCalculated();
        } else {
            appendExpression(getInput());
        }
        appendExpression(str);
        setInput("");
    }

    public void addBracket(String bracket) {
        if (getInput().equals("Error")) return;
        if (Calculator.isCalculated()) {
            setInput("");
            setExpression(bracket);
            Calculator.resetCalculated();
            return;
        }
        if (getInput().length() > 0) {
            appendExpression(getInput());
        }
        appendExpression(bracket);
        setInput("");
    }

    public void addEngineeringOperation(String operation) {
        if (getInput().equals("Error")) return;
        if (Calculator.isCalculated()) {
            setExpression(operation);
            Calculator.resetCalculated();
        } else {
            appendExpression(operation);
        }
        appendExpression("(");
        setInput("");

    }
}
