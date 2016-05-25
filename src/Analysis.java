import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analysis{

    private BufferedReader bufferedReader;
    private Map<String, Integer> map;
    private List<Word> listWords;
    private Translator translator = new Translator();

    public Analysis(File file) throws IOException {
        try {

            bufferedReader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        //String regex = "\\b[a-z']+\\b";
        //\\w+
        Pattern pattern = Pattern.compile("\\b[a-z']+\\b");

        map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();

        while (bufferedReader.ready())
        {
            //String str = bufferedReader.readLine().toLowerCase();
            Matcher matcher = pattern.matcher(bufferedReader.readLine().toLowerCase());
            while (matcher.find()) {
                String currentWord = matcher.group();
                Integer countCurrentWord = map.get(currentWord);
                map.put(currentWord, countCurrentWord == null ? 1 : countCurrentWord + 1);
            }
        }

        bufferedReader.close();
        addFromMapToListWords(map);

    }

    public List<Word> addFromMapToListWords(Map<String, Integer> map) throws IOException {
        listWords = new ArrayList<Word>();

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            String currentEngWord = pair.getKey();
            String currentRuWord = (translator.translate(currentEngWord));
            listWords.add(new Word(currentEngWord, currentRuWord, pair.getValue()));

        }

        Collections.sort(listWords);

        return listWords;
    }

    public List<Word> getList(){
        return listWords;
    }

}
