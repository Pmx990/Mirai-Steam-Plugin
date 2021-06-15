package dev.horizonlight.miraiplugin;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class LoadDragon
    {

        List<File> ImageData;

        int current = 0;

        private static volatile LoadDragon instance;

        public void Reload()
        {
            ImageData = Arrays.asList(Objects.requireNonNull(new File("D:\\机器人\\mirai_plugin_example-master\\Dragon").listFiles()));
        }


        private LoadDragon()
        {
            ImageData = Arrays.asList (Objects.requireNonNull(new File("D:\\机器人\\mirai_plugin_example-master\\Dragon").listFiles()));
        }


            public static LoadDragon getInstance()
            {
                if(instance == null)
                {
                    synchronized (LoadDragon.class)
                    {
                        if(instance==null)
                        {
                            instance = new LoadDragon();
                        }
                    }
                }
                return instance;
            }

            public File GetImage()
            {
                //int rNum =  (int)(0 + Math.random()*ImageData.length-1);
                if(current<ImageData.size()-1)
                {
                    return ImageData.get(current++);
                }
                current = 0;
                Collections.shuffle(ImageData);
                return GetImage();


            }

    }
