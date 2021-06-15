package dev.horizonlight.miraiplugin.SteamChecker.pojo;

import java.util.List;

public class Data{
public String type;
public String name;
public int steam_appid;
public int required_age;
public boolean is_free;
public String controller_support;
public List<Integer> dlc;
public String detailed_description;
public String about_the_game;
public String short_description;
public String supported_languages;
public String header_image;
public String website;
public transient PcRequirements pc_requirements;
public transient MacRequirements mac_requirements;
public transient LinuxRequirements linux_requirements;
public String legal_notice;
public List<String> developers;
public List<String> publishers;
public PriceOverview price_overview;
public List<Integer> packages;
public List<PackageGroup> package_groups;
public Platforms platforms;
public List<Category> categories;
public List<Genre> genres;
public List<Screenshot> screenshots;
public List<Movy> movies;
public Recommendations recommendations;
public Achievements achievements;
public ReleaseDate release_date;
public SupportInfo support_info;
public String background;
public ContentDescriptors content_descriptors;
}
