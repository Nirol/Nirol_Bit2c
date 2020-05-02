package Bit2c.utils;



import lombok.var;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiSign {


    public static RequestEntity<String> getRequestPublic (String url) {
        return getRequestPublic(url, new HashMap<>());
    }

    public static RequestEntity<String> getRequestPublic (String url, Map<String,Object> formData) {
        var headers = new HttpHeaders();
        long nonce = System.currentTimeMillis();
        var data = formData.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue() + "&").collect(Collectors.joining());
        data += "nonce=" + nonce;
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("User-Agent", "Mozilla/4.76");

        try {
            return new RequestEntity<String>(data, headers, HttpMethod.GET, new URI(url));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public static String calculateSignature(String data, String secret) {

        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA512");
        }
        catch ( NoSuchAlgorithmException e ) {
            e.printStackTrace();
        }
        SecretKeySpec secret_spec = new SecretKeySpec(secret.getBytes(), "HmacSHA512");
        try {
            mac.init(secret_spec);
        }
        catch ( InvalidKeyException e ) {
            e.printStackTrace();
        }
        return ( new BASE64Encoder() ).encode(mac.doFinal(data.getBytes())).replaceAll("\r\n", "");

}

    public static RequestEntity<String> getRequest (String url,  LocalPropLoader props,  HttpMethod httpMethod) {
        return getRequest(url, new HashMap<>(),  props, httpMethod);
    }

    public static RequestEntity<String> getRequest (String url, Map<String,Object> formData,  LocalPropLoader props, HttpMethod httpMethod) {
        var headers = new HttpHeaders();

        long nonce = System.currentTimeMillis();

        var data = formData.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue() + "&").collect(Collectors.joining());
        data += "nonce=" + nonce;


        headers.add("key", props.getApiKey());
        headers.add("sign", ApiSign.calculateSignature(  data, props.getApiSec()));
        headers.add("User-Agent", "Mozilla/4.76");

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        url += "?" + data;
        try {
            return new RequestEntity<String>(data, headers,httpMethod, new URI(url));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
