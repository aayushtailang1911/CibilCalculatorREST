package org.example.Service.ReadService;

import java.util.HashMap;
import java.util.Map;

public abstract class ReadFromDatabase implements IReadService{

    protected final Map<String,String> databaseCredentialsMap ;

    ReadFromDatabase(){
        this.databaseCredentialsMap = new HashMap<>();

    }

}
