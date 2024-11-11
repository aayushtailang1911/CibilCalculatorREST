package com.CibilCalculator.adapters.writingAdapter;

import com.CibilCalculator.entities.Attribute;
import org.apache.spark.sql.Dataset;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ParquetWriter implements IWriter{
    @Override
    public Optional<?> writeToFile(String outputStoragePath, Dataset<?> outputDataset, List<Attribute> attributeList) throws IOException {
        System.out.println("writing in Parquet File");
        return null;
    }
}
