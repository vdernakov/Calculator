package com.example.vlad.fcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SimpleOperationsFragment extends Fragment {

    Button zeroBtn;
    Button oneBtn;
    Button twoBtn;
    Button threeBtn;
    Button fourBtn;
    Button fiveBtn;
    Button sixBtn;
    Button sevenBtn;
    Button eightBtn;
    Button nineBtn;

    Button additionBtn;
    Button differenceBtn;
    Button multiplyBtn;
    Button divisionBtn;

    Button pointBtn;
    Button signBtn;


    public SimpleOperationsFragment() {
        // Required empty public constructor
    }

    public static SimpleOperationsFragment newInstance() {
        SimpleOperationsFragment fragment = new SimpleOperationsFragment();
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

        View v = inflater.inflate(R.layout.fragment_simple_operations, container, false);
        zeroBtn = (Button) v.findViewById(R.id.fact_btn);
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.zero);
            }
        });
        oneBtn = (Button) v.findViewById(R.id.log_btn);
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.one);
            }
        });
        twoBtn = (Button) v.findViewById(R.id.ln_btn);
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.two);
            }
        });
        threeBtn = (Button) v.findViewById(R.id.pi_btn);
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.three);
            }
        });
        fourBtn = (Button) v.findViewById(R.id.asin_btn);
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.four);
            }
        });
        fiveBtn = (Button) v.findViewById(R.id.acos_btn);
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.five);
            }
        });
        sixBtn = (Button) v.findViewById(R.id.atg_btn);
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.six);
            }
        });
        sevenBtn = (Button) v.findViewById(R.id.sin_btn);
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.seven);
            }
        });
        eightBtn = (Button) v.findViewById(R.id.cos_btn);
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.eight);
            }
        });
        nineBtn = (Button) v.findViewById(R.id.tg_btn);
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.nine);
            }
        });

        pointBtn = (Button) v.findViewById(R.id.pow2_btn);
        pointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendInput(R.string.point);
            }
        });
        signBtn = (Button) v.findViewById(R.id.pow_btn);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeSign();
            }
        });

        additionBtn = (Button) v.findViewById(R.id.ctg_btn);
        additionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation(R.string.plus);
            }
        });
        differenceBtn = (Button) v.findViewById(R.id.actg_btn);
        differenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation(R.string.minus);
            }
        });
        multiplyBtn = (Button) v.findViewById(R.id.sqrt_btn);
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation(R.string.asterisk);
            }
        });
        divisionBtn = (Button) v.findViewById(R.id.exp_btn);
        divisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleOperation(R.string.slash);
            }
        });

        return v;
    }

    private void appendInput(int stringId) {
        String value = getResources().getString(stringId);
        ((MainActivity)getActivity()).appendInput(value);
    }

    private void addSimpleOperation(int stringId) {
        String value = getResources().getString(stringId);
        ((MainActivity)getActivity()).addSimpleOperation(value);
    }

}
