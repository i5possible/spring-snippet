package net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author lianghong
 * @date 04/10/2018
 */

public class URLConnectionUtils {
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try{
            String urlNameString = url + "?" + param;
            URL realURL = new URL(urlNameString);
            URLConnection urlConnection = realURL.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.connect();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realURL = new URL(url);
            URLConnection urlConnection = realURL.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setDoOutput(true);
            out = new PrintWriter(urlConnection.getOutputStream());
            out.print(param);
            out.flush();
            urlConnection.connect();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void httpURLConnection() throws IOException {
        HttpURLConnection httpURLConnection = new HttpURLConnection(new URL("")) {
            @Override
            public void connect() throws IOException {

            }

            @Override
            public void disconnect() {

            }

            @Override
            public boolean usingProxy() {
                return false;
            }
        };
        httpURLConnection.getHeaderField("fieldName");
        InputStream errorStream = httpURLConnection.getErrorStream();
        String requestMethod = httpURLConnection.getRequestMethod();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
    }
}
