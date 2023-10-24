package entity;

import java.io.File;

public class Resource {
    private String link;
    private File bibTex;

    // setters
    public void setLink(String link){
        this.link = link;
    }
    public void setBibtex(File bibtex){
        this.bibTex = bibtex;
    }

    //getters
    public File getBibtex(){
        return this.bibTex;
    }
    public String getLink(){
        return this.link;
    }
}
