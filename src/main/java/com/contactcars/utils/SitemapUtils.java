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
        Elements urlElements = doc.select("url > loc");

        for (Element el : urlElements) {
            urls.add(el.text());
        }
        return urls;
    }
}
