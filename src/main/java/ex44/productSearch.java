/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 RAYME PERSAD
 */

/*
Create a program that takes a product name as input and retrieves the current price and quantity for that product.
The product data is in a data file in the JSON format  and looks like this (you will create this file as `exercise44_input.json`):


{
    "products" : [
        {"name": "Widget", "price": 25.00, "quantity": 5 },
        {"name": "Thing", "price": 15.00, "quantity": 5 },
        {"name": "Doodad", "price": 5.00, "quantity": 10 }
    ]
}
Print out the product name, price, and quantity if the product is found.
If no product matches the search, state that no product was found and start over.
 */

package ex44;

public class productSearch {
    public static void main(String[] args) {
        //To read json file, first you need to add one external library
        //This is the library json-simple-1.1.1.jar
        //Create one json parser object
        JSONParser parser = new JSONParser();
        try {
            //Read json file using parser and store it in obj
            Object obj = parser.parse(new FileReader("D:/products.json"));
            //Create json object to read internal values
            JSONObject jsonObject = (JSONObject)obj;
            //Reading products array from  the file
            JSONArray subjects = (JSONArray)jsonObject.get("products");
            //Create buffered reader object to take user input
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //Create string variable
            String input;
            //Flag is used whether given string is present or not
            int flag = 0;
            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();
            //Create iterator for products array
            Iterator iterator = subjects.iterator();
            //Loop through the iterator
            while (iterator.hasNext()) {
                //Create another json
                JSONObject json = (JSONObject) iterator.next();
                //Get the name value
                String name = (String)json.get("name");
                //Compare it with given input
                if(input.toLowerCase().equals(name.toLowerCase())){
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1;
                }
            }
            //If flag value is zero, then value is not found
            if(flag == 0){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
