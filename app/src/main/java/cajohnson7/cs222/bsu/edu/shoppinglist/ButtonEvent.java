package cajohnson7.cs222.bsu.edu.shoppinglist;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

class ButtonEvent implements View.OnClickListener {
    private IngredientsCart myCart= new IngredientsCart();
    private  RelativeLayout myLayout;

    public void setLayOut(RelativeLayout input){
        this.myLayout=input;
    }
    @Override
    public void onClick(View v) {

        TextView myTextView =
                (TextView)this.myLayout.findViewById(R.id.textView2);
        TextView myTextView2 =
                (TextView)this.myLayout.findViewById(R.id.textView4);

        if(v.getId()==R.id.button){
            Spinner getSpinner = (Spinner) this.myLayout.findViewById(R.id.spinner);
            String getSpinnerValue = (String) getSpinner.getSelectedItem();
            myCart.addItemToCart(getSpinnerValue);
        }
        else if (v.getId()==R.id.button4){
            myCart.removeItemFromCart();
        }
        else{
            System.out.println("no button");
        }
        ScrollView myScrollView = (ScrollView) this.myLayout.findViewById(R.id.scrollView);
        myTextView.setMovementMethod(new ScrollingMovementMethod());
        myScrollView.scrollTo(0, myTextView.getHeight());
        myTextView.setText(myCart.returnedCart());
        myTextView2.setText("you have "+myCart.cartSize()+" items in the cart");
    }
}

