package com.briup.estore.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 书籍类
 */
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double price;
	private String author;
	private String publisher;
	private Date pubDate;
	private String description;
	private String image;
	private int click;

	public Book() {

	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", publisher="
				+ publisher + ", pubDate=" + pubDate + ", description=" + description + ", image=" + image + "]";
	}

}
