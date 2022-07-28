package com.techelevator.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class PullSelectionsFromCSV
{
    private BufferedReader bR;
    private String line = "";

    private final String MAX_ITEM_QUANTITY = "6";
    private String filePath = "/Users/danieldanio/workspace/module-1-capstone-group-0/catering.csv";
    public static Map<String, String> inputCodeToSelectionMap = new HashMap<>();          //SelectionCode, Name
    public static Map<String, String> inputSelectionToPriceMap = new HashMap<>();         //Name, Price
    public static Map<String, String> inputSelectionToCategoryMap = new HashMap<>();      //Name, Type
    public static Map<String, String> inputSelectionToQuantityMap = new HashMap<>();      //SelectionCode, MAX_ITEM_QUANTITY(6)


    public void pullSelectionsFromCSV()
    {
        try
        {
            bR = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        while (true)
        {
            try
            {
                if (!((line = bR.readLine()) != null)) break;
                String[] values = line.split(",");
                inputCodeToSelectionMap.put(values[0], values[1]);
                inputSelectionToPriceMap.put(values[1], values[3]);
                inputSelectionToCategoryMap.put(values[1], values[4]);
                inputSelectionToQuantityMap.put(values[0], MAX_ITEM_QUANTITY);

            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }
}
