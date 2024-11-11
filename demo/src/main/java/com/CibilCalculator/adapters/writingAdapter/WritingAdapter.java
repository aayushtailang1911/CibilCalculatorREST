package com.CibilCalculator.adapters.writingAdapter;

import com.CibilCalculator.entities.Attribute;
import org.apache.spark.sql.Dataset;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class WritingAdapter implements IWriter{

    private IWriter writer;

    public WritingAdapter(String writer) {
        this.writer = this.getWriter(writer);
    }

    public IWriter getWriter(String format){
        if(format.contains("csv")){
            return new CSVWriter();
        }
        else {
            return new ParquetWriter();
        }
    }

    @Override
    public Optional<?> writeToFile(String outputStoragePath, Dataset<?> outputDataset, List<Attribute> attributeList) throws IOException {
        return writer.writeToFile(outputStoragePath,outputDataset,attributeList);
    }
}
