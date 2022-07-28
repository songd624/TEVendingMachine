package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SalesReport
{
private final String PATH = "src/main/resources";

private final String SALES_REPORT_FILENAME = "sales_report.txt";

private File salesObject;

private PrintWriter writer;

public void salesReport()
{
 salesObject = new File(PATH, SALES_REPORT_FILENAME);

 try
 {
     this.writer = new PrintWriter(new FileOutputStream(this.salesObject), true);
     writer.println();
 } catch (FileNotFoundException e)
 {  //TODO: remove this for final product
     throw new RuntimeException(e);
 }
}

    public void write(String messageToSalesReport) {

    // TODO: add in proper variables
        // TODO: may move total sales

        String saleItemWithQuantity = itemPurchased + "|" + quantityPurchased;
String Total

        this.writer.println(saleItemWithQuantity);
        this.writer.println();
        this.writer.flush();


    }

    public void close() {
        this.writer.flush();
        this.writer.close();
        this.writer = null;
    }

    public boolean isClosed() {
        return this.writer == null;
    }}
