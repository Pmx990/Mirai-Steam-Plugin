package dev.horizonlight.miraiplugin.SteamChecker.Setting;

public class SettingController
    {

        String id;
        String input;

        public String ChangeCurrency(String _input, String _id){
            id = _id;
            _input = _input.replace(",steam设置货币 ","");
            _input = _input.replace("，,steam设置货币","");
            _input.replace("\t", "+");
            input = _input;
            return Setting.getInstance().UpdateLangs(id,input);
        }

    }
