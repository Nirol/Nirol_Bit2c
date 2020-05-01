package Bit2c.utils;


import Enums.API;
import lombok.var;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
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



    public static String calculateSignature(String  nonce, String data, String secret, String path) {
        var signature = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((nonce + data).getBytes());
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(new SecretKeySpec(Base64.decodeBase64(secret.getBytes()), "HmacSHA512"));
            mac.update(path.getBytes());
            signature = new String(Base64.encodeBase64(mac.doFinal(md.digest())));
        } catch(Exception e) {}
        return signature;
    }

    public static RequestEntity<String> getRequest (String url, String path, LocalPropLoader props, API api) {
        return getRequest(url, new HashMap<>(), path, props,api);
    }

    public static RequestEntity<String> getRequest (String url, Map<String,Object> formData, String path, LocalPropLoader props, API api) {
        var headers = new HttpHeaders();
        long nonce = System.currentTimeMillis();
        var data = formData.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue() + "&").collect(Collectors.joining());
        data += "nonce=" + nonce;
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("API-Key", props.getApiKey(api));
        headers.add("API-Sign", ApiSign.calculateSignature(nonce +"", data, props.getApiSec(api), path));
        headers.add("User-Agent", "Mozilla/4.76");
        try {
            return new RequestEntity<String>(data, headers, HttpMethod.POST, new URI(url));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
