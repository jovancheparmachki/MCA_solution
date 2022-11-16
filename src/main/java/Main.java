import com.fasterxml.jackson.databind.ObjectMapper;
import models.Receipt;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        URI url=new URI("https://interview-task-api.mca.dev/qr-scanner-codes/alpha-qr-gFpwhsQ8fkY1");
        String json = IOUtils.toString(url, Charset.forName("UTF-8"));
        JSONArray jsonArray=new JSONArray(json);
        List<Receipt> domesticReceipts=new ArrayList<>();
        List<Receipt> importedReceipts=new ArrayList<>();
        float domesticCost=0.0f;
        float importedCost=0.0f;
        for (int i=0;i<jsonArray.length();i++){
            JSONObject o=jsonArray.getJSONObject(i);
            String weight;
            if (o.has("weight"))
                weight=String.valueOf(o.getInt("weight"));
            else
                weight="N/A";

            Receipt recipt= new Receipt(o.getString("name"),o.getBoolean("domestic"),o.getFloat("price"),weight,o.getString("description"));
            if (recipt.isDomestic()){
                domesticReceipts.add(recipt);
                domesticCost+=recipt.getPrice();
            }

            else{
                importedReceipts.add(recipt);
                importedCost+=recipt.getPrice();
            }

        }

        Collections.sort(domesticReceipts, Comparator.comparing(Receipt::getName));
        Collections.sort(importedReceipts, Comparator.comparing(Receipt::getName));

        for (Receipt r:domesticReceipts) {
            System.out.println(r.printNav());
        }
        for (Receipt r:importedReceipts){
            System.out.println(r.printNav());
        }
        System.out.println(String.format("Domestic cost: %.01f",domesticCost));
        System.out.println(String.format("Imported cost: %.01f",importedCost));
        System.out.println(String.format("Domestic count: %d",domesticReceipts.size()));
        System.out.println(String.format("Imported count: %d",importedReceipts.size()));

    }
}
