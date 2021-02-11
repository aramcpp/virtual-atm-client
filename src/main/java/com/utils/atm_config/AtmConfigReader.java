package com.utils.atm_config;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AtmConfigReader implements AtmConfigReaderInterface{

    private final String filePath = "src/main/resources/cash_holder.json";
    private JSONObject atmConfigJson;

    private void getATMConfigJSON() {
        try {
            FileReader jsonStringReader = new FileReader(filePath);
            atmConfigJson = new JSONObject(jsonStringReader);
        } catch (FileNotFoundException e) {
            throw new JSONException("FILE NOT FOUND OR INCORRECT JSON FORMAT");
        }
    }

    @Override
    public boolean getCurrentCash() {
        getATMConfigJSON();
        return atmConfigJson.getBoolean("current_cash");
    }

    @Override
    public void addToCurrentCash(boolean amountToAdd) {
        getATMConfigJSON();
        atmConfigJson.put("current_cash", atmConfigJson.get())
    }

    @Override
    public boolean subtractFromCurrentCash() {

    }
}
