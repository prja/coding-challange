package prja.leetcode.challange.general;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloader
{
    public static void main(String[] arguments) throws IOException
    {
        downloadImage( "https://media.istockphoto.com/id/1226671001/photo/close-up-studio-portrait-of-a-10-year-old-gir.webp?s=2048x2048&w=is&k=20&c=EPt7pkIwMrKZSAAc1ixKI5WqzvUjmzhx0UIIo_wQh9s="
        		//"https://chicks.domino.cwp.pnp-hcl.com/names.nsf/0/E6B694EDF85099508525889B005D5BFC/$FILE/ContactPhoto?OpenElement&EmbedImg=1&ts=1715152870000"
        		//"https://upload.wikimedia.org/wikipedia/commons/7/73/Lion_waiting_in_Namibia.jpg"
        		,
                new File("C:\\prabhu\\Mygitrepo\\coding-challange\\leetcode-challange\\src\\main\\resources").getAbsolutePath());
    }

    public static void downloadImage(String sourceUrl, String targetDirectory)
            throws MalformedURLException, IOException, FileNotFoundException
    {
        URL imageUrl = new URL(sourceUrl);
       // imageUrl.
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                        new FileOutputStream(targetDirectory + File.separator
                                + "abc.jpg"));)
        {
            int readByte;

            while ((readByte = imageReader.read()) != -1)
            {
                imageWriter.write(readByte);
            }
        }
    }
}