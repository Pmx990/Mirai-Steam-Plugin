package dev.horizonlight.miraiplugin.SteamChecker.Setting;

import dev.horizonlight.miraiplugin.SteamChecker.Setting.Dao.FileController;
import dev.horizonlight.miraiplugin.SteamChecker.Setting.Dao.Pojo.GroupSetting;

import java.util.HashMap;
import java.util.Map;


public class Setting
    {

    private static volatile Setting instance;
    private HashMap<String, String> langs;
    private HashMap<String, GroupSetting> settingMap = new HashMap();


    private Setting(){
        Constant c = new Constant();
        //c.UpdateCurrencyName(FileController.getInstance().GetCurrencyNames());
        langs =  c.GetCurrencyName();
    }

    public static Setting getInstance()
    {
        if(instance == null)
        {
            synchronized(Setting.class)
            {
                if(instance == null)
                {
                    instance = new Setting();
                }
            }
        }
        return instance;
    }


        public void InitMap(Map map){
            if(map instanceof HashMap){
                settingMap = (HashMap<String, GroupSetting>) map;
            }else{
                throw new RuntimeException();
            }
        }

    /**
     * 更新用户设定中的货币
     * @param id        群号
     * @param changeTo      目标货币
     * @return
     */
        public String UpdateLangs(String id, String changeTo){
            if(langs.containsKey(changeTo)){
                changeTo = langs.get(changeTo);
            }
            GroupSetting gs;
            if(settingMap.containsKey(id)){
                gs = settingMap.get(id);
            }else{
                gs = new GroupSetting();
                gs.groupIDNumber = id;
            }
            gs.currency = changeTo;
            settingMap.put(id, gs);
            FileController.getInstance().UpdateDic(settingMap);
            return changeTo;
        }

        public String GetCurrency(String id){
            return settingMap.get(id).currency;
        }

        public boolean ContainsGroup(String id){
            return settingMap.containsKey(id);
        }





    }
