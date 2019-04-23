package com.movies;
import java.util.*;

/**
 * 
 */
public class Movie {

    /**
     * Default constructor
     */
    public Movie(String url, String title, List<String> tags)
    {
        this.setUrl(url);
        this.setTitle(title);
        this.setTags(tags);
    }

    private String url;
    private String title;
    private List<String> tags;

    /**
     * Getters and Setters
     */
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<String> getTags()
    {
        return tags;
    }

    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }
}