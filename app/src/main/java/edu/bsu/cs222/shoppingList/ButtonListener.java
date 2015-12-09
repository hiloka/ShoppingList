package edu.bsu.cs222.shoppingList;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import cajohnson7.cs222.bsu.edu.shoppinglist.R;

class ButtonListener implements View.OnClickListener {
    private  RelativeLayout sourceLayout;
    private Context sourceContext;
    private IngredientsCartFormatter shoppingCartAdapter;
    private Integer addIdNumber;
    private Integer removeIdNumber;
    private Integer viewIdNumber;
    @Override
    public void onClick(View v) {
        Spinner ingredientsSpinner = (Spinner) this.sourceLayout.findViewById(R.id.spinner);
        String getSpinnerValue = (String) ingredientsSpinner.getSelectedItem();
        ListView itemsInCart =
                (ListView)this.sourceLayout.findViewById(R.id.listView2);
        TextView amountOfItems =
                (TextView)this.sourceLayout.findViewById(R.id.textView4);
        addIdNumber=R.id.addButton;
        removeIdNumber=R.id.removeButton;
        if(v.getId()==R.id.addButton){
            shoppingCartAdapter.addItemToCart(getSpinnerValue);
        }
        else if (v.getId()==R.id.removeButton){
            shoppingCartAdapter.removeItemFromCart(getSpinnerValue);
        }
        else{
            amountOfItems.setText(String.format("%s", " no button set"));
        }
        itemsInCart.setAdapter(shoppingCartAdapter.getAdapter());
         amountOfItems.setText(String.format("%s%s%s", " you have ", shoppingCartAdapter.getCartSize(), " items in the cart "));
    }
    public void setContext(Context input){
        sourceContext =input;
        setUpAdapter();
    }
    private void setUpAdapter(){
        this.shoppingCartAdapter = new IngredientsCartFormatter(sourceContext,android.R.layout.simple_list_item_1);
    }
    public void setLayOut(RelativeLayout input){
        this.sourceLayout =input;
    }
}