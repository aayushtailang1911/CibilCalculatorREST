package com.CibilCalculator.adapters.writingAdapter;

import com.CibilCalculator.entities.Attribute;
import com.CibilCalculator.entities.OutputSubject;
import org.apache.hadoop.fs.PathNotFoundException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import com.CibilCalculator.helpers.AttributeHelperClass;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CSVWriter implements IWriter{
    @Override
    public Optional<?> writeToFile(String outputStoragePath, Dataset<?> outputDataset, List<Attribute> attributeList) throws IOException {
        System.out.println("writing in CSV file");
        try{
            writeCsvWithOverwrite( outputStoragePath, formatToOutputDataset(outputDataset,attributeList));

            return Optional.of(Boolean.TRUE);
        }
        catch(Exception e){
            return Optional.of(Boolean.FALSE);
        }
    }

    private Dataset<OutputSubject> formatToOutputDataset(Dataset<?> outputDataset, List<Attribute> attributeList){
        outputDataset = outputDataset.as(Encoders.bean(OutputSubject.class));

        return AttributeHelperClass.addAttributeColumns(outputDataset,AttributeHelperClass.getAttributeNames(attributeList));
    }

    private static void writeCsvWithOverwrite(String outputStoragePath, Dataset<?> outputDataset) throws PathNotFoundException,IOException {

        System.out.println("total number of records : "+outputDataset.count());
        outputDataset.drop("attributeScore").select("*").show((int) outputDataset.count());

        //persisting output in csv file
        outputDataset.toDF()
                .coalesce(1)
//                .drop("attributeScore")
                .orderBy("userId")
                .write()
                .format("csv")
                .option("header", "true")
                .mode("overwrite")
                .save(outputStoragePath);
    }

}
