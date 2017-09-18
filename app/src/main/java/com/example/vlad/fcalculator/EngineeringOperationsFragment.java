package com.example.vlad.fcalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class EngineeringOperationsFragment extends Fragment {

    Button sinBtn;
    Button cosBtn;
    Button tgBtn;
    Button ctgBtn;
    Button asinBtn;
    Button acosBtn;
    Button atgBtn;
    Button actgBtn;
    Button logBtn;
    Button lnBtn;
    Button piBtn;
    Button sqrtBtn;
    Button factBtn;
    Button pow2Btn;
    Button powBtn;
    Button expBtn;

    public EngineeringOperationsFragment() {

    }


    public static EngineeringOperationsFragment newInstance() {
        EngineeringOperationsFragment fragment = new EngineeringOperationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_engineering_operations, container, false);

        sinBtn = (Button) v.findViewById(R.id.sin_btn);
        sinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.sin);
            }
        });
        cosBtn = (Button) v.findViewById(R.id.cos_btn);
        cosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.cos);
            }
        });
        tgBtn = (Button) v.findViewById(R.id.tg_btn);
        tgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.tg);
            }
        });
        ctgBtn = (Button) v.findViewById(R.id.ctg_btn);
        ctgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.ctg);
            }
        });
        asinBtn = (Button) v.findViewById(R.id.asin_btn);
        asinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.asin);
            }
        });
        acosBtn = (Button) v.findViewById(R.id.acos_btn);
        acosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.acos);
            }
        });
        atgBtn = (Button) v.findViewById(R.id.atg_btn);
        atgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.atg);
            }
        });
        actgBtn = (Button) v.findViewById(R.id.actg_btn);
        actgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.actg);
            }
        });
        logBtn = (Button) v.findViewById(R.id.log_btn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.log);
            }
        });
        lnBtn = (Button) v.findViewById(R.id.ln_btn);
        lnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.ln);
            }
        });
        sqrtBtn = (Button) v.findViewById(R.id.sqrt_btn);
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.sqrt);
            }
        });
        expBtn = (Button) v.findViewById(R.id.exp_btn);
        expBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEngineeringOperation(R.string.exp);
            }
        });
        piBtn = (Button) v.findViewById(R.id.pi_btn);
        piBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setInput(String.valueOf(Math.PI));
            }
        });
        pow2Btn = (Button) v.findViewById(R.id.pow2_btn);
        pow2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = ((MainActivity) getActivity()).getInput();
                if (currentInput.length() >= 0) {
                    ((MainActivity) getActivity()).appendExpression(currentInput);
                }
                ((MainActivity) getActivity()).appendExpression("^2");
                ((MainActivity) getActivity()).setInput("");
            }
        });
        powBtn = (Button) v.findViewById(R.id.pow_btn);
        powBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = ((MainActivity) getActivity()).getInput();
                if (currentInput.length() >= 0) {
                    ((MainActivity) getActivity()).appendExpression(currentInput);
                }
                ((MainActivity) getActivity()).appendExpression("^");
                ((MainActivity) getActivity()).setInput("");
            }
        });
        factBtn = (Button) v.findViewById(R.id.fact_btn);
        factBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentInput = ((MainActivity) getActivity()).getInput();
                if (currentInput.length() >= 0) {
                    ((MainActivity) getActivity()).appendExpression(currentInput);
                }
                ((MainActivity) getActivity()).appendExpression("!");
                ((MainActivity) getActivity()).setInput("");
            }
        });


        return v;
    }

    private void addEngineeringOperation(int operationId) {
        String operation = getResources().getString(operationId);
        ((MainActivity)getActivity()).addEngineeringOperation(operation);
    }

}
