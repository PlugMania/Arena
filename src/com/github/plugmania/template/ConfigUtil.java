package com.github.plugmania.template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigUtil {
	
	static Template plugin;
	
	public ConfigUtil(Template instance){
		plugin = instance;
	}
	
	public static YamlConfiguration getConfig(String confName){
		if(confName == null) return null;
		File file = new File(plugin.getDataFolder() + File.separator + confName + ".yml");
		if(file.exists()){
			YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
			return conf;
		}
		return null;
	}
	
	public static void saveConfig(YamlConfiguration conf, String confName){
		if(confName == null) return;
		File file = new File(plugin.getDataFolder() + File.separator + confName + ".yml");	
		if(file.exists()){
			try {
				conf.save(file);
			} catch (IOException e) {
				Util.log(Lang._("failedSaveConfig"));
			}
		}
	}
	
	public static void loadConfig(String confName, String templateName){
		if(confName == null) return;
		
		File dataFolder = new File(plugin.getDataFolder().toString());
		File file = new File(plugin.getDataFolder() + File.separator + confName + ".yml");
		
		if(!dataFolder.exists()){
			Util.debug(Lang._("tryCreatePluginFolder"));
			try {
                boolean success = new File(plugin.getDataFolder().toString()).mkdir();
                if (success) {
                    Util.log(Lang._("successCreatePluginFolder"));
                }
            } catch (Exception e) {
                Util.log(Lang._("failCreatePluginFolder"));
                Util.debug(e.getMessage());
            }
		}
		
		if(dataFolder.exists() && !file.exists()){
			Util.debug(Lang._("tryingToCreateFile") + confName);
			try {
                boolean success = false;
        		InputStream templateIn = plugin.getResource("resources" + File.separator + templateName + ".yml");
                OutputStream outStream = new FileOutputStream(file);
                
            	int read = 0;
            	byte[] bytes = new byte[1024];
             
            	while ((read = templateIn.read(bytes)) != -1) {
            		outStream.write(bytes, 0, read);
            	}
             
            	templateIn.close();
            	outStream.flush();
            	outStream.close();
                if (success) {
                    Util.log(Lang._("successToCreateFile") + confName);
                }
            } catch (Exception e) {
                Util.log(Lang._("failToCreateFile") + confName);
                e.printStackTrace();
            }
		}
	}
	
	//player config methods from RoyalCommands by jkcclemens
	public static void setPValString(OfflinePlayer t, String value, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            pconf.set(path, value);
            try {
                pconf.save(pconfl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setPValLong(OfflinePlayer t, long value, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            pconf.set(path, value);
            try {
                pconf.save(pconfl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setPVal(OfflinePlayer t, Object value, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            pconf.set(path, value);
            try {
                pconf.save(pconfl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setPValInteger(OfflinePlayer t, Integer value, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            pconf.set(path, value);
            try {
                pconf.save(pconfl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setPValStringList(OfflinePlayer t, List<String> value, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            pconf.set(path, value);
            try {
                pconf.save(pconfl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> getPValStringList(OfflinePlayer t, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            return pconf.getStringList(path);
        }
        return null;
    }

    public static void setPValBoolean(OfflinePlayer t, Boolean value, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            pconf.set(path, value);
            try {
                pconf.save(pconfl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean getPValBoolean(OfflinePlayer t, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            return pconf.getBoolean(path);
        }
        return false;
    }

    public static Integer getPValInteger(OfflinePlayer t, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            return pconf.getInt(path);
        }
        return -1;
    }

    public static Object getPVal(OfflinePlayer t, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            return pconf.get(path);
        }
        return false;
    }

    public static Long getPValLong(OfflinePlayer t, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            return pconf.getLong(path);
        }
        return -1L;
    }

    public static String getPValString(OfflinePlayer t, String path) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        if (pconfl.exists()) {
            FileConfiguration pconf = YamlConfiguration.loadConfiguration(pconfl);
            return pconf.getString(path);
        }
        return "";
    }

    public static boolean getPConfExists(OfflinePlayer t) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + t.getName().toLowerCase() + ".yml");
        return pconfl.exists();
    }

    public static boolean getPConfExists(String name) {
        File pconfl = new File(plugin.getDataFolder() + File.separator + "userdata" + File.separator + name.toLowerCase() + ".yml");
        return pconfl.exists();
    }
}
