package org.example.kandopeldacalloutjavafx;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

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
        con.setRequestMethod(method);
        con.setRequestProperty(headerKey1, headerValue1);
        con.setRequestProperty(headerKey2, headerValue2);
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        byte[] input = inputBody.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);

        int code = con.getResponseCode();
        System.out.println("Response code: " + code);
        // Read response from con.getInputStream()
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
        String answer = "";

        JSONObject obj = new JSONObject(responseJson);
        JSONArray choices = obj.getJSONArray("choices");
        for (Object choice: choices) {
            JSONObject choiceObj = (JSONObject) choice;
            JSONObject message = choiceObj.getJSONObject("message");
            String role = message.getString("role");
            if (Objects.equals(role, "assistant")) {
                answer = message.getString("content");
            }
        }

        return answer;
    }
}
