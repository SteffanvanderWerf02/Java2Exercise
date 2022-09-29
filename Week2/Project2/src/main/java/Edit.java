public final class Edit {
    /**
     * Static method that makes an string an url friendly String
     * @param url unclean URl
     * @return
     */
   public static String createUrl(String url) {
       String newUrl = url.replace(",","").replace(".","").replace("?","").replace("!","").replace("&","&amp;").replace(" ", "-").toLowerCase();
       return newUrl;
   }
}