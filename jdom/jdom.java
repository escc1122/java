import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

    Map<String, Map<String, String>> products = new LinkedHashMap<String, Map<String, String>>();
    List<Element> productkList = getShopProductsXml(categoryId,path);
    if (productkList != null && productkList.size() != 0) {
      HashMap<String, String> productmap = null;

      //取得每一個<Product>下的資料
      for (Element product : productkList) {
        Iterator it = product.getChildren().iterator();
        productmap = new LinkedHashMap<String, String>();
        String productId = "";
        while (it.hasNext()) {
          Element node = (Element) it.next();
          if (node.getName().equals("ProductId")) {
            productId = node.getValue();
          }
          productmap.put(node.getName(), node.getValue()); //標籤名稱對映值存在map裡
        }
        products.put(productId, productmap);
      }
    }
