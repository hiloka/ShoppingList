package edu.bsu.cs222.shoppingList;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import cajohnson7.cs222.bsu.edu.shoppinglist.R;

class ButtonEvent  implements View.OnClickListener {
    private  RelativeLayout myLayout;
    private Context tempContext;
    private IngredientsCartFormatter myAdapter;
    @Override
    public void onClick(View v) {
        Spinner ingredientsSpinner = (Spinner) this.myLayout.findViewById(R.id.spinner);
        String getSpinnerValue = (String) ingredientsSpinner.getSelectedItem();
        ListView itemsInCart =
                (ListView)this.myLayout.findViewById(R.id.listView2);
        TextView amountOfItems =
                (TextView)this.myLayout.findViewById(R.id.textView4);
        if(v.getId()==R.id.button){
            myAdapter.add(getSpinnerValue);
        }
        else if (v.getId()==R.id.button4){
            myAdapter.remove(getSpinnerValue);
        }
        else{
            amountOfItems.setText(String.format("%s", " no button set"));
        }
        itemsInCart.setAdapter(myAdapter.getAdapter());
         amountOfItems.setText(String.format("%s%s%s", " you have " , myAdapter.cartSize(), " items in the cart "));
    }
    public void setContext(Context input){
        tempContext=input;
        setUpAdapter();
    }
    private void setUpAdapter(){
        this.myAdapter = new IngredientsCartFormatter(tempContext,android.R.layout.simple_list_item_1);
    }
    public void setLayOut(RelativeLayout input){
        this.myLayout=input;
    }
}