package dev.horizonlight.miraiplugin.SteamChecker.Setting.Dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.horizonlight.miraiplugin.SteamChecker.Setting.Constant;
import dev.horizonlight.miraiplugin.SteamChecker.Setting.Dao.Pojo.GroupSetting;
import dev.horizonlight.miraiplugin.SteamChecker.Setting.Setting;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * 于Data文件夹下创建用户信息json文件
 *  以及处理该文件的相关方法
 */
public class FileController
    {
    private static volatile FileController instance;
    private String PATH = "data//steam-checker";
    private File filePath;

    private FileController()
    {
        UpdateData();
    }

    public void UpdateData()
    {
        filePath = new File(PATH);
        if(!filePath.exists())
        {
            CreateDic();
        }
        else
        {
            ReadFromDic();
        }

    }

    public static FileController getInstance()
    {
        if(instance == null)
        {
            synchronized (Setting.class)
            {
                if(instance == null)
                {
                    instance = new FileController();
                }
            }
        }
        return instance;
    }

    public void CreateDic()
    {
        filePath.mkdirs();
    }

    public void ReadFromDic()
    {
        try
        {
            String str = new String(Files.readAllBytes(Paths.get("data//steam-checker/setting.json")), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Map<String, GroupSetting> map = new HashMap<>();
            Type type = new TypeToken<HashMap<String, GroupSetting>>()
                {
                }.getType();
            map = gson.fromJson(str, type);
            Setting.getInstance().InitMap(map);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void UpdateDic(HashMap<String, GroupSetting> map)
    {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(map);
        FileWriter fileWriter;
        try
        {
            fileWriter = new FileWriter("data//steam-checker/setting.json");
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /*
    public void WriteDefaultToFile()
    {
        FileWriter fileWriter;
        Gson gson = new GsonBuilder().create();
        Constant ct = new Constant();
        String json = gson.toJson(ct.GetDefaultName());
        try
        {
            fileWriter = new FileWriter("data//steam-checker/AreaName.json");
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public Map GetCurrencyNames()
    {
        Map<String, String> map = new HashMap<>();
        try
        {
            File file;
            file = new File("data//steam-checker/AreaName.json");
            if(!file.exists())
            {
                WriteDefaultToFile();
                return null;
            }

            String str = new String(Files.readAllBytes(Paths.get("data//steam-checker/AreaName.json")), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<String, GroupSetting>>()
                {
                }.getType();
            map = gson.fromJson(str, type);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return map;
    }*/


    }
