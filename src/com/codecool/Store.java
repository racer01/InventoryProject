package com.codecool;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public abstract class Store implements StoreCapable {
    private void saveToXml(Product product) {
        try {
            File file = new File("src/products.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Element root = document.getDocumentElement();
            Element element = document.createElement("Product");

            Attr name = document.createAttribute("name");
            Attr price = document.createAttribute("price");
            Attr size = document.createAttribute("size");
            Attr type = document.createAttribute("type");

            element.setAttributeNode(name);
            element.setAttributeNode(price);
            element.setAttributeNode(size);
            element.setAttributeNode(type);

            name.setValue(product.name);
            price.setValue(String.valueOf(product.price));
            if (product instanceof BookProduct) {
                size.setValue(String.valueOf(((BookProduct) product).pageSize()));
                type.setValue("book");
            } else if (product instanceof CDProduct) {
                size.setValue(String.valueOf(((CDProduct) product).numOfTracks()));
            }
            root.appendChild(element);

            DOMSource source = new DOMSource(document);
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            StreamResult result = new StreamResult(new File("src/products.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void storeProduct(Product product);

    protected Product createProduct(String type, String name, int price, int size) {
        if (type == "Book")
            return new BookProduct(name, price, size);
        else if (type == "CD")
            return new CDProduct(name, price, size);
        else
            return null;
    }

    public ArrayList<Product> loadProducts() {
        return null;
    }

    public final void store(Product product) {
        saveToXml(product);
        storeProduct(product);
    }

}
