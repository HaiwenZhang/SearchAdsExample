package com.haiwen.adserver.utils;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.en.KStemFilter;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class LuceneHelper {

    private static final Version LUCENE_VERSION = Version.LUCENE_7_3_0;
    private static String stopWords = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be," +
            "because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has," +
            "have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might," +
            "most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should," +
            "since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were," +
            "what,when,where,which,while,who,whom,why,will,with,would,yet,you,your";

    private static CharArraySet getStopWords(String stopWords) {
        List<String> stopWordsList = new ArrayList<String>();
        for(String stop : stopWords.split(",")) {
            stopWordsList.add(stop.trim());
        }
        return new CharArraySet(stopWordsList, true);
    }

    public static String strJoin(List<String> arr, String step) {
        StringBuffer sbStr = new StringBuffer();
        for (int i = 0; i < arr.size(); i++) {
            if( i > 0)
                sbStr.append(step);
            sbStr.append(arr.get(i));
        }
        return sbStr.toString();
    }

    public static List<String> cleanedTokenize(String input) {
        List<String> tokens = new ArrayList<String>();
        StringReader reader = new StringReader(input.toLowerCase());
        Tokenizer tokenizer = new StandardTokenizer();
        tokenizer.setReader(reader);
        TokenStream tokenStream = new StandardFilter(tokenizer);
        tokenStream = new StopFilter(tokenStream, getStopWords(stopWords));
        tokenStream = new KStemFilter(tokenStream);

        StringBuilder sb = new StringBuilder();
        CharTermAttribute charTermAttribute = tokenizer.addAttribute(CharTermAttribute.class);

        try {
            tokenStream.reset();
            while(tokenStream.incrementToken()) {
                String term = charTermAttribute.toString();
                tokens.add(term);
                sb.append(term + " ");
            }
            tokenStream.end();
            tokenStream.close();

            tokenizer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cleaned Tokens = " + sb.toString());

        return tokens;
    }

    public static void main(String[] args) {
        String str = "remove stop word, tokenize, stem";
        cleanedTokenize(str);
    }

}
