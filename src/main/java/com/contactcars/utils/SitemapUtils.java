package com.contactcars.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SitemapUtils {

    public static List<String> extractUrlsFromSitemap(String sitemapUrl) throws IOException {
        List<String> urls = new ArrayList<>();
        Document doc = Jsoup.connect(sitemapUrl).get();
        Element urlElements = doc.getElementsByTag("loc").get(12);
        for (Element el : urlElements) {
            Document locsDoc = Jsoup.connect(el.text()).get();
            Elements locsElements = locsDoc.getElementsByTag("loc");
            for (Element locEl : locsElements) {
                urls.add(locEl.text());
            }
        }
        return urls;
    }
}
