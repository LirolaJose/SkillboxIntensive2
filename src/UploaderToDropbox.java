import com.dropbox.core.v2.DbxClientV2;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.InputStream;
        import java.text.SimpleDateFormat;
        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import java.util.Date;

public class UploaderToDropbox extends Thread {
    LocalDateTime now = LocalDateTime.now();
    String fileName = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
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
