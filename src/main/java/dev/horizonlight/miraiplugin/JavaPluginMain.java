package dev.horizonlight.miraiplugin;

import dev.horizonlight.miraiplugin.SteamChecker.SCController;
import dev.horizonlight.miraiplugin.SteamChecker.pojo.Root;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.InputStream;
import java.net.URL;



public final class JavaPluginMain extends JavaPlugin {
    public static final JavaPluginMain INSTANCE = new JavaPluginMain();
    private JavaPluginMain() {
        super(new JvmPluginDescriptionBuilder("dev.horizonlight.miraisteamplugin", "0.1.0")
                .info("EG")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("magic spear插件启动");
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(MessageEvent.class, g -> {
            getLogger().info(g.getMessage().contentToString());
            RunPrefix(g.getMessage().contentToString(),g);
        });
    }

    private void RunPrefix(String input, MessageEvent a)
    {
        input = input.toLowerCase();
        input = input.replaceAll("，", ",");

        if(input.startsWith(",steam查询"))
        {
            SCController sc = new SCController(input);
            if(sc.TryGetResult())
            {
                Root root = sc.GetResult();
                StringBuilder sb = new StringBuilder();
                sb.append("游戏: ").append(StringValidator(root.GamePojo.data.name)).append("\n");
                sb.append("开发: ").append(StringValidator(root.GamePojo.data.developers.get(0))).append("\n");
                if(root.GamePojo.data.price_overview!=null){
                    sb.append("价格: ").append(StringValidator(root.GamePojo.data.price_overview.final_formatted)).append("\n");
                }else
                {
                    sb.append("价格: ").append("未公布").append("\n");
                }
                if(root.GamePojo.data.release_date.date==null || root.GamePojo.data.release_date.date.isEmpty())
                {
                    sb.append("发售日期: ").append("待定").append("\n");
                }else
                {
                    sb.append("发售日期: ").append(StringValidator(root.GamePojo.data.release_date.date)).append("\n");
                }
                sb.append("简介: ").append(StringValidator(root.GamePojo.data.short_description)).append("\n");

                a.getSubject().sendMessage(sb.toString());

                if(!root.GamePojo.data.header_image.isEmpty())
                {
                    try{
                        InputStream is = new URL(root.GamePojo.data.header_image).openStream();
                                ExternalResource.sendAsImage(is, a.getSubject());
                                is.close();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }else
            {
                a.getSubject().sendMessage("无指定结果，请尝试使用英文搜索");
            }
        }

    }

    private String StringValidator(String input)
    {
        if(input==null || input.isEmpty())
        {
            return "信息不可用";
        }
        return input;
    }

/*
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, g -> {
            //监听群消息
            getLogger().info(g.getMessage().contentToString());
        });
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, f -> {
            //监听好友消息

            getLogger().info(f.getMessage().contentToString());
            MessageChain chain = f.getMessage();
            if(!chain.toString().equals("大象叫"))
            {
                f.getSubject().sendMessage("狗叫");
            }
            if(chain.toString().equals("大象叫")){
                f.getSubject().sendMessage("大香蕉？");}
        });*/


}