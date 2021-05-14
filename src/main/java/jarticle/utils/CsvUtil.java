package jarticle.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jarticle.model.ArticleModel;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvUtil {

    private ObservableList<ArticleModel> studentsModels = FXCollections.observableArrayList(
            new ArticleModel(1, LocalDate.of(2021, 01, 01),
                    "TitleA", "CategoryA", "www.thisisanurl1.com"),
            new ArticleModel(2, LocalDate.of(2021, 01, 01),
                    "TitleB", "CategoryB", "www.thisisanurl2.com"));


    public void convertToCsv() throws IOException {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]{"John", "Doe", "38", "truc"});
        dataLines.add(new String[]{"Douh", "Pitch", "18", "test"});

        try (CSVWriter writer = new CSVWriter(new FileWriter("c:/test.csv"))) {
            //    writer.writeAll(csvData);
            //}
        }
    }


    //public void convertArticleToStringArray() {
    //    //studentsModels.stream().map(s -> E)
    //}

}

