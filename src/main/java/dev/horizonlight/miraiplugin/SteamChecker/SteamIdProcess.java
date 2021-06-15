package dev.horizonlight.miraiplugin.SteamChecker;
import com.google.gson.Gson;
import dev.horizonlight.miraiplugin.SteamChecker.pojo.Root;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.IOException;

public class SteamIdProcess
    {
        private static final String SEARCH_LINK = "https://store.steampowered.com/search/?term=";
        private static final String INFO_LINK = "http://store.steampowered.com/api/appdetails?appids=";
        private static final String INFO_FIX = "&l=schinese&cc=CN";
        protected String SearchId(String search)
        {
            try
            {
                String url = SEARCH_LINK +search;
                Document document = Jsoup.connect(url).header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2").get();
                JXDocument jxd = JXDocument.create(document);
                JXNode jxn =  jxd.selNOne("//div[@id='search_resultsRows']/a[1]/@data-ds-appid");
                return jxn.asString();
            }catch (IOException e)
            {
                e.printStackTrace();
                return "-1";
            }catch (NullPointerException e)
            {
                return "-1";
            }

        }

        protected String GetJson(String id)
        {
            try
            {
                String url = INFO_LINK + id+INFO_FIX;
                System.out.println(url);
                String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
                json = json.replaceFirst(id,"GamePojo");
                return json;
            } catch (IOException e)
            {
                e.printStackTrace();
                return "-1";
            }
        }

        protected Root GetGameData(String json)
        {
            Gson gson = new Gson();
            return gson.fromJson(json, Root.class);
        }


    }
