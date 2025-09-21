package com.contactcars.base;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.Request;
import org.openqa.selenium.devtools.v138.network.model.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DevToolsManager extends TestBase{

    public DevToolsManager() throws IOException {
        super();
    }

    public static DevTools devTools;
    public static Map<String, String> apiRequests = new ConcurrentHashMap<>();
    public static JSONArray resultArray;
    public static JSONObject resultObject;
    public static JSONObject result;
    public static JSONObject responseBodyInJSON;


    public static void setupDevTools() {
        // Trigger the network activity
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        //  Enable Network Monitoring
        devTools.send(Network.enable(Optional.of(10000000), Optional.of(10000000), Optional.of(10000000), Optional.empty()));
    }

    public static void setupRequestListeners(String apiName) {
        // Listen for all requests
        devTools.addListener(Network.requestWillBeSent(), request -> {
            String requestId = request.getRequestId().toString();
            Request networkRequest = request.getRequest();
            String url = networkRequest.getUrl();
            String method = networkRequest.getMethod();

            // Capture API requests based on patterns
            if (isApiRequest(url, method)) {
                apiRequests.put(requestId, url);

                if(url.contains(apiName)){
//                    System.out.println("🚀 API REQUEST CAPTURED");
//                    System.out.println("URL: " + url);
//                    System.out.println("Method: " + method);
//                    System.out.println("Request ID: " + requestId);
                    // Log request body for POST/PUT requests
//                    if (networkRequest.getPostData() != null && !networkRequest.getPostData().isEmpty()) {
//                        System.out.println("Request Body: " + networkRequest.getPostData());
//                    }
                }
            }
        });
    }

    public static void setupResponseListeners(String apiName, String type) {
        // Listen for all responses
        devTools.addListener(Network.responseReceived(), response -> {
            String requestId = response.getRequestId().toString();

            if (apiRequests.containsKey(requestId) && response.getResponse().getStatus() == 200 && response.getResponse().getUrl().contains(apiName)) {
                Response networkResponse = response.getResponse();
                String url = networkResponse.getUrl();
                int statusCode = networkResponse.getStatus();
                String statusText = networkResponse.getStatusText();


//                System.out.println("✅ API RESPONSE RECEIVED");
//                System.out.println("URL: " + url);
//                System.out.println("Status: " + statusCode + " " + statusText);
//                System.out.println("Request ID: " + requestId);

                // Get and log response body
                try {
                    Network.GetResponseBodyResponse responseBody = devTools.send(Network.getResponseBody(response.getRequestId()));
                    String body = responseBody.getBody();
//                    System.out.println(formatJsonResponse(body));

                    // First get the Json object instance from the Response interface
                    responseBodyInJSON = new JSONObject(body);
                    if (type == "Array") {
                        parseJsonArray();
                    } else if (type == "Object") {
                        parseJsonObject();
                    } else {
                        result = responseBodyInJSON;
                    }
                } catch (Exception e) {
                    System.out.println("Error getting response body: " + e.getMessage());
                }
            }
        });

        // Also capture loading failed events
//        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
//            String requestId = loadingFailed.getRequestId().toString();
//            if (apiRequests.containsKey(requestId)) {
//                System.out.println("\n❌ API REQUEST FAILED: " + apiRequests.get(requestId));
//                System.out.println("Error: " + loadingFailed.getErrorText());
//            }
//        });
    }

    public static boolean isApiRequest(String url, String method) {
        String lowerUrl = url.toLowerCase();

        // Common API patterns
        String[] apiPatterns = {
                "/api/", "api.", "graphql", "rest", "json", "xml",
                "service", "endpoint", "ajax", "xhr", "webservice",
                "v1/", "v2/", "v3/", "users", "products", "auth",
                "login", "register", "customer", "order", "cart",
                "/api", "api-", "fetch"
        };

        // Check URL patterns
        for (String pattern : apiPatterns) {
            if (lowerUrl.contains(pattern)) {
                return true;
            }
        }

        // Also capture non-GET requests to unknown endpoints (often APIs)
        if (!"GET".equalsIgnoreCase(method) &&
                !lowerUrl.endsWith(".html") &&
                !lowerUrl.endsWith(".css") &&
                !lowerUrl.endsWith(".js") &&
                !lowerUrl.endsWith(".png") &&
                !lowerUrl.endsWith(".jpg") &&
                !lowerUrl.endsWith(".gif")) {
            return true;
        }

        return false;
    }

    public static String formatJsonResponse(String response) {
        // Simple JSON formatting
        try {
            return response.replace(",", ",\n    ")
                    .replace("{", "{\n    ")
                    .replace("}", "\n}")
                    .replace("[", "[\n    ")
                    .replace("]", "\n]");
        } catch (Exception e) {
            return response; // Return original if formatting fails
        }
    }

    // Get the resultObject array from the response
    public static void parseJsonArray() {
        resultArray = responseBodyInJSON.getJSONArray("result");
    }

    // Get the resultObject object from the response
    public static void parseJsonObject() {
        resultObject = responseBodyInJSON.getJSONObject("result");
    }

}
