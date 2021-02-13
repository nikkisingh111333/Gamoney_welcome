package Gamoneynew.Gamoneywelcomenew;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearch extends ElasticsearchRepository<Article, String>{

	 List<Article> findByMessage(String name);
	    List<Article> findByName(String name);
}
