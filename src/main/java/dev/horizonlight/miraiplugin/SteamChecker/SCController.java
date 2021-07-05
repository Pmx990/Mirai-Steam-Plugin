package dev.horizonlight.miraiplugin.SteamChecker;

import dev.horizonlight.miraiplugin.SteamChecker.Pojo.Root;
import dev.horizonlight.miraiplugin.SteamChecker.Setting.Setting;

public class SCController
    {
        String search;
        Root result;
        String id;

        public SCController(String _search, String _id)
        {
            _search = _search.replace(",steam查询 ","");
            _search = _search.replace("，steam查询","");
            _search.replace("\t", "+");


            search = _search;
            id = _id;
        }

        public boolean TryGetResult()
        {
            try
            {
                SteamIdProcess process = new SteamIdProcess();

                if(Setting.getInstance().ContainsGroup(id)){
                    process.SetCurrency(Setting.getInstance().GetCurrency(id));
                }
                String id = process.SearchId(search);
                if(id.equals("-1"))
                {
                    return false;
                }

                String json = process.GetJson(id);
                if(json==null || json.equals("-1"))
                {
                    return false;
                }

                result = process.GetGameData(json);
                return true;
            }catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }

        public Root GetResult()
        {
            if(result==null)
            {
                TryGetResult();
            }
            return result;
        }

    }
