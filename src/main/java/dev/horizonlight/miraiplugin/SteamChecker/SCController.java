package dev.horizonlight.miraiplugin.SteamChecker;

import dev.horizonlight.miraiplugin.SteamChecker.pojo.Root;

public class SCController
    {
        String search;
        Root result;

        public SCController(String _search)
        {
            _search = _search.replace(",steam查询 ","");
            _search = _search.replace(",steam查询","");
            _search.replace("\t", "+");


            search = _search;
        }

        public boolean TryGetResult()
        {
            try
            {
                SteamIdProcess process = new SteamIdProcess();
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
