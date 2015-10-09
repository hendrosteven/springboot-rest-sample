package org.hendrosteven.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hendrosteven.springboot.entity.Produk;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleApplication.class)
@WebIntegrationTest
public class SampleApplicationTests {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testInsertBook() throws JsonProcessingException {
        String urlInsert = "http://localhost:8080/produk/insert";
        String urlUpdate = "http://localhost:8080/produk/update";
        String urlGetAll = "http://localhost:8080/produk/getall";
        String urlGetById = "http://localhost:8080/produk/getbyid/{id}";
        String urlDelete = "http://localhost:8080/produk/delete/{id}";

        Produk produk = new Produk();
        produk.setKode("T001");
        produk.setNama("Test Produk");
        produk.setHarga(2000);

        //test insert
        Produk insertResponse = restTemplate.postForObject(urlInsert, produk, Produk.class);
        assertNotNull(insertResponse);
        assertEquals("T001", insertResponse.getKode());

        //test update
        insertResponse.setKode("T002");
        insertResponse.setNama("Test Produk update");
        insertResponse.setHarga(3000);
        Produk updateResponse = restTemplate.postForObject(urlUpdate, insertResponse, Produk.class);
        assertNotNull(updateResponse);
        assertEquals("T002", updateResponse.getKode());
        assertEquals("Test Produk update", updateResponse.getNama());

        //test getbyid
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", updateResponse.getId());
        Produk getResponse = restTemplate.getForObject(urlGetById, Produk.class, params);
        assertNotNull(getResponse);

        //test getAll
        List<Produk> allResponse = restTemplate.getForObject(urlGetAll, List.class);
        assertNotNull(allResponse);

        //delete
        Map<String, Long> paramDel = new HashMap<String, Long>();
        paramDel.put("id", updateResponse.getId());
        restTemplate.getForObject(urlDelete, Boolean.class, paramDel);

    }

}
