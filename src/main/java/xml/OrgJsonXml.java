package xml;

import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

/**
 * @author lianghong
 * @date 10/01/2019
 */

public class OrgJsonXml {
    public static void main(String[] args) throws IOException {
//        jsonToXml();
        jsonWithPropertyToXml();
    }

    public static void jsonToXml() throws IOException {
        // 1. Convert Json String -> XML String
        String jsonStr = "{\"Customer\": {" +
                "\"address\": {" +
                "\"street\": \"NANTERRE CT\"," +
                "\"postcode\": 77471" +
                "}," +
                "\"name\": \"Mary\"," +
                "\"age\": 37" +
                "}}";

        JSONObject json = new JSONObject(jsonStr);
        String xml = XML.toString(json);

        System.out.println(xml);
    }

    public static void jsonWithPropertyToXml() {
        String jsonStr = "{\n" +
                "  \"line\": {\n" +
                "    \"item\": [\n" +
                "      {\n" +
                "        \"@font-size\": \"20\",\n" +
                "        \"#text\": \"name\"\n" +
                "      },\n" +
                "      \"age\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        JSONObject json = new JSONObject(jsonStr);
        String xml = XML.toString(json);

        System.out.println(xml);
    }
}
		/*
		 	<Customer><address><street>NANTERRE CT</street><postcode>77471</postcode></address><name>Mary</name><age>37</age></Customer>

		 	--> pretty-print

			<?xml version="1.0"?>
			<Customer>
			  <address>
			    <street>NANTERRE CT</street>
			    <postcode>77471</postcode>
			  </address>
			  <name>Mary</name>
			  <age>37</age>
			</Customer>
		 */

        // 2. Convert Json File -> XML File
//        String jsonFile = System.getProperty("user.dir") + "\\file.json";
//        String xmlFile = System.getProperty("user.dir") + "\\file.xml";
//
//        jsonStr = new String(Files.readAllBytes(Paths.get(jsonFile)));
//        json = new JSONObject(jsonStr);
//
//        try (FileWriter fileWriter = new FileWriter(xmlFile)){
//            fileWriter.write(XML.toString(json));
//        }
//    }
//}
