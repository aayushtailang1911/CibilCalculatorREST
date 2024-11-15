package org.example.Service.ReadService;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IReadService {

    Optional<?> read() throws Exception;

    Optional<?> readAndMapToDataset(Class<?> className) throws Exception;

}
