package com.learning.research.xmltojsoncomparator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.learning.research.xmltojsoncomparator.service.ComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class XmlToJsonComparatorApplication {

    @Autowired
    private ComparatorService compareService;

    public static void main(String[] args) {
        SpringApplication.run(XmlToJsonComparatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            JsonNode jsonNode = new ObjectMapper().readTree(new File("sample-json.json"));
            JsonNode xmlNode = new XmlMapper().readTree(new File("sample-xml.xml"));

            if (compareService.compareJson(jsonNode, xmlNode)) {
                System.out.println("JSON and XML are equal");
            } else {
                System.out.println("There are differences in JSON and XML");
            }
            System.exit(1);
        };
    }

}
