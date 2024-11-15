package org.example.Service.ReadService;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.example.ExceptionHandler.CustomException;
import org.example.Service.SparkService.SparkSessionManager;

import java.util.Optional;

public class ReadFromCSV extends ReadFromFile {

    ReadFromCSV( String filePath){
        super(filePath);
    }

    @Override
    public Optional<?> read() throws Exception {
        return Optional.of(this.readCsvFile());
    }



    protected Dataset<Row> readCsvFile() throws Exception {
        try {
            return SparkSessionManager.getSparkSession()
                    .read()
                    .option("multiline",true)
                    .option("header", true)
                    .csv(this.filePath);

        } catch (RuntimeException ex) {
            {
                ex.printStackTrace();
//                throw new CustomException("invalid file path", 500);
            }
        } finally {
            this.close();
        }
        return null;
    }


    @Override
    public Optional<?> readAndMapToDataset(Class<?> className) throws Exception {
        return Optional.of(this.readCsvFile(className));
    }

    protected Dataset<?> readCsvFile( Class<?> className ) throws Exception {
        try {
            return SparkSessionManager.getSparkSession()
                    .read()
                    .option("header", true)
                    .csv(this.filePath);
            } catch (RuntimeException ex) {
            {
                throw new CustomException("invalid class Name"+ className.toString(),500);
            }
            }finally {
            this.close();
            }
    }

    @Override
    public void close() throws Exception {
        SparkSessionManager.closeSession();
    }
}
