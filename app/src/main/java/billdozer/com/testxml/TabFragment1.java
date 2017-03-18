package billdozer.com.testxml;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class TabFragment1 extends Fragment implements View.OnClickListener {

    ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    OnFragmentButtonClick fragmentButtonClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        b1 = (ImageButton) view.findViewById(R.id.food_btn);
        b1.setOnClickListener(this);
        b2 = (ImageButton) view.findViewById(R.id.shopping_btn);
        b2.setOnClickListener(this);
        b3 = (ImageButton) view.findViewById(R.id.healthcare_btn);
        b3.setOnClickListener(this);
        b4 = (ImageButton) view.findViewById(R.id.home_btn);
        b4.setOnClickListener(this);
        b5 = (ImageButton) view.findViewById(R.id.travel_btn);
        b5.setOnClickListener(this);
        b6 = (ImageButton) view.findViewById(R.id.family_btn);
        b6.setOnClickListener(this);
        b7 = (ImageButton) view.findViewById(R.id.groceries_btn);
        b7.setOnClickListener(this);
        b8 = (ImageButton) view.findViewById(R.id.bills_btn);
        b8.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.food_btn:
                b1.setImageResource(R.drawable.green_food);
                fragmentButtonClick.onFragmentChoose("food");
                break;

            case R.id.shopping_btn:
                b2.setImageResource(R.drawable.green_shopping);
                fragmentButtonClick.onFragmentChoose("shopping");
                break;

            case R.id.healthcare_btn:
                b3.setImageResource(R.drawable.green_healthcare);
                fragmentButtonClick.onFragmentChoose("healthcare");
                break;

            case R.id.home_btn:
                b4.setImageResource(R.drawable.green_home);
                fragmentButtonClick.onFragmentChoose("home");
                break;

            case R.id.travel_btn:
                b5.setImageResource(R.drawable.green_travel);
                fragmentButtonClick.onFragmentChoose("travel");
                break;

            case R.id.family_btn:
                b6.setImageResource(R.drawable.green_family);
                fragmentButtonClick.onFragmentChoose("family");
                break;

            case R.id.groceries_btn:
                b7.setImageResource(R.drawable.green_groceries);
                fragmentButtonClick.onFragmentChoose("groceries");
                break;

            case R.id.bills_btn:
                b8.setImageResource(R.drawable.green_bills);
                fragmentButtonClick.onFragmentChoose("bills");
                break;
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        fragmentButtonClick = (OnFragmentButtonClick) context;
    }
}