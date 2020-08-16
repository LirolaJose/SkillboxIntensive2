import com.dropbox.core.v2.DbxClientV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploaderToDropbox extends Thread {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    Date now = new Date();
    String fileName = dateFormat.format(now);
    private DbxClientV2 client;
    private ByteArrayOutputStream outputStream;

    public UploaderToDropbox(DbxClientV2 client,  ByteArrayOutputStream outputStream){
        this.client = client;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            client.files().uploadBuilder("/" + fileName + ".png")
                    .uploadAndFinish(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
