import java.util.Map;

import com.ssm.currency.Base64Utils;
import com.ssm.currency.RSAUtils;

public class RSATester {

   static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
          
          /* publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);*/
            
            
           publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbeiyc45WgxXN2WeHJD1Zawrg3wupkZaFHssEJucQ0JJTN28kpz605ZD36ZI3jpGyEzBZXYWypONvZoAwzdvTPWoQM4H9W9WzaN6zDcsQeF8E3ae0rZkCYnolj5v73zLtdT3oVdS8QyoP3siGS1x16VQ2ZadgLIkqPQNE0meWoowIDAQAB";
            
            
            
  privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJt6LJzjlaDFc3ZZ4ckPVlrCuDfC6mRloUeywQm5xDQklM3bySnPrTlkPfpkjeOkbITMFldhbKk429mgDDN29M9ahAzgf1b1bNo3rMNyxB4XwTdp7StmQJieiWPm/vfMu11PehV1LxDKg/eyIZLXHXpVDZlp2AsiSo9A0TSZ5aijAgMBAAECgYBoLDEOIbLUmNenGcwdkigzAbq6qd+wyyOHza5nnM9ofIYzdCrR1/Nhu9eHGK61Myr+w1vIyl8q9wzfQMxMA009Orv3c1Crbtgb3QJvDKZNtdwCSrtQw3pQ7R+u3jhHuJHPRrDfdjEe1XG+wEcamK308AhIqnj08y8pF8RZNVvSUQJBAPyjByKfR44UC+7rx4OHGx807kn4lHIbzcQqAPhgD92NhFgHHjqDbH+jQhKgGqhPDcVTXqsok5HG441flA+ljXkCQQCdjAgwSyoCOonMffZfS1D2nTQOiyhTRtrFqTYimZPm5EA2Z/a0QE5Tg7DrC6n13hpk0sl+QrTXsR0eITteTcv7AkEAs8iYlUzgMP2XGGl1y+XjqSuTv9REX4flwIlbs2U5JSNGYRZ/rohEN/jIVlTVY50OYbRYlFkF2yG8Yaj4xsG7kQJBAJyaLSmUDVXZyk+yhcuDmh8JdE1gldzxeVUxNdZ+wj2odQufm+LgaPsq1BlPpsn21FWUESWoOQqNy1u/vLuoqTECQCjs4dvb2YI2LcHNZicD9eNHjI1G4n834aEusaH/CSZqOnEJK+les8e8Yh5QUPwAqA7tZs21N/xBasZXc7zUp5U=";
            
            
            
            
            
            
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	
    
    
    
    public static void main(String[] args) throws Exception {
        test();
        testSign();
    }

    static void test() throws Exception {
 
    	System.err.println("公钥加密——私钥解密");
       
        
        
        String source = "123";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        
        
        System.out.println("加密后文字：\r\n" + new String(encodedData)
        		
        		+"\r\n"+Base64Utils.encode(encodedData)
        		
        		);
        
        
         
        
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
   
    
    
    
    
    
    
    }

    static void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);
        System.err.println("验证结果:\r" + status);
    }
    
}