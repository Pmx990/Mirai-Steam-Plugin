package dev.horizonlight.miraiplugin.SteamChecker.Pojo;

import com.google.gson.annotations.SerializedName;

public class PriceOverview
    {
    public String currency;
    public int initial;
    @SerializedName("final")
    public int _final;
    public int discount_percent;
    public String initial_formatted;
    public String final_formatted;
    }
