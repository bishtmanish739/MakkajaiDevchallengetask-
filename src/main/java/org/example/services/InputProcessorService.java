package org.example.services;
import org.example.enums.ItemCategory;
import org.example.model.Item;

import java.util.List;

public class InputProcessorService {


    public static Item processInput(String input) throws Exception {
        String[]  parts=input.split(" ");
        String itemTitle=getItemTitle(parts);
        input=input.toLowerCase();
        boolean isImported=input.contains(" imported ");
        input=input.replace(" imported "," ");
        parts=input.split(" ");
        if(parts.length<4 || !input.contains("at")){
            throw new Exception("invalid input");
        }




        int quantity = Integer.parseInt(parts[0]);
        String name = findItemName(parts);

        double price = Double.parseDouble(parts[parts.length-1]);

        return new Item(name,quantity,price,isImported,findItemCategory(name),itemTitle);



    }

    private static String getItemTitle(String[] parts) {
        String itemTitle="";
        for(int i=1;i< parts.length;i++){
            if(parts[i].equals("at")){
                return itemTitle.trim();
            }
            else {
               itemTitle= itemTitle.concat(parts[i]);
                itemTitle=itemTitle.concat(" ");
            }
        }
        return itemTitle.trim();
    }

    private static String findItemName(String[]  parts){
        String itemName= "";
        for(int i=1;i<parts.length-2;i++){
            if(parts[i].equals("of")){
                itemName = "";
            }
            else{
               itemName= itemName.concat(parts[i]);
               itemName= itemName.concat(" ");
            }

        }
       return itemName.trim();


    }
   private static ItemCategory findItemCategory(String name){
       List<String> medicalProducts=List.of("pills","tablet","serum","injection","headache pills");
       List<String> foodProducts=List.of("chocolate bar","rice","grain","biscuit","chocolates");

       if(name.equalsIgnoreCase("book"))
           return ItemCategory.BOOK;
       if(medicalProducts.contains(name.toLowerCase())){
           return ItemCategory.MEDICAL_PRODUCT;
       }
       if(foodProducts.contains(name.toLowerCase())){
           return ItemCategory.FOOD;
       }
       return ItemCategory.OTHER;


   }
}
