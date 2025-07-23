package org.example.kandopeldacalloutjavafx;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

//import static javax.xml.catalog.BaseEntry.CatalogEntryType.URI;

public class GroqService {
    public static String getResponseJson(String question) throws IOException {
        String groqApiKey = Credentials.groqApiKey;

        String method = "POST";
        String endpoint = "https://api.groq.com/openai/v1/chat/completions";
        String headerKey1 = "Content-Type";
        String headerValue1 = "application/json";
        String headerKey2 = "Authorization";
        String headerValue2 = "Bearer "+groqApiKey;
        String inputBody = """
                {
                    "model": "deepseek-r1-distill-llama-70b",
                    "messages": [
                        {
                            "role": "user",
                            "content": """ +"\""+question+"\""+ """
                        }
                    ]
                }
                """;

        URL url = new URL(endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + groqApiKey);
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        byte[] input = inputBody.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);

        int code = con.getResponseCode();
        System.out.println("Response code: " + code);
        // Read response from con.getInputStream() if needed
        InputStream responseInputStream = con.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(responseInputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        String jsonString = response.toString();
        System.out.println(jsonString); // Optional: see raw JSON

        int i=2;

        return jsonString;
    }
    public static String parseAnswer(String responseJson) {
        return "TODO";
    }
}
