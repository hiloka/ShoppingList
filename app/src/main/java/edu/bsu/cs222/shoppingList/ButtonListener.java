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

    public ButtonListener(Context input){
        this.sourceContext=input;
        setUpAdapter();
    }
    @Override
    public void onClick(View v) {
        Spinner ingredientsSpinner = (Spinner) this.sourceLayout.findViewById(R.id.spinner);
        String getSpinnerValue = (String) ingredientsSpinner.getSelectedItem();
        ListView itemsInCart =
                (ListView)this.sourceLayout.findViewById(R.id.listView2);
        TextView amountOfItems =
                (TextView)this.sourceLayout.findViewById(R.id.textView4);
        Integer addIdNumber = R.id.addButton;
        Integer removeIdNumber = R.id.removeButton;
        Integer viewIdNumber = v.getId();
        if(viewIdNumber.equals(addIdNumber)){
            shoppingCartAdapter.addItemToCart(getSpinnerValue);
        }
        else if (viewIdNumber.equals(removeIdNumber)){
            shoppingCartAdapter.removeItemFromCart(getSpinnerValue);
        }
        else{
            amountOfItems.setText(String.format("%s", " no button set"));
        }
        itemsInCart.setAdapter(shoppingCartAdapter.getAdapter());
         amountOfItems.setText(String.format("%s%s%s", " you have ", shoppingCartAdapter.getCartSize(), " items in the cart "));
    }
    private void setUpAdapter(){
        this.shoppingCartAdapter = new IngredientsCartFormatter(sourceContext,android.R.layout.simple_list_item_1);
    }
    public void setLayOut(RelativeLayout input){
        this.sourceLayout =input;
    }
}