package org.example.Service.ReadService;


import org.example.ExceptionHandler.CustomException;

import java.io.Serializable;
import java.util.Optional;
import java.util.StringTokenizer;

public class ReadServiceAdapter implements Serializable,IReadService{

    private final IReadService reader;

    ReadServiceAdapter(String filePath){
        this.reader = getReaderObject(filePath);
        if(reader==null)
            throw new CustomException("Invalid file type",505);
    }
    //Factory method to get object as per file path.
    private IReadService getReaderObject (String filePath){

        //to fetch file type from its path.
        StringTokenizer st = new StringTokenizer(filePath,".");
        if(st.countTokens() != 2)
            throw new CustomException("Invalid file path or file type",505);

        String fileType="";
        while(st.hasMoreTokens())
             fileType = st.nextToken();

        return switch (fileType.toLowerCase()) {
            case "csv" -> new ReadFromCSV(filePath);
            case "json" -> new ReadFromJson(filePath);
            default -> null;
        };
    }

    @Override
    public Optional<?> read() throws Exception {
        return reader.read();
    }

    @Override
    public Optional<?> readAndMapToDataset( Class<?> className) throws Exception {
        return reader.readAndMapToDataset(className);
    }
}
