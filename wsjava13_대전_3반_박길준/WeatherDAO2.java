package com.ssafy.edu3;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAO2 {
	List<Weather> list = new ArrayList<>();

	public List<Weather> getNewsList(String url) {
		list.removeAll(list);
		connectWeather(url);
		return list;

	}

	private List<Weather> connectWeather(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(),
					handler);
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public class SAXHandler extends DefaultHandler {
		private StringBuilder sbject;
		Weather weather;

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			sbject.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			if (weather != null) {
				if (name.equalsIgnoreCase("hour")) {
					weather.setHour(sbject.toString().trim());
				} else if (name.equalsIgnoreCase("temp")) {
					weather.setTemp(sbject.toString().trim());
				} else if (name.equalsIgnoreCase("wfKor")) {
					weather.setWfKor(sbject.toString().trim());
				} else if (name.equalsIgnoreCase("reh")) {
					weather.setReh(sbject.toString().trim());
				} else if (name.equalsIgnoreCase("data")) {
					list.add(weather);
				}
			}
			sbject.setLength(0);
		}

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list = new ArrayList<Weather>();
			sbject = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("data")) {
				weather = new Weather();
			}
		}
	}

}