package Gamoneynew.Gamoneywelcomenew;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "article")
public class Article {
	@Id
	  private String id;
	  
	  @Field(type = FieldType.Text, name = "name")
	  private String name;
	  
	  @Field(type = FieldType.Text, name = "message")
	  private String message;
	  public Article(String name,String msg) {
		  this.name=name;
		  this.message=msg;
	  }
	  
}
