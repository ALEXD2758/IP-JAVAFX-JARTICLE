package jarticle.controller;

import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import jarticle.model.ArticleModel;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<ArticleModel, Integer> id;
    @FXML
    private TableColumn<ArticleModel, LocalDate> year;
    @FXML
    private TableColumn<ArticleModel, String> title;
    @FXML
    private TableColumn<ArticleModel, String> category;
    @FXML
    private TableColumn<ArticleModel, String> link;

    private final HostServices hostServices ;

    public HomeController(HostServices hostServices) {
        this.hostServices = hostServices ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView.setStyle("-fx-selection-bar: royalblue; -fx-selection-bar-non-focused: cornflowerblue;");

        id.setCellValueFactory(new PropertyValueFactory<ArticleModel, Integer>("Id"));
        year.setCellValueFactory(new PropertyValueFactory<ArticleModel, LocalDate>("Year"));
        title.setCellValueFactory(new PropertyValueFactory<ArticleModel, String>("Title"));
        category.setCellValueFactory(new PropertyValueFactory<ArticleModel, String>("Category"));
        link.setCellValueFactory(new PropertyValueFactory<ArticleModel, String>("Link"));
        setColumnWithClickableUrl(link);

        id.setVisible(false);
        tableView.setPlaceholder(new Label("No rows to display"));
        tableView.setItems(studentsModels);
    }

    private void setColumnWithClickableUrl(TableColumn<ArticleModel, String> linkColumn) {
        linkColumn.setCellFactory(new Callback<TableColumn<ArticleModel, String>, TableCell<ArticleModel, String>>() {
            @Override
            public TableCell<ArticleModel, String> call(TableColumn<ArticleModel, String> param) {
                TableCell<ArticleModel, String> cell = new TableCell<ArticleModel, String>() {
                    private final Hyperlink hyperlink = new Hyperlink();

                    {
                        hyperlink.setOnAction(event -> {
                            event.consume();
                            getTableView().getSelectionModel().select(getIndex(), getTableColumn());
                            hostServices.showDocument(getTableView().getSelectionModel().getSelectedItem().getLink());
                        });
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            hyperlink.setText(item);
                            setGraphic(hyperlink);
                        }
                    }
                };
                return cell;
            }
        });
    }

    private ObservableList<ArticleModel> studentsModels = FXCollections.observableArrayList(
            new ArticleModel(1, LocalDate.of(2021,01,01),
                    "TitleA", "CategoryA", "www.thisisanurl1.com"),
            new ArticleModel(2, LocalDate.of(2021,01,01),
                    "TitleB", "CategoryB", "www.thisisanurl2.com"));

}
