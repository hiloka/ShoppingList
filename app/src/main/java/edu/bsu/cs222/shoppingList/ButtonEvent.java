package edu.bsu.cs222.shoppingList;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import cajohnson7.cs222.bsu.edu.shoppinglist.R;

class ButtonEvent implements View.OnClickListener {
    private IngredientsCart shoppingCart = new IngredientsCart();
    private  RelativeLayout myLayout;
    
    public void setLayOut(RelativeLayout input){
        this.myLayout=input;
    }
    @Override
    public void onClick(View v) {
        TextView itemsInCart =
                (TextView)this.myLayout.findViewById(R.id.textView2);
        TextView amountOfItems =
                (TextView)this.myLayout.findViewById(R.id.textView4);
        if(v.getId()==R.id.button){
            Spinner ingredientsSpinner = (Spinner) this.myLayout.findViewById(R.id.spinner);
            String getSpinnerValue = (String) ingredientsSpinner.getSelectedItem();
            shoppingCart.addItemToCart(getSpinnerValue);
        }
        else if (v.getId()==R.id.button4){
            shoppingCart.removeItemFromCart();
        }
        else{
            itemsInCart.setText("no button");
        }
        ScrollView myScrollView = (ScrollView) this.myLayout.findViewById(R.id.scrollView);
        itemsInCart.setMovementMethod(new ScrollingMovementMethod());
        myScrollView.scrollTo(0, itemsInCart.getHeight());
        itemsInCart.setText(shoppingCart.returnedCart());
        amountOfItems.setText("you have " + shoppingCart.cartSize() + " items in the cart");
    }

}

