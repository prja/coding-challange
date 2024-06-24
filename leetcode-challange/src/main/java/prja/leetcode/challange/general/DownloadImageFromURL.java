package prja.leetcode.challange.general;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

public class DownloadImageFromURL {
    public static void main(String[] args) throws IOException {
//        try  {
//            final var url = new URL("https://directory.cwp.pnp-hcl.com/8625826A0073D932/0/13862CC60D168E6400258271007A0DD1/$FILE/CKMNT4.jpg");
//            BufferedImage image = ImageIO.read(url);
//            image.flush();
//            ImageIO.write(image, "jpg", new File("image_test.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        TheKing_DownloadFileFromURL("https://chicks.domino.cwp.pnp-hcl.com/names.nsf/0/E6B694EDF85099508525889B005D5BFC/$FILE/ContactPhoto?OpenElement&EmbedImg=1&ts=1715152870000"
        		//"https://media.istockphoto.com/id/1226671001/photo/close-up-studio-portrait-of-a-10-year-old-gir.webp?s=2048x2048&w=is&k=20&c=EPt7pkIwMrKZSAAc1ixKI5WqzvUjmzhx0UIIo_wQh9s="
        		//"https://media.istockphoto.com/id/824894330/photo/vidhana_soudha.webp?s=2048x2048&w=is&k=20&c=1VxwWFwBOLhenTEmRxla9GhdanG_jFJhj7U1dOGVhC0="
        		//"https://directory.cwp.pnp-hcl.com/8625826A0073D932/0/13862CC60D168E6400258271007A0DD1/$FILE/CKMNT4.jpg"
        ,"C:\\\\prabhu\\\\Mygitrepo\\\\coding-challange\\\\leetcode-challange\\\\src\\\\main\\\\resources\\abc.jpg");
    }
    
    public static void TheKing_DownloadFileFromURL(String search, String path) throws IOException {

        // This will get input data from the server
        InputStream inputStream = null;

        // This will read the data from the server;
        OutputStream outputStream = null;

        try {
            // This will open a socket from client to server
            URL url = new URL(search);

            // This user agent is for if the server wants real humans to visit
            String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

            // This socket type will allow to set user_agent
            URLConnection con = url.openConnection();
            con.setUseCaches(true);
              con.setRequestProperty("User-Agent", USER_AGENT);
            String token="\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzYW1ldGltZSIsImlhdCI6MTcxNTYwMDQ0OSwiZXhwIjoxNzE1NjA3NjUwLCJhdXRoX3RpbWUiOjE3MTU2MDA0NDksInN1YiI6IkNOPVN1c2FuIEFkYW1zMSIsImNvbnRleHQiOnsidXNlciI6eyJuYW1lIjoiU3VzYW4gQWRhbXMxIiwicGVyc29uYWxSb29tIjoiTWVldE1lLjNjSWlybXRnRTd1NzF4V2Y1ZDVsR08iLCJhdmF0YXIiOiJodHRwczovL3N0cG9jLmN3cC5wbnAtaGNsLmNvbTo0NDMvc3R3ZWJhcGkvdXNlcmluZm8vaW1hZ2UvQ049U3VzYW4gQWRhbXMxIiwiZW1haWwiOiJzdXNhbl9hZGFtczFAc2FtZXRpbWUuY3dwLnBucC1oY2wuY29tIn0sInJvbGVzIjpbIm1vZGVyYXRvciJdfSwiYXVkIjoic2FtZXRpbWVNZWV0aW5ncyIsInJvb20iOiIqIn0.9jiEC5JE_La8WKBxXmtqwNjoUC3ZEBhqOM19pBl5fss";
			con.addRequestProperty("Cookie", "sametimeJwt=" + token);
            //con.addRequestProperty("Authorization", "Basic " + token);
            //Getting content Length
            int contentLength = con.getContentLength();
            System.out.println("File contentLength = " + contentLength + " bytes");


            String password = "samet1me";  
            String username = "adams2";  
            String userpass = username + ":" + password;  
            String basicAuth = "Basic :" + new String(Base64.getEncoder().encode(userpass.getBytes()));  
            System.out.println(basicAuth);  
            con.setRequestProperty ("Authorization", basicAuth);  
            System.out.println(basicAuth);  
            
            // Requesting input data from server
            inputStream = con.getInputStream();

            // Open local file writer
            outputStream = new FileOutputStream(path);

            // Limiting byte written to file per loop
            byte[] buffer = new byte[8192];

            // Increments file size
            int length;
            int downloaded = 0; 

            // Looping until server finishes
            while ((length = inputStream.read(buffer)) != -1) 
            {
                // Writing data
                outputStream.write(buffer, 0, length);
                downloaded+=length;
                //System.out.println("Downlad Status: " + (downloaded * 100) / (contentLength * 1.0) + "%");


            }
        } catch (Exception ex) {
        	ex.printStackTrace();
            //Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }

        // closing used resources
        // The computer will not be able to use the image
        // This is a must
        if(null!=outputStream)
        outputStream.close();
        if(null!=inputStream)
        inputStream.close();
    }
    
    

}