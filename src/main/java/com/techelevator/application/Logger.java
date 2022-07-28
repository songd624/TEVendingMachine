package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger
{
    private final String PATH = "src/main/resources";
    private final String AUDIT_LOG_FILENAME = "audit.txt";
    private File fileObj;
    private PrintWriter writer;

    public Logger() {
        fileObj = new File(PATH, AUDIT_LOG_FILENAME);

        try
        {
            this.writer = new PrintWriter(new FileOutputStream(this.fileObj), true);
            writer.println();
        } catch (FileNotFoundException e) {
            //TODO: remove this for final product
            System.out.println("ERROR: File creation not valid!");
        }
    }

    public void write(String messageToLog) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter currentFormatted = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String formattedDateAndTime = current.format(currentFormatted);
        String messageWithTimeStamp = formattedDateAndTime + " " + messageToLog;

        this.writer.println(messageWithTimeStamp);
        this.writer.flush();

        // TODO: add selection number into audit.txt
        // 1/01/2022 12:00:20 PM 7Down           B4 $10.00   $6.75
    }

    public void close() {
        this.writer.flush();
        this.writer.close();
        this.writer = null;
    }

    public boolean isClosed() {
        return this.writer == null;
    }
}
