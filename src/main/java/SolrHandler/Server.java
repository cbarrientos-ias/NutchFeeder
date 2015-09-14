package SolrHandler;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 * Created by Barcode on 14/09/2015.
 */
public class Server {
    public static void main(String[] args) throws IOException, SolrServerException {
        String url = "http://192.168.99.100:8080/solr/nutch";
        SolrClient server = new HttpSolrClient(url);
        SolrQuery query = new SolrQuery();
        query.set("q", "url:bitstream");
        query.setRows(8000);
        QueryResponse response = server.query(query);
        SolrDocumentList list = response.getResults();
        System.out.println(list.toString());
    }
}
