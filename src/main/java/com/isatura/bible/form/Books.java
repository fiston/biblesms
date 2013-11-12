package com.isatura.bible.form;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/11/13
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Books")
public class Books {

    @Id
    @Column(name = "number")
    @GeneratedValue
    private int number;
    @Column(name = "abbr_english")
    private String abbrEnglish;
    @Column(name = "Full_name_english")
    private String Full_name_english;
    @Column(name = "chapters")
    private int chapters;
    @Column(name = "abbr_french")
    private String abbrFrench;
    @Column(name = "Full_name_French")
    private String fullNameFrench;

    public String getAbbrEnglish() {
        return abbrEnglish;
    }

    public void setAbbrEnglish(String abbrEnglish) {
        this.abbrEnglish = abbrEnglish;
    }

    public String getAbbrFrench() {
        return abbrFrench;
    }

    public void setAbbrFrench(String abbrFrench) {
        this.abbrFrench = abbrFrench;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getFull_name_english() {
        return Full_name_english;
    }

    public void setFull_name_english(String full_name_english) {
        Full_name_english = full_name_english;
    }

    public String getFullNameFrench() {
        return fullNameFrench;
    }

    public void setFullNameFrench(String fullNameFrench) {
        this.fullNameFrench = fullNameFrench;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
