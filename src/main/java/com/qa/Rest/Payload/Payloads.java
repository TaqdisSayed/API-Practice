package com.qa.Rest.Payload;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.Rest.POJO.AppointmentType;
import com.qa.Rest.POJO.LineId;
import com.qa.Rest.POJO.Search;
import com.qa.Rest.POJO.Status;
import org.json.JSONObject;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Payloads {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> mapper1;

    public static ObjectNode objNode;

    public static ArrayNode namesNode;

    public static String jsonRequest;

    public static JSONObject jsonObject;


    public static Search SearchRequestFromPoJo() {
        System.out.println("inside playlist builder");
        return Search.
                builder().
                ccsIdOrContNoOrContApptNo("CAMCR000035Y").
                apptDateTo("").
                apptDateFrom("").
                subContractCompanyId("").
                subContractCompanyName("").
                apptDateTo("").
                truckingCompanyName("")
                // appointmentType(AppointmentType.builder().methods(new String[]{"",""}).build())
                .appointmentType(new String[]{})
                .clientCode("").
                driverPortPassId("").
                lineId(new String[]{}).
                //lineId(LineId.builder().id(new String[]{"",""}).build()).
                        passNo("").
                order("").
                grade("").
                pageNo("").
                pageSize("").
                site("").
                referenceNo("").
                status(new String[]{}).
                //status(Status.builder().st(new String[]{"",""}).build()).
                        truckId("").
                truckVisitAppointmentNo("").
                build();


    }

    public static Map<String, Object> setgetPayload(String jsonPayload, String Attribute_type, String key, String value) throws IOException {
        mapper1 = objectMapper.readValue(new File(jsonPayload),
                new TypeReference<Map<String, Object>>() {
                });

        objNode = objectMapper.createObjectNode();
        namesNode = objNode.arrayNode();
        namesNode.add(value);

        String type = Attribute_type;
        switch (type) {
            case "Array":
                System.out.println("Array");
                mapper1.put(key, namesNode);
                jsonRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper1);
                System.out.println(jsonRequest);
                break;
            case "Array1":
                System.out.println("Tuesday");
                break;
            case "Array2":
                System.out.println("Wednesday");
                break;
        }


        return mapper1;


    }
}
