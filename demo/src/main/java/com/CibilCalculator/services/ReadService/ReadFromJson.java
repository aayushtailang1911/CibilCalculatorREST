package org.example.Service.ReadService;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.example.ExceptionHandler.CustomException;
import org.example.Service.SparkService.SparkSessionManager;

import java.util.Optional;

public class ReadFromJson implements IReadService,AutoCloseable {

    String filePath;

    ReadFromJson( String filePath){
        this.filePath = filePath;
    }

    @Override
    public Optional<?> read() throws Exception {
        return Optional.of(this.readJsonFile());
    }

    @Override
    public Optional<?> readAndMapToDataset(Class<?> className) throws Exception {
        return Optional.of(this.readJsonFile(className));
    }

    public Dataset<?> readJsonFile( Class<?> className ) throws Exception {
        try {
            return SparkSessionManager.getSparkSession()
                    .read()
                    .option("multiline",true)
                    .json(this.filePath);
                   // .as(Encoders.bean(className));
        } catch (Exception ex) {
            {
                ex.printStackTrace();
//                throw new CustomException("invalid class Name"+ className.toString(),500);
            }
        }finally {
            this.close();
        }
        return null;

    }

    public Dataset<Row> readJsonFile() throws Exception {
        try {
            return SparkSessionManager.getSparkSession()
                    .read()
                    .option("multiline",true)
                    .option("header", true)
                    .json(this.filePath);

        } catch (RuntimeException ex) {
            {
                throw new CustomException("invalid file path", 500);
            }
        } finally {
            this.close();
        }
    }

    @Override
    public void close() throws  Exception {
        SparkSessionManager.closeSession();
    }
}
