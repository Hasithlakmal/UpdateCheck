package edu.icet.Services;

import org.update4j.Configuration;
import org.update4j.UpdateOptions;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;

public class AppUpdater {
    public  void config() {
        try {
            // 1. Server එකේ ඇති Update Configuration එක කියවීම (මෙය ඔබගේ වෙබ් අඩවියක තිබිය යුතුයි)
            URL configUrl = new URL("https://raw.githubusercontent.com/Hasithlakmal/UpdateCheck/refs/heads/main/");

            Configuration config;
            try (InputStreamReader reader = new InputStreamReader(configUrl.openStream())) {
                config = Configuration.read(reader);
            }

            // 2. අලුත් Update එකක් තිබේදැයි පරීක්ෂා කිරීම (WhatsApp වල මෙන්)
            if (config.requiresUpdate()) {
                System.out.println("අලුත් Update එකක් හමුවුණා. Download වෙමින් පවතී...");

                // 3. Update එක Download කර Install කිරීම
                config.update(UpdateOptions.archive(Paths.get("update.zip")));
                System.out.println("Update එක සාර්ථකයි!");

            }

            // 4. යාවත්කාලීන වූ Application එක පණගැන්වීම
            config.launch();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Update කිරීමේදී දෝෂයක් ඇති විය.");
        }
    }
}
