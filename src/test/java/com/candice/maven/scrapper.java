package com.candice.maven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;

public class scrapper {
    public static void main(String[] args) throws IOException, SQLException {
        String url = "http://insider.espn.com/nba/draft/rounds/_/round/x/year/2016";

        // connect to MySQL Database
        Connection con = ConnectionManager.getConnection();

        //Truncate table
        Statement deleteTable = con.createStatement();
        String deleteTableData ="TRUNCATE TABLE nba_draft_2017";
        deleteTable.executeUpdate(deleteTableData);

        //Set number for pagination
        int k = 3;
        for (int i = 1; i < k; i++) {
            String url2 = (url.replace("x", String.valueOf(i)));
            Document doc = Jsoup.connect(url2).get();
            Elements player = null;
            Elements team = null;
            Elements school = null;
            Elements position = null;
            Elements height = null;
            Elements weight = null;
            try {
                Elements table = doc.select("tbody");
                Elements row = table.select("tr");
                row.remove(1);
                for (Element column : row.select("tr")) {
                    player = column.select("td a strong");
                    team = column.select("td:nth-child(2) > ul > li > p.team-name");
                    school = column.select("td:nth-child(7) > ul > li > p");
                    height = column.select("td:eq(3)");
                    weight = column.select("td:eq(4)");
                    position = column.select("td:eq(5)");
//                    System.out.println(player.text() + " " + team.text() + " " + height.text() + " " +
//                            weight.text() + " " + position.text());
                    try {
                        String sql = "INSERT INTO nba_draft_2017 (FULL_NAME, TEAMS, SCHOOL, POS, HGT, WT, POS_SCHOOL)" +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, String.valueOf(player.text().toUpperCase()));
                    preparedStatement.setString(2, String.valueOf(team.text().toUpperCase()));
                    preparedStatement.setString(3, String.valueOf(school.text().toUpperCase()));
                    preparedStatement.setString(4, String.valueOf(position.text().toUpperCase()));
                    preparedStatement.setString(5, String.valueOf(height.text().toUpperCase()));
                    preparedStatement.setString(6, String.valueOf(weight.text().toUpperCase()));
                    preparedStatement.setString(7, String.valueOf(position.text().toUpperCase() + " / " + school.text().toUpperCase()));
                    preparedStatement.executeUpdate();
                    } catch (Exception e) {
                        System.err.println("Got an exception! ");
                    }
                    System.out.println("Inserted Successfully");
                }
                // Delete rows with no data
                Statement cleanup = con.createStatement();
                String cleanData ="delete from nba_draft_2017 where FULL_NAME = ' '";
                cleanup.executeUpdate(cleanData);
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Finished!");
    }
}



