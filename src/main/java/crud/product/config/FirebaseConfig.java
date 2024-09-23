package crud.product.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class FirebaseConfig {
    private final String serviceAccountKeyPath = "D:\\Rikkei Academy\\Module03 - Connect DB & Java Webapp - IntelliJ IDEA\\Thi MD3\\PT_JV240416_BS_TranLongThanh\\product\\src\\main\\webapp\\resource\\firebase.json";

    @Bean
    public Storage storage() throws IOException {
        InputStream serviceAccount = Files.newInputStream(Paths.get(serviceAccountKeyPath));
        return StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build().getService();
    }
}
