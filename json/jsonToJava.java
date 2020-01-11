    public static String convert(String json, String root) throws JSONException
    {
        org.json.JSONObject jsonFileObject = new org.json.JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">"
                + org.json.XML.toString(jsonFileObject) + "</"+root+">";
        return xml;
    }
