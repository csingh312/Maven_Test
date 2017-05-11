package com.candice.maven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class scrapper {
    public static void main(String[] args) throws IOException {
        String url = "http://insider.espn.com/nba/draft/rounds/_/round/x/year/2016";
        int k = 3;
        for (int i = 1; i < k; i++) {
            String url2 = (url.replace("x", String.valueOf(i)));
            Document doc = Jsoup.connect(url2).get();
            try {
                Elements table = doc.select("tbody");
                Elements row = table.select("tr");
                row.remove(1);

                for (Element column : row.select("tr")) {
                    Elements player = column.select("td a strong");
                    Elements team = column.select("p[class=team-name]");
                    Elements height = column.select("td:eq(3)");
                    Elements weight = column.select("td:eq(4)");
                    Elements position = column.select("td:eq(5)");
                    System.out.println(player.text() + " " + team.text() + " " + height.text() + " " +
                            weight.text() + " " + position.text());
                }
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }
    }
}



