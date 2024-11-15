package org.example.Service.ReadService;

import java.util.Optional;

public abstract class ReadFromFile implements IReadService,AutoCloseable{

    protected String filePath;

    ReadFromFile(String filePath){
        this.filePath = filePath;
    }

   public abstract Optional<?> read() throws Exception;

   public abstract Optional<?> readAndMapToDataset(Class<?> className) throws Exception;

}
