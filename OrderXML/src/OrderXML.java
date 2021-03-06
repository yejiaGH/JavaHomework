import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class OrderXML {

	public static void main(String[] args) {

		NodeList goods = readShopping();
		int count = 0;
		float total = 0.0f;
		for(int i=0; i<goods.getLength(); i++){
			Element good = (Element) goods.item(i);
			Element name = (Element) good.getElementsByTagName("name").item(0);
			int number = Integer.parseInt(good.getElementsByTagName("number").item(0).getTextContent());
			float price = Float.parseFloat(good.getElementsByTagName("price").item(0).getTextContent())*number;
			System.out.println("----------------");
			System.out.println("name="+name.getTextContent());
			System.out.println("----------------");
			System.out.println("number="+number);
			count += number;
			System.out.println("----------------");
			System.out.println("count="+count);
			total += price;
			System.out.println("----------------");
			System.out.println("total="+total);
		}

		createOrderXML(count, total);
	}

	//	获得shopping.xml中的所有goods节点
	private static NodeList readShopping(){
		NodeList list = null;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		Element root;

		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File("shopping.xml"));
			root = document.getDocumentElement();
			list = root.getElementsByTagName("goods");
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return list;
	}

	// 	生成订单XML
	private static void createOrderXML(int total, float sums) {		

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("order");

			Element cTotal = document.createElement("total");
			cTotal.setTextContent(total+"");
			Element cSums = document.createElement("sums");
			cSums.setTextContent(sums+"");

			root.appendChild(cTotal);
			root.appendChild(cSums);
			document.appendChild(root);

			//			-----------------------写入XML文件------------------------
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new File("order.xml")));
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (TransformerConfigurationException e) {

			e.printStackTrace();
		} catch (TransformerException e) {

			e.printStackTrace();
		}
	}
}
