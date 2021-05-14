package jarticle.model;

import javafx.scene.control.Hyperlink;

import java.time.LocalDate;

public class ArticleModel {

    private Integer id;
    private LocalDate year;
    private String title;
    private String category;
    private String link;

    public ArticleModel() {
    }

    public ArticleModel(Integer id, LocalDate year, String title, String category, String websiteUrl) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.category = category;
        this.link = websiteUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String websiteUrl) {
        this.link = websiteUrl;
    }
}