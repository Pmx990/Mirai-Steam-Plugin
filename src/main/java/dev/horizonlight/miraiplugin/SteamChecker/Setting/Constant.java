package dev.horizonlight.miraiplugin.SteamChecker.Setting;

import dev.horizonlight.miraiplugin.SteamChecker.Setting.Dao.FileController;

import java.util.HashMap;
import java.util.Map;

public class Constant
    {
        private HashMap CurrencyName;

        public Constant(){
            /*HashMap t;
            t = (HashMap) FileController.getInstance().GetCurrencyNames();
            if(t == null){
                GetDefaultName();
            }else{
                CurrencyName = t;
            }*/
        }

        public HashMap GetCurrencyName(){
            if(CurrencyName == null){
                return GetDefaultName();
            }
            return CurrencyName;
        }

        /*public void UpdateCurrencyName(Map c){
            CurrencyName = (HashMap) c;
        }*/



        public HashMap GetDefaultName(){
            /**
             * 暂时先hardcode, 网上看到的国家区号资源往往不包含一些简称，看看有什么别的解决方案
             */
            HashMap<String, String> langs = new HashMap<>();
            langs.put("CNY","CN");
            langs.put("cny","CN");
            langs.put("人民币","CN");
            langs.put("RMB","CN");
            langs.put("rmb","CN");
            langs.put("中国","CN");
            langs.put("人民币","CN");
            //---------------------------------------
            langs.put("USD", "US");
            langs.put("usd", "US");
            langs.put("美元", "US");
            langs.put("美国", "US");
            //---------------------------------------
            langs.put("加拿大", "CA");
            langs.put("加币", "CA");
            langs.put("CAD", "CA");
            langs.put("cad", "CA");
            //---------------------------------------
            langs.put("JPY", "JP");
            langs.put("jpy", "JP");

            langs.put("日元", "JP");
            langs.put("日本", "JP");
            //---------------------------------------
            langs.put("阿根廷", "AR");
            langs.put("ARS", "AR");
            langs.put("ars", "AR");

            langs.put("阿根廷比索", "AR");
            //---------------------------------------
            langs.put("港币", "HK");
            langs.put("香港", "HK");
            langs.put("HKD", "HK");
            langs.put("hkd", "HK");

            //---------------------------------------
            langs.put("台币", "TW");
            langs.put("twd", "TW");
            langs.put("TWD", "TW");

            langs.put("台湾", "TW");

            CurrencyName = langs;
            return  langs;
        }
    }
