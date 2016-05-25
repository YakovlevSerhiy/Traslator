import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public  class Translator {

    public   String translate( String input) throws IOException {
        String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" +
                "trnsl.1.1.20160317T094925Z.3f29b42115496ba4.b9902b65b3665af903583dd574b603dcb9dea49a";
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8") + "&lang=en-ru");

        //BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream(), "CP1251"));
        InputStreamReader response = new InputStreamReader(connection.getInputStream(), "UTF-8");
        //InputStream response = connection.getInputStream();

        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");
        String translated = json.substring(start + 2, end - 1);
        return translated;
        //return json.toString();
    }

}
